package br.com.agence.fleet.vehicles.controller.advice;

import br.com.agence.fleet.vehicles.infra.exception.BrandNotRegisteredException;
import br.com.agence.fleet.vehicles.infra.exception.BrandRegisterException;
import br.com.agence.fleet.vehicles.infra.exception.EmployeeNotRegisteredException;
import br.com.agence.fleet.vehicles.infra.exception.EmployeeRegisterException;
import br.com.agence.fleet.vehicles.infra.exception.InvalidLoginException;
import br.com.agence.fleet.vehicles.infra.exception.TravelNotRegisteredException;
import br.com.agence.fleet.vehicles.infra.exception.TravelNotRegisteredOrFinishedException;
import br.com.agence.fleet.vehicles.infra.exception.VehicleNotRegisteredException;
import br.com.agence.fleet.vehicles.infra.exception.VehicleRegisterException;
import br.com.agence.fleet.vehicles.infra.exception.enums.ExceptionsE;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public final class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeeRegisterException.class)
	public ResponseEntity<?> handlerEmployeeRegisterAlready(EmployeeRegisterException fee) {
		return new ResponseEntity<>(ExceptionsE.ENROLLMENT_REGISTERED.getTipo(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(InvalidLoginException.class)
	public ResponseEntity<?> handlerInvalidLogin(InvalidLoginException fee) {
		return new ResponseEntity<>(ExceptionsE.INVALID_LOGIN.getTipo(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(EmployeeNotRegisteredException.class)
	public ResponseEntity<?> handlerEmployeeNotRegistered(EmployeeNotRegisteredException fee) {
		return new ResponseEntity<>(ExceptionsE.EMPLOYEE_NOT_REGISTERED.getTipo(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(BrandNotRegisteredException.class)
	public ResponseEntity<?> handlerBrandNotRegister(BrandNotRegisteredException fee) {
		return new ResponseEntity<>(ExceptionsE.BRAND_NOT_REGISTERED.getTipo(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(BrandRegisterException.class)
	public ResponseEntity<?> handlerBrandRegister(BrandRegisterException fee) {
		return new ResponseEntity<>(ExceptionsE.BRAND_REGISTERED.getTipo(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(VehicleRegisterException.class)
	public ResponseEntity<?> handlerVehicleRegister(VehicleRegisterException fee) {
		return new ResponseEntity<>(ExceptionsE.VEHICLE_REGISTERED.getTipo(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(VehicleNotRegisteredException.class)
	public ResponseEntity<?> handlerVehicleNorRegister(VehicleNotRegisteredException fee) {
		return new ResponseEntity<>(ExceptionsE.VEHICLE_NOT_REGISTERED.getTipo(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(TravelNotRegisteredException.class)
	public ResponseEntity<?> handlerTravelNotRegister(TravelNotRegisteredException fee) {
		return new ResponseEntity<>(ExceptionsE.TRAVEL_NOT_REGISTERED.getTipo(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(TravelNotRegisteredOrFinishedException.class)
	public ResponseEntity<?> handlerTravelNotRegisteredOrFinished(TravelNotRegisteredOrFinishedException fee) {
		return new ResponseEntity<>(ExceptionsE.TRAVEL_NOT_REGISTERED_OR_FINISHED.getTipo(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
}
