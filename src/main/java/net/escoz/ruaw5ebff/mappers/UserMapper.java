package net.escoz.ruaw5ebff.mappers;

import net.escoz.ruaw5ebff.controllers.dtos.user.UserInDTO;
import net.escoz.ruaw5ebff.models.AppUser;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

	@Autowired
	protected PasswordEncoder passwordEncoder;

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "roles", ignore = true)
	public abstract AppUser toEntity(UserInDTO userInDTO);

	@AfterMapping
	protected void updatePassword(@MappingTarget AppUser appUser) {
		appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
	}

	@AfterMapping
	protected void updateRoles(@MappingTarget AppUser appUser) {
		appUser.setRoles("USER");
	}
}
