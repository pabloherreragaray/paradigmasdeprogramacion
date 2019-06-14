package co.edu.poli.pdp.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa un animal
 *
 */
public class Animal {

	private int numeroRegistro;
	private Especie especie;
	private String nombre;
	private Sexo sexo;
	private Date fechaNacimiento;
	private Propietario propietario;
	private List<CambioPropietarioAnimal> historialPropietarios;

	/**
	 * Constructor
	 */
	public Animal() {
		historialPropietarios = new ArrayList<CambioPropietarioAnimal>();
	}

	/**
	 * Obtiene el número del registro del animal
	 * 
	 * @return Número del registro del animal
	 */
	public int getNumeroRegistro() {
		return numeroRegistro;
	}

	/**
	 * Modifica el número de registro del animal
	 * 
	 * @param numeroRegistro Nuevo número de registro
	 */
	public void setNumeroRegistro(int numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	/**
	 * Obtiene la especie del animal
	 * 
	 * @return Especie del animal
	 */
	public Especie getEspecie() {
		return especie;
	}

	/**
	 * Modifica la especie del animal
	 * 
	 * @param especie Nueva especie del animal
	 */
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	/**
	 * Obtiene el nombre del animal
	 * 
	 * @return Nombre del animal
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre del animal
	 * 
	 * @param nombre NUevo nombre del animal
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el sexo del animal
	 * 
	 * @return Sexo del animal
	 */
	public Sexo getSexo() {
		return sexo;
	}

	/**
	 * Modifica el sexo del animal
	 * 
	 * @param sexo Sexo del animal
	 */
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	/**
	 * Obtiene la fecha de nacimiento del animal
	 * 
	 * @return Fecha de nacimiento del animal
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Modifica la fecha de nacimiento del animal
	 * 
	 * @param fechaNacimiento Nueva fecha de nacimiento del animal
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Obtiene el propietario del animal
	 * 
	 * @return Propietario del animal
	 */
	public Propietario getPropietario() {
		return propietario;
	}

	/**
	 * Modifica el propietario del animal. Este método no debe usarse para cambiar
	 * de propietario, para eso use cambiarPropietario. Solo debe usarse para
	 * construir la instancia con datos persistentes.
	 * 
	 * @param propietario Nuevo propietario del animal
	 * @see cambiarPropietario
	 */
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	/**
	 * Obtiene el historial de propietarios del animal
	 * 
	 * @return Historial de propietarios del animal
	 */
	public List<CambioPropietarioAnimal> getHistorialPropietarios() {
		return historialPropietarios;
	}

	/**
	 * Modifica el historial de propietarios del animal
	 * 
	 * @param historialPropietarios Nuevo historial de propietarios
	 */
	public void setHistorialPropietarios(List<CambioPropietarioAnimal> historialPropietarios) {
		this.historialPropietarios = historialPropietarios;
	}

	/**
	 * Cambia el propietario del animal y guarda el cambio en el historial
	 * 
	 * @param nuevoPropietario NUevo propietario del animal
	 * @param fecha            Fecha del cambio de dueño
	 */
	public void cambiarPropietario(Propietario nuevoPropietario, Date fecha) {
		CambioPropietarioAnimal cambio = new CambioPropietarioAnimal();
		cambio.setAnimal(this);
		cambio.setFechaPaso(fecha);
		cambio.setPropietario(nuevoPropietario);
		cambio.setTipoPaso(TipoPasoPropietario.Cambio);
		getHistorialPropietarios().add(cambio);
		setPropietario(nuevoPropietario);
	}

	/**
	 * Establece el primer propietario del animal. Debe llamarse al crearse el
	 * registro del animal.
	 * 
	 * @param primerPropietario Primer propietario
	 * @param fecha             Fecha del registro
	 */
	public void setPrimerPropietario(Propietario primerPropietario, Date fecha) {
		CambioPropietarioAnimal cambio = new CambioPropietarioAnimal();
		cambio.setAnimal(this);
		cambio.setFechaPaso(fecha);
		cambio.setPropietario(primerPropietario);
		cambio.setTipoPaso(TipoPasoPropietario.Inicio);
		getHistorialPropietarios().add(cambio);
		setPropietario(primerPropietario);
	}

}
