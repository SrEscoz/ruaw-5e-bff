package net.escoz.ruaw5ebff.configurations.security;

import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.models.AppUser;
import net.escoz.ruaw5ebff.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserDetailService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));

		return User.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.roles(getRoles(user.getRoles()))
				.build();
	}

	private String[] getRoles(String roles) {
		if (roles == null)
			return new String[]{"USER"};

		return roles.split(",");
	}
}
