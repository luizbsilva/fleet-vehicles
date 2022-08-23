package br.com.agence.fleet.vehicles.infra.adapter.repository.dao;

import br.com.agence.fleet.vehicles.domain.VehiclePort;
import br.com.agence.fleet.vehicles.domain.mapper.VehicleMapper;
import br.com.agence.fleet.vehicles.domain.port.repository.BrandRepositoryPort;
import br.com.agence.fleet.vehicles.domain.port.repository.VehicleRepositoryPort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Brand;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Travel;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Vehicle;
import br.com.agence.fleet.vehicles.infra.adapter.repository.TravelRepository;
import br.com.agence.fleet.vehicles.infra.adapter.repository.VehicleRepository;
import br.com.agence.fleet.vehicles.infra.exception.VehicleNotRegisteredException;
import br.com.agence.fleet.vehicles.infra.validation.VehicleValidation;
import javassist.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class VehicleDao implements VehicleRepositoryPort {
	
	private VehicleRepository repository;
	private BrandRepositoryPort brandRepository;
	private TravelRepository travelRepository;
	private VehicleValidation validation;
	private VehicleMapper vehicleMapper;
	
	public VehicleDao(VehicleRepository repository, BrandRepositoryPort brandRepository,
					  TravelRepository travelRepository, VehicleValidation validation, VehicleMapper vehicleMapper) {
		this.repository = repository;
		this.brandRepository = brandRepository;
		this.travelRepository = travelRepository;
		this.validation = validation;
		this.vehicleMapper = vehicleMapper;
		
	}
	
	@Override
	@Transactional
	public VehiclePort createVehicle(VehiclePort vehiclePort) throws NotFoundException {
		Brand brand = brandRepository.findById(vehiclePort.getBrandPort().getId());
		Vehicle vehicle = vehicleMapper.toDomain(vehiclePort);
		validation.isValid(Optional.ofNullable(vehicle));
		vehicle.setBrand(brand);
		repository.save(vehicle);
		return vehicleMapper.toModel(vehicle);
	}
	
	@Override
	public List<VehiclePort> getAllVehicle() {
		List<Vehicle> employees = repository.findAll();
		return employees.stream().map(Vehicle::toVehiclePort).collect(Collectors.toList());
	}
	
	@Override
	public Vehicle getById(Long idVehicle) {
		Optional<Vehicle> vehicle = repository.findById(idVehicle);
		return vehicle.orElseThrow(() -> new VehicleNotRegisteredException());
	}
	
	@Override
	@Transactional
	public void removeVehicle(VehiclePort vehiclePort) throws NotFoundException {
		Optional<Vehicle> vehicle = repository.findByBoard(vehiclePort.getBoard());
		
		if (!vehicle.isPresent()) {
			throw new VehicleNotRegisteredException();
		}
		
		vehicle.get().setActive(Boolean.FALSE);
		vehicle.get().setUpdateDate(LocalDateTime.now());
		repository.save(vehicle.get());
	}
	
	@Override
	public List<VehiclePort> getVehiclesInUse() {
		List<Travel> travels = travelRepository.findByDeliveryDateIsNull();
		return travels.stream().map(Travel::toVehiclePort).collect(Collectors.toList());
	}
	
}
