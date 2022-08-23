package br.com.agence.fleet.vehicles.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleResponse {
	
	private Long id;
	private String model;
	private String brandName;
	private String board;
	private String color;
	
}

