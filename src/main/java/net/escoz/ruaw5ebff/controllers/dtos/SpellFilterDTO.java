package net.escoz.ruaw5ebff.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class SpellFilterDTO {

	private Integer level;
	private String school;
	private String className;
	private String sort = "name";
	private String order = "asc";
}
