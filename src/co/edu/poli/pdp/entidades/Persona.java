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
	 * Obtiene el número de documento
	 * 
	 * @return Número de documento
	 */
	public int getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * Modifica el número de documento
	 * 
	 * @param numeroDocumento Nuevo número de documento
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
	 * Obtiene la dirección
	 * 
	 * @return Dirección
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Modifica la dirección
	 * 
	 * @param direccion Nueva dirección
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Obtiene el teléfono
	 * 
	 * @return Teléfono
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * Modifica el teléfono
	 * 
	 * @param telefono Nuevo teléfono
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
