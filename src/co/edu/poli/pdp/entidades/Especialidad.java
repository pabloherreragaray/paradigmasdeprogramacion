package co.edu.poli.pdp.entidades;

import java.io.Serializable;

/**
 * Representa una especialidad
 *
 */
public class Especialidad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7744088384148404003L;
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
	
	@Override
	public String toString() {
		return getNombre();
	}

}
