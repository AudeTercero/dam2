package ikerRuiz_JavierVillarta_CentroDeFormacion;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Alumno {
	private int numExpediente;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String direccion;
	private Date fechNac;
	private HashMap<Integer, Curso> cursos;
	private File file = new File("Alumnos.bin");
	private FicherosBinarios fb = new FicherosBinarios();

	/**
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 * @param direccion
	 * @param fechNac
	 */
	public Alumno(String nombre, String apellidos, String telefono, String direccion, Date fechNac) {		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fechNac = fechNac;
		this.numExpediente = nuevoExpediente(file);
		
	}
	
	public Alumno(int expe, String nombre, String apellidos, String telefono, String direccion, Date fechNac) {		
		this.numExpediente = expe;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fechNac = fechNac;		
		
	}
	
	public int nuevoExpediente(File file) {
		int aux = 0;
		
		HashMap<Integer, Alumno> alumnos = fb.leer(file);
		for (Map.Entry<Integer, Alumno> entry : alumnos.entrySet()) {
            Alumno a = entry.getValue();
            
            if(a.getNumExpediente() > aux) {
            	aux = a.getNumExpediente();
            }					            
        }
		return aux;
	}

	public int getNumExpediente() {
		return numExpediente;
	}

	public void setNumExpediente(int numExpediente) {
		this.numExpediente = numExpediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechNac() {
		return fechNac;
	}

	public void setFechNac(Date fechNac) {
		this.fechNac = fechNac;
	}

	public HashMap<Integer, Curso> getCursos() {
		return cursos;
	}

	public void setCursos(HashMap<Integer, Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() { //Fallara por el hashmap 100%
		return "Alumno [numExpediente=" + numExpediente + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", telefono=" + telefono + ", direccion=" + direccion + ", fechNac=" + fechNac + ", cursos=" + cursos
				+ "]";
	}
	
	

}
