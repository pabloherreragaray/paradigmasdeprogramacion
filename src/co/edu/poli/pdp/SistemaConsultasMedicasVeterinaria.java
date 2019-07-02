package co.edu.poli.pdp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
import co.edu.poli.pdp.entidades.Sexo;
import co.edu.poli.pdp.persistencia.ContenedorSerializable;
import co.edu.poli.pdp.persistencia.DALInterface;

/**
 * Clase contenedora de todas las entidades
 *
 */
public class SistemaConsultasMedicasVeterinaria {
	private static SistemaConsultasMedicasVeterinaria instancia;

	private List<Animal> animales;
	private List<Propietario> propietarios;
	private List<Profesional> profesionales;
	private List<Consulta> consultas;
	private List<Especie> especies;
	private List<Raza> razas;
	private List<Especialidad> especialidades;
	private List<Enfermedad> enfermedades;
	private List<Patologia> patologias;
	private List<Medicina> medicinas;
	private DALInterface dal;

	/**
	 * Constructor privado
	 */
	private SistemaConsultasMedicasVeterinaria() {
		animales = new ArrayList<Animal>();
		propietarios = new ArrayList<Propietario>();
		profesionales = new ArrayList<Profesional>();
		consultas = new ArrayList<Consulta>();
		especies = new ArrayList<Especie>();
		razas = new ArrayList<Raza>();
		especialidades = new ArrayList<Especialidad>();
		enfermedades = new ArrayList<Enfermedad>();
		patologias = new ArrayList<Patologia>();
		medicinas = new ArrayList<Medicina>();
	}

	/**
	 * Patrón singleton
	 * 
	 * @return Instancia única
	 */
	public static SistemaConsultasMedicasVeterinaria getInstancia() {
		if (instancia == null)
			instancia = new SistemaConsultasMedicasVeterinaria();
		return instancia;
	}

	/**
	 * Obtiene la lista de animales
	 * 
	 * @return Animales
	 */
	public List<Animal> getAnimales() {
		return animales;
	}

	/**
	 * Encuantra un animal por su número de registro
	 * 
	 * @param numeroRegistro Número de registro
	 * @return Animal encontrado o null
	 */
	public Animal getAnimalPorNumeroRegistro(int numeroRegistro) {
		return animales.stream().filter((a) -> a.getNumeroRegistro() == numeroRegistro).findFirst().orElse(null);
	}

	/**
	 * Obtiene la lista de propietarios
	 * 
	 * @return Propietarios
	 */
	public List<Propietario> getPropietarios() {
		return propietarios;
	}

	/**
	 * Obtiene un propietario por su número de documento
	 * 
	 * @param numeroDocumento Número de documento
	 * @return Propietario encontrado o null
	 */
	public Propietario getPropietarioPorNumeroDocumento(long numeroDocumento) {
		return propietarios.stream().filter((p) -> p.getNumeroDocumento() == numeroDocumento).findFirst().orElse(null);
	}

	/**
	 * Obtiene la lista de profesionales
	 * 
	 * @return Profesionales
	 */
	public List<Profesional> getProfesionales() {
		return profesionales;
	}

	/**
	 * Obtiene un profesional por su número de documento
	 * 
	 * @param numeroDocumento Número de documento
	 * @return Profesional encontrado o null
	 */
	public Profesional getProfesionalPorNumeroDocumento(long numeroDocumento) {
		return profesionales.stream().filter((p) -> p.getNumeroDocumento() == numeroDocumento).findFirst().orElse(null);
	}

	/**
	 * Obtiene un profesional por su número de registro
	 * 
	 * @param numeroRegistro Número de registro
	 * @return Profesional encontrado o null
	 */
	public Profesional getProfesionalPorNumeroRegistro(int numeroRegistro) {
		return profesionales.stream().filter((p) -> p.getNumeroRegistro() == numeroRegistro).findFirst().orElse(null);
	}

	/**
	 * Obtiene la lista de consultas
	 * 
	 * @return Consultas
	 */
	public List<Consulta> getConsultas() {
		return consultas;
	}

	/**
	 * Obtiene una consulta por su código
	 * 
	 * @param codigo Código
	 * @return Consulta encontrada on null
	 */
	public Consulta getConsultaPorCodigo(String codigo) {
		return consultas.stream().filter((c) -> c.getCodigo().equals(codigo)).findFirst().orElse(null);
	}

