package co.edu.poli.pdp.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Representa una consulta médica
 *
 */
public class Consulta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4163782314181363722L;
	private String codigo;
	private Date fecha;
	private Animal animal;
	private String motivo;
	private String examenFisico;
	private String tratamiento;
	private Profesional profesional;
	private Patologia patologia;
	private Enfermedad enfermedadCronica;
	private List<ItemReceta> receta;

	/**
	 * Constructor
	 */
	public Consulta() {
		receta = new ArrayList<ItemReceta>();
	}

	/**
	 * Obtiene el código de la consulta
	 * 
	 * @return Código de la consulta
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Modifca el código de la consulta
	 * 
	 * @param codigo Nuevo código de la consulta
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene la fecha de la consulta
	 * 
	 * @return Fecha de la consulta
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Modifica la fecha de la consulta
	 * 
	 * @param fecha Nueva fecha de la consulta
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene el animal atendido
	 * 
	 * @return Animal atendido
	 */
	public Animal getAnimal() {
		return animal;
	}

	/**
	 * Modifica el animal atendido
	 * 
	 * @param animal Nuevo animal atendido
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	/**
	 * Obtiene el motivo de la consulta
	 * 
	 * @return Motivo de la consulta
	 */
	public String getMotivo() {
		return motivo;
	}

	/**
	 * Modifica el motivo de la consulta
	 * 
	 * @param motivo Nuevo motivo de la consulta
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	/**
	 * Obtiene el examen físico
	 * 
	 * @return Examen físico
	 */
	public String getExamenFisico() {
		return examenFisico;
	}

	/**
	 * Modifica el examen físico
	 * 
	 * @param examenFisico NUevo examen físico
	 */
	public void setExamenFisico(String examenFisico) {
		this.examenFisico = examenFisico;
	}

	/**
	 * Obtiene el tratamiento
	 * 
	 * @return Tratamiento
	 */
	public String getTratamiento() {
		return tratamiento;
	}

	/**
	 * Modifica el tratamiento
	 * 
	 * @param tratamiento Nuevo tratamiento
	 */
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	/**
	 * Obtiene el profesoinal que atiende la consulta
	 * 
	 * @return Profesional que atiende
	 */
	public Profesional getProfesional() {
		return profesional;
	}

	/**
	 * Modifica el profesional que atiende la consulta
	 * 
	 * @param profesional Nuevo profesional que atiende
	 */
	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	/**
	 * Obtiene la patología
	 * 
	 * @return Patología
	 */
	public Patologia getPatologia() {
		return patologia;
	}

	/**
	 * Modifica la patología
	 * 
	 * @param patologia Nueva patología
	 */
	public void setPatologia(Patologia patologia) {
		this.patologia = patologia;
	}

	/**
	 * Obtiene la enfermedad crónica detectada (si la hay)
	 * 
	 * @return Enfermedad crónica detectada
	 */
	public Enfermedad getEnfermedadCronica() {
		return enfermedadCronica;
	}

	/**
	 * Modifica la enfermedad crónica
	 * 
	 * @param enfermedadCronica Nueva enfermedad crónica
	 */
	public void setEnfermedadCronica(Enfermedad enfermedadCronica) {
		this.enfermedadCronica = enfermedadCronica;
	}

	/**
	 * Obtiene la lista de medicamentos recetados
	 * 
	 * @return Lista de medicamentos
	 */
	public List<ItemReceta> getReceta() {
		return receta;
	}

	/**
	 * Modifica la lista de medicamentos
	 * 
	 * @param receta Nueva lista de medicamentos
	 */
	public void setReceta(List<ItemReceta> receta) {
		this.receta = receta;
	}

	/**
	 * Adiciona un ítem a la receta
	 * 
	 * @param item Nuevo ítem de la receta
	 */
	public void adicionarItemAReceta(ItemReceta item) {
		getReceta().add(item);
	}

}
