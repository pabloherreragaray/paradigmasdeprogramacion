package co.edu.poli.pdp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSeparator;

import co.edu.poli.pdp.entidades.Especie;

public class VentanaEspecies extends VentanaMaestroBase<Especie> {

	protected JButton btRazas;

	public VentanaEspecies() {
		super("Especies");
	}

	@Override
	protected void crearPanelDerecho() {
		super.crearPanelDerecho();
		fila++;
		columna = 0;
		panel.add(new JSeparator(), getGBC());
		fila++;
		columna = 1;
		btRazas = new JButton("Razas");
		panel.add(btRazas, getGBC());
		btRazas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (itemActual == null)
					return;
				MainFrame.instancia.razas.especieActual = itemActual;
				MainFrame.instancia.razas.mostrar();
			}
		});
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
		new ModeloLista<Especie>(getSistema().getEspecies(), lista);
	}

	@Override
	protected void guardar() {
		if (!validarVacio(txNombre, "Debe escribir un nombre"))
			return;
		if (itemActual != null) {
			itemActual.setNombre(txNombre.getText());
		} else {
			getSistema().registrarEspecie(txNombre.getText());
		}
		super.guardar();
	}

	@Override
	protected void borrar() {
		getSistema().getEspecies().remove(itemActual);
		super.guardar();
	}

}
