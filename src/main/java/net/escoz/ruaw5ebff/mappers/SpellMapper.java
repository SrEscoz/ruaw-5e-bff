package net.escoz.ruaw5ebff.mappers;


import net.escoz.ruaw5ebff.controllers.dtos.SpellInDTO;
import net.escoz.ruaw5ebff.controllers.dtos.SpellOutDTO;
import net.escoz.ruaw5ebff.models.Class;
import net.escoz.ruaw5ebff.models.MagicSchool;
import net.escoz.ruaw5ebff.models.Spell;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface SpellMapper {

	SpellOutDTO toSpellOutDTO(Spell spell);

	List<SpellOutDTO> toSpellOutDTOs(List<Spell> spells);

	@Mapping(target = "id", ignore = true)
	Spell toEntity(SpellInDTO spellInDTO);

	default String mapEnumToString(MagicSchool magicSchool) {
		return magicSchool.getDisplayName();
	}

	default MagicSchool mapStringToEnum(String magicSchool) {
		return MagicSchool.fromDisplayName(magicSchool);
	}

	default List<String> mapClases(Set<Class> clases) {
		return clases.stream().map(Class::getName).collect(Collectors.toList());
	}
}
