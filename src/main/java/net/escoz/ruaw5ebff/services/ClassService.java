package net.escoz.ruaw5ebff.services;

import net.escoz.ruaw5ebff.models.Class;

import java.util.List;

public interface ClassService {

	List<Class> findAll();

	Class findByName(String name);

}
