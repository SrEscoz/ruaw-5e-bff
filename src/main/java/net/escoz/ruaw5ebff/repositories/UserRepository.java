package net.escoz.ruaw5ebff.repositories;

import net.escoz.ruaw5ebff.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

	Optional<AppUser> findByUsername(String username);

	Optional<AppUser> findByEmail(String email);
}
