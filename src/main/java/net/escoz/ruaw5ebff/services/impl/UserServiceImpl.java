package net.escoz.ruaw5ebff.services.impl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.transaction.Transactional;
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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final JwtService jwtService;
	private final AppUserDetailService appUserDetailService;
	private final AuthenticationManager authenticationManager;

	@Override
	@Transactional
	public void registerUser(AppUser user) {
		checkDuplicated(user);
		userRepository.save(user);
	}

	@Override
	public String loginUser(UserLoginDTO loginDTO) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
			);

			if (authentication.isAuthenticated()) {
				return jwtService.generateToken(appUserDetailService.loadUserByUsername(loginDTO.getEmail()));
			} else {
				throw new AppUserException("Email o contraseña incorrecta");
			}

		} catch (AuthenticationException ex) {
			throw new AppUserException("Email o contraseña incorrecta");
		}
	}

	@Override
	public String refreshToken(String token) {
		try {
			String username = jwtService.extractUsername(token);

			if (username != null) {
				UserDetails userDetails = appUserDetailService.loadUserByJwtUsername(username);

				return jwtService.generateToken(userDetails);

			} else {
				throw new AppUserException("El token contiene un usuario no válido");
			}

		} catch (ExpiredJwtException ex) {
			throw new AppUserException("El token ha expirado");
		} catch (JwtException ex) {
			throw new AppUserException("El token no es válido");
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
