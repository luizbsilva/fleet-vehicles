package br.com.agence.fleet.vehicles.domain.port.adapter;

import br.com.agence.fleet.vehicles.domain.dto.TravelDTO;
import br.com.agence.fleet.vehicles.domain.dto.VehicleDTO;
import br.com.agence.fleet.vehicles.domain.request.VehicleRequest;
import br.com.agence.fleet.vehicles.domain.response.VehicleResponse;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import java.text.ParseException;
import java.util.List;

public interface TravelServicePort {
	
	TravelDTO createTravel(Long idEmploee, Long idVehicle) throws NotFoundException, ParseException;
	
	List<TravelDTO> searchTripsByMonthAndYear(Integer month, Integer year);
	
	void removeTravel(Long idEmploee, Long idVehicle) throws NotFoundException;
	
}
