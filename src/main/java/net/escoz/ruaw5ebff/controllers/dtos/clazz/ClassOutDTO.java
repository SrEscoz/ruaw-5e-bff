package net.escoz.ruaw5ebff.controllers.dtos.clazz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.escoz.ruaw5ebff.controllers.dtos.spell.SpellOutDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class ClassOutDTO {

	private long id;
	private String name;
	private String description;
	private List<SpellOutDTO> spells;
	private List<ClassLevelOutDTO> levels;
}
