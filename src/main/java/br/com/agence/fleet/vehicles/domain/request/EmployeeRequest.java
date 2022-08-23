package br.com.agence.fleet.vehicles.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
	private String name;
	private String login;
	private String email;
	private String password;
	private String numberRegistration;
	

}
