package net.escoz.ruaw5ebff.services;

import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.exceptions.SpellNotFoundException;
import net.escoz.ruaw5ebff.models.MagicSchool;
import net.escoz.ruaw5ebff.models.Spell;
import net.escoz.ruaw5ebff.repositories.SpellRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class SpellServiceImpl implements SpellService {

	private final SpellRepository spellRepository;

	@Override
	public List<Spell> findAll() {
		return spellRepository.findAll();
	}

	@Override
	public Spell findById(Long id) {
		return spellRepository.findById(id)
				.orElseThrow(() -> new SpellNotFoundException(id));
	}

	@Override
	public Spell findByName(String name) {
		return spellRepository.findByName(name)
				.orElseThrow(() -> new SpellNotFoundException(name));
	}

	@Override
	public Spell save(Spell spell) {
		return null;
	}

	@Override
	public Spell update(Spell spell) {
		return null;
	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public List<String> getAllMagicSchools() {
		return Arrays.stream(MagicSchool.values())
				.map(MagicSchool::getDisplayName)
				.toList();
	}
}
