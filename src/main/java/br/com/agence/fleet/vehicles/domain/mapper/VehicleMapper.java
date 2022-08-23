package br.com.agence.fleet.vehicles.domain.mapper;

import br.com.agence.fleet.vehicles.domain.EmployeePort;
import br.com.agence.fleet.vehicles.domain.VehiclePort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Employee;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Vehicle;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class VehicleMapper implements MapperDomain<Vehicle, VehiclePort> {
	
	@Override
	public VehiclePort toModel(Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }
		
		return VehiclePort.builder()
				.id(vehicle.getId())
				.brandPort(vehicle.getBrand().toBrandPort())
				.model(vehicle.getModel())
				.board(vehicle.getBoard())
				.collor(vehicle.getCollor())
				.active(vehicle.isActive())
				.createDate(vehicle.getCreateDate())
				.updateDate(vehicle.getUpdateDate() != null ? vehicle.getUpdateDate() : null).build();
	}
	
	@Override
	public Vehicle toDomain(VehiclePort vehiclePort) {
        if (vehiclePort == null) {
            return null;
        }
		
		return Vehicle.builder()
				.model(vehiclePort.getModel())
				.board(vehiclePort.getBoard())
				.collor(vehiclePort.getCollor())
				.active(Boolean.TRUE)
				.createDate(LocalDateTime.now()).build();
	}
	
}
