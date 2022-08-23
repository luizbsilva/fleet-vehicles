package br.com.agence.fleet.vehicles.infra.exception.enums;

public enum ExceptionsE {
	
	ENROLLMENT_REGISTERED("Matrícula informa já cadastrada"),
	INVALID_LOGIN("Login informado já Existe"),
	EMPLOYEE_NOT_REGISTERED("Funcionário não cadastrado"),
	BRAND_NOT_REGISTERED("Marca não cadastrado"),
	BRAND_REGISTERED("Já existe uma marca cadastrado com esse CNPJ"),
	VEHICLE_REGISTERED("Já existe uma veículo cadastrado com essa placa"),
	VEHICLE_NOT_REGISTERED("Veículo não cadastrado"),
	TRAVEL_NOT_REGISTERED("Viagem não cadastrado"),
	TRAVEL_NOT_REGISTERED_OR_FINISHED("Viagem não cadastrado ou já finalizada");
	
	private final String descricao;
	
	ExceptionsE(String tipo) {
		this.descricao = tipo;
	}
	
	public String getTipo() {
		return descricao;
	}
}
