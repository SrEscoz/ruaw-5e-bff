package net.escoz.ruaw5ebff.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.controllers.dtos.SpellInDTO;
import net.escoz.ruaw5ebff.controllers.dtos.SpellOutDTO;
import net.escoz.ruaw5ebff.mappers.SpellMapper;
import net.escoz.ruaw5ebff.models.Spell;
import net.escoz.ruaw5ebff.services.SpellService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spells")
@AllArgsConstructor
public class SpellController {

	private final SpellService spellService;
	private final SpellMapper spellsMapper;

	@GetMapping
	public ResponseEntity<List<SpellOutDTO>> getSpells() {
		return ResponseEntity
				.ok()
				.body(spellsMapper.toSpellOutDTOs(spellService.findAll()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<SpellOutDTO> getSpell(@PathVariable long id) {
		return ResponseEntity
				.ok()
				.body(spellsMapper.toSpellOutDTO(spellService.findById(id)));
	}

	@GetMapping("/search")
	public ResponseEntity<SpellOutDTO> getSpellByName(@RequestParam String name) {
		return ResponseEntity
				.ok()
				.body(spellsMapper.toSpellOutDTO(spellService.findByName(name)));
	}

	@PostMapping
	public ResponseEntity<SpellOutDTO> postSpell(@Valid @RequestBody SpellInDTO spellInDTO) {
		Spell spell = spellsMapper.toEntity(spellInDTO);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(spellsMapper.toSpellOutDTO(spellService.save(spell)));
	}

	@GetMapping("/schools")
	public ResponseEntity<List<String>> getMagicSchools() {
		return ResponseEntity
				.ok()
				.body(spellService.getAllMagicSchools());
	}
}
