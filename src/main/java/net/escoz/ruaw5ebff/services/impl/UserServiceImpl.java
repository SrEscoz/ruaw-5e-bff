package net.escoz.ruaw5ebff.services.impl;

import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.exceptions.UserConflictException;
import net.escoz.ruaw5ebff.models.AppUser;
import net.escoz.ruaw5ebff.repositories.UserRepository;
import net.escoz.ruaw5ebff.services.UserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public void registerUser(AppUser user) {
		checkDuplicated(user);
		userRepository.save(user);
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
