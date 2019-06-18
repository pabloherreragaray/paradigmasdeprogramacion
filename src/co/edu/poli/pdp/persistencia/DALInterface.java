package co.edu.poli.pdp.persistencia;

public interface DALInterface {
	
	void guardar(ContenedorSerializable contenedor) throws Exception;
	
	ContenedorSerializable cargar() throws Exception;

}
