package co.edu.poli.pdp.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un profesional que hereda de una Persona
 *
 */
public class Profesional extends Persona {

	private long numeroRegistro;
	private List<Especialidad> especialidades;

	/**
	 * Constructor
	 */
	public Profesional() {
		especialidades = new ArrayList<Especialidad>();
	}

	/**
	 * Obtiene el número de registro
	 * 
	 * @return Número de registro
	 */
	public long getNumeroRegistro() {
		return numeroRegistro;
	}

	/**
	 * Modifica el número de registro
	 * 
	 * @param numeroRegistro Nuevo número de registro
	 */
	public void setNumeroRegistro(long numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	/**
	 * Obtiene las especialidades del profesional
	 * 
	 * @return Especialidades
	 */
	public List<Especialidad> getEspecialidades() {
		return especialidades;
	}

	/**
	 * Modifica las especialidades del profesional
	 * 
	 * @param especialidades Nuevas especialidades
	 */
	public void setEspecialidades(List<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}

	/**
	 * Adiciona una especialidad
	 * 
	 * @param especialidad Nueva especialidad
	 */
	public void adicionarEspecialidad(Especialidad especialidad) {
		getEspecialidades().add(especialidad);
	}

}
