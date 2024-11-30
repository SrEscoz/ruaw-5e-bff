package net.escoz.ruaw5ebff.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MetadataRepositoryImpl implements MetadataRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<String> findAllClassNames() {
		return entityManager.createQuery("select distinct c.name from Class c", String.class)
				.getResultList();
	}

	@Override
	public List<String> findAllSourceBooks() {
		return entityManager.createQuery("select distinct s.title from SourceBook s", String.class)
				.getResultList();
	}
}
