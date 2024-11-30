package net.escoz.ruaw5ebff.controllers;

import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.services.MetadataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/metadata")
@AllArgsConstructor
public class MetadataController {

	private final MetadataService metadataService;

	@GetMapping("/schools")
	public ResponseEntity<List<String>> getMagicSchools() {
		return ResponseEntity
				.ok()
				.body(metadataService.getAllMagicSchools());
	}

	@GetMapping("/classes")
	public ResponseEntity<List<String>> getClasses() {
		return ResponseEntity
				.ok()
				.body(metadataService.getAllClasses());
	}

	@GetMapping("/sources")
	public ResponseEntity<List<String>> getSourceBooks() {
		return ResponseEntity
				.ok()
				.body(metadataService.getSourceBooks());
	}
}
