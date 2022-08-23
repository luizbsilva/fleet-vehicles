package br.com.agence.fleet.vehicles.infra.validation;

import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Vehicle;
import br.com.agence.fleet.vehicles.infra.adapter.repository.VehicleRepository;
import br.com.agence.fleet.vehicles.infra.exception.EmployeeRegisterException;
import br.com.agence.fleet.vehicles.infra.exception.VehicleRegisterException;
import br.com.agence.fleet.vehicles.infra.exception.dto.ErrorInfo;
import javassist.NotFoundException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class VehicleValidation implements Validation<Vehicle> {
	
	public static final String ENROLLMENT_REGISTERED = "veículo informado já cadastrada";
	private VehicleRepository repository;
	
	public VehicleValidation(VehicleRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void isValid(Optional<Vehicle> res) throws NotFoundException {
		Vehicle vehicle = res.orElseThrow(() -> new NotFoundException(""));
		List<ErrorInfo> listError = new ArrayList<>();
		
		Optional<Vehicle> creditCardOld = repository.findByBoard(vehicle.getBoard());
		
		if (creditCardOld.isPresent()) {
			listError.add(new ErrorInfo(ENROLLMENT_REGISTERED));
		}
		if (!listError.isEmpty()) {
			throw new VehicleRegisterException();
		}
		
	}
	
}
