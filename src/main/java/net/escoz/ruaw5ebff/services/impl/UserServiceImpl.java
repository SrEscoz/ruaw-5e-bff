package net.escoz.ruaw5ebff.services.impl;

import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.configurations.security.AppUserDetailService;
import net.escoz.ruaw5ebff.configurations.security.JwtService;
import net.escoz.ruaw5ebff.controllers.dtos.user.UserLoginDTO;
import net.escoz.ruaw5ebff.exceptions.AppUserException;
import net.escoz.ruaw5ebff.exceptions.UserConflictException;
import net.escoz.ruaw5ebff.models.AppUser;
import net.escoz.ruaw5ebff.repositories.UserRepository;
import net.escoz.ruaw5ebff.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final JwtService jwtService;
	private final AppUserDetailService appUserDetailService;
	private final AuthenticationManager authenticationManager;

	@Override
	public void registerUser(AppUser user) {
		checkDuplicated(user);
		userRepository.save(user);
	}

	@Override
	public String loginUser(UserLoginDTO loginDTO) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
			);

			if (authentication.isAuthenticated()) {
				return jwtService.generateToken(appUserDetailService.loadUserByUsername(loginDTO.getUsername()));
			} else {
				throw new AppUserException("Usuario o contraseña incorrecta");
			}

		} catch (AuthenticationException ex) {
			throw new AppUserException("Usuario o contraseña incorrecta");
		}
	}

	private void checkDuplicated(AppUser user) {
		userRepository.findByUsername(user.getUsername())
				.ifPresent(u -> {
					throw new UserConflictException(user.getUsername());
				});

		userRepository.findByEmail(user.getEmail())
				.ifPresent(u -> {
					throw new UserConflictException(user.getEmail());
				});
	}
}
