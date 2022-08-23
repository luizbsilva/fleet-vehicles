package br.com.agence.fleet.vehicles.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
	
	private Long id;
	private String employeeName;
	private String employeeRegistration;
	
}

