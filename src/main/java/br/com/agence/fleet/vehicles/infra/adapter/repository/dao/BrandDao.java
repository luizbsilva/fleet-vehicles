package br.com.agence.fleet.vehicles.infra.adapter.repository.dao;

import br.com.agence.fleet.vehicles.domain.BrandPort;
import br.com.agence.fleet.vehicles.domain.mapper.BrandMapper;
import br.com.agence.fleet.vehicles.domain.port.repository.BrandRepositoryPort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Brand;
import br.com.agence.fleet.vehicles.infra.adapter.repository.BrandRepository;
import br.com.agence.fleet.vehicles.infra.exception.BrandNotRegisteredException;
import br.com.agence.fleet.vehicles.infra.validation.BrandValidation;
import javassist.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BrandDao implements BrandRepositoryPort {
	
	private BrandRepository repository;
	private BrandValidation validation;
	private BrandMapper brandMapper;
	
	public BrandDao(BrandRepository repository, BrandValidation validation, BrandMapper brandMapper) {
		this.repository = repository;
		this.validation = validation;
		this.brandMapper = brandMapper;
		
	}
	
	@Override
	@Transactional
	public BrandPort createBrand(BrandPort brandPort) throws NotFoundException {
		Brand brand = brandMapper.toDomain(brandPort);
		validation.isValid(Optional.ofNullable(brand));
		repository.save(brand);
		return brandMapper.toModel(brand);
	}
	
	@Override
	public Brand findById(Long idBrand) throws NotFoundException {
		Optional<Brand> optionalBrand = repository.findById(idBrand);
		return optionalBrand.orElseThrow(() -> new BrandNotRegisteredException());
	}
	
	@Override
	public List<BrandPort> getAllBrand() {
		List<Brand> brands = repository.findAll();
		return brands.stream().map(Brand::toBrandPort).collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public void removeBrand(BrandPort brandPort) throws NotFoundException {
		Optional<Brand> brand = repository.findByDocument(brandPort.getDocument());
		
		if (brand.isEmpty()) {
			throw new BrandNotRegisteredException();
		}
		
		brand.get().setActive(Boolean.FALSE);
		brand.get().setUpdateDate(LocalDateTime.now());
		repository.save(brand.get());
	}
	
}
