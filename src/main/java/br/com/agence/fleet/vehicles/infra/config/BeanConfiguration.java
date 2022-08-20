package br.com.agence.fleet.vehicles.infra.config;

import br.com.agence.fleet.vehicles.domain.adapter.service.UserServiceImp;
import br.com.agence.fleet.vehicles.domain.port.adapter.UserServicePort;
import br.com.agence.fleet.vehicles.domain.port.repository.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
	
	@Bean
	UserServicePort userService(UserRepositoryPort repositoryPort) {
		return new UserServiceImp(repositoryPort);
	}
	
}
