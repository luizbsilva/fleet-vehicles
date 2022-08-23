package br.com.agence.fleet.vehicles.infra.adapter.repository;

import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
	
	Optional<Brand> findByDocument(String document);
	
}
