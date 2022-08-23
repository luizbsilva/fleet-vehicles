package br.com.agence.fleet.vehicles.domain.mapper;

import br.com.agence.fleet.vehicles.domain.EmployeePort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Employee;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class EmployeeMapper implements MapperDomain<Employee, EmployeePort> {
	
	@Override
	public EmployeePort toModel(Employee employee) {
        
        if (employee == null) {
            return null;
        }
		
		return EmployeePort.builder().id(employee.getId()).employeeName(employee.getEmployeeName())
				.employeeRegistration(employee.getEmployeeRegistration()).userPort(employee.getUser().toUserPort())
				.active(employee.isActive()).createDate(employee.getCreateDate())
				.updateDate(employee.getUpdateDate() != null ? employee.getUpdateDate() : null).build();
	}
	
	@Override
	public Employee toDomain(EmployeePort employeePort) {
        if (employeePort == null) {
            return null;
        }
		
		return Employee.builder().employeeName(employeePort.getEmployeeName())
				.employeeRegistration(employeePort.getEmployeeRegistration()).active(Boolean.TRUE)
				.createDate(LocalDateTime.now()).build();
	}
	
}
