package net.escoz.ruaw5ebff.repositories.specifications;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Order;
import net.escoz.ruaw5ebff.controllers.dtos.SpellFilterDTO;
import net.escoz.ruaw5ebff.models.Class;
import net.escoz.ruaw5ebff.models.MagicSchool;
import net.escoz.ruaw5ebff.models.Spell;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class SpellSpecification {

	public static Specification<Spell> fromFilter(SpellFilterDTO filter) {
		return Specification
				.where(withLevel(filter.getLevel()))
				.and(withSchool(filter.getSchool()))
				.and(withClass(filter.getClassName()))
				.and(withOrderBy(filter));
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

	private static Specification<Spell> withClass(String className) {
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

	private static Specification<Spell> withOrderBy(SpellFilterDTO filter) {
		return (root, query, criteriaBuilder) -> {
			List<Order> orders = new ArrayList<>();

			if (filter.getSort() != null && !filter.getSort().isEmpty()) {
				String sortBy = filter.getSort().toLowerCase();
				String sortDirection = filter.getOrder();

				if ("name".equals(sortBy)) {
					orders.add("desc".equalsIgnoreCase(sortDirection) ?
							criteriaBuilder.desc(root.get("name")) :
							criteriaBuilder.asc(root.get("name")));
				}

				if ("level".equals(sortBy)) {
					orders.add("desc".equalsIgnoreCase(sortDirection) ?
							criteriaBuilder.desc(root.get("level")) :
							criteriaBuilder.asc(root.get("level")));
				}
			}

			if (orders.isEmpty()) {
				return criteriaBuilder.conjunction(); // Sin orden, aplicamos una conjunción vacía
			}

			assert query != null;
			query.orderBy(orders);

			return criteriaBuilder.conjunction();
		};
	}
}
