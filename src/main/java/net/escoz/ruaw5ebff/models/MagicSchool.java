package net.escoz.ruaw5ebff.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum MagicSchool {
	ABJURACION("Abjuración"),
	CONJURACION("Conjuración"),
	ADIVINACION("Adivinación"),
	ENCANTAMIENTO("Encantamiento"),
	EVOCACION("Evocación"),
	ILUSION("Ilusión"),
	NIGROMANCIA("Nigromancia"),
	TRANSMUTACION("Transmutación");

	private final String displayName;

	public static MagicSchool fromDisplayName(String displayName) {
		return Arrays.stream(MagicSchool.values())
				.filter(school -> school.getDisplayName().equals(displayName))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Magic school with name: " + displayName + " not found"));
	}

}