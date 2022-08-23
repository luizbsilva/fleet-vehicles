package br.com.agence.fleet.vehicles.infra.validation;

import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.User;
import br.com.agence.fleet.vehicles.infra.adapter.repository.UserRepository;
import br.com.agence.fleet.vehicles.infra.exception.InvalidLoginException;
import br.com.agence.fleet.vehicles.infra.exception.dto.ErrorInfo;
import javassist.NotFoundException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserValidation implements Validation<User> {
	
	public static final String RECORD_ALREADY_REGISTERED = "Login ja cadastrado informa já cadastrada";
	private UserRepository userRepository;
	
	public UserValidation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void isValid(Optional<User> res) throws NotFoundException {
		User user = res.orElseThrow(() -> new NotFoundException(""));
		List<ErrorInfo> listErrorUser = new ArrayList<>();
		
		Optional<User> userOld = Optional.ofNullable(userRepository.findByLogin(user.getLogin()));
		
		if (userOld.isPresent()) {
			listErrorUser.add(new ErrorInfo(RECORD_ALREADY_REGISTERED));
		}
		if (!userOld.isEmpty()) {
			throw new InvalidLoginException();
		}
		
	}
	
}
