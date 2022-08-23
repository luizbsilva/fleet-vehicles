package br.com.agence.fleet.vehicles.infra.adapter.entity.colections;

import br.com.agence.fleet.vehicles.domain.EmployeePort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.BaseDomain;
import br.com.agence.fleet.vehicles.infra.util.ConstantsColections;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = ConstantsColections.EMPLOYEE)
public class Employee extends BaseDomain {
	
	private static final long serialVersionUID = -9052191466844207045L;
	
	@Id
	@SequenceGenerator(name = "seq_employee", sequenceName = "employee_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_employee")
	@Column(name = "id_employee")
	private Long id;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "employeeRegistration")
	private String employeeRegistration;
	
	@OneToOne
	@JoinColumn(name = "id_application_user")
	private User user;
	
	@NotNull
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "create_date", nullable = false, updatable = false)
	private LocalDateTime createDate;
	
	@Column(name = "update_date", insertable = false)
	private LocalDateTime updateDate;
	
	public EmployeePort toEmployeePort() {
		return new EmployeePort(this.id, this.employeeName, this.employeeRegistration, this.user.toUserPort()
		,this.active);
	}
	
}
