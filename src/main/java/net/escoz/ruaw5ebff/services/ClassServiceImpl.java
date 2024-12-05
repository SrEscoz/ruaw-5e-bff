package net.escoz.ruaw5ebff.services;

import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.controllers.dtos.clazz.ClassInDTO;
import net.escoz.ruaw5ebff.exceptions.ClassConflictException;
import net.escoz.ruaw5ebff.exceptions.ClassNotFoundException;
import net.escoz.ruaw5ebff.mappers.ClassMapper;
import net.escoz.ruaw5ebff.models.Class;
import net.escoz.ruaw5ebff.repositories.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClassServiceImpl implements ClassService {

	private final ClassRepository classRepository;
	private final ClassMapper classMapper;

	@Override
	public List<Class> getClasses() {
		return classRepository.findAllByOrderByNameAsc();
	}

	@Override
	public Class findClass(Long id) {
		return classRepository.findById(id)
				.orElseThrow(() -> new ClassNotFoundException(id));
	}

	@Override
	public Class findByName(String name) {
		return classRepository.findByName(name)
				.orElseThrow(() -> new ClassNotFoundException(name));
	}

	@Override
	public Class addClass(Class clazz) {
		classRepository.findByName(clazz.getName())
				.ifPresent(s -> {
					throw new ClassConflictException(clazz.getName());
				});

		return classRepository.save(clazz);
	}

	@Override
	public Class updateClass(ClassInDTO classInDTO, long id) {
		Class actualClass = findClass(id);

		classRepository.findByName(classInDTO.getName())
				.ifPresent(s -> {
					if (actualClass.getId() != id) {
						throw new ClassConflictException(classInDTO.getName());
					}
				});

		return classRepository.save(classMapper.updateClass(actualClass, classInDTO));
	}


	@Override
	public void deleteClass(long id) {
		Class clazz = findClass(id);
		clazz.getSpells().forEach(spell -> spell.getClasses().remove(clazz));
		clazz.getSpells().clear();

		classRepository.delete(clazz);
	}

}
