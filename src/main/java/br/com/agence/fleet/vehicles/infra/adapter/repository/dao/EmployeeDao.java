package br.com.agence.fleet.vehicles.infra.adapter.repository.dao;

import br.com.agence.fleet.vehicles.domain.EmployeePort;
import br.com.agence.fleet.vehicles.domain.UserPort;
import br.com.agence.fleet.vehicles.domain.mapper.EmployeeMapper;
import br.com.agence.fleet.vehicles.domain.port.repository.EmployeeRepositoryPort;
import br.com.agence.fleet.vehicles.domain.port.repository.UserRepositoryPort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Brand;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Employee;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.User;
import br.com.agence.fleet.vehicles.infra.adapter.repository.EmployeeRepository;
import br.com.agence.fleet.vehicles.infra.exception.BrandNotRegisteredException;
import br.com.agence.fleet.vehicles.infra.exception.EmployeeNotRegisteredException;
import br.com.agence.fleet.vehicles.infra.validation.EmployeeValidation;
import javassist.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeDao implements EmployeeRepositoryPort {
	
	private EmployeeRepository repository;
	private UserRepositoryPort userRepository;
	private EmployeeValidation validation;
	private EmployeeMapper employeeMapper;
	
	public EmployeeDao(EmployeeRepository repository, UserRepositoryPort userRepository,
					   EmployeeValidation validation,
					   EmployeeMapper employeeMapper) {
		this.repository = repository;
		this.userRepository = userRepository;
		this.validation = validation;
		this.employeeMapper = employeeMapper;
		
	}
	
	@Override
	@Transactional
	public EmployeePort createEmployee(EmployeePort employeePort) throws NotFoundException {
		User user = userRepository.createdUser(employeePort.getUserPort());
		Employee employee = employeeMapper.toDomain(employeePort);
		validation.isValid(Optional.ofNullable(employee));
		employee.setUser(user);
		repository.save(employee);
		return employeeMapper.toModel(employee);
	}
	
	@Override
	public List<EmployeePort> findAllEmployee() {
		List<Employee> employees = repository.findAll();
		return employees.stream().map(Employee::toEmployeePort).collect(Collectors.toList());
	}
	
	@Override
	public Employee findById(Long idEmployee) {
		Optional<Employee> employee = repository.findById(idEmployee);
		return employee.orElseThrow(() -> new EmployeeNotRegisteredException());
	}
	
	@Override
	@Transactional
	public void removeEmployee(EmployeePort employeePort) throws NotFoundException {
		Optional<Employee> employee = repository.findByEmployeeRegistration(employeePort.getEmployeeRegistration());
		
		if (!employee.isPresent()) {
			throw new EmployeeNotRegisteredException();
		}
		userRepository.removeUser(
				new UserPort(employee.get().getUser().getLogin(), employee.get().getUser().getPassword()));
		employee.get().setActive(Boolean.FALSE);
		employee.get().setUpdateDate(LocalDateTime.now());
		repository.save(employee.get());
	}
	
}
