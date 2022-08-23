package br.com.agence.fleet.vehicles.domain.adapter.service;

import br.com.agence.fleet.vehicles.domain.EmployeePort;
import br.com.agence.fleet.vehicles.domain.TravelPort;
import br.com.agence.fleet.vehicles.domain.VehiclePort;
import br.com.agence.fleet.vehicles.domain.dto.TravelDTO;
import br.com.agence.fleet.vehicles.domain.port.adapter.TravelServicePort;
import br.com.agence.fleet.vehicles.domain.port.repository.TravelRepositoryPort;
import javassist.NotFoundException;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

public class TravelServiceImpl implements TravelServicePort {
	
	private TravelRepositoryPort repositoryPort;
	
	public TravelServiceImpl(TravelRepositoryPort repositoryPort) {
		this.repositoryPort = repositoryPort;
	}
	
	@Override
	public TravelDTO createTravel(Long idEmploee, Long idVehicle) throws NotFoundException, ParseException {
		TravelPort travelPort = repositoryPort.createTravel(createdTravel(idEmploee, idVehicle));
		return travelPort.toTravelDTO();
	}
	
	private TravelPort createdTravel(Long idEmploee, Long idVehicle) {
		return TravelPort.builder().employeePort(EmployeePort.builder().id(idEmploee).build())
				.vehiclePort(VehiclePort.builder().id(idVehicle).build()).build();
	}
	
	@Override
	public List<TravelDTO> searchTripsByMonthAndYear(Integer month, Integer year) {
		List<TravelPort> employeePorts = repositoryPort.searchTripsByMonthAndYear(
				TravelPort.builder().month(month).year(year).build());
		return employeePorts.stream().map(TravelPort::toTravelDTO).collect(Collectors.toList());
	}
	
	@Override
	public void removeTravel(Long idEmploee, Long idVehicle) throws NotFoundException {
		repositoryPort.removeTravel(createdTravel(idEmploee, idVehicle));
		
		
	}
	
}
