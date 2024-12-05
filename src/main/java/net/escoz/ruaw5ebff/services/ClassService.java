package net.escoz.ruaw5ebff.services;

import net.escoz.ruaw5ebff.models.Class;

import java.util.List;

public interface ClassService {

	List<Class> getClasses();

	Class findClass(Long id);

	Class findByName(String name);

	Class addClass(Class clazz);

	void deleteClass(long id);
}
