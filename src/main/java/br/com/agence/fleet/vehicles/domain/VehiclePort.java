package br.com.agence.fleet.vehicles.domain;

import br.com.agence.fleet.vehicles.domain.dto.VehicleDTO;
import br.com.agence.fleet.vehicles.domain.request.VehicleRequest;
import br.com.agence.fleet.vehicles.domain.response.EmployeeResponse;
import br.com.agence.fleet.vehicles.domain.response.VehicleInuseResponse;
import br.com.agence.fleet.vehicles.domain.response.VehicleResponse;
import br.com.agence.fleet.vehicles.infra.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.text.ParseException;
import java.time.LocalDateTime;
@Builder
@AllArgsConstructor
public class VehiclePort {
	
	private Long id;
	
	private BrandPort brandPort;
	
	private String model;
	
	private String board;
	
	private String collor;
	
	private Boolean active;
	
	private LocalDateTime dateWithdrawal;
	
	private LocalDateTime createDate;
	
	private LocalDateTime updateDate;
	
	public VehiclePort() {
	}
	
	public VehiclePort(VehicleDTO vehicleDTO) {
		this.id = vehicleDTO.getId();
		this.brandPort = new BrandPort(vehicleDTO.getBrandDTO());
		this.model = vehicleDTO.getModel();
		this.collor = vehicleDTO.getCollor();
	}
	
	public VehiclePort(VehicleRequest request) {
		this.model = request.getModel();
		this.collor = request.getCollor();
		this.board = request.getBoard();
		this.brandPort = BrandPort.builder().id(request.getIdBrandD()).build();
	}
	
	public VehiclePort(Long id, BrandPort brandPort, String model, String board, LocalDateTime dateWithdrawal) {
		this.id = id;
		this.brandPort = brandPort;
		this.model = model;
		this.board = board;
		this.dateWithdrawal = dateWithdrawal;
	}
	
	public VehiclePort(Long id, BrandPort brandPort, String model, String board, String collor, Boolean active) {
		this.id = id;
		this.brandPort = brandPort;
		this.model = model;
		this.board = board;
		this.collor = collor;
		this.active = active;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public BrandPort getBrandPort() {
		return brandPort;
	}
	
	public void setBrandPort(BrandPort brandPort) {
		this.brandPort = brandPort;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getBoard() {
		return board;
	}
	
	public void setBoard(String board) {
		this.board = board;
	}
	
	public String getCollor() {
		return collor;
	}
	
	public void setCollor(String collor) {
		this.collor = collor;
	}
	
	public Boolean isActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
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
	public VehicleResponse toVehicleResponse() {
		return new VehicleResponse(this.id, this.model, this.brandPort.getName(), this.board, this.collor);
	}
	public VehicleDTO toVehicleDTO() throws ParseException {
		return new VehicleDTO(this.id, this.brandPort.toBrandDTO(), this.model, this.board, this.collor);
	}
	public VehicleInuseResponse toVehicleInuseResponse(){
		return new VehicleInuseResponse(this.id, this.model, this.brandPort.getName(), this.board, DateUtil.dateTimeToString(this.dateWithdrawal, "dd/MM/yyyy"));
	}
	
}
