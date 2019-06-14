package co.edu.poli.pdp.entidades;

/**
 * Representa una patología
 *
 */
public class Patologia {

	private String codigo;
	private String nombre;

	/**
	 * Obtiene el código
	 * 
	 * @return Código
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Modifica el código
	 * 
	 * @param codigo Nuevo código
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

}
