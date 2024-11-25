package net.escoz.ruaw5ebff.services;

import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.exceptions.ClassNotFoundException;
import net.escoz.ruaw5ebff.models.Class;
import net.escoz.ruaw5ebff.repositories.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClassServiceImpl implements ClassService {

	private final ClassRepository classRepository;

	@Override
	public List<Class> findAll() {
		return classRepository.findAll();
	}

	@Override
	public Class findByName(String name) {
		return classRepository.findByName(name)
				.orElseThrow(() -> new ClassNotFoundException(name));
	}

	@Override
	public List<String> getClassNames() {
		return classRepository.findAllNames();
	}
}
