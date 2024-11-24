package net.escoz.ruaw5ebff.services;

import net.escoz.ruaw5ebff.models.MagicSchool;
import net.escoz.ruaw5ebff.models.Spell;

import java.util.List;

public interface SpellService {

	List<Spell> findAll();

	Spell findById(Long id);

	Spell save(Spell spell);

	Spell update(Spell spell);

	void delete(Long id);

	List<MagicSchool> getAllMagicSchools();

}
