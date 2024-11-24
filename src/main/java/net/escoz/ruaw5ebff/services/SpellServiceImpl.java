package net.escoz.ruaw5ebff.services;

import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.models.MagicSchool;
import net.escoz.ruaw5ebff.models.Spell;
import net.escoz.ruaw5ebff.repositories.SpellRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SpellServiceImpl implements SpellService {

	private final SpellRepository spellRepository;


	@Override
	public List<Spell> findAll() {
		return List.of();
	}

	@Override
	public Spell findById(Long id) {
		return null;
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
	public List<MagicSchool> getAllMagicSchools() {
		return List.of();
	}
}
