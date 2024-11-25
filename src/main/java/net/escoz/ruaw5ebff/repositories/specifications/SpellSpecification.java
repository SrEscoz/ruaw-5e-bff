package net.escoz.ruaw5ebff.repositories.specifications;

import jakarta.persistence.criteria.Join;
import net.escoz.ruaw5ebff.controllers.dtos.SpellFilterDTO;
import net.escoz.ruaw5ebff.models.Class;
import net.escoz.ruaw5ebff.models.MagicSchool;
import net.escoz.ruaw5ebff.models.Spell;
import org.springframework.data.jpa.domain.Specification;

public class SpellSpecification {

	public static Specification<Spell> fromFilter(SpellFilterDTO filter) {
		return Specification
				.where(withLevel(filter.getLevel()))
				.and(withSchool(filter.getMagicSchool()))
				.and(withClass(filter.getClassName()));
	}

	private static Specification<Spell> withLevel(Integer level) {
		return (root, query, criteriaBuilder) -> {
			if (level == null) {
				return criteriaBuilder.conjunction();
			}
			return criteriaBuilder.equal(root.get("level"), level);
		};
	}

	private static Specification<Spell> withSchool(String magicSchool) {
		return (root, query, criteriaBuilder) -> {
			if (magicSchool == null || magicSchool.isEmpty()) {
				return criteriaBuilder.conjunction();
			}

			MagicSchool magicSchoolEnum = MagicSchool.fromDisplayName(magicSchool);
			return criteriaBuilder.equal(root.get("magicSchool"), magicSchoolEnum);
		};
	}

	public static Specification<Spell> withClass(String className) {
		return (root, query, criteriaBuilder) -> {
			if (className == null || className.isEmpty()) {
				return criteriaBuilder.conjunction();
			}

			Join<Spell, Class> classes = root.join("classes");
			return criteriaBuilder.equal(
					criteriaBuilder.lower(classes.get("name")),
					className.toLowerCase()
			);
		};
	}
}
