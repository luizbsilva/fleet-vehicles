package br.com.agence.fleet.vehicles.infra.adapter.entity.colections;

import br.com.agence.fleet.vehicles.domain.BrandPort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.BaseDomain;
import br.com.agence.fleet.vehicles.infra.util.ConstantsColections;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = ConstantsColections.BRAND)
public class Brand extends BaseDomain {
	
	private static final long serialVersionUID = -9052191466844207045L;
	
	@Id
	@SequenceGenerator(name = "seq_brand", sequenceName = "brand_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_brand")
	@Column(name = "id_brand")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "document")
	private String document;
	
	@NotNull
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "create_date", nullable = false, updatable = false)
	private LocalDateTime createDate;
	
	@Column(name = "update_date", insertable = false)
	private LocalDateTime updateDate;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
	private List<Vehicle> vehicle;
	
	public BrandPort toBrandPort() {
		return new BrandPort(this.id, this.name, this.document, this.active);
	}
	
}
