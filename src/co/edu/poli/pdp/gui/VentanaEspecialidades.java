package co.edu.poli.pdp.gui;

import co.edu.poli.pdp.entidades.Especialidad;

public class VentanaEspecialidades extends VentanaMaestroBase<Especialidad> {

	public VentanaEspecialidades() {
		super("Especialidades");
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
		new ModeloLista<Especialidad>(getSistema().getEspecialidades(), lista);
	}

	@Override
	protected void guardar() {
		if (!validarVacio(txNombre, "Debe escribir un nombre"))
			return;
		if (itemActual == null) {
			getSistema().registrarEspecialidad(txNombre.getText());
		} else {
			itemActual.setNombre(txNombre.getText());
		}
		super.guardar();
	}

	@Override
	protected void borrar() {
		getSistema().getEspecialidades().remove(itemActual);
		super.guardar();
	}

}
