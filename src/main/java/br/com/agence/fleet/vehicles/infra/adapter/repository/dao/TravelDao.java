package br.com.agence.fleet.vehicles.infra.adapter.repository.dao;

import br.com.agence.fleet.vehicles.domain.TravelPort;
import br.com.agence.fleet.vehicles.domain.mapper.TravelMapper;
import br.com.agence.fleet.vehicles.domain.port.repository.EmployeeRepositoryPort;
import br.com.agence.fleet.vehicles.domain.port.repository.TravelRepositoryPort;
import br.com.agence.fleet.vehicles.domain.port.repository.VehicleRepositoryPort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Employee;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Travel;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Vehicle;
import br.com.agence.fleet.vehicles.infra.adapter.repository.TravelRepository;
import br.com.agence.fleet.vehicles.infra.exception.TravelNotRegisteredException;
import br.com.agence.fleet.vehicles.infra.exception.TravelNotRegisteredOrFinishedException;
import javassist.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TravelDao implements TravelRepositoryPort {
	
	private TravelRepository repository;
	private VehicleRepositoryPort vehicleRepository;
	private EmployeeRepositoryPort employeeRepository;
	
	public TravelDao(TravelRepository repository, VehicleRepositoryPort vehicleRepository,
					 EmployeeRepositoryPort employeeRepository) {
		this.repository = repository;
		this.vehicleRepository = vehicleRepository;
		this.employeeRepository = employeeRepository;
		
	}
	
	@Override
	@Transactional
	public TravelPort createTravel(TravelPort travelPort) throws NotFoundException {
		Vehicle vehicle = vehicleRepository.getById(travelPort.getVehiclePort().getId());
		Employee employee = employeeRepository.findById(travelPort.getEmployeePort().getId());
		Travel travel = Travel.builder().description("Veículo retirado por: " + employee.getEmployeeName())
				.employee(employee).vehicle(vehicle).dateWithdrawal(LocalDateTime.now())
				.month(LocalDateTime.now().getMonthValue()).year(LocalDateTime.now().getYear()).active(Boolean.TRUE)
				.createDate(LocalDateTime.now()).build();
		repository.save(travel);
		return TravelMapper.toTravelPort(travel);
	}
	
	@Override
	public List<TravelPort> searchTripsByMonthAndYear(TravelPort travelPort) {
		List<Travel> employees = repository.findByMonthAndYear(travelPort.getMonth(), travelPort.getYear());
		return employees.stream().map(Travel::toTravelPort).collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public void removeTravel(TravelPort travelPort) throws NotFoundException {
		Optional<Travel> travel = repository.findByEmployeeAndVehicle(travelPort.getEmployeePort().getId(),
				travelPort.getVehiclePort().getId());
		
		if (!travel.isPresent()) {
			throw new TravelNotRegisteredOrFinishedException();
		}
		travel.get().setDeliveryDate(LocalDateTime.now());
		travel.get().setActive(Boolean.FALSE);
		travel.get().setUpdateDate(LocalDateTime.now());
		repository.save(travel.get());
	}
	
	@Override
	public List<Travel> searchUnfinishedTrips() {
		return repository.findByDeliveryDateIsNull();
	}
	
}
