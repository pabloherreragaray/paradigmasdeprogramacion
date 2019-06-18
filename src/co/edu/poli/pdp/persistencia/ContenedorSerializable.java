package co.edu.poli.pdp.persistencia;

import java.io.Serializable;
import java.util.List;

import co.edu.poli.pdp.entidades.Animal;
import co.edu.poli.pdp.entidades.Consulta;
import co.edu.poli.pdp.entidades.Enfermedad;
import co.edu.poli.pdp.entidades.Especialidad;
import co.edu.poli.pdp.entidades.Especie;
import co.edu.poli.pdp.entidades.Medicina;
import co.edu.poli.pdp.entidades.Patologia;
import co.edu.poli.pdp.entidades.Profesional;
import co.edu.poli.pdp.entidades.Propietario;
import co.edu.poli.pdp.entidades.Raza;

public class ContenedorSerializable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6477732093360892649L;
	public List<Animal> animales;
	public List<Consulta> consultas;
	public List<Enfermedad> enfermedades;
	public List<Especialidad> especialidades;
	public List<Especie> especies;
	public List<Medicina> medicinas;
	public List<Patologia> patologias;
	public List<Profesional> profesionales;
	public List<Propietario> propietarios;
	public List<Raza> razas;

}
