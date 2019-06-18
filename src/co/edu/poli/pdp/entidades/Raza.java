package co.edu.poli.pdp.entidades;

import java.io.Serializable;

/**
 * Representa una raza
 *
 */
public class Raza implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6636284126515251781L;
	private String nombre;
	private Especie especie;

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
	 * Obtiene la especie
	 * 
	 * @return Especie
	 */
	public Especie getEspecie() {
		return especie;
	}

	/**
	 * Modifica la especie
	 * 
	 * @param especie Nueva especie
	 */
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

}
