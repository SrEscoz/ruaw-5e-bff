package net.escoz.ruaw5ebff.services;

import net.escoz.ruaw5ebff.models.Class;

import java.util.List;

public interface ClassService {

	Class findClass(Long id);

	Class findByName(String name);

	List<String> getClassNames();
}
