package co.edu.poli.pdp.gui;

import java.util.stream.Collectors;

import co.edu.poli.pdp.entidades.Especie;
import co.edu.poli.pdp.entidades.Raza;

public class VentanaRazas extends VentanaMaestroBase<Raza> {

	protected Especie especieActual;

	public VentanaRazas() {
		super("Razas");
	}

	@Override
	protected void seleccionaItem() {
		if (itemActual == null) {
			txNombre.setText("");
		} else {
			txNombre.setText(itemActual.getNombre());
		}
	}

	@Override
	protected void cargaItems() {
		new ModeloLista<Raza>(getSistema().getRazas().stream().filter((r) -> r.getEspecie() == especieActual)
				.collect(Collectors.toList()), lista);
	}

	@Override
	protected void guardar() {
		if (!validarVacio(txNombre, "Debe escribir un nombre"))
			return;
		if (itemActual == null) {
			getSistema().registrarRaza(especieActual, txNombre.getText());
		} else {
			itemActual.setNombre(txNombre.getText());
		}
		super.guardar();
	}

	@Override
	protected void borrar() {
		getSistema().getRazas().remove(itemActual);
		super.guardar();
	}

}
