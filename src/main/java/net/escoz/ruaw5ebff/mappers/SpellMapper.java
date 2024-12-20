package net.escoz.ruaw5ebff.mappers;


import net.escoz.ruaw5ebff.controllers.dtos.spell.SpellInDTO;
import net.escoz.ruaw5ebff.controllers.dtos.spell.SpellOutDTO;
import net.escoz.ruaw5ebff.models.Class;
import net.escoz.ruaw5ebff.models.MagicSchool;
import net.escoz.ruaw5ebff.models.Spell;
import net.escoz.ruaw5ebff.services.ClassService;
import net.escoz.ruaw5ebff.utils.Utils;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = ClassService.class)
public interface SpellMapper {

	SpellOutDTO toSpellOutDTO(Spell spell);

	@BeanMapping(ignoreByDefault = true)
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "level", target = "level")
	@Mapping(source = "magicSchool", target = "magicSchool")
	SpellOutDTO toSpellMinDTO(Spell spell);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "name", source = "name", qualifiedByName = "sanitizeName")
	@Mapping(target = "slug", source = "name", qualifiedByName = "generateSlug")
	Spell toEntity(SpellInDTO spellInDTO);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "name", source = "name", qualifiedByName = "sanitizeName")
	@Mapping(target = "slug", source = "name", qualifiedByName = "generateSlug")
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

	@Named("sanitizeName")
	default String mapCapitalizedName(String s) {
		return Utils.sanitizeName(s);
	}

	@Named("generateSlug")
	default String mapSlug(String s) {
		return Utils.generateSlug(s);
	}
}
