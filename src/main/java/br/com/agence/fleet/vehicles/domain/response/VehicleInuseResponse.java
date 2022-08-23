package br.com.agence.fleet.vehicles.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleInuseResponse {
	
	private Long id;
	private String model;
	private String brandName;
	private String board;
	private String dateWithdrawal;
	
}

