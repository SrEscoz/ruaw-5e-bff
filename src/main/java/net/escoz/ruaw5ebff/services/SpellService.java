package net.escoz.ruaw5ebff.services;

import net.escoz.ruaw5ebff.models.Spell;

import java.util.List;

public interface SpellService {

	List<Spell> findAll();

	Spell findById(long id);

	Spell findByName(String name);

	Spell save(Spell spell);

	Spell update(Spell spell);

	void delete(long id);

	List<String> getAllMagicSchools();

}
