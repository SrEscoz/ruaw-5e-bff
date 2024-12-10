package net.escoz.ruaw5ebff.services;

import net.escoz.ruaw5ebff.controllers.dtos.user.UserLoginDTO;
import net.escoz.ruaw5ebff.models.AppUser;

public interface UserService {

	void registerUser(AppUser user);

	String loginUser(UserLoginDTO loginDTO);
}
