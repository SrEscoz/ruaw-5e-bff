package net.escoz.ruaw5ebff.controllers;

import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.controllers.dtos.ClassOutDTO;
import net.escoz.ruaw5ebff.mappers.ClassMapper;
import net.escoz.ruaw5ebff.services.ClassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classes")
@AllArgsConstructor
public class ClassController {

	private final ClassService classService;
	private final ClassMapper classMapper;

	@Deprecated
	@GetMapping
	public ResponseEntity<List<ClassOutDTO>> getClasses() {
		return ResponseEntity
				.ok()
				.body(classMapper.toClassOutDTOs(classService.findAll()));
	}
}
