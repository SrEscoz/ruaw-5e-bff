package net.escoz.ruaw5ebff.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassOutDTO {

	private long id;
	private String name;
	private List<SpellOutDTO> spells;
}
