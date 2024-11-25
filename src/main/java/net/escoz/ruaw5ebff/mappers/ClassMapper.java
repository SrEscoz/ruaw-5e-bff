package net.escoz.ruaw5ebff.mappers;

import net.escoz.ruaw5ebff.controllers.dtos.ClassOutDTO;
import net.escoz.ruaw5ebff.controllers.dtos.SpellOutDTO;
import net.escoz.ruaw5ebff.models.Class;
import net.escoz.ruaw5ebff.models.Spell;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ClassMapper {

	ClassOutDTO toClassOutDTO(Class clazz);

	List<ClassOutDTO> toClassOutDTOs(List<Class> classes);

	@BeanMapping(ignoreByDefault = true)
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "level", target = "level")
	SpellOutDTO toSpellMinimalDTO(Spell spell);

	default List<SpellOutDTO> mapSpells(Set<Spell> spells) {
		return spells.stream()
				.map(this::toSpellMinimalDTO)
				.toList();
	}
}
