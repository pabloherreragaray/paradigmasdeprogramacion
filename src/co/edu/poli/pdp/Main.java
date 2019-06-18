package co.edu.poli.pdp;

import co.edu.poli.pdp.entidades.Especie;
import co.edu.poli.pdp.persistencia.DALInterface;
import co.edu.poli.pdp.persistencia.DALSerializable;

/**
 * Clse principal de ejecuci�n del programa
 *
 */
public class Main {

	/**
	 * M�todo de ejecuci�n
	 * 
	 * @param args Argumentos
	 */
	public static void main(String[] args) {
	}
	
	private static void ejemploDeGuardado() {
		//Inicio el sistema
		SistemaConsultasMedicasVeterinaria scv = SistemaConsultasMedicasVeterinaria.getInstancia();
		//Creo la interfaz de guardado
		DALInterface dal = new DALSerializable();
		//Le asigno la interfaz de guardado al sistema
		scv.setDal(dal);
		//Cargo los datos desde el archivo
		scv.cargar();
		//Inicio los datos de ejemplo (solo si el sistema est� vac�o)
		iniciarEntidadesDeEjemplo(scv);
		//Ac� realizo todos los cambios
		//Guardo los cambios
		scv.guardar();
	}

	private static void iniciarEntidadesDeEjemplo(SistemaConsultasMedicasVeterinaria scv) {
		if (scv.getEspecies().size() > 0)
			return;
		Especie gato = scv.registrarEspecie("Gato");
		Especie perro = scv.registrarEspecie("Perro");
		scv.registrarEspecie("Caballo");
		scv.registrarRaza(gato, "Angora");
		scv.registrarRaza(gato, "Siam�s");
		scv.registrarRaza(gato, "Persa");
		scv.registrarRaza(perro, "Pastor alem�n");
		scv.registrarRaza(perro, "D�lmata");
		scv.registrarRaza(perro, "Doberman");
		scv.registrarRaza(perro, "Pitbull");
		scv.registrarRaza(perro, "Pincher");
		scv.registrarPatologia("A", "Ansiedad");
		scv.registrarEnfermedad("Deficiencia cardiaca");
	}

}