	/**
	 * Obtiene la lista de especies
	 * 
	 * @return Especies
	 */
	public List<Especie> getEspecies() {
		return especies;
	}

	/**
	 * Obtiene una especie por su nombre
	 * 
	 * @param nombre Nombre
	 * @return Especie encontrada o null
	 */
	public Especie getEspeciePorNombre(String nombre) {
		return especies.stream().filter((e) -> e.getNombre().equals(nombre)).findFirst().orElse(null);
	}

	/**
	 * Obtiene la lista de razas
	 * 
	 * @return Razas
	 */
	public List<Raza> getRazas() {
		return razas;
	}

	/**
	 * Obtiene una raza por su nombre
	 * 
	 * @param nombre Nombre
	 * @return Raza encontrada o null
	 */
	public Raza getRazaPorNombre(String nombre) {
		return razas.stream().filter((r) -> r.getNombre().equals(nombre)).findFirst().orElse(null);
	}

	/**
	 * Obtiene la lista de especialidades
	 * 
	 * @return especialidades
	 */
	public List<Especialidad> getEspecialidades() {
		return especialidades;
	}

	/**
	 * Obtiene una especialidad por su nombre
	 * 
	 * @param nombre Nombre
	 * @return Especialidad encontrada o null
	 */
	public Especialidad getEspecialidadPorNombre(String nombre) {
		return especialidades.stream().filter((e) -> e.getNombre().equals(nombre)).findFirst().orElse(null);
	}

	/**
	 * Obtiene la lista de enfermedades crónicas
	 * 
	 * @return Enfermedades crónicas
	 */
	public List<Enfermedad> getEnfermedades() {
		return enfermedades;
	}

	/**
	 * Obtiene una enfermedad por su nombre
	 * 
	 * @param nombre Nombre
	 * @return Enfermedad encontrada o null
	 */
	public Enfermedad getEnfermedadPorNombre(String nombre) {
		return enfermedades.stream().filter((e) -> e.getNombre().equals(nombre)).findFirst().orElse(null);
	}

	/**
	 * Obtiene la lista de patologías
	 * 
	 * @return Patologías
	 */
	public List<Patologia> getPatologias() {
		return patologias;
	}

	/**
	 * Obtiene una patología por su código
	 * 
	 * @param codigo Código
	 * @return Patología encontrada o null
	 */
	public Patologia getPatologiaPorCodigo(String codigo) {
		return patologias.stream().filter((p) -> p.getCodigo().equals(codigo)).findFirst().orElse(null);
	}

	/**
	 * Obtiene la lista de medicinas
	 * 
	 * @return Medicinas
	 */
	public List<Medicina> getMedicina() {
		return medicinas;
	}

	/**
	 * Obtiene una medicina por su código
	 * 
	 * @param codigo Código
	 * @return Medicina encontrada o null
	 */
	public Medicina getMedicinaPorCodigo(String codigo) {
		return medicinas.stream().filter((m) -> m.getCodigo().equals(codigo)).findFirst().orElse(null);
	}

	/**
	 * Adiciona un animal pasando la instancia de la clase. Este método debe usarse
	 * para cargar las entidades desde los datos persistentes.
	 * 
	 * @param animal
	 * @return Animal registrado
	 */
	public Animal registrarAnimal(Animal animal) {
		animales.add(animal);
		return animal;
	}

	/**
	 * Adiciona un animal pasando la información de éste. Este método debe usarse
	 * para registrar un nuevo animal en el sistema.
	 * 
	 * @param numeroRegistro  Número de registro del animal
	 * @param especie         Especie del animal
	 * @param raza            Raza del animal (opcional)
	 * @param nombre          Nombre del animal
	 * @param sexo            Sexo del animal
	 * @param fechaNacimiento Fecha de nacimiento del animal
	 * @param propietario     Propietario del animal
	 * @param padre           Padre del animal (opcional)
	 * @param madre           Madre del animal (opcional)
	 * @return Animal registrado
	 */
	public Animal registrarAnimal(int numeroRegistro, Especie especie, Raza raza, String nombre, Sexo sexo,
			Date fechaNacimiento, Propietario propietario, Animal padre, Animal madre) {
		Animal a = new Animal();
		a.setNumeroRegistro(numeroRegistro);
		a.setEspecie(especie);
		a.setNombre(nombre);
		a.setSexo(sexo);
		a.setFechaNacimiento(fechaNacimiento);
		a.setPrimerPropietario(propietario, new Date());
		return registrarAnimal(a);
	}

