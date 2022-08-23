package br.com.agence.fleet.vehicles.infra.adapter.repository;

import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {
	
	List<Travel> findByMonthAndYear(Integer Month, Integer Year);
	
	List<Travel> findByDeliveryDateIsNull();
	@Query(value = "SELECT * " +
			" FROM travel " +
			"  WHERE id_employee = :idEmployee " +
			"    AND id_car = :idVehicle"+
			"    AND delivery_date is null",
			nativeQuery = true)
	Optional<Travel> findByEmployeeAndVehicle(Long idEmployee, Long idVehicle);
	
}
