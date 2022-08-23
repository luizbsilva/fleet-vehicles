package br.com.agence.fleet.vehicles.domain.adapter.service;

import br.com.agence.fleet.vehicles.domain.EmployeePort;
import br.com.agence.fleet.vehicles.domain.dto.EmployeeDTO;
import br.com.agence.fleet.vehicles.domain.response.EmployeeResponse;
import br.com.agence.fleet.vehicles.domain.port.adapter.EmployeeServicePort;
import br.com.agence.fleet.vehicles.domain.port.repository.EmployeeRepositoryPort;
import br.com.agence.fleet.vehicles.domain.request.EmployeeRequest;
import javassist.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeServicePort {
	
	private EmployeeRepositoryPort repositoryPort;
	
	public EmployeeServiceImpl(EmployeeRepositoryPort repositoryPort) {
		this.repositoryPort = repositoryPort;
	}
	
	@Override
	public EmployeeDTO createEmployee(EmployeeRequest request) throws NotFoundException {
		EmployeePort employeePort = repositoryPort.createEmployee(new EmployeePort(request));
		EmployeeDTO employeeDTO = employeePort.toEmployeeDTO();
		employeeDTO.getUserDataDTO().setPassword(request.getPassword());
		return employeeDTO;
	}
	
	@Override
	public List<EmployeeResponse> getAllEmployee() {
		List<EmployeePort> employeePorts = repositoryPort.findAllEmployee();
		return employeePorts.stream().map(EmployeePort::toEmployeeResponse).collect(Collectors.toList());
	}
	
	@Override
	public void removeEmployee(String numberRegistration) throws NotFoundException {
		repositoryPort.removeEmployee(EmployeePort.builder().employeeRegistration(numberRegistration).build());
		
	
	}
	
}
