package br.com.agence.fleet.vehicles.domain.mapper;

import br.com.agence.fleet.vehicles.domain.TravelPort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.Travel;

public class TravelMapper {
	
	public static TravelPort toTravelPort(Travel travel) {
		return TravelPort.builder().id(travel.getId()).description(travel.getDescription())
				.employeePort(travel.getEmployee().toEmployeePort()).vehiclePort(travel.getVehicle().toVehiclePort())
				.dateWithdrawal(travel.getDateWithdrawal())
				.deliveryDate(travel.getDeliveryDate() != null ? travel.getDeliveryDate() : null)
				.active(travel.isActive()).createDate(travel.getCreateDate())
				.updateDate(travel.getUpdateDate() != null ? travel.getUpdateDate() : null).build();
	}
	
}
