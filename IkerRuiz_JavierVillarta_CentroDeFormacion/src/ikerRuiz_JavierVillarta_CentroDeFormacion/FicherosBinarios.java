package ikerRuiz_JavierVillarta_CentroDeFormacion;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class FicherosBinarios {

	public void guardar(Alumno alumno, File file) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file, true)));
			out.writeObject(alumno);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void guardar2(Alumno alumno, File file) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			out.writeObject(alumno);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public HashMap<Integer, Alumno> leer(File file) {

		ObjectInputStream in = null;
		HashMap<Integer, Alumno> alumnos = new HashMap<>();
		int expe;
		String nom, ape, tel, dir;
		Date fechNc;

		if (file.length() != 0) {
			try {
				in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

				while (true) {
					Alumno a = (Alumno) in.readObject();
					alumnos.put(a.getNumExpediente(), a);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else {
			alumnos = new HashMap<>();
		}

		return alumnos;

	}
}
