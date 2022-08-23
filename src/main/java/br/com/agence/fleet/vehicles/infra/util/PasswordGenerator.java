package br.com.agence.fleet.vehicles.infra.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
	
	public static String passwordGenerator(String password) {
		final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
		
	}
	
}
