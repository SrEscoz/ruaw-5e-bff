package net.escoz.ruaw5ebff.exceptions;

public class SpellConflictException extends RuntimeException {
	public SpellConflictException(String spell) {
		super("Ya existe un hechizo con el nombre: " + spell);
	}
}
