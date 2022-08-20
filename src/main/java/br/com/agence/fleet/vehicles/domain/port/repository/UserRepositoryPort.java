package br.com.agence.fleet.vehicles.domain.port.repository;


import br.com.agence.fleet.vehicles.domain.UserPort;

public interface UserRepositoryPort {
    UserPort findByEmail(String email);
}
