package net.escoz.ruaw5ebff.repositories;

import net.escoz.ruaw5ebff.models.Spell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpellRepository extends JpaRepository<Spell, Long>, JpaSpecificationExecutor<Spell> {
	Optional<Spell> findByName(String name);

	Optional<Spell> findBySlug(String slug);

	@Query("SELECT s FROM Spell s JOIN s.classes c WHERE c.id = :id ORDER BY s.name")
	List<Spell> findAllByClassId(long id);

	boolean existsByNameAndIdNot(String name, Long id);
}
