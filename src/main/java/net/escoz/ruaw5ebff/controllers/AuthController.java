package net.escoz.ruaw5ebff.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.configurations.security.JwtService;
import net.escoz.ruaw5ebff.controllers.dtos.BasicOutDTO;
import net.escoz.ruaw5ebff.controllers.dtos.TokenOutDTO;
import net.escoz.ruaw5ebff.controllers.dtos.user.UserInDTO;
import net.escoz.ruaw5ebff.controllers.dtos.user.UserLoginDTO;
import net.escoz.ruaw5ebff.controllers.dtos.user.UserTokenInDTO;
import net.escoz.ruaw5ebff.mappers.UserMapper;
import net.escoz.ruaw5ebff.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

	private final UserService userService;
	private final JwtService jwtService;
	private final UserMapper userMapper;

	@PostMapping("/register")
	public ResponseEntity<BasicOutDTO> registerUser(@Valid @RequestBody UserInDTO userInDTO) {
		userService.registerUser(userMapper.toEntity(userInDTO));

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new BasicOutDTO(HttpStatus.CREATED.value(), "Usuario registrado con éxito"));
	}

	@PostMapping("/login")
	public ResponseEntity<TokenOutDTO> loginUser(@Valid @RequestBody UserLoginDTO userLoginDTO) {
		String token = userService.loginUser(userLoginDTO);

		return ResponseEntity
				.ok()
				.body(new TokenOutDTO(HttpStatus.OK.value(), token, jwtService.getExpiration()));
	}

	@PostMapping("/refresh-token")
	public ResponseEntity<TokenOutDTO> refreshToken(@Valid @RequestBody UserTokenInDTO userTokenInDTO) {
		String newToken = userService.refreshToken(userTokenInDTO.getToken());

		return ResponseEntity
				.ok()
				.body(new TokenOutDTO(HttpStatus.OK.value(), newToken, jwtService.getExpiration()));
	}
}
