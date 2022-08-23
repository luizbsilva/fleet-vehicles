package br.com.agence.fleet.vehicles.infra.validation;

import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Brand;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Employee;
import br.com.agence.fleet.vehicles.infra.adapter.repository.BrandRepository;
import br.com.agence.fleet.vehicles.infra.adapter.repository.EmployeeRepository;
import br.com.agence.fleet.vehicles.infra.adapter.repository.UserRepository;
import br.com.agence.fleet.vehicles.infra.exception.BrandRegisterException;
import br.com.agence.fleet.vehicles.infra.exception.EmployeeRegisterException;
import br.com.agence.fleet.vehicles.infra.exception.dto.ErrorInfo;
import javassist.NotFoundException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BrandValidation implements Validation<Brand> {
	
	public static final String RECORD_ALREADY_REGISTERED = "Marca informada já cadastrada";
	private BrandRepository repository;
	
	public BrandValidation(BrandRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void isValid(Optional<Brand> res) throws NotFoundException {
		Brand brand = res.orElseThrow(() -> new NotFoundException(""));
		List<ErrorInfo> listErrorEmployee = new ArrayList<>();
		
		Optional<Brand> creditCardOld = repository.findByDocument(brand.getDocument());
		
		if (creditCardOld.isPresent()) {
			listErrorEmployee.add(new ErrorInfo(RECORD_ALREADY_REGISTERED));
		}
		if (!listErrorEmployee.isEmpty()) {
			throw new BrandRegisterException();
		}
	}
	
}
