package net.escoz.ruaw5ebff.controllers.dtos;

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
	private String magicSchool;
	private int level;
	private String description;
	private String castingTime;
	private String range;
	private String components;
	private String materials;
	private String duration;
	private boolean ritual;
	private boolean concentration;
	private String highLevelsDescription;
	private String source;
	private List<String> classes;

}
