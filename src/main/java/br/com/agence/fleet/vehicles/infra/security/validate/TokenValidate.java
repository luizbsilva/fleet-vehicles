package br.com.agence.fleet.vehicles.infra.security.validate;

public class TokenValidate {
	
	private String token;
	
	public TokenValidate() {
	}
	
	public TokenValidate(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
}
