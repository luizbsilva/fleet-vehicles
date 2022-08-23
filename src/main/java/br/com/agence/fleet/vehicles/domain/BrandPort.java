package br.com.agence.fleet.vehicles.domain;

import br.com.agence.fleet.vehicles.domain.dto.BrandDTO;
import br.com.agence.fleet.vehicles.domain.request.BrandRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.text.ParseException;
import java.time.LocalDateTime;
@Builder
@AllArgsConstructor
public class BrandPort {
	
	private Long id;
	
	private String name;
	private String document;
	
	private Boolean active;
	
	private LocalDateTime createDate;
	
	private LocalDateTime updateDate;
	
	public BrandPort() {
	}
	
	public BrandPort(BrandDTO brandDTO) {
		this.id = brandDTO.getId();
		this.name = brandDTO.getName();
		this.active = brandDTO.getAtivo();
	}
	
	public BrandPort(BrandRequest request) {
		this.name = request.getName();
		this.document = request.getDocument().replaceAll("[./-]", "");
	}
	
	public BrandPort(Long id, String name, String document, Boolean active) {
		this.id = id;
		this.name = name;
		this.document = document;
		this.active = active;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDocument() {
		return document;
	}
	
	public void setDocument(String document) {
		this.document = document;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	
	public BrandDTO toBrandDTO() throws ParseException {
		return new BrandDTO(this.id, this.name, this.document, this.active);
	}
	
}
