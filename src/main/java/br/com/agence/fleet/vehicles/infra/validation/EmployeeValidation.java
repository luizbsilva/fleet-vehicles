package br.com.agence.fleet.vehicles.infra.validation;

import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Employee;
import br.com.agence.fleet.vehicles.infra.adapter.repository.EmployeeRepository;
import br.com.agence.fleet.vehicles.infra.exception.EmployeeRegisterException;
import br.com.agence.fleet.vehicles.infra.exception.dto.ErrorInfo;
import javassist.NotFoundException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeValidation implements Validation<Employee> {
	
	public static final String RECORD_ALREADY_REGISTERED = "Matrícula informa já cadastrada";
	private EmployeeRepository repository;
	
	public EmployeeValidation(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void isValid(Optional<Employee> res) throws NotFoundException {
		Employee employee = res.orElseThrow(() -> new NotFoundException(""));
		List<ErrorInfo> listErrorEmployee = new ArrayList<>();
		
		Optional<Employee> creditCardOld = repository.findByEmployeeRegistration(employee.getEmployeeRegistration());
		
		if (creditCardOld.isPresent()) {
			listErrorEmployee.add(new ErrorInfo(RECORD_ALREADY_REGISTERED));
		}
		if (!listErrorEmployee.isEmpty()) {
			throw new EmployeeRegisterException();
		}
		
	}
	
}
