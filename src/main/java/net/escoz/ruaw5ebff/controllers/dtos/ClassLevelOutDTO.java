package net.escoz.ruaw5ebff.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
public final class ClassLevelOutDTO {

	private Integer level;
	private Integer proficiencyBonus;
	private Integer knownCantrips;
	private String features;
	private Map<String, String> spellSlots;
}