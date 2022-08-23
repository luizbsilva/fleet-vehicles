package br.com.agence.fleet.vehicles.infra.config;

import br.com.agence.fleet.vehicles.domain.adapter.service.BrandServiceImpl;
import br.com.agence.fleet.vehicles.domain.adapter.service.EmployeeServiceImpl;
import br.com.agence.fleet.vehicles.domain.adapter.service.TravelServiceImpl;
import br.com.agence.fleet.vehicles.domain.adapter.service.UserServiceImp;
import br.com.agence.fleet.vehicles.domain.adapter.service.VehicleServiceImpl;
import br.com.agence.fleet.vehicles.domain.port.adapter.BrandServicePort;
import br.com.agence.fleet.vehicles.domain.port.adapter.EmployeeServicePort;
import br.com.agence.fleet.vehicles.domain.port.adapter.TravelServicePort;
import br.com.agence.fleet.vehicles.domain.port.adapter.UserServicePort;
import br.com.agence.fleet.vehicles.domain.port.adapter.VehicleServicePort;
import br.com.agence.fleet.vehicles.domain.port.repository.BrandRepositoryPort;
import br.com.agence.fleet.vehicles.domain.port.repository.EmployeeRepositoryPort;
import br.com.agence.fleet.vehicles.domain.port.repository.TravelRepositoryPort;
import br.com.agence.fleet.vehicles.domain.port.repository.UserRepositoryPort;
import br.com.agence.fleet.vehicles.domain.port.repository.VehicleRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
	
	@Bean
	UserServicePort userService(UserRepositoryPort repositoryPort) {
		return new UserServiceImp(repositoryPort);
	}
	
	@Bean
	EmployeeServicePort employeeService(EmployeeRepositoryPort repositoryPort) {
		return new EmployeeServiceImpl(repositoryPort);
	}
	
	@Bean
	BrandServicePort brandService(BrandRepositoryPort repositoryPort) {
		return new BrandServiceImpl(repositoryPort);
	}
	
	@Bean
	VehicleServicePort vehicleService(VehicleRepositoryPort repositoryPort) {
		return new VehicleServiceImpl(repositoryPort);
	}
	
	@Bean
	TravelServicePort travelService(TravelRepositoryPort repositoryPort) {
		return new TravelServiceImpl(repositoryPort);
	}
	
}
