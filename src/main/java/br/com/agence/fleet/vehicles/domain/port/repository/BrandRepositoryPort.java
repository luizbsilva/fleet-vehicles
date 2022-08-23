package br.com.agence.fleet.vehicles.domain.port.repository;


import br.com.agence.fleet.vehicles.domain.BrandPort;
import br.com.agence.fleet.vehicles.domain.EmployeePort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Brand;
import javassist.NotFoundException;
import java.util.List;

public interface BrandRepositoryPort {
	
	BrandPort createBrand(BrandPort brandPort) throws NotFoundException;
	Brand findById(Long idBrand) throws NotFoundException;
	List<BrandPort> getAllBrand();
	
	void removeBrand(BrandPort brandPort) throws NotFoundException;
	
}
