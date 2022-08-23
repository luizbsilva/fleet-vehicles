package br.com.agence.fleet.vehicles.infra.adapter.entity.colections;

import br.com.agence.fleet.vehicles.domain.UserPort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.BaseDomain;
import br.com.agence.fleet.vehicles.infra.adapter.enums.ProfileEnum;
import br.com.agence.fleet.vehicles.infra.util.ConstantsColections;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = ConstantsColections.USER)
public class User extends BaseDomain {
	
	private static final long serialVersionUID = -9052191466844207045L;
	
	@Id
	@SequenceGenerator(name = "seq_application_user", sequenceName = "application_user_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_application_user")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "profile")
	private ProfileEnum profile;
	
	@NotNull
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "create_date", nullable = false, updatable = false)
	private LocalDateTime createDate;
	
	@Column(name = "update_date", insertable = false)
	private LocalDateTime updateDate;
	
	public UserPort toUserPort() {
		return new UserPort(this.id, this.createDate, this.updateDate, this.login, this.password, this.profile,
				this.active);
	}
	
}
