package co.edu.poli.pdp.entidades;

/**
 * Representa una mascota, que hereda de un Animal
 *
 */
public class Mascota extends Animal {

	private Mascota padre;
	private Mascota madre;
	private Raza raza;

	/**
	 * Constructor
	 */
	public Mascota() {
		super();
	}

	/**
	 * Obtiene el padre de la mascota
	 * 
	 * @return Padre
	 */
	public Mascota getPadre() {
		return padre;
	}

	/**
	 * Modifica el padre de la mascota
	 * 
	 * @param padre Nuevo padre
	 */
	public void setPadre(Mascota padre) {
		this.padre = padre;
	}

	/**
	 * Obtiene la madre de la mascota
	 * 
	 * @return Madre
	 */
	public Mascota getMadre() {
		return madre;
	}

	/**
	 * Modifica la madre de la mascota
	 * 
	 * @param madre Nueva madre
	 */
	public void setMadre(Mascota madre) {
		this.madre = madre;
	}

	/**
	 * Obtiene la raza
	 * 
	 * @return Raza
	 */
	public Raza getRaza() {
		return raza;
	}

	/**
	 * Modifica la raza
	 * 
	 * @param raza Nueva raza
	 */
	public void setRaza(Raza raza) {
		this.raza = raza;
	}

}
