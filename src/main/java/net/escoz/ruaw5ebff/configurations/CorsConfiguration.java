package net.escoz.ruaw5ebff.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

	@Value("${ruaw.allowed-origin}")
	private String allowedOrigin;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins(allowedOrigin)
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
	}
}