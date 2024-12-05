package net.escoz.ruaw5ebff.services;

import net.escoz.ruaw5ebff.controllers.dtos.spell.SpellFilterDTO;
import net.escoz.ruaw5ebff.controllers.dtos.spell.SpellInDTO;
import net.escoz.ruaw5ebff.models.Spell;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SpellService {

	Page<Spell> findSpells(Pageable pageable, SpellFilterDTO filters);

	Spell findById(long id);

	Spell saveSpell(Spell spell);

	Spell updateSpell(SpellInDTO spellInDTO, long id);

	void deleteSpell(long id);

}
