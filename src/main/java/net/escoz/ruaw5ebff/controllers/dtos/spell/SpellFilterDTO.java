package net.escoz.ruaw5ebff.controllers.dtos.spell;

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
}
