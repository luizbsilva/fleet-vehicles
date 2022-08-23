package br.com.agence.fleet.vehicles.domain;

import br.com.agence.fleet.vehicles.domain.dto.TravelDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelPort {
	
	private Long id;
	
	private String description;
	
	private EmployeePort employeePort;
	
	private VehiclePort vehiclePort;
	
	private LocalDateTime dateWithdrawal;
	
	private LocalDateTime deliveryDate;
	
	private Integer month;
	
	private Integer year;
	
	private Boolean active;
	
	private LocalDateTime createDate;
	
	private LocalDateTime updateDate;
	
	
	public TravelPort(Long id, String description, EmployeePort employeePort, VehiclePort vehiclePort,
					  LocalDateTime dateWithdrawal, LocalDateTime deliveryDate, Boolean active) {
		this.id = id;
		this.description = description;
		this.employeePort = employeePort;
		this.vehiclePort = vehiclePort;
		this.dateWithdrawal = dateWithdrawal;
		this.deliveryDate = deliveryDate;
		this.active = active;
	}
	
	public TravelDTO toTravelDTO() {
		return new TravelDTO(this.id, this.vehiclePort.getBrandPort().getName(), this.vehiclePort.getModel(),
				this.description, this.getEmployeePort().getEmployeeName(), this.dateWithdrawal, this.deliveryDate);
	}
	
}
