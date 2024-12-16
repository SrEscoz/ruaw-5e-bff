package net.escoz.ruaw5ebff.configurations;

import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.configurations.security.JwtAuthFilter;
import net.escoz.ruaw5ebff.exceptions.UserUnauthorizedException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration {

	private final UserDetailsService userDetailsService;
	private final HandlerExceptionResolver handlerExceptionResolver;
	private final JwtAuthFilter jwtAuthFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(registry ->
						registry.requestMatchers("/auth/**").permitAll()
								.requestMatchers(HttpMethod.GET).permitAll()
								.anyRequest().hasRole("ADMIN")
				)
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
				.exceptionHandling(exceptionHandling ->
						exceptionHandling
								.accessDeniedHandler((request, response, accessDeniedException) -> {
									UserUnauthorizedException invalidTokenException = new UserUnauthorizedException("Acceso denegado: no tienes los permisos suficientes");
									handlerExceptionResolver.resolveException(request, response, null, invalidTokenException);
								})
								.authenticationEntryPoint((request, response, authException) -> {
									UserUnauthorizedException invalidTokenException = new UserUnauthorizedException("Acceso denegado: credenciales no válidas");
									handlerExceptionResolver.resolveException(request, response, null, invalidTokenException);
								})
				)
				.build();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager() {
		return new ProviderManager(authenticationProvider());
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return userDetailsService;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
