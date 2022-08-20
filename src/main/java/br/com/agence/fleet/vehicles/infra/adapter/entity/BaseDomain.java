package br.com.agence.fleet.vehicles.infra.adapter.entity;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseDomain<ID> implements Serializable {
	
	private static final long serialVersionUID = 2279373407613957602L;
	
	public abstract void setId(Long id);
	
	public abstract void setCreateDate(LocalDateTime createDate);
	
	public abstract void setUpdateDate(LocalDateTime updateDate);
	
}
