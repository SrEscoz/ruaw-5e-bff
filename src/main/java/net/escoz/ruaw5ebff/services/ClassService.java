package net.escoz.ruaw5ebff.services;

import net.escoz.ruaw5ebff.models.Class;

public interface ClassService {

	Class findClass(Long id);

	Class findByName(String name);

}
