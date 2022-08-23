package br.com.agence.fleet.vehicles.domain.port.repository;


import br.com.agence.fleet.vehicles.domain.VehiclePort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Vehicle;
import javassist.NotFoundException;
import java.util.List;

public interface VehicleRepositoryPort {
	
	VehiclePort createVehicle(VehiclePort vehiclePort) throws NotFoundException;
	List<VehiclePort> getAllVehicle();
	Vehicle getById(Long idVehicle);
	
	void removeVehicle(VehiclePort vehiclePort) throws NotFoundException;
	
	List<VehiclePort> getVehiclesInUse();
	
}
