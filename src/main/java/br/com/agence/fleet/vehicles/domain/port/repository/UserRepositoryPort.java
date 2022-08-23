package br.com.agence.fleet.vehicles.domain.port.repository;


import br.com.agence.fleet.vehicles.domain.UserPort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.User;
import javassist.NotFoundException;

public interface UserRepositoryPort {
	
	UserPort findByLogin(String login);
	
	User createdUser(UserPort userPort) throws NotFoundException;
	void removeUser(UserPort userPort);
	
}
