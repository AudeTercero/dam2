package ikerRuiz_JavierVillarta_CentroDeFormacion;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestionAlumnos implements CRUD {
	
	private String fichero = "Alumnos.bin";
	private Scanner sc = new Scanner(System.in);
	private static Verificaciones verif = new Verificaciones();
	private static FicherosBinarios fb = new FicherosBinarios();
	private static File file = new File("Alumnos.bin");
	private HashMap<Integer, Alumno> alumnos = fb.leer(file);

	/*
	 * Metodo menu para seleccionar las acciones requeridas a ejecutar
	 */
	public void menu() {
		System.out.println("-- GESTION ALUMNOS --");

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
				buscar();
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

	/*
	 * Metodo para dar de alta alumnos. Recoje los diferentes atributos, los valida
	 * y crea un objeto alumno que se guarda en un fichero
	 */
	public void alta() {
		Scanner sc = new Scanner(System.in);
		int cont = 0;
		boolean fallo = false;
		boolean repe = false;

		String nom, ape, tel, dir, fech;
		Date fechNac = null;
		;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-mm-dd");

		System.out.println("-ALTA ALUMNOS- \n");

		do {
			System.out.println("Introduce el nombre del alumno:");
			nom = sc.nextLine();
			try {
				verif.hayAlgo(nom);

			} catch (MisExceptions e) {
				System.out.println(e);
				fallo = true;
				cont++;
			}

		} while (fallo && cont < 5);

		if (cont < 5) {
			cont = 0;
			do {
				System.out.println("Introduce el apellido del alumno:");
				ape = sc.nextLine();
				try {
					verif.hayAlgo(ape);

				} catch (MisExceptions e) {
					System.out.println(e);
					fallo = true;
					cont++;
				}

			} while (fallo && cont < 5);

			if (cont < 5) {
				do {
					System.out.println("Introduce el telefono del alumno:");
					tel = sc.nextLine();
					try {
						verif.hayAlgo(tel);
						verif.nueveCaracteres(tel);
						verif.esNum(tel);

					} catch (MisExceptions e) {
						System.out.println(e);
						fallo = true;
						cont++;
					}

				} while (fallo && cont < 5);

				if (cont < 5) {
					cont = 0;
					do {
						System.out.println("Introduce la direccion del alumno:");
						dir = sc.nextLine();
						try {
							verif.hayAlgo(dir);

						} catch (MisExceptions e) {
							System.out.println(e);
							fallo = true;
							cont++;
						}

					} while (fallo && cont < 5);

					if (cont < 5) {
						cont = 0;
						do {
							System.out.println(
									"Introduce la fecha de nacimiento del alumno, por favor ingresa la fecha (en formato YYYY-MM-DD):");
							fech = sc.nextLine();
							try {
								verif.hayAlgo(fech);
								verif.esFech(fech);

							} catch (MisExceptions e) {
								System.out.println(e);
								fallo = true;
								cont++;
							}

						} while (fallo && cont < 5);

						if (cont < 5) {
							cont = 0;
							try {
								fechNac = formatoFecha.parse(fech);
							} catch (ParseException e) {
								e.printStackTrace();
							}

							//Iteramos hashmap alumnos para ver si ya existe el alumno a introducir
							for (Map.Entry<Integer, Alumno> entry : alumnos.entrySet()) {
					            Alumno a = entry.getValue();
					            if(nom == a.getNombre() && ape == a.getApellidos()) {
					            	repe = true;
					            	System.out.println("Alumno ya existente");
					            }					            
					        }
							
							//Si el alumno no esta repetido, lo creamos y lo guardamos
							if(repe == false) {
								Alumno alumno = new Alumno (nom, ape, tel, dir, fechNac);
								alumnos.put(alumno.getNumExpediente(), alumno);
								
								fb.guardar(alumno);
							}

						} else {
							System.out.println("Has llegado a 5 intentos, saliendo...");
						}

					} else {
						System.out.println("Has llegado a 5 intentos, saliendo...");
					}

				} else {
					System.out.println("Has llegado a 5 intentos, saliendo...");
				}

			} else {
				System.out.println("Has llegado a 5 intentos, saliendo...");
			}

		} else {
			System.out.println("Has llegado a 5 intentos, saliendo...");
		}
		
		sc.close();// cerramos el escanner

	}

	public void baja() {

	}

	public void modificar() {

	}

	public void buscar() {

	}

	public void mostrar() {

	}

	public void inscribir() {

	}

}
