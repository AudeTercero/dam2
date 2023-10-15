import java.util.HashMap;

public class Curso {
	private int codCur;
	private String nombre;
	private String descripcion;
	private HashMap<Integer, Alumno> alumnos;

	/**
	 * @param codCur
	 * @param nombre
	 * @param descripcion
	 * @param cursos
	 */
	public Curso(int codCur, String nombre, String descripcion, HashMap<Integer, Alumno> alumnos) {		
		this.codCur = codCur;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.alumnos = alumnos;
	}

	public int getCodCur() {
		return codCur;
	}

	public void setCodCur(int codCur) {
		this.codCur = codCur;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public HashMap<Integer, Alumno> getCursos() {
		return alumnos;
	}

	public void setCursos(HashMap<Integer, Alumno> cursos) {
		this.alumnos = cursos;
	}

	@Override
	public String toString() {
		return "Curso [codCur=" + codCur + ", nombre=" + nombre + ", descripcion=" + descripcion + ", cursos=" + alumnos
				+ "]";
	}

}
