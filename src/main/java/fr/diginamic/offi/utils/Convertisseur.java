package fr.diginamic.offi.utils;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Classe qui fournit des services de conversion de chaine de caractères en
 * Double et en Integer
 */
public class Convertisseur {

	/**
	 * Convertit une chaine de caractères en Integer, ou retourne null si la chaine
	 * ne contient pas un entier.
	 * 
	 * @param value valeur à convertir
	 * @return Integer
	 */
	public static Integer toInt(String value) {
		if (NumberUtils.isDigits(value)) {
			return Integer.parseInt(value);
		}
		return null;
	}

	/**
	 * Convertit une chaine de caractères en Double, ou retourne null si la chaine
	 * ne contient pas un nombre décimal.
	 * 
	 * @param value valeur à convertir
	 * @return Integer
	 */
	public static Double toDouble(String value) {
		if (NumberUtils.isCreatable(value)) {
			return Double.parseDouble(value);
		}
		return null;
	}
}
