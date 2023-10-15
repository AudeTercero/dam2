import java.sql.Date;
import java.util.HashMap;
import java.util.Scanner;

public class GestionAlumnos {
	private HashMap<Integer,Alumno> alumnos = new HashMap<>();
	private String fichero = "Alumnos.bin";

	public void menu() {
		System.out.println("-- GESTION ALUMNOS --");
		Scanner sc = new Scanner(System.in);
		String op = null;

		do {
			System.out.println("\n Selecciona una opcion: \n 1.Inscribir Alumnos \n 2.Borrar Alumnos "
					+ "\n 3.Modificar Alumnos \n 4.Consultar Alumnos \n 5.Mostrar Alumnos "
					+ "\n 6.Inscribir Alumnos en Cursos \n 0.Salir");
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
			case "6":
				inscribir();
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
		Scanner sc = new Scanner(System.in);

		int id = 0;
		String nom, ape, tel, dir = null;
		Date fechNac;

		System.out.println("-ALTA ALUMNOS- \n");

		do {

		} while (id != 0);

	}

	public static void baja() {

	}

	public static void modificar() {

	}

	public static void consulta() {

	}

	public static void mostrar() {

	}

	public static void inscribir() {

	}

}
