package net.escoz.ruaw5ebff.exceptions;

public class UserConflictException extends RuntimeException {
	public UserConflictException(String identifier) {
		super("Ya existe el usuario con el identificador: " + identifier);
	}
}
