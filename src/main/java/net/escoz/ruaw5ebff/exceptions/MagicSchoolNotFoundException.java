package net.escoz.ruaw5ebff.exceptions;

public class MagicSchoolNotFoundException extends RuntimeException {
	public MagicSchoolNotFoundException(String magicSchool) {
		super("No es posible encontrar la escuela mágica: " + magicSchool);
	}
}
