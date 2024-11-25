package net.escoz.ruaw5ebff.services;

import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.controllers.dtos.SpellFilterDTO;
import net.escoz.ruaw5ebff.exceptions.SpellConflictException;
import net.escoz.ruaw5ebff.exceptions.SpellNotFoundException;
import net.escoz.ruaw5ebff.models.Class;
import net.escoz.ruaw5ebff.models.MagicSchool;
import net.escoz.ruaw5ebff.models.Spell;
import net.escoz.ruaw5ebff.repositories.SpellRepository;
import net.escoz.ruaw5ebff.repositories.specifications.SpellSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class SpellServiceImpl implements SpellService {

	private final ClassService classService;
	private final SpellRepository spellRepository;

	@Override
	public Page<Spell> findSpells(Pageable pageable, SpellFilterDTO filters) {
		Specification<Spell> spec = SpellSpecification.fromFilter(filters);

		return spellRepository.findAll(spec, pageable);
	}

	@Override
	public Spell findById(long id) {
		return spellRepository.findById(id)
				.orElseThrow(() -> new SpellNotFoundException(id));
	}

	@Override
	public Spell save(Spell spell) {
		spellRepository.findByName(spell.getName())
				.ifPresent(s -> {
					throw new SpellConflictException(spell.getName());
				});

		List<Class> classes = spell.getClasses().stream()
				.map(c -> classService.findByName(c.getName()))
				.toList();
		spell.setClasses(new LinkedHashSet<>(classes));

		return spellRepository.save(spell);
	}

	@Override
	public Spell update(Spell spell) {
		return null;
	}

	@Override
	public void delete(long id) {
		spellRepository.delete(findById(id));
	}

	@Override
	public List<String> getAllMagicSchools() {
		return Arrays.stream(MagicSchool.values())
				.map(MagicSchool::getDisplayName)
				.toList();
	}
}
