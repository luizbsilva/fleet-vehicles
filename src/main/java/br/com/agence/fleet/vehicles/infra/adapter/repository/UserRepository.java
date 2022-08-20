package br.com.agence.fleet.vehicles.infra.adapter.repository;

import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
