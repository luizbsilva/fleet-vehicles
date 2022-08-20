package br.com.agence.fleet.vehicles.infra.adapter.entity.colections;

import br.com.agence.fleet.vehicles.domain.UserPort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.BaseDomain;
import br.com.agence.fleet.vehicles.infra.adapter.enums.ProfileEnum;
import br.com.agence.fleet.vehicles.infra.util.ConstantsColections;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = ConstantsColections.USER)
public class User extends BaseDomain {
    
    private static final long serialVersionUID = -9052191466844207045L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name_user")
    private String name;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "profile")
    private ProfileEnum profile;
    
    @NotNull
    @Column(name = "active")
    private boolean active;
    
    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate;
    
    @Column(name = "update_date", insertable = false)
    private LocalDateTime updateDate;
    
    public UserPort toUser() {
        return new UserPort(this.id, this.createDate,
                this.updateDate, this.name, this.email, this.password, this.profile, this.active = active);
    }

}
