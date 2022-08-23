package br.com.agence.fleet.vehicles.domain.port.adapter;

import br.com.agence.fleet.vehicles.domain.dto.VehicleDTO;
import br.com.agence.fleet.vehicles.domain.request.VehicleRequest;
import br.com.agence.fleet.vehicles.domain.response.VehicleInuseResponse;
import br.com.agence.fleet.vehicles.domain.response.VehicleResponse;
import javassist.NotFoundException;
import java.text.ParseException;
import java.util.List;

public interface VehicleServicePort {
	
	VehicleDTO createVehicle(VehicleRequest request) throws NotFoundException, ParseException;
	
	List<VehicleResponse> getAllVehicle();
	
	void removeVehicle(String numberBoard) throws NotFoundException;
	
	List<VehicleInuseResponse> getVehiclesInUse();
	
}
