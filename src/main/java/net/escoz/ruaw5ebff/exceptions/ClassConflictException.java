package net.escoz.ruaw5ebff.exceptions;

public class ClassConflictException extends RuntimeException {
	public ClassConflictException(String className) {
		super("Ya existe una clase con el nombre: " + className);
	}
}
