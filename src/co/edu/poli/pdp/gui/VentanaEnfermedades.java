package co.edu.poli.pdp.gui;

import co.edu.poli.pdp.entidades.Enfermedad;

public class VentanaEnfermedades extends VentanaMaestroBase<Enfermedad> {

	public VentanaEnfermedades() {
		super("Enfermedades");
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
		new ModeloLista<Enfermedad>(getSistema().getEnfermedades(), lista);
	}

	@Override
	protected void guardar() {
		if (!validarVacio(txNombre, "Debe escribir un nombre"))
			return;
		if (itemActual == null) {
			getSistema().registrarEnfermedad(txNombre.getText());
		} else {
			itemActual.setNombre(txNombre.getText());
		}
		super.guardar();
	}

	@Override
	protected void borrar() {
		getSistema().getEnfermedades().remove(itemActual);
		super.guardar();
	}

}
