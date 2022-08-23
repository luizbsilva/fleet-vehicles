package br.com.agence.fleet.vehicles.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TravelDTO {
	
	private Long id;
	private String brandName;
	private String model;
	private String description;
	private String removedByEmployee;
	private LocalDateTime dateWithdrawal;
	private LocalDateTime deliveryDate;
	
	
}

