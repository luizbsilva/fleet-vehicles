package br.com.agence.fleet.vehicles.domain.adapter.service;

import br.com.agence.fleet.vehicles.domain.BrandPort;
import br.com.agence.fleet.vehicles.domain.dto.BrandDTO;
import br.com.agence.fleet.vehicles.domain.port.adapter.BrandServicePort;
import br.com.agence.fleet.vehicles.domain.port.repository.BrandRepositoryPort;
import br.com.agence.fleet.vehicles.domain.request.BrandRequest;
import javassist.NotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class BrandServiceImpl implements BrandServicePort {
	
	private BrandRepositoryPort repositoryPort;
	
	public BrandServiceImpl(BrandRepositoryPort repositoryPort) {
		this.repositoryPort = repositoryPort;
	}
	
	@Override
	public BrandDTO createBrand(BrandRequest request) throws NotFoundException, ParseException {
		BrandPort brandPort = repositoryPort.createBrand(new BrandPort(request));
		return brandPort.toBrandDTO();
	}
	
	@Override
	public List<BrandDTO> getAllBrand() {
		List<BrandPort> brandPorts = repositoryPort.getAllBrand();
		List<BrandDTO> brandDTOList = new ArrayList<>();
		brandPorts.forEach(brandPort -> {
			try {
				brandDTOList.add(brandPort.toBrandDTO());
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		});
		return brandDTOList;
	}
	
	@Override
	public void removeBrand(String document) throws NotFoundException {
		repositoryPort.removeBrand(BrandPort.builder().document(document.replaceAll("[./-]", "")).build());
		
		
	}
	
}
