package net.escoz.ruaw5ebff.mappers;


import net.escoz.ruaw5ebff.controllers.dtos.SpellInDTO;
import net.escoz.ruaw5ebff.controllers.dtos.SpellOutDTO;
import net.escoz.ruaw5ebff.models.Class;
import net.escoz.ruaw5ebff.models.MagicSchool;
import net.escoz.ruaw5ebff.models.Spell;
import net.escoz.ruaw5ebff.services.ClassService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = ClassService.class)
public interface SpellMapper {

	SpellOutDTO toSpellOutDTO(Spell spell);

	@Mapping(target = "id", ignore = true)
	Spell toEntity(SpellInDTO spellInDTO);

	@Mapping(target = "id", ignore = true)
	Spell updateSpell(@MappingTarget Spell originalSpell, SpellInDTO spell);

	default String mapEnumToString(MagicSchool magicSchool) {
		return magicSchool.getDisplayName();
	}

	default MagicSchool mapStringToEnum(String magicSchool) {
		return MagicSchool.fromDisplayName(magicSchool);
	}

	default List<String> mapClasses(Set<Class> clases) {
		return clases.stream().map(Class::getName).collect(Collectors.toList());
	}
}
