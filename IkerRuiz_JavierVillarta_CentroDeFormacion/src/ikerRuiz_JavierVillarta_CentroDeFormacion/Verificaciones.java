package ikerRuiz_JavierVillarta_CentroDeFormacion;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Verificaciones {
	public void nueveCaracteres(String cadena) throws MisExceptions {// Este metodo pretende verificar si la cadena que
																		// recibe tiene
		// exactamente 9 caracteres.
		cadena = cadena.trim();
		if (cadena.length() != 9) {
			throw new MisExceptions("Debe de tener 9 caracteres");
		}

	}

	/*
	 * Metodo que verifica si un string solo contiene numeros
	 */
	public void esNum(String string) throws MisExceptions {

		string.trim();// Eliminamos espacios de los laterales

		// recorre el string pasandolo a un array de chars
		for (char c : string.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new MisExceptions("Solo puede haber numeros");
			}
		}
	}

	/*
	 * Metodo que comprueba que un string tiene formato Date y solo contiene numeros
	 */
	public void esFech(String string) throws MisExceptions {
		string.trim(); // Eliminamos espacios de los laterales
		String partes[] = string.split("-");// Separamos los anios, meses y dias

		if (partes.length < 3) {// Comprobamos que solo hay tres partes en el split

			if (partes[0].length() != 4) {// Comprobamos si el primer puesto corresponde al anio si tiene una longitud igual a 4
				throw new MisExceptions("Introduce una fecha valida");

			} else if (partes[0].length() > 2) {//Comprobamos si el segundo puesto tiene una longitud mayor a 2
				throw new MisExceptions("Introduce una fecha valida");

			} else if (partes[0].length() > 2) {//Comprobamos si el tercer puesto tiene una longitud mayor a 2
				throw new MisExceptions("Introduce una fecha valida");

			} else { //Iteramos cada parte y comprobamos que todos los valores sean numericoss
				for (int i = 0; i < partes.length; i++) {
					for (char c : partes[i].toCharArray()) {
						if (!Character.isDigit(c)) {
							throw new MisExceptions("Introduce una fecha valida");
						}
					}
				}
			}
		} else {
			throw new MisExceptions("Introduce una fecha valida");

		}

	}

	public float cadeNumF(String num) {// paso de String a float
		float numero;

		numero = Float.parseFloat(num);// metodo de java que pasa String a Float
		return numero;

	}

	public void hayAlgo(String cadena) throws MisExceptions {// verifica si ha escrito algo
		if (cadena.length() == 0) {
			throw new MisExceptions("No ha escrito nada, por favor rellene el campo");
		}

	}

	public void esFloat(String num) throws MisExceptions {// esto captura un fallo para saber si se puede pasar de
															// String a float.
		try {
			Float.parseFloat(num);

		} catch (NumberFormatException e) {
			throw new MisExceptions("Lo que has introducido no es un numero decimal");
		}
	}

}
