package net.escoz.ruaw5ebff.mappers;

import net.escoz.ruaw5ebff.controllers.dtos.ClassLevelOutDTO;
import net.escoz.ruaw5ebff.controllers.dtos.ClassOutDTO;
import net.escoz.ruaw5ebff.controllers.dtos.SpellOutDTO;
import net.escoz.ruaw5ebff.models.Class;
import net.escoz.ruaw5ebff.models.ClassLevel;
import net.escoz.ruaw5ebff.models.Spell;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ClassMapper {

	@Mapping(source = "classLevels", target = "levels")
	ClassOutDTO toClassOutDTO(Class clazz);

	@BeanMapping(ignoreByDefault = true)
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "level", target = "level")
	SpellOutDTO toSpellMinimalDTO(Spell spell);

	ClassLevelOutDTO toClassLevelDTO(ClassLevel classLevel);

	default List<SpellOutDTO> mapSpells(Set<Spell> spells) {
		return spells.stream()
				.map(this::toSpellMinimalDTO)
				.toList();
	}
}
