package net.escoz.ruaw5ebff.controllers.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class UserInDTO {

	@NotBlank(message = "El nombre de usuario no puede estar vacío.")
	@Size(min = 3, max = 20, message = "El nombre de usuario debe tener entre 3 y 20 caracteres.")
	private String username;

	@NotBlank(message = "La contraseña no puede estar vacía.")
	@Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres.")
	@Pattern(
			regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).*$",
			message = "La contraseña debe contener al menos una letra mayúscula, una minúscula, un número y un carácter especial."
	)
	private String password;

	@NotBlank(message = "El correo electrónico no puede estar vacío.")
	@Email(message = "El formato del correo electrónico no es válido.")
	private String email;
}