	/**
	 * Adiciona un propietario pasando la instancia de la clase. Este método debe
	 * usarse para cargar las entidades desde los datos persistentes
	 * 
	 * @param propietario Propietario
	 * @return Prtopietario registrado
	 */
	public Propietario registrarPropietario(Propietario propietario) {
		propietarios.add(propietario);
		return propietario;
	}

	/**
	 * Adiciona un propietario pasando los datos de éste. Este método debe usarse
	 * para adicionar un nuevo propietario al sistema.
	 * 
	 * @param numeroDocumento Número de documento
	 * @param nombre          Nombres
	 * @param apellido        Apellidos
	 * @param direccion       Dirección
	 * @param telefono        Teléfono
	 * @param celular         Celular
	 * @return Propietario registrado
	 */
	public Propietario registrarPropietario(long numeroDocumento, String nombre, String apellido, String direccion,
			long telefono, long celular) {
		Propietario p = new Propietario();
		p.setNumeroDocumento(numeroDocumento);
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setDireccion(direccion);
		p.setTelefono(telefono);
		p.setCelular(celular);
		return registrarPropietario(p);
	}

	/**
	 * Cambia el propietario de un animal
	 * 
	 * @param animal           Animal
	 * @param nuevoPropietario NUevo propietario
	 * @param fechaPaso        Fecha del cambio del propietario
	 */
	public void cambiarPropietario(Animal animal, Propietario nuevoPropietario, Date fechaPaso) {
		animal.cambiarPropietario(nuevoPropietario, fechaPaso);
	}

	/**
	 * Adiciona un profesional pasando la instancia de la clase. Este método debe
	 * usarse para cargar las entidades desde los datos persistentes
	 * 
	 * @param profesional Profesional
	 * @return Profesional registrado
	 */
	public Profesional registrarProfesional(Profesional profesional) {
		profesionales.add(profesional);
		return profesional;
	}

	/**
	 * Adiciona un profesional pasando los datos de éste. Este método debe usarse
	 * para adicionar un nuevo profesional al sistema
	 * 
	 * @param numeroDocumento Número de documento
	 * @param nombre          Nombres
	 * @param apellido        Apellidos
	 * @param direccion       Dirección
	 * @param telefono        Teléfono
	 * @param celular         Celular
	 * @param numeroRegistro  Número de registro profesional
	 * @return Profesional registrado
	 */
	public Profesional registrarProfesional(long numeroDocumento, String nombre, String apellido, String direccion,
			long telefono, long celular, long numeroRegistro) {
		Profesional p = new Profesional();
		p.setNumeroDocumento(numeroDocumento);
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setDireccion(direccion);
		p.setTelefono(telefono);
		p.setCelular(celular);
		p.setNumeroRegistro(numeroRegistro);
		return registrarProfesional(p);
	}

	/**
	 * Adiciona una nueva consulta pasando la instancia de la clase. Este método
	 * debe usarse para cargar las entidades desde los datos persistentes.
	 * 
	 * @param consulta Consulta
	 * @return Consulta registrada
	 */
	public Consulta registrarConsulta(Consulta consulta) {
		consultas.add(consulta);
		return consulta;
	}

	/**
	 * Adiciona una nueva consulta pasando los datos de ésta. Este método debe
	 * usarse para adicionar una nueva cosulta al sistema.
	 * 
	 * @param codigo            Código de la consulta
	 * @param animal            Animal
	 * @param fecha             Fecha de la consulta
	 * @param motivo            Motivo de consulta
	 * @param examen            Examen físico
	 * @param tratamiento       Tratamiento
	 * @param profesional       Profesional
	 * @param patologia         Patología hallada
	 * @param enfermedadCronica Enfermedad crónica encontrada
	 * @return Consulta registrada
	 */
	public Consulta registrarConsulta(String codigo, Animal animal, Date fecha, String motivo, String examen,
			String tratamiento, Profesional profesional, Patologia patologia, Enfermedad enfermedadCronica) {
		Consulta c = new Consulta();
		c.setCodigo(codigo);
		c.setAnimal(animal);
		c.setFecha(fecha);
		c.setMotivo(motivo);
		c.setExamenFisico(examen);
		c.setTratamiento(tratamiento);
		c.setProfesional(profesional);
		c.setPatologia(patologia);
		c.setEnfermedadCronica(enfermedadCronica);
		return registrarConsulta(c);
	}

