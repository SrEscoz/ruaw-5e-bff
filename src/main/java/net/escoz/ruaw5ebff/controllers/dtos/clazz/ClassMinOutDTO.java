package net.escoz.ruaw5ebff.controllers.dtos.clazz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class ClassMinOutDTO {

	private long id;
	private String name;
	private String simpleDescription;
}
