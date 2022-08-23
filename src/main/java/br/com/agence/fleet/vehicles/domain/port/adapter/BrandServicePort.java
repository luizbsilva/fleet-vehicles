package br.com.agence.fleet.vehicles.domain.port.adapter;

import br.com.agence.fleet.vehicles.domain.dto.BrandDTO;
import br.com.agence.fleet.vehicles.domain.dto.EmployeeDTO;
import br.com.agence.fleet.vehicles.domain.request.BrandRequest;
import br.com.agence.fleet.vehicles.domain.request.EmployeeRequest;
import br.com.agence.fleet.vehicles.domain.response.EmployeeResponse;
import javassist.NotFoundException;
import java.text.ParseException;
import java.util.List;

public interface BrandServicePort {
	
	BrandDTO createBrand(BrandRequest request) throws NotFoundException, ParseException;
	
	List<BrandDTO> getAllBrand();
	
	void removeBrand(String document) throws NotFoundException;
	
}
