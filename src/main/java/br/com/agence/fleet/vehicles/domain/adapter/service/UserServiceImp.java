package br.com.agence.fleet.vehicles.domain.adapter.service;

import br.com.agence.fleet.vehicles.domain.UserPort;
import br.com.agence.fleet.vehicles.domain.dto.UserDataDTO;
import br.com.agence.fleet.vehicles.domain.port.adapter.UserServicePort;
import br.com.agence.fleet.vehicles.domain.port.repository.UserRepositoryPort;
import java.util.Optional;

public class UserServiceImp implements UserServicePort {
    private UserRepositoryPort repository;

    public UserServiceImp(UserRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Optional<UserDataDTO> findByLogin(String login) {
        UserPort user = repository.findByLogin(login);
        return Optional.ofNullable(user.toUser());
    }
}