	/**
	 * Adiciona una enfermedad pasando la instancia de la clase. Este método debe
	 * usarse para cargar las entidades desde los datos persistentes.
	 * 
	 * @param enfermedad Enfermedad
	 * @return Enfermedad registrada
	 */
	public Enfermedad registrarEnfermedad(Enfermedad enfermedad) {
		enfermedades.add(enfermedad);
		return enfermedad;
	}

	/**
	 * Adiciona una enfermedad pasando el nombre de ésta. Este método debe usarse
	 * para adicionar una nueva enfermedad al sistema.
	 * 
	 * @param nombre Nombre de la enfermedad
	 * @return Enfermedad registrada
	 */
	public Enfermedad registrarEnfermedad(String nombre) {
		Enfermedad e = new Enfermedad();
		e.setNombre(nombre);
		return registrarEnfermedad(e);
	}

	/**
	 * Adiciona una medicina pasando la instancia de la clase. Este método debe
	 * usarse para cargar las entidades desde los datos persistentes.
	 * 
	 * @param medicina Medicina
	 * @return Medicina registrada
	 */
	public Medicina registrarMedicina(Medicina medicina) {
		medicinas.add(medicina);
		return medicina;
	}

	/**
	 * Adiciona una medicina pasando los datos de ésta. Este método debe usarse para
	 * adicionar una nueva medicina al sistema.
	 * 
	 * @param codigo      Código de la medicina
	 * @param nombreDroga Nombre
	 * @return Medicina registrada
	 */
	public Medicina registrarMedicina(String codigo, String nombreDroga) {
		Medicina m = new Medicina();
		m.setCodigo(codigo);
		m.setNombreDroga(nombreDroga);
		return registrarMedicina(m);
	}

	/**
	 * Adiciona una especialidad pasando la instancia de la clase. Este método debe
	 * usarse para cargar las entidades desde los datos persistentes.
	 * 
	 * @param especialidad Especialidad
	 * @return Especialidad registrada
	 */
	public Especialidad registrarEspecialidad(Especialidad especialidad) {
		especialidades.add(especialidad);
		return especialidad;
	}

	/**
	 * Adiciona una especialidad pasando el nombre de ésta. Este método debe usarse
	 * para adicionar una especialidad al sistema.
	 * 
	 * @param nombre Nombre
	 * @return Especialidad registrada
	 */
	public Especialidad registrarEspecialidad(String nombre) {
		Especialidad e = new Especialidad();
		e.setNombre(nombre);
		return registrarEspecialidad(e);
	}

	/**
	 * Adiciona una especie pasando la instancia de la clase. Este método debe
	 * usarse para cargar las entidades desde los datos persistentes.
	 * 
	 * @param especie Especie
	 * @return Especie registrada
	 */
	public Especie registrarEspecie(Especie especie) {
		especies.add(especie);
		return especie;
	}

	/**
	 * Adiciona una especie pasando el nombre de éste. Este método debe usarse para
	 * adicionar una especie al sistema
	 * 
	 * @param nombre Nombre de la especie
	 * @return Especie registrada
	 */
	public Especie registrarEspecie(String nombre) {
		Especie e = new Especie();
		e.setNombre(nombre);
		return registrarEspecie(e);
	}

	/**
	 * Adiciona una raza pasando la instancia de la clase. Este método debe usarse
	 * para cargar las entidades desde los datos persistentes.
	 * 
	 * @param raza Raza
	 * @return Raza registrada
	 */
	public Raza registrarRaza(Raza raza) {
		razas.add(raza);
		return raza;
	}

	/**
	 * Adiciona una raza pasando los datos de ésta. Este método debe usarse para
	 * adicionar una raza al sistema.
	 * 
	 * @param especie Especie
	 * @param nombre  Nombre de la raza
	 * @return Raza registrada
	 */
	public Raza registrarRaza(Especie especie, String nombre) {
		Raza r = new Raza();
		r.setNombre(nombre);
		r.setEspecie(especie);
		return registrarRaza(r);
	}

