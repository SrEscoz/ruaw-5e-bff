package net.escoz.ruaw5ebff.exceptions;

public class SpellNotFoundException extends RuntimeException {

	public SpellNotFoundException(String spell) {
		super("Could not find spell: " + spell);
	}

	public SpellNotFoundException(long id) {
		super("Could not find spell with id: " + id);
	}
}
