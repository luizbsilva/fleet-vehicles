package br.com.agence.fleet.vehicles.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
	
	private Long id;
	
	private BrandDTO brandDTO;
	
	private String model;
	
	private String board;
	
	private String collor;
	
}