	/**
	 * Adiciona una patología pasando la instancia de la clase. Este método debe
	 * usarse para cargar las entidades desde los datos persistentes.
	 * 
	 * @param patologia Patología
	 * @return Patología registrada
	 */
	public Patologia registrarPatologia(Patologia patologia) {
		patologias.add(patologia);
		return patologia;
	}

	/**
	 * Adiciona una patología pasando los datos de ésta. Este método debe usarse
	 * para adicionar una patología al sistema.
	 * 
	 * @param codigo Código
	 * @param nombre Nombre
	 * @return Patología registrada
	 */
	public Patologia registrarPatologia(String codigo, String nombre) {
		Patologia p = new Patologia();
		p.setCodigo(codigo);
		p.setNombre(nombre);
		return registrarPatologia(p);
	}

	/**
	 * Genera un reporte de consultas médicas que cumplen el filtro dado. Todos los
	 * criterios del filtro son opcionales, es decir, si se pasa null omite ese
	 * parámetro.
	 * 
	 * @param fechaInicial Fecha inicial del reporte
	 * @param fechaFinal   Fecha final del reporte (por defecto la fecha actual)
	 * @param animal       Filtrar por un animal específico
	 * @param profesional  Filtrar por un profesional específico
	 * @param especie      Filtrar por una especie específica
	 * @param raza         Filtrar por una raza específica
	 * @param especialidad Filtrar por una especialidad de profesional específica
	 * @param enfermedad   Filtrar por una enfermedad crónica específica
	 * @param patologia    Filtrar por una patología específica
	 * @return Lista de consultas que cumplen los criterios del fitro
	 */
	public List<Consulta> reporteConsultas(Date fechaInicial, Date fechaFinal, Animal animal, Profesional profesional,
			Especie especie, Raza raza, Especialidad especialidad, Enfermedad enfermedad, Patologia patologia) {
		List<Consulta> resultado = consultas.stream()
				.filter((c) -> (fechaInicial == null || c.getFecha().getTime() >= fechaInicial.getTime())
						&& (fechaFinal == null || c.getFecha().getTime() <= fechaFinal.getTime())
						&& (animal == null || c.getAnimal().getNumeroRegistro() == animal.getNumeroRegistro())
						&& (profesional == null
								|| c.getProfesional().getNumeroDocumento() == profesional.getNumeroDocumento())
						&& (especie == null || c.getAnimal().getEspecie().getNombre().equals(especie.getNombre()))
						&& (raza == null || c.getAnimal().getRaza().getNombre().equals(raza.getNombre()))
						&& (enfermedad == null || c.getEnfermedadCronica().getNombre().equals(enfermedad.getNombre()))
						&& (patologia == null || c.getPatologia().getCodigo().equals(patologia.getCodigo()))
						&& (especialidad == null || c.getProfesional().getEspecialidades().stream()
								.anyMatch((e) -> e.getNombre().equals(especialidad.getNombre()))))
				.collect(Collectors.toList());
		return resultado;
	}

	public DALInterface getDal() {
		return dal;
	}

	public void setDal(DALInterface dal) {
		this.dal = dal;
	}

	public void guardar() {
		if (dal == null)
			return;
		ContenedorSerializable contenedor = new ContenedorSerializable();
		contenedor.animales = getAnimales();
		contenedor.consultas = getConsultas();
		contenedor.enfermedades = getEnfermedades();
		contenedor.especialidades = getEspecialidades();
		contenedor.especies = getEspecies();
		contenedor.medicinas = getMedicina();
		contenedor.patologias = getPatologias();
		contenedor.profesionales = getProfesionales();
		contenedor.propietarios = getPropietarios();
		contenedor.razas = getRazas();
		try {
			dal.guardar(contenedor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cargar() {
		if (dal == null)
			return;
		ContenedorSerializable cont = null;
		try {
			cont = dal.cargar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (cont == null)
			return;
		animales = cont.animales;
		consultas = cont.consultas;
		enfermedades = cont.enfermedades;
		especialidades = cont.especialidades;
		especies = cont.especies;
		medicinas = cont.medicinas;
		patologias = cont.patologias;
		profesionales = cont.profesionales;
		propietarios = cont.propietarios;
		razas = cont.razas;
	}
}
