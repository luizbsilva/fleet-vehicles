package br.com.agence.fleet.vehicles.domain.adapter.service;

import br.com.agence.fleet.vehicles.domain.VehiclePort;
import br.com.agence.fleet.vehicles.domain.dto.VehicleDTO;
import br.com.agence.fleet.vehicles.domain.port.adapter.VehicleServicePort;
import br.com.agence.fleet.vehicles.domain.port.repository.VehicleRepositoryPort;
import br.com.agence.fleet.vehicles.domain.request.VehicleRequest;
import br.com.agence.fleet.vehicles.domain.response.VehicleInuseResponse;
import br.com.agence.fleet.vehicles.domain.response.VehicleResponse;
import javassist.NotFoundException;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleServiceImpl implements VehicleServicePort {
	
	private VehicleRepositoryPort repositoryPort;
	
	public VehicleServiceImpl(VehicleRepositoryPort repositoryPort) {
		this.repositoryPort = repositoryPort;
	}
	
	@Override
	public VehicleDTO createVehicle(VehicleRequest request) throws NotFoundException, ParseException {
		VehiclePort vehiclePort = repositoryPort.createVehicle(new VehiclePort(request));
		return vehiclePort.toVehicleDTO();
	}
	
	@Override
	public List<VehicleResponse> getAllVehicle() {
		List<VehiclePort> vehicles = repositoryPort.getAllVehicle();
		return vehicles.stream().map(VehiclePort::toVehicleResponse).collect(Collectors.toList());
	}
	
	@Override
	public void removeVehicle(String numberBoard) throws NotFoundException {
		repositoryPort.removeVehicle(VehiclePort.builder().board(numberBoard).build());
		
		
	}
	
	@Override
	public List<VehicleInuseResponse> getVehiclesInUse() {
		List<VehiclePort> vehicles = repositoryPort.getVehiclesInUse();
		return vehicles.stream().map(VehiclePort::toVehicleInuseResponse).collect(Collectors.toList());
	}
	
}
