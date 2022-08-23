package br.com.agence.fleet.vehicles.domain;

import br.com.agence.fleet.vehicles.domain.dto.UserDataDTO;
import br.com.agence.fleet.vehicles.infra.adapter.enums.ProfileEnum;
import br.com.agence.fleet.vehicles.infra.util.PasswordGenerator;
import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public class UserPort {
	
	private Long id;
	
	private LocalDateTime createdDate;
	
	private LocalDateTime lastModifiedDate;
	
	private String login;
	
	private String password;
	
	private ProfileEnum profile;
	
	private Boolean active;
	
	public UserPort() {
	}
	
	public UserPort(Long id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, String login, String password,
					ProfileEnum profile, boolean active) {
		this.id = id;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.login = login;
		this.password = password;
		this.profile = profile;
		this.active = active;
	}
	
	public UserPort(String login, String password) {
		this.login = login;
		this.password = PasswordGenerator.passwordGenerator(password);
	}
	
	public UserPort(UserDataDTO userDataDTO) {
		this.login = userDataDTO.getLogin();
		this.password = userDataDTO.getPassword();
		this.profile = userDataDTO.getProfile();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}
	
	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public ProfileEnum getProfile() {
		return profile;
	}
	
	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public UserDataDTO toUser() {
		return new UserDataDTO(this.id, this.login, this.password, this.profile);
	}
	
}
