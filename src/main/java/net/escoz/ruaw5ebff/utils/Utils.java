package net.escoz.ruaw5ebff.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Utils {

	private static final Set<String> EXCLUDED_WORDS = new HashSet<>(Arrays.asList(
			"de", "con", "y", "o", "en", "el", "la", "los", "las", "del", "al"
	));

	public static String sanitizeName(String input) {
		if (input == null || input.trim().isEmpty())
			return input;


		String[] words = input.toLowerCase().split("\\s+");
		StringBuilder capitalizedTitle = new StringBuilder();

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (i == 0 || !EXCLUDED_WORDS.contains(word)) {

				word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
			}
			capitalizedTitle.append(word).append(" ");
		}

		return capitalizedTitle.toString().trim();
	}
}
