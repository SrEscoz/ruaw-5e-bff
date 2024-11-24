package net.escoz.ruaw5ebff.controllers;

import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.services.SpellService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spells")
@AllArgsConstructor
public class SpellController {

	private final SpellService spellService;

	@GetMapping("/schools")
	public ResponseEntity<List<String>> getMagicSchools() {
		return ResponseEntity
				.ok()
				.body(spellService.getAllMagicSchools());
	}
}
