package net.escoz.ruaw5ebff.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.controllers.dtos.*;
import net.escoz.ruaw5ebff.mappers.SpellMapper;
import net.escoz.ruaw5ebff.models.Spell;
import net.escoz.ruaw5ebff.services.SpellService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spells")
@AllArgsConstructor
public class SpellController {

	private final SpellService spellService;
	private final SpellMapper spellMapper;

	@GetMapping
	public ResponseEntity<PageOutDTO<?>> getSpells(SpellFilterDTO filters,
	                                               Pageable pageable) {

		Page<Spell> spells = spellService.findSpells(pageable, filters);
		PageOutDTO<SpellOutDTO> response = new PageOutDTO<>(spells.map(spellMapper::toSpellOutDTO));

		return ResponseEntity
				.ok()
				.body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SpellOutDTO> getSpell(@PathVariable long id) {
		return ResponseEntity
				.ok()
				.body(spellMapper.toSpellOutDTO(spellService.findById(id)));
	}

	@PostMapping
	public ResponseEntity<SpellOutDTO> postSpell(@Valid @RequestBody SpellInDTO spellInDTO) {
		Spell spell = spellMapper.toEntity(spellInDTO);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(spellMapper.toSpellOutDTO(spellService.save(spell)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BasicOutDTO> deleteSpell(@PathVariable long id) {
		spellService.delete(id);
		return ResponseEntity
				.ok(new BasicOutDTO(HttpStatus.OK.value(), "Hechizo eliminado satisfactoriamente"));
	}
}
