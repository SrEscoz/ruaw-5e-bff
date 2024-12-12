package net.escoz.ruaw5ebff.controllers.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class UserLoginDTO {

	private String email;
	private String password;
}
