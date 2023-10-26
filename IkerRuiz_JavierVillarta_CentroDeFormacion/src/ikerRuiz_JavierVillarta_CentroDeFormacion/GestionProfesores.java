package ikerRuiz_JavierVillarta_CentroDeFormacion;

import java.util.Scanner;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestionProfesores implements CRUD {
	private static final String FICHERO = "Profesores.ser";
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
				buscar();
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

	public void alta() {
		Profesor profe;
		String dni, nombre, direccion, telefono;
		int contError = 0;
		boolean fallo = false;

		do {// Inicio de do while que controla si hay fallo
			fallo = false;
			System.out.println("Introduce el dni del Profesor:");
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

			do {// Inicio de do while que controla si hay fallo
				fallo = false;
				System.out.println("Introduce el nombre del Profesor:");
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

				contError = 0;
				do {// Inicio de do while que controla si hay fallo
					fallo = false;
					System.out.println("Introduce la direccion del Profesor:");
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

					contError = 0;
					do {// Inicio de do while que controla si hay fallo
						fallo = false;
						System.out.println("Introduce el telefono del Profesor:");
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
						guardarFich(profe);
					}

				} else {
					System.out.println("Se han superado el maximo de errores permitidos(5)");
				}

			} else {
				System.out.println("Se han superado el maximo de errores permitidos(5)");
			}

		} else {
			System.out.println("Se han superado el maximo de errores permitidos(5)");
		}

	}

	public void baja() {
		System.out.println("Introduce el dni del Profesor que quiera dar de baja");

		String dni = sc.nextLine();
		ArrayList<Profesor> profesores = leerFich();
		ObjectOutputStream out = null;
		
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FICHERO)));
			for (Profesor p : profesores) {
				if(!dni.equalsIgnoreCase(p.getDni())) {
					out.writeObject(p);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			out.close();
			}catch(IOException e) {
				e.fillInStackTrace();
			}
		}

	}

	public void modificar() {
		System.out.println("Introduce el dni del profesor a modificar");
		String dni = sc.nextLine();
		ObjectOutputStream out = null;
		ArrayList <Profesor> profesores = leerFich();
		for(Profesor p : profesores) {
			if(dni.equalsIgnoreCase(p.getDni())) {
				
			}
		}
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FICHERO)));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void buscar() {
		System.out.println("Introduce el dni del profesor");
		String dni = sc.nextLine();
		ObjectInputStream in = null;
		Profesor profe;
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FICHERO)));
			while (true) {
				profe = (Profesor) in.readObject();
				if (dni.equalsIgnoreCase(profe.getDni())) {
					System.out.println("****PROFESOR****");
					System.out.println("Dni: " + profe.getDni());
					System.out.println("Nombre: " + profe.getNombre());
					System.out.println("Direccion: " + profe.getDireccion());
					System.out.println("Telefono: " + profe.getTelefono());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void mostrar() {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FICHERO)));
			while (true) {
				Profesor profe = (Profesor) in.readObject();
				System.out.println("****PROFESOR****");
				System.out.println("Dni: " + profe.getDni());
				System.out.println("Nombre: " + profe.getNombre());
				System.out.println("Direccion: " + profe.getDireccion());
				System.out.println("Telefono: " + profe.getTelefono());
			}
		} catch (EOFException e) {

			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al mostrar Profesores");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			System.out.println("Error al mostrar Profesores");
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public ArrayList<Profesor> leerFich() {
		File fichero = new File(FICHERO);
		ObjectInputStream in = null;
		ArrayList<Profesor> profesores = new ArrayList<>();

		try {
			if (fichero.exists()) {//Comprobamos si existe
				in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichero)));
				while (true) {
					profesores.add((Profesor) in.readObject());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in !=null) {
					in.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return profesores;
	}

	public void guardarFich(Profesor profe) {
		File fichero = new File(FICHERO);
		FileOutputStream fileOut = null;
		BufferedOutputStream bufOut = null;
		ObjectOutputStream out = null;
		ArrayList<Profesor> listProfe = leerFich();
		boolean existe = false;
		try {			
			fileOut = new FileOutputStream(fichero);
			bufOut = new BufferedOutputStream(fileOut);
			out = new ObjectOutputStream(bufOut);
			for (Profesor p : listProfe) {
				out.writeObject(p);
				if (p.getDni().equalsIgnoreCase(profe.getDni())) {
					existe = true;
				}
			}

			if (!existe) {
				out.writeObject(profe);
			} else {
				System.out.println("Ese profesor ya existe. No puede haber dos Profesores con el mismo dni.");
			}
		} catch (IOException ex) {
//	            ex.printStackTrace();
		} finally {
			try {
				out.close();
				bufOut.close();
				fileOut.close();
			} catch (Exception ex) {
				// ex.printStackTrace();
			}
		}
	}
}
