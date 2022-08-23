package br.com.agence.fleet.vehicles.domain;

import br.com.agence.fleet.vehicles.domain.dto.EmployeeDTO;
import br.com.agence.fleet.vehicles.domain.request.VehicleRequest;
import br.com.agence.fleet.vehicles.domain.response.EmployeeResponse;
import br.com.agence.fleet.vehicles.domain.request.EmployeeRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
public class EmployeePort {
	
	private Long id;
	
	private String employeeName;
	
	private String employeeRegistration;
	
	private UserPort userPort;
	
	private boolean active;
	
	private LocalDateTime createDate;
	
	private LocalDateTime updateDate;
	
	public EmployeePort() {
	}
	
	public EmployeePort(EmployeeDTO employeeDTO) {
		this.id = employeeDTO.getId();
		this.employeeName = employeeDTO.getEmployeeName();
		this.employeeRegistration = employeeDTO.getEmployeeRegistration();
	}
	
	public EmployeePort(EmployeeRequest request) {
		this.employeeName = request.getName();
		this.employeeRegistration = request.getNumberRegistration();
		this.userPort = new UserPort(request.getLogin(), request.getPassword());
	}
	
	public EmployeePort(Long id, String employeeName, String employeeRegistration, UserPort userPort,
						boolean active) {
		this.id = id;
		this.employeeName = employeeName;
		this.employeeRegistration = employeeRegistration;
		this.userPort = userPort;
		this.active = active;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getEmployeeRegistration() {
		return employeeRegistration;
	}
	
	public void setEmployeeRegistration(String employeeRegistration) {
		this.employeeRegistration = employeeRegistration;
	}
	
	public UserPort getUserPort() {
		return userPort;
	}
	
	public void setUserPort(UserPort userPort) {
		this.userPort = userPort;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
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
	
	public EmployeeDTO toEmployeeDTO() {
		return new EmployeeDTO(this.id, this.employeeName, this.userPort.toUser(), this.employeeRegistration);
	}
	public EmployeeResponse toEmployeeResponse() {
		return new EmployeeResponse(this.id, this.employeeName, this.employeeRegistration);
	}
	
	
}
