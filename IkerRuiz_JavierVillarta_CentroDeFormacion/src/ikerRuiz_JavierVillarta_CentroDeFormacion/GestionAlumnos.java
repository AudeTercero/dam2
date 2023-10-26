package ikerRuiz_JavierVillarta_CentroDeFormacion;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionAlumnos implements CRUD {

	private static final String FICHERO = "Alumnos.bin";
	private Scanner sc = new Scanner(System.in);
	private static Verificaciones verif = new Verificaciones();

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

		String nom, ape, tel, dir, fech;
		;

		System.out.println("-ALTA ALUMNOS- \n");

		do {
			fallo = false;
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
				fallo = false;
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
					fallo = false;
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
						fallo = false;
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
							fallo = false;
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

							Alumno alumno = new Alumno(nom, ape, tel, dir, fech);
							guardarFich(alumno);

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

	}

	public void baja() {

	}

	public void modificar() {

	}

	public void buscar() {

	}

	public void mostrar() {
		ArrayList<Alumno> alumnos = leerFich();

		for (Alumno a : alumnos) {
			a.toString();
		}
	}

	public void inscribir() {

	}

	/*
	 * Metodo para guardar los atributos de un objeto alumno en un fichero binario
	 */
	public void guardarFich(Alumno alumno) {
		DataOutputStream out = null;
		ArrayList<Alumno> alumnos = leerFich();
		boolean repe = false;

		for (Alumno a : alumnos) {
			if ((a.getNombre().equalsIgnoreCase(alumno.getNombre())
					&& (a.getApellidos().equalsIgnoreCase(alumno.getApellidos())))) {
				repe = true;
			}
		}
		if (repe != true) {
			try {
				out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FICHERO, true)));

				out.write(alumno.getNumExpediente());
				out.writeUTF(alumno.getNombre());
				out.writeUTF(alumno.getApellidos());
				out.writeUTF(alumno.getTelefono());
				out.writeUTF(alumno.getDireccion());
				out.writeUTF(alumno.getFechNac().toString());

			} catch (IOException e) {
				// e.printStackTrace();
			} finally {
				try {
					out.close();
				} catch (IOException e) {
					// e.printStackTrace();
				}
			}
		} else {
			System.out.println("Alumno ya existente.");
		}

	}

	/*
	 * Metodo para guardar en un ArrayList alumnos formados por los atributos
	 * recibidos de un fichero binario
	 */
	public ArrayList<Alumno> leerFich() {
		ArrayList<Alumno> alumnos = new ArrayList<>();
		DataInputStream in = null;
		int id = 0;
		String nom, ape, tel, dir, fech;
		File file = new File(FICHERO);

		if (file.length() != 0) {
			try {
				in = new DataInputStream(new BufferedInputStream(new FileInputStream(FICHERO)));
				while (true) {
					id = in.readInt();
					nom = in.readUTF();
					ape = in.readUTF();
					tel = in.readUTF();
					dir = in.readUTF();
					fech = in.readUTF();

					Alumno a = new Alumno(nom, ape, tel, dir, fech);
					a.setNumExpediente(id);

					alumnos.add(a);

				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return alumnos;

	}
}
