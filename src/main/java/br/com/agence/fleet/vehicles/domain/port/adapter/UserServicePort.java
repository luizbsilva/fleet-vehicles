package br.com.agence.fleet.vehicles.domain.port.adapter;

import br.com.agence.fleet.vehicles.domain.dto.UserDataDTO;
import java.util.Optional;

public interface UserServicePort {

    Optional<UserDataDTO> findByEmail(String email);
}
