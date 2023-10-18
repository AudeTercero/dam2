
public class Verificaciones {
	public void nuveCaracteres(String cadena) throws MisExceptions{// Este metodo pretende verificar si la cadena que recibe tiene
													// exactamente 9 caracteres.
		cadena = cadena.trim(); // Eliminamos espacios de los laterales
		if (cadena.length() != 9) {
			throw new MisExceptions("Debe de tener 9 caracteres");
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

	public void esFloat(String num) throws MisExceptions {// esto captura un fallo para saber si se puede pasar de String a float.
		try {
			Float.parseFloat(num);
			
		} catch (NumberFormatException e) {
			throw new MisExceptions("Lo que has introducido no es un numero decimal");
		}
	}
}
