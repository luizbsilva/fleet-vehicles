package br.com.agence.fleet.vehicles.infra.adapter.repository;

import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Optional<Employee> findByEmployeeRegistration(String registration);
	
}
