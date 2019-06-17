package co.edu.poli.pdp.entidades;

import java.util.Date;

/**
 * Representa un ítem dentro del historial de propietarios de un animal
 *
 */
public class HistorialPropietarioAnimal {

	private Animal animal;
	private Propietario propietario;
	private Date fechaPaso;
	private TipoPasoPropietario tipoPaso;

	/**
	 * Obtiene el animal
	 * 
	 * @return Animal
	 */
	public Animal getAnimal() {
		return animal;
	}

	/**
	 * Modifica el animal
	 * 
	 * @param animal Nuevo animal
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	/**
	 * Obtiene el propietario
	 * 
	 * @return Propietario
	 */
	public Propietario getPropietario() {
		return propietario;
	}

	/**
	 * Modifica el propietario
	 * 
	 * @param propietario NUevo propietario
	 */
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	/**
	 * Obtiene la fecha del paso
	 * 
	 * @return Fecha del paso
	 */
	public Date getFechaPaso() {
		return fechaPaso;
	}

	/**
	 * Modifica la fecha del paso
	 * 
	 * @param fechaPaso Nueva fecha del paso
	 */
	public void setFechaPaso(Date fechaPaso) {
		this.fechaPaso = fechaPaso;
	}

	/**
	 * Obtiene el tipo de paso
	 * 
	 * @return Tipo de paso
	 */
	public TipoPasoPropietario getTipoPaso() {
		return tipoPaso;
	}

	/**
	 * Modifica el tipo de paso
	 * 
	 * @param tipoPaso NUevo tipo de paso
	 */
	public void setTipoPaso(TipoPasoPropietario tipoPaso) {
		this.tipoPaso = tipoPaso;
	}

}
