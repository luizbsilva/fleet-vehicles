package br.com.agence.fleet.vehicles.controller;

import br.com.agence.fleet.vehicles.domain.dto.VehicleDTO;
import br.com.agence.fleet.vehicles.domain.port.adapter.VehicleServicePort;
import br.com.agence.fleet.vehicles.domain.request.VehicleRequest;
import br.com.agence.fleet.vehicles.domain.response.VehicleInuseResponse;
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
@RequestMapping(ConstantsUrl.VEHICLE_URL)
public class VehicleController {
	
	private VehicleServicePort servicePort;
	
	public VehicleController(VehicleServicePort servicePort) {
		this.servicePort = servicePort;
	}
	
	@ApiOperation(value = "Create a new Vehicle", notes = "Used to Create a new Vehicle")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Vehicle created successfully"),
						   @ApiResponse(code = 422, message = "Existing Vehicle, please provide board login to " +
                                   "Vehicle"),
						   @ApiResponse(code = 500, message = "The requested operation could not be performed. " +
                                   "Contact support and report the error")})
	@PostMapping()
	ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleRequest request)
			throws NotFoundException, ParseException {
		return ResponseEntity.status(HttpStatus.CREATED).body(servicePort.createVehicle(request));
	}
	
	    @DeleteMapping("/{numberBoard}")
	    @ResponseStatus(HttpStatus.OK)
	    @PreAuthorize("hasAuthority('ROLE_ADM')")
	    public ResponseEntity<String> removeVehicle(@PathVariable String numberBoard) throws NotFoundException {
	        servicePort.removeVehicle(numberBoard);
	        return ResponseEntity.ok("veículo Removido com sucesso");
	    }

	    @ApiOperation(value = "Search All Employee", notes = "Used to Fetch Employees")
	    @ApiResponses(value = {
	            @ApiResponse(code = 202, message = "Search Transaction Employee"),
	            @ApiResponse(code = 404, message = "There are no registered employees"),
	            @ApiResponse(code = 500, message = "The requested operation could not be performed. Contact support and report the error")})
	    @GetMapping("")
	    ResponseEntity<List<VehicleResponse>> getAlVehicle() {
	        return ResponseEntity.status(HttpStatus.OK).body(servicePort.getAllVehicle());
	    }

	    @ApiOperation(value = "Search All Employee", notes = "Used to Fetch Employees")
	    @ApiResponses(value = {
	            @ApiResponse(code = 202, message = "Search for vehicles in use"),
	            @ApiResponse(code = 404, message = "There are not vehicles in use"),
	            @ApiResponse(code = 500, message = "The requested operation could not be performed. Contact support and report the error")})
	    @GetMapping("/withdrawn")
	    ResponseEntity<List<VehicleInuseResponse>> getVehiclesInUse() {
	        return ResponseEntity.status(HttpStatus.OK).body(servicePort.getVehiclesInUse());
	    }
}
