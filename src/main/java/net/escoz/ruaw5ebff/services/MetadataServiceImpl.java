package net.escoz.ruaw5ebff.services;

import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.models.MagicSchool;
import net.escoz.ruaw5ebff.repositories.MetadataRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class MetadataServiceImpl implements MetadataService {

	private final MetadataRepository metadataRepository;

	@Override
	public List<String> getAllMagicSchools() {
		return Arrays.stream(MagicSchool.values())
				.map(MagicSchool::getDisplayName)
				.toList();
	}

	@Override
	public List<String> getAllClasses() {
		return metadataRepository.findAllClassNames();
	}

	@Override
	public List<String> getSourceBooks() {
		return metadataRepository.findAllSourceBooks();
	}
}
