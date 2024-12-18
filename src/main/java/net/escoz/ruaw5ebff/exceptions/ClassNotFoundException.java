package net.escoz.ruaw5ebff.exceptions;

public class ClassNotFoundException extends RuntimeException {

	public ClassNotFoundException(String className) {
		super("No es posible encontrar la clase: " + className);
	}

	public ClassNotFoundException(long id) {
		super("No es posible encontrar la clase con id: " + id);
	}
}
