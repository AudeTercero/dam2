import java.util.HashMap;

public class Profesor {
	private String dni;
	private String nombre;
	private String direccion;
	private String telefono;
	private HashMap<Integer, Curso> cursos;

	/**
	 * @param dni
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param cursos
	 */
	public Profesor(String dni, String nombre, String direccion, String telefono, HashMap<Integer, Curso> cursos) {		
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.cursos = cursos;
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

	public HashMap<Integer, Curso> getCursos() {
		return cursos;
	}

	public void setCursos(HashMap<Integer, Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		return "Profesor [dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", cursos=" + cursos + "]";
	}

}
