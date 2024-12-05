package net.escoz.ruaw5ebff.controllers;

import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.controllers.dtos.clazz.ClassMinOutDTO;
import net.escoz.ruaw5ebff.controllers.dtos.clazz.ClassOutDTO;
import net.escoz.ruaw5ebff.mappers.ClassMapper;
import net.escoz.ruaw5ebff.services.ClassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<ClassOutDTO> getClass(@PathVariable Long id) {
		return ResponseEntity
				.ok()
				.body(classMapper.toClassOutDTO(classService.findClass(id)));
	}

}
