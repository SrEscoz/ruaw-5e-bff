package net.escoz.ruaw5ebff.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.controllers.dtos.BasicOutDTO;
import net.escoz.ruaw5ebff.controllers.dtos.clazz.ClassInDTO;
import net.escoz.ruaw5ebff.controllers.dtos.clazz.ClassMinOutDTO;
import net.escoz.ruaw5ebff.controllers.dtos.clazz.ClassOutDTO;
import net.escoz.ruaw5ebff.controllers.dtos.clazz.ClassSpellInDTO;
import net.escoz.ruaw5ebff.mappers.ClassMapper;
import net.escoz.ruaw5ebff.models.Class;
import net.escoz.ruaw5ebff.services.ClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
@AllArgsConstructor
public class ClassController {

	private final ClassService classService;
	private final ClassMapper classMapper;

	@GetMapping
	public ResponseEntity<List<ClassMinOutDTO>> getClasses() {
		List<ClassMinOutDTO> classes = classService.getClasses()
				.stream()
				.map(classMapper::toClassMinOutDTO)
				.toList();

		return ResponseEntity
				.ok()
				.body(classes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClassOutDTO> getClass(@PathVariable long id) {
		return ResponseEntity
				.ok()
				.body(classMapper.toClassOutDTO(classService.findClass(id)));
	}

	@PostMapping
	public ResponseEntity<ClassOutDTO> addClass(@Valid @RequestBody ClassInDTO classInDTO) {
		Class clazz = classMapper.toEntity(classInDTO);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(classMapper.toClassOutDTO(classService.addClass(clazz)));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClassOutDTO> updateClass(@PathVariable long id,
	                                               @Valid @RequestBody ClassInDTO classInDTO) {

		return ResponseEntity
				.ok()
				.body(classMapper.toClassOutDTO(classService.updateClass(classInDTO, id)));
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ClassOutDTO> patchClass(@PathVariable long id,
	                                              @RequestBody ClassSpellInDTO spellsDTO) {

		return ResponseEntity
				.ok()
				.body(classMapper.toClassOutDTO(classService.updateClassSpells(spellsDTO, id)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BasicOutDTO> deleteClass(@PathVariable long id) {
		classService.deleteClass(id);

		return ResponseEntity
				.ok(new BasicOutDTO(HttpStatus.OK.value(), "Clase eliminada satisfactoriamente"));
	}
}
