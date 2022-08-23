package br.com.agence.fleet.vehicles.infra.adapter.entity.colections;

import br.com.agence.fleet.vehicles.domain.TravelPort;
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
@Table(name = ConstantsColections.TRAVEL)
public class Travel extends BaseDomain {
	
	private static final long serialVersionUID = -9052191466844207045L;
	
	@Id
	@SequenceGenerator(name = "seq_travel", sequenceName = "travel_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_travel")
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "description")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_employee")
	private Employee employee;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_car")
	private Vehicle vehicle;
	
	@Column(name = "date_withdrawal")
	private LocalDateTime dateWithdrawal;
	
	@NotNull
	@Column(name = "delivery_date")
	private LocalDateTime deliveryDate;
	
	@NotNull
	@Column(name = "month")
	private Integer month;
	
	@NotNull
	@Column(name = "year")
	private Integer year;
	
	@NotNull
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "create_date", nullable = false, updatable = false)
	private LocalDateTime createDate;
	
	@Column(name = "update_date", insertable = false)
	private LocalDateTime updateDate;
	
	public TravelPort toTravelPort() {
		return new TravelPort(this.id, this.description, this.employee.toEmployeePort(), this.vehicle.toVehiclePort(),
				this.dateWithdrawal, this.deliveryDate, this.active);
	}
	
	public VehiclePort toVehiclePort() {
		return new VehiclePort(this.id, this.vehicle.getBrand().toBrandPort(), this.vehicle.getModel(), this.vehicle.getBoard(), this.dateWithdrawal);
	}
	
}
