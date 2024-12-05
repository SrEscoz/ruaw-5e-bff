package net.escoz.ruaw5ebff.controllers.dtos.clazz;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class ClassInDTO {

	@NotBlank(message = "El nombre de la clase es obligatorio")
	@Size(max = 255, message = "El nombre no puede exceder los 255 caracteres")
	private String name;

	@NotBlank(message = "La descripción es obligatoria")
	@Size(max = 4000, message = "La descripción no puede exceder los 4000 caracteres")
	private String description;

	@NotBlank(message = "La descripción breve es obligatoria")
	@Size(max = 1000, message = "La descripción breve no puede exceder los 1000 caracteres")
	private String simpleDescription;

	@NotBlank(message = "La fuente es obligatoria")
	private String source;

	@NotBlank(message = "El dado de golpe es obligatorio")
	@Pattern(regexp = "^d\\d+$", message = "El dado de golpe debe tener el formato 'dN', donde N es un número positivo")
	private String hitDice;

	@Size(max = 1000, message = "La aptitud mágica no puede exceder los 1000 caracteres")
	private String magicalAptitude;

	@Size(max = 1000, message = "El requisito de multiclase no puede exceder los 1000 caracteres")
	private String multiClassRequisite;

	@NotNull(message = "Debe especificar si la clase conoce hechizos")
	private Boolean castsKnown;

	@NotNull(message = "Debe especificar si la clase prepara hechizos")
	private Boolean castPrepared;
}

