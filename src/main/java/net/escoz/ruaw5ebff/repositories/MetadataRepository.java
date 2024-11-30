package net.escoz.ruaw5ebff.repositories;

import java.util.List;

public interface MetadataRepository {

	List<String> findAllClassNames();

	List<String> findAllSourceBooks();
}
