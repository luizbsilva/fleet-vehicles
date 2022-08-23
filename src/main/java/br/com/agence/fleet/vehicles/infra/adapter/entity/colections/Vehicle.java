package br.com.agence.fleet.vehicles.infra.adapter.entity.colections;

import br.com.agence.fleet.vehicles.domain.VehiclePort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.BaseDomain;
import br.com.agence.fleet.vehicles.infra.util.ConstantsColections;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = ConstantsColections.VEHICLE)
public class Vehicle extends BaseDomain {
	
	private static final long serialVersionUID = -9052191466844207045L;
	
	@Id
	@SequenceGenerator(name = "seq_vehicle", sequenceName = "vehicle_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vehicle")
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_brand")
	private Brand brand;
	
	@Column(name = "model")
	private String model;
	
	@NotNull
	@Column(name = "board")
	private String board;
	
	@NotNull
	@Column(name = "collor")
	private String collor;
	
	@NotNull
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "create_date", nullable = false, updatable = false)
	private LocalDateTime createDate;
	
	@Column(name = "update_date", insertable = false)
	private LocalDateTime updateDate;
	
	public VehiclePort toVehiclePort() {
		return new VehiclePort(this.id, this.brand.toBrandPort(), this.model, this.board, this.collor, this.active);
	}
	
}
