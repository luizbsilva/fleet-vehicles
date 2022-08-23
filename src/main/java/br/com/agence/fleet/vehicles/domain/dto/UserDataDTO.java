package br.com.agence.fleet.vehicles.domain.dto;

import br.com.agence.fleet.vehicles.infra.adapter.enums.ProfileEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDataDTO {
	
	private Long code;
	private String login;
	private String password;
	private ProfileEnum profile;
	
}

