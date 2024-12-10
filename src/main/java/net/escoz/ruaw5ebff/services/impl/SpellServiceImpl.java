package net.escoz.ruaw5ebff.services.impl;

import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.controllers.dtos.spell.SpellFilterDTO;
import net.escoz.ruaw5ebff.controllers.dtos.spell.SpellInDTO;
import net.escoz.ruaw5ebff.exceptions.SpellConflictException;
import net.escoz.ruaw5ebff.exceptions.SpellNotFoundException;
import net.escoz.ruaw5ebff.mappers.SpellMapper;
import net.escoz.ruaw5ebff.models.Spell;
import net.escoz.ruaw5ebff.repositories.SpellRepository;
import net.escoz.ruaw5ebff.repositories.specifications.SpellSpecification;
import net.escoz.ruaw5ebff.services.SpellService;
import net.escoz.ruaw5ebff.utils.Utils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SpellServiceImpl implements SpellService {

	private final SpellRepository spellRepository;
	private final SpellMapper spellMapper;

	@Override
	public Page<Spell> findSpells(Pageable pageable, SpellFilterDTO filters) {
		Specification<Spell> spec = SpellSpecification.fromFilter(filters);

		return spellRepository.findAll(spec, pageable);
	}

	@Override
	public List<Spell> findSpellsByClass(long id) {
		return spellRepository.findAllByClassId(id);
	}

	@Override
	public Spell findById(long id) {
		return spellRepository.findById(id)
				.orElseThrow(() -> new SpellNotFoundException(id));
	}

	@Override
	public Spell findBySlug(String slug) {
		return spellRepository.findBySlug(slug)
				.orElseThrow(() -> new SpellNotFoundException(slug));
	}

	@Override
	public Spell saveSpell(Spell spell) {
		spellRepository.findByName(spell.getName())
				.ifPresent(s -> {
					throw new SpellConflictException(spell.getName());
				});

		return spellRepository.save(spell);
	}

	@Override
	public Spell updateSpell(SpellInDTO spellInDTO, long id) {
		Spell spell = findById(id);

		// Comprobamos la duplicidad del nombre ignorando el propio hechizo para evitar conflictos con el mismo
		if (!spell.getName().equalsIgnoreCase(spellInDTO.getName())
				&& spellRepository.existsByNameAndIdNot(Utils.sanitizeName(spellInDTO.getName()), id)) {
			throw new SpellConflictException(spellInDTO.getName());
		}

		spell = spellMapper.updateSpell(spell, spellInDTO);

		return spellRepository.save(spell);
	}

	@Override
	public void deleteSpell(long id) {
		spellRepository.delete(findById(id));
	}
}
