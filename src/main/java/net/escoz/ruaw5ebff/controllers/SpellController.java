package net.escoz.ruaw5ebff.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.controllers.dtos.BasicOutDTO;
import net.escoz.ruaw5ebff.controllers.dtos.PageOutDTO;
import net.escoz.ruaw5ebff.controllers.dtos.spell.SpellFilterDTO;
import net.escoz.ruaw5ebff.controllers.dtos.spell.SpellInDTO;
import net.escoz.ruaw5ebff.controllers.dtos.spell.SpellOutDTO;
import net.escoz.ruaw5ebff.mappers.SpellMapper;
import net.escoz.ruaw5ebff.models.Spell;
import net.escoz.ruaw5ebff.services.SpellService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spells")
@AllArgsConstructor
public class SpellController {

	private final SpellService spellService;
	private final SpellMapper spellMapper;

	@GetMapping
	public ResponseEntity<PageOutDTO<?>> getSpells(SpellFilterDTO filters,
	                                               @PageableDefault(sort = {"name"}, direction = Sort.Direction.ASC, size = 20)
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

	@GetMapping("/classes/{id}")
	public ResponseEntity<List<SpellOutDTO>> getClassSpells(@PathVariable long id) {
		List<SpellOutDTO> spells = spellService.findSpellsByClass(id).stream()
				.map(spellMapper::toSpellMinDTO)
				.toList();

		return ResponseEntity
				.ok()
				.body(spells);
	}

	@PostMapping
	public ResponseEntity<SpellOutDTO> postSpell(@Valid @RequestBody SpellInDTO spellInDTO) {
		Spell spell = spellMapper.toEntity(spellInDTO);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(spellMapper.toSpellOutDTO(spellService.saveSpell(spell)));
	}

	@PutMapping("/{id}")
	public ResponseEntity<SpellOutDTO> updateSpell(@PathVariable long id,
	                                               @Valid @RequestBody SpellInDTO spellInDTO) {

		return ResponseEntity
				.ok()
				.body(spellMapper.toSpellOutDTO(spellService.updateSpell(spellInDTO, id)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BasicOutDTO> deleteSpell(@PathVariable long id) {
		spellService.deleteSpell(id);
		return ResponseEntity
				.ok(new BasicOutDTO(HttpStatus.OK.value(), "Hechizo eliminado satisfactoriamente"));
	}
}
