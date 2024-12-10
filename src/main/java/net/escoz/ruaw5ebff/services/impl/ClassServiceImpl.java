package net.escoz.ruaw5ebff.services.impl;

import lombok.AllArgsConstructor;
import net.escoz.ruaw5ebff.controllers.dtos.clazz.ClassInDTO;
import net.escoz.ruaw5ebff.controllers.dtos.clazz.ClassSpellInDTO;
import net.escoz.ruaw5ebff.exceptions.ClassConflictException;
import net.escoz.ruaw5ebff.exceptions.ClassNotFoundException;
import net.escoz.ruaw5ebff.mappers.ClassMapper;
import net.escoz.ruaw5ebff.models.Class;
import net.escoz.ruaw5ebff.models.Spell;
import net.escoz.ruaw5ebff.repositories.ClassRepository;
import net.escoz.ruaw5ebff.services.ClassService;
import net.escoz.ruaw5ebff.services.SpellService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = {@Lazy})
public class ClassServiceImpl implements ClassService {

	@Lazy
	private final SpellService spellService;

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
		Class currentClass = findClass(id);

		classRepository.findByName(classInDTO.getName())
				.ifPresent(s -> {
					if (currentClass.getId() != id) {
						throw new ClassConflictException(classInDTO.getName());
					}
				});

		return classRepository.save(classMapper.updateClass(currentClass, classInDTO));
	}

	@Override
	@Transactional
	public Class updateClassSpells(ClassSpellInDTO spellsDTO, long id) {
		// Buscar la clase existente
		Class currentClass = findClass(id);

		// Borrar relaciones actuales
		currentClass.getSpells().forEach(spell -> spell.getClasses().remove(currentClass));
		currentClass.getSpells().clear();

		// Crear nuevas relaciones
		List<Spell> newSpells = spellsDTO.getSpellIds().stream()
				.map(spellService::findById)
				.peek(spell -> spell.getClasses().add(currentClass))
				.toList();

		currentClass.getSpells().addAll(newSpells);

		return classRepository.save(currentClass);
	}

	@Override
	public void deleteClass(long id) {
		Class clazz = findClass(id);
		clazz.getSpells().forEach(spell -> spell.getClasses().remove(clazz));
		clazz.getSpells().clear();

		classRepository.delete(clazz);
	}

}
