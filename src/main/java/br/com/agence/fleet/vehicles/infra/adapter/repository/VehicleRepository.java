package br.com.agence.fleet.vehicles.infra.adapter.repository;

import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.xml.transform.sax.SAXResult;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	Optional<Vehicle> findByBoard(String board);
}
