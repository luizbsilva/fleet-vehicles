package br.com.agence.fleet.vehicles.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	
	private Long id;
	private String employeeName;
	private UserDataDTO userDataDTO;
	private String employeeRegistration;
	
}

