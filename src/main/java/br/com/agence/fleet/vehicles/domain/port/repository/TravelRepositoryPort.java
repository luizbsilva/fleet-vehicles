package br.com.agence.fleet.vehicles.domain.port.repository;


import br.com.agence.fleet.vehicles.domain.TravelPort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Travel;
import javassist.NotFoundException;
import java.text.ParseException;
import java.util.List;

public interface TravelRepositoryPort {
	
	TravelPort createTravel(TravelPort travelPort) throws NotFoundException, ParseException;
	
	List<TravelPort> searchTripsByMonthAndYear(TravelPort travelPort);
	
	void removeTravel(TravelPort travelPort) throws NotFoundException;
	
	List<Travel> searchUnfinishedTrips();
	
}
