package net.escoz.ruaw5ebff.repositories;

import net.escoz.ruaw5ebff.models.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {

	List<Class> findAllByOrderByNameAsc();

	Optional<Class> findByName(String name);

}
