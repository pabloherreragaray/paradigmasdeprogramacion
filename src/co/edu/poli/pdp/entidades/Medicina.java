package co.edu.poli.pdp.entidades;

/**
 * Representa una medicina o medicamento
 *
 */
public class Medicina {

	private String codigo;
	private String nombreDroga;

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
