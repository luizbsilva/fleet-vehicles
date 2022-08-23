package br.com.agence.fleet.vehicles.domain.port.repository;


import br.com.agence.fleet.vehicles.domain.EmployeePort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Employee;
import javassist.NotFoundException;
import java.util.List;

public interface EmployeeRepositoryPort {
	
	EmployeePort createEmployee(EmployeePort employeePort) throws NotFoundException;
	
	List<EmployeePort> findAllEmployee();
	
	Employee findById(Long idEmployee);
	
	void removeEmployee(EmployeePort employeePort) throws NotFoundException;
	
}
