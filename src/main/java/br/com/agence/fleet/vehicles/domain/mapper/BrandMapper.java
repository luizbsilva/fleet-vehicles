package br.com.agence.fleet.vehicles.domain.mapper;

import br.com.agence.fleet.vehicles.domain.BrandPort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Brand;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class BrandMapper implements MapperDomain<Brand, BrandPort> {
	
	@Override
	public BrandPort toModel(Brand brand) {
		
		if (brand == null) {
			return null;
		}
		
		return BrandPort.builder().id(brand.getId()).name(brand.getName()).document(brand.getDocument())
				.active(brand.isActive()).createDate(brand.getCreateDate())
				.updateDate(brand.getUpdateDate() != null ? brand.getUpdateDate() : null).build();
	}
	
	@Override
	public Brand toDomain(BrandPort brandPort) {
		if (brandPort == null) {
			return null;
		}
		
		return Brand.builder().name(brandPort.getName()).document(brandPort.getDocument()).active(Boolean.TRUE)
				.createDate(LocalDateTime.now()).build();
	}
	
}
