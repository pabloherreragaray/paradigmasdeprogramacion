package co.edu.poli.pdp.entidades;

/**
 * Representa una medicina o medicamento
 *
 */
public class Medicina {

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

}
