package co.edu.poli.pdp.entidades;

import java.io.Serializable;

/**
 * Representa una medicina o medicamento
 *
 */
public class Medicina implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7517398780498507406L;
	private String codigo;
	private String nombreDroga;

	/**
	 * Obtiene el c�digo
	 * 
	 * @return C�digo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Modifica el c�digo
	 * 
	 * @param codigo Nuevo c�digo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene el nombre de la droga
	 * 
	 * @return Nombre de la droga
	 */
	public String getNombreDroga() {
		return nombreDroga;
	}

	/**
	 * Modifica el nombre de la droga
	 * 
	 * @param nombreDroga Nuevo nombre de la droga
	 */
	public void setNombreDroga(String nombreDroga) {
		this.nombreDroga = nombreDroga;
	}

	@Override
	public String toString() {
		return getCodigo() + " - " + getNombreDroga();
	}

}
