
public class Verificaciones {
	public boolean nuveCaracteres(String cadena) {// Este metodo pretende verificar si la cadena que recibe tiene
													// exactamente 9 caracteres.
		cadena = cadena.trim(); // Eliminamos espacios de los laterales
		if (cadena.length() == 9) {
			return true;
		}

		return false;
	}

	public float cadeNumF(String num) {// paso de String a float
		float numero;

		numero = Float.parseFloat(num);// metodo de java que pasa String a Float
		return numero;

	}

	public boolean hayAlgo(String cadena) {// verifica si ha escrito algo
		if (cadena.length() != 0) {
			return true;
		}
		return false;
	}

	public boolean esFloat(String num) {// esto captura un fallo para saber si se puede pasar de String a float.
		try {
			Float.parseFloat(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
