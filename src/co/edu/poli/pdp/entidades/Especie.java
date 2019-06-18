package co.edu.poli.pdp.entidades;

import java.io.Serializable;

/**
 * Representa una especie
 *
 */
public class Especie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7608895283496795470L;
	private String nombre;

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
