package ikerRuiz_JavierVillarta_CentroDeFormacion;

import java.io.Serializable;
import java.util.HashMap;

public class Profesor implements Serializable {
	private String dni;
	private String nombre;
	private String direccion;
	private String telefono;

	/**
	 * @param dni
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param cursos
	 */
	public Profesor(String dni, String nombre, String direccion, String telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;

	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Profesor [dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", cursos=" + "]";
	}

}
