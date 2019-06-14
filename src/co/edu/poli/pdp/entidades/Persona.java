package co.edu.poli.pdp.entidades;

/**
 * Representa una persona
 *
 */
public abstract class Persona {

	private int numeroDocumento;
	private String nombre;
	private String apellido;
	private String direccion;
	private int telefono;
	private int celular;

	/**
	 * Obtiene el n�mero de documento
	 * 
	 * @return N�mero de documento
	 */
	public int getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * Modifica el n�mero de documento
	 * 
	 * @param numeroDocumento Nuevo n�mero de documento
	 */
	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	/**
	 * Obtiene el nombre
	 * 
	 * @return Nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre
	 * 
	 * @param nombre Nuevo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el apellido
	 * 
	 * @return Apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Modifica el apellido
	 * 
	 * @param apellido Nuevo apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Obtiene la direcci�n
	 * 
	 * @return Direcci�n
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Modifica la direcci�n
	 * 
	 * @param direccion Nueva direcci�n
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Obtiene el tel�fono
	 * 
	 * @return Tel�fono
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * Modifica el tel�fono
	 * 
	 * @param telefono Nuevo tel�fono
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * Obtiene el celular
	 * 
	 * @return Celular
	 */
	public int getCelular() {
		return celular;
	}

	/**
	 * Modifica el celular
	 * 
	 * @param celular Nuevo celular
	 */
	public void setCelular(int celular) {
		this.celular = celular;
	}

}
