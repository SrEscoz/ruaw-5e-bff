package net.escoz.ruaw5ebff.controllers.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpellInDTO {

	@NotBlank(message = "El nombre del hechizo es obligatorio")
	@Size(max = 255, message = "El nombre no puede exceder los 255 caracteres")
	private String name;

	@NotNull(message = "La escuela de magia es obligatoria")
	private String magicSchool;

	@NotNull(message = "El nivel del hechizo es obligatorio")
	@Min(value = 0, message = "El nivel debe ser al menos 0")
	@Max(value = 9, message = "El nivel no puede ser mayor a 9")
	private Integer level;

	@NotBlank(message = "La descripción es obligatoria")
	@Size(max = 4000, message = "La descripción no puede exceder los 4000 caracteres")
	private String description;

	@NotBlank(message = "El tiempo de lanzamiento es obligatorio")
	private String castingTime;

	@NotBlank(message = "El rango es obligatorio")
	private String range;

	@NotBlank(message = "Los componentes son obligatorios")
	@Pattern(regexp = "^[VSM, ]+$", message = "Los componentes deben ser una combinación de 'V', 'S' y 'M'")
	private String components;

	@Size(max = 1000, message = "Los materiales no pueden exceder los 1000 caracteres")
	private String materials;

	@NotBlank(message = "La duración es obligatoria")
	private String duration;

	private Boolean ritual = false;

	private Boolean concentration = false;

	@Size(max = 4000, message = "La descripción para niveles superiores no puede exceder los 4000 caracteres")
	private String highLevelsDescription;

	@NotBlank(message = "La fuente es obligatoria")
	private String source;
}
