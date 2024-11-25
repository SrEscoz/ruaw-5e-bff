package net.escoz.ruaw5ebff.repositories;

import net.escoz.ruaw5ebff.models.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
	Optional<Class> findByName(String name);

	@Query("SELECT c.name FROM Class c")
	List<String> findAllNames();
}
