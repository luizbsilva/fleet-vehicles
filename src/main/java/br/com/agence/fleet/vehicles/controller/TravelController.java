package br.com.agence.fleet.vehicles.controller;

import br.com.agence.fleet.vehicles.domain.dto.TravelDTO;
import br.com.agence.fleet.vehicles.domain.dto.VehicleDTO;
import br.com.agence.fleet.vehicles.domain.port.adapter.TravelServicePort;
import br.com.agence.fleet.vehicles.domain.port.adapter.VehicleServicePort;
import br.com.agence.fleet.vehicles.domain.request.VehicleRequest;
import br.com.agence.fleet.vehicles.domain.response.VehicleResponse;
import br.com.agence.fleet.vehicles.infra.util.ConstantsUrl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(ConstantsUrl.TRAVEL_URL)
public class TravelController {
	
	private TravelServicePort servicePort;
	
	public TravelController(TravelServicePort servicePort) {
		this.servicePort = servicePort;
	}
	
	@ApiOperation(value = "Create a new Travel", notes = "Used to Create a new Travel")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Travel created successfully"),
						   @ApiResponse(code = 500, message = "The requested operation could not be performed. " +
                                   "Contact support and report the error")})
	@PostMapping("/{idEmploee}/{idVehicle}")
	ResponseEntity<TravelDTO> createTravel(@PathVariable Long idEmploee, @PathVariable Long idVehicle)
			throws NotFoundException, ParseException {
		return ResponseEntity.status(HttpStatus.CREATED).body(servicePort.createTravel(idEmploee, idVehicle));
	}
	
	    @DeleteMapping("/{idEmploee}/{idVehicle}")
	    @ResponseStatus(HttpStatus.OK)
	    @PreAuthorize("hasAuthority('ROLE_ADM')")
	    public ResponseEntity<String> removeTravel(@PathVariable Long idEmploee, @PathVariable Long idVehicle) throws NotFoundException {
	        servicePort.removeTravel(idEmploee, idVehicle);
	        return ResponseEntity.ok("Veículo Removido com sucesso");
	    }

	    @ApiOperation(value = "Search Travel by Month and Year", notes = "Used to Fetch Travel by Month and Year")
	    @ApiResponses(value = {
	            @ApiResponse(code = 202, message = "Search Travel by Month and Year"),
	            @ApiResponse(code = 404, message = "There are no registered Travel"),
	            @ApiResponse(code = 500, message = "The requested operation could not be performed. Contact support and report the error")})
	    @GetMapping("/{month}/{year}")
	    ResponseEntity<List<TravelDTO>> searchTripsByMonthAndYear(@PathVariable Integer month, @PathVariable Integer year) {
	        return ResponseEntity.status(HttpStatus.OK).body(servicePort.searchTripsByMonthAndYear(month, year));
	    }
}
