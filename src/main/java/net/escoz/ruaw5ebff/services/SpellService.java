package net.escoz.ruaw5ebff.services;

import net.escoz.ruaw5ebff.controllers.dtos.SpellFilterDTO;
import net.escoz.ruaw5ebff.models.Spell;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SpellService {

	Page<Spell> findSpells(Pageable pageable, SpellFilterDTO filters);

	Spell findById(long id);

	Spell save(Spell spell);

	Spell update(Spell spell);

	void delete(long id);

	List<String> getAllMagicSchools();

}
