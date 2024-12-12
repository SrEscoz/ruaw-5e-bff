package net.escoz.ruaw5ebff.controllers.dtos.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class UserLoginDTO {

	@NotBlank(message = "El email es obligatorio")
	private String email;

	@NotBlank(message = "El correo es obligatorio")
	private String password;
}
