package co.edu.poli.pdp.gui;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JTextField;

import co.edu.poli.pdp.entidades.Patologia;

public class VentanaPatologias extends VentanaMaestroBase<Patologia> {

	protected JTextField txCodigo;

	public VentanaPatologias() {
		super("Patolog�as");
	}

	@Override
	protected void crearControles() {
		fila++;
		columna = 0;
		panel.add(new JLabel("C�digo"), getGBC());
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
			txNombre.setText(itemActual.getNombre());
		}
	}

	@Override
	protected void cargaItems() {
		new ModeloLista<Patologia>(getSistema().getPatologias(), lista);
	}

	@Override
	protected void guardar() {
		if (!validarVacio(txCodigo, "Debe escribir un c�digo") || !validarVacio(txNombre, "Debe escribir un nombre"))
			return;
		if (itemActual == null) {
			getSistema().registrarPatologia(txCodigo.getText(), txNombre.getText());
		} else {
			itemActual.setCodigo(txCodigo.getText());
			itemActual.setNombre(txNombre.getText());
		}
		txCodigo.setText("");
		super.guardar();
	}

	@Override
	protected void borrar() {
		getSistema().getPatologias().remove(itemActual);
		txCodigo.setText("");
		super.guardar();
	}

}
