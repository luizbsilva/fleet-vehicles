package br.com.agence.fleet.vehicles.domain;

import br.com.agence.fleet.vehicles.domain.dto.UserDataDTO;
import br.com.agence.fleet.vehicles.infra.adapter.enums.ProfileEnum;
import java.time.LocalDateTime;

public class UserPort {
    
    private Long id;
    
    private LocalDateTime createdDate;
    
    private LocalDateTime lastModifiedDate;
    
    private String name;
    
    private String email;
    
    private String password;
    
    private ProfileEnum profile;
    
    private boolean active;
    
    public UserPort() {
    }
    
    public UserPort(Long id, LocalDateTime createdDate, LocalDateTime lastModifiedDate,
                    String name, String email, String password, ProfileEnum profile, boolean active) {
        this.id = id;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.active = active;
    }
    
    public UserPort(UserDataDTO userDataDTO) {
        this.name = userDataDTO.getEmail();
        this.email = userDataDTO.getEmail();
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
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
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
    
    public boolean isActive() {
        return active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
    
    public UserDataDTO toUser() {
        return new UserDataDTO(this.id, this.email, this.password, this.profile);
    }
}
