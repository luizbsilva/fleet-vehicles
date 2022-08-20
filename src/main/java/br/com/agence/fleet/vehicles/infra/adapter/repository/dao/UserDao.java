package br.com.agence.fleet.vehicles.infra.adapter.repository.dao;

import br.com.agence.fleet.vehicles.domain.UserPort;
import br.com.agence.fleet.vehicles.domain.port.repository.UserRepositoryPort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.User;
import br.com.agence.fleet.vehicles.infra.adapter.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserDao implements UserRepositoryPort {

    private UserRepository userRepository;

    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserPort findByEmail(String email) {
        User userEntity = this.userRepository.findByEmail(email);
        return userEntity.toUser();
    }
}
