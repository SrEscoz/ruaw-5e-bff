package net.escoz.ruaw5ebff.controllers.dtos.spell;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SpellOutDTO {

	private long id;
	private String name;
	private String slug;
	private String magicSchool;
	private int level;
	private String description;
	private String castingTime;
	private String range;
	private String components;
	private String materials;
	private String duration;
	private Boolean ritual;
	private Boolean concentration;
	private String highLevelsDescription;
	private String source;
	private List<String> classes;

}
