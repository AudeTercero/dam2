import java.util.Scanner;
import java.util.HashMap;

public class GestionProfesores {
	private HashMap<String, Curso> cursos = new HashMap<>();
	private String fichero = "Profesores.bin";
	private static Scanner sc = new Scanner(System.in);
	private static Verificaciones verif = new Verificaciones();

	public void menu() {
		System.out.println("-- GESTION PROFESORES --");

		String op = null;

		do {
			System.out.println(
					"\n Selecciona una opcion: \n 1.Inscribir Profesores \n 2.Borrar Profesores \n 3.Modificar Profesores \n 4.Consultar Profesores \n 5.Mostrar Profesores \n 0.Salir");
			op = sc.nextLine();

			switch (op) {
			case "1":
				alta();
				break;
			case "2":
				baja();
				break;
			case "3":
				modificar();
				break;
			case "4":
				consulta();
				break;
			case "5":
				mostrar();
				break;
			case "0":
				System.out.println("Saliendo... \n");
				break;
			default:
				System.out.println("Operacion no valida, prueba de nuevo.");
			}

		} while (!op.equalsIgnoreCase("0"));
	}

	public static void alta() {
		Profesor profe;
		String dni, nombre, direccion, telefono;
		int contError = 0;
		boolean fallo = false;

		do {// Inicio de do while que controla si hay fallo
			dni = sc.nextLine();
			try {
				verif.hayAlgo(dni);
			} catch (MisExceptions e) {
				System.out.println(e);
				fallo = true;
				contError++;
			}
		} while (fallo == true && contError != 5);// fin de do while que controla si hay fallo

		if (contError < 5) {
			contError = 0;
			fallo = false;
			do {// Inicio de do while que controla si hay fallo
				nombre = sc.nextLine();
				try {
					verif.hayAlgo(nombre);
				} catch (MisExceptions e) {
					System.out.println(e);
					fallo = true;
					contError++;
				}
			} while (fallo == true && contError != 5);// fin de do while que controla si hay fallo

			if (contError < 5) {
				fallo = false;
				contError = 0;
				do {// Inicio de do while que controla si hay fallo
					direccion = sc.nextLine();
					try {
						verif.hayAlgo(direccion);
					} catch (MisExceptions e) {
						System.out.println(e);
						fallo = true;
						contError++;
					}
				} while (fallo == true && contError != 5);// Fin de do while que controla si hay fallo

				if (contError < 5) {
					fallo = false;
					contError = 0;
					do {// Inicio de do while que controla si hay fallo
						telefono = sc.nextLine();
						try {
							verif.esNum(telefono);
							verif.nueveCaracteres(telefono);
						} catch (MisExceptions e) {
							System.out.println(e);
							fallo = true;
							contError++;
						}
					} while (fallo == true && contError != 5);// Fin de do while que controla si hay fallo

					if (contError != 5) {
						
						profe = new Profesor(dni, nombre, direccion, telefono);
						
					} else {
						// msg ERROR
					}

				} else {
					// msg ERROR
				}

			} else {
				// msg ERROR
			}

		} else {
			// msg ERROR
		}

	}

	public static void baja() {

	}

	public static void modificar() {

	}

	public static void consulta() {

	}

	public static void mostrar() {

	}
}
