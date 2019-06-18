package co.edu.poli.pdp.entidades;

import java.io.Serializable;

/**
 * Representa el ítem de una receta
 *
 */
public class ItemReceta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4267574670635398965L;
	private Medicina medicina;
	private String dosis;
	private int frecuenciaEnHoras;
	private int cantidadDias;

	/**
	 * Obtiene la medicina recetada
	 * 
	 * @return Medicina
	 */
	public Medicina getMedicina() {
		return medicina;
	}

	/**
	 * Modifica la medicina
	 * 
	 * @param medicina Nueva medicina
	 */
	public void setMedicina(Medicina medicina) {
		this.medicina = medicina;
	}

	/**
	 * Obtiene la dosis
	 * 
	 * @return Dosis
	 */
	public String getDosis() {
		return dosis;
	}

	/**
	 * Modifica la dosis
	 * 
	 * @param dosis Nueva dosis
	 */
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	/**
	 * Obtiene la frecuencia en horas
	 * 
	 * @return Frecuencia en horas
	 */
	public int getFrecuenciaEnHoras() {
		return frecuenciaEnHoras;
	}

	/**
	 * Modifica la frecuencia en horas
	 * 
	 * @param frecuenciaEnHoras Nueva frecuencia en horas
	 */
	public void setFrecuenciaEnHoras(int frecuenciaEnHoras) {
		this.frecuenciaEnHoras = frecuenciaEnHoras;
	}

	/**
	 * Modifica la cantidad de días
	 * 
	 * @return Cantidad de días
	 */
	public int getCantidadDias() {
		return cantidadDias;
	}

	/**
	 * Modifica la cantidad en días
	 * 
	 * @param cantidadDias Nueva cantidad en días
	 */
	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

}
