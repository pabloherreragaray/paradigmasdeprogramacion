package co.edu.poli.pdp.gui;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JTextField;

import co.edu.poli.pdp.entidades.Medicina;

public class VentanaMedicinas extends VentanaMaestroBase<Medicina> {

	protected JTextField txCodigo;

	public VentanaMedicinas() {
		super("Medicinas");
	}

	@Override
	protected void crearControles() {
		fila++;
		columna = 0;
		panel.add(new JLabel("Código"), getGBC());
		txCodigo = new JTextField(16);
		columna = 1;
		panel.add(txCodigo, getGBC(GridBagConstraints.HORIZONTAL));
		super.crearControles();
	}

	@Override
	protected void seleccionaItem() {
		if (itemActual == null) {
			txCodigo.setText("");
			txNombre.setText("");
		} else {
			txCodigo.setText(itemActual.getCodigo());
			txNombre.setText(itemActual.getNombreDroga());
		}
	}

	@Override
	protected void cargaItems() {
		new ModeloLista<Medicina>(getSistema().getMedicina(), lista);
	}

	@Override
	protected void guardar() {
		if (!validarVacio(txCodigo, "Debe escribir un código") || !validarVacio(txNombre, "Debe escribir un nombre"))
			return;
		if (itemActual == null) {
			getSistema().registrarMedicina(txCodigo.getText(), txNombre.getText());
		} else {
			itemActual.setCodigo(txCodigo.getText());
			itemActual.setNombreDroga(txNombre.getText());
		}
		txCodigo.setText("");
		super.guardar();
	}

	@Override
	protected void borrar() {
		getSistema().getMedicina().remove(itemActual);
		txCodigo.setText("");
		super.guardar();
	}

}
