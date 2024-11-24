package net.escoz.ruaw5ebff.exceptions;

public class SpellNotFoundException extends RuntimeException {

	public SpellNotFoundException(String spell) {
		super("No es posible encontrar el hechizo: " + spell);
	}

	public SpellNotFoundException(long id) {
		super("No es posible encontrar el hechizo con id: " + id);
	}
}
