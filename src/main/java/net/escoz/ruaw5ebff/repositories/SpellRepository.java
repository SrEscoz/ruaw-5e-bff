package net.escoz.ruaw5ebff.repositories;

import net.escoz.ruaw5ebff.models.Spell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpellRepository extends JpaRepository<Spell, Long> {
	Optional<Spell> findByName(String name);
}
