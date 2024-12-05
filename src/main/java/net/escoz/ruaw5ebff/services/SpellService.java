package net.escoz.ruaw5ebff.services;

import net.escoz.ruaw5ebff.controllers.dtos.spell.SpellFilterDTO;
import net.escoz.ruaw5ebff.controllers.dtos.spell.SpellInDTO;
import net.escoz.ruaw5ebff.models.Spell;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SpellService {

	Page<Spell> findSpells(Pageable pageable, SpellFilterDTO filters);

	List<Spell> findSpellsByClass(long id);

	Spell findById(long id);

	Spell saveSpell(Spell spell);

	Spell updateSpell(SpellInDTO spellInDTO, long id);

	void deleteSpell(long id);

}
