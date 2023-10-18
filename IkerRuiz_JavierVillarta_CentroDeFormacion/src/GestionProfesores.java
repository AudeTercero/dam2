import java.util.Scanner;
import java.util.HashMap;

public class GestionProfesores {
	private HashMap<String,Curso> cursos = new HashMap<>();
	private String fichero = "Profesores.bin";
	private Scanner sc = new Scanner(System.in);

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
