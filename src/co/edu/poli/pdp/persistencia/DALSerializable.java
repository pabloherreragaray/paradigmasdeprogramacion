package co.edu.poli.pdp.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DALSerializable implements DALInterface {
	public static final String NombreArchivoPorDefecto = "entidades.obj";

	private String nombreArchivo;

	public DALSerializable(String nombreArchivo) {
		setNombreArchivo(nombreArchivo);
	}

	public DALSerializable() {
		this(NombreArchivoPorDefecto);
	}

	@Override
	public void guardar(ContenedorSerializable contenedor) throws Exception {
		FileOutputStream fos = new FileOutputStream(getNombreArchivo());
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(contenedor);
		oos.close();
	}

	@Override
	public ContenedorSerializable cargar() throws Exception {
		if (!(new File(getNombreArchivo()).exists()))
			return null;
		FileInputStream fis = new FileInputStream(getNombreArchivo());
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		ois.close();
		return (ContenedorSerializable) obj;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

}
