package br.com.agence.fleet.vehicles.infra.adapter.repository.dao;

import br.com.agence.fleet.vehicles.domain.UserPort;
import br.com.agence.fleet.vehicles.domain.mapper.UserMapper;
import br.com.agence.fleet.vehicles.domain.port.repository.UserRepositoryPort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.User;
import br.com.agence.fleet.vehicles.infra.adapter.repository.UserRepository;
import br.com.agence.fleet.vehicles.infra.validation.UserValidation;
import javassist.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class UserDao implements UserRepositoryPort {
	
	private UserRepository userRepository;
	private UserValidation validation;
	private UserMapper mapper;
	
	public UserDao(UserRepository userRepository, UserValidation validation, UserMapper mapper) {
		this.userRepository = userRepository;
		this.validation = validation;
		this.mapper = mapper;
	}
	
	@Override
	public UserPort findByLogin(String login) {
		User userEntity = this.userRepository.findByLogin(login);
		return userEntity.toUserPort();
	}
	
	@Override
	@Transactional
	public User createdUser(UserPort userPort) throws NotFoundException {
		User user = mapper.toDomain(userPort);
		validation.isValid(Optional.ofNullable(user));
		userRepository.save(user);
		return user;
	}
	
	@Override
	@Transactional
	public void removeUser(UserPort userPort) {
		User user = userRepository.findByLogin(userPort.getLogin());
		user.setActive(Boolean.FALSE);
		user.setUpdateDate(LocalDateTime.now());
		userRepository.save(user);
		
		
	}
	
}
