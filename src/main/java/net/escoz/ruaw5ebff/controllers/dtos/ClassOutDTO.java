package net.escoz.ruaw5ebff.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class ClassOutDTO {

	private long id;
	private String name;
	private List<SpellOutDTO> spells;
	private List<ClassLevelOutDTO> levels;
}
