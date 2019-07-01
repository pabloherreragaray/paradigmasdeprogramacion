package co.edu.poli.pdp.entidades;

import java.io.Serializable;

/**
 * Representa una enfermedad
 *
 */
public class Enfermedad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4737133787917912877L;
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
	 * @param nombre NUevo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return getNombre();
	}

}
