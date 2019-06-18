package co.edu.poli.pdp.entidades;

import java.io.Serializable;

/**
 * Representa una patología
 *
 */
public class Patologia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7663615804407300993L;
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
