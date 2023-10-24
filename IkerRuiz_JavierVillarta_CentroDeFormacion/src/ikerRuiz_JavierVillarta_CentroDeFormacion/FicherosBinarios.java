package ikerRuiz_JavierVillarta_CentroDeFormacion;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

public class FicherosBinarios {

	public void guardar(Object o) {
		
	}
	
	public HashMap <Integer,Alumno> leer(File file) {
		DataInputStream in = null;
		HashMap <Integer, Alumno> alumnos = new HashMap<>();
		int expe;
		String nom, ape, tel, dir;
		Date fechNc;
		
		try {
			in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
			
			while(true) {
				
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return alumnos;
		
	}
}
