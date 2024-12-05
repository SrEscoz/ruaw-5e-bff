package net.escoz.ruaw5ebff.services;

import net.escoz.ruaw5ebff.controllers.dtos.clazz.ClassInDTO;
import net.escoz.ruaw5ebff.controllers.dtos.clazz.ClassSpellInDTO;
import net.escoz.ruaw5ebff.models.Class;

import java.util.List;

public interface ClassService {

	List<Class> getClasses();

	Class findClass(Long id);

	Class findByName(String name);

	Class addClass(Class clazz);

	Class updateClass(ClassInDTO classInDTO, long id);

	Class updateClassSpells(ClassSpellInDTO spellsDTO, long id);

	void deleteClass(long id);
}
