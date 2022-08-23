package br.com.agence.fleet.vehicles.domain.mapper;

import br.com.agence.fleet.vehicles.domain.UserPort;
import br.com.agence.fleet.vehicles.infra.adapter.entity.colections.User;
import br.com.agence.fleet.vehicles.infra.adapter.enums.ProfileEnum;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class UserMapper implements MapperDomain<User, UserPort> {
	
	
	@Override
	public UserPort toModel(User user) {
		if (user == null) {
			return null;
		}
		
		UserPort userPort = UserPort.builder().id(user.getId()).login(user.getLogin()).password(user.getPassword())
				.profile(user.getProfile()).active(user.toUserPort().getActive()).createdDate(LocalDateTime.now())
				.lastModifiedDate(user.getUpdateDate() != null ? user.getUpdateDate() : null).build();
		return userPort;
	}
	
	@Override
	public User toDomain(UserPort userPort) {
		if (userPort == null) {
			return null;
		}
		
		User employee =
				User.builder().id(userPort.getId()).login(userPort.getLogin()).password(userPort.getPassword())
				.profile(ProfileEnum.ROLE_USER).active(Boolean.TRUE).createDate(LocalDateTime.now()).build();
		return employee;
	}
	
}
