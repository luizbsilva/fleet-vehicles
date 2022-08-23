package br.com.agence.fleet.vehicles.domain.port.adapter;

import br.com.agence.fleet.vehicles.domain.dto.EmployeeDTO;
import br.com.agence.fleet.vehicles.domain.response.EmployeeResponse;
import br.com.agence.fleet.vehicles.domain.request.EmployeeRequest;
import javassist.NotFoundException;
import java.util.List;

public interface EmployeeServicePort {
	
	EmployeeDTO createEmployee(EmployeeRequest request) throws NotFoundException;
	
	List<EmployeeResponse> getAllEmployee();
	
	void removeEmployee(String numberRegistration) throws NotFoundException;
	
}
