package co.edu.poli.pdp.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import co.edu.poli.pdp.SistemaConsultasMedicasVeterinaria;

public abstract class VentanaMaestroBase<T> extends JInternalFrame {
	protected JList<T> lista;
	protected JPanel panel;
	protected JButton btNuevo;
	protected JButton btGuardar;
	protected JButton btBorrar;
	protected int fila;
	protected int columna;
	protected JTextField txNombre;
	protected T itemActual;

	public VentanaMaestroBase(String titulo) {
		super(titulo, true, true, false, false);
		crearUI();
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
	}

	protected void crearUI() {
		setLayout(new BorderLayout());
		lista = new JList<T>();
		lista.setPreferredSize(new Dimension(160, 140));
		add(lista, BorderLayout.CENTER);
		panel = new JPanel();
		add(panel, BorderLayout.EAST);
		crearPanelDerecho();
		lista.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				itemActual = lista.getSelectedValue();
				seleccionaItem();
			}
		});
	}

	protected GridBagConstraints getGBC(int ancho, int fill, int alin) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = columna;
		c.gridy = fila;
		c.gridwidth = ancho;
		c.fill = fill;
		c.anchor = alin;
		c.insets = new Insets(3, 3, 3, 3);
		return c;
	}

	protected GridBagConstraints getGBC(int fill) {
		return getGBC(1, fill, GridBagConstraints.WEST);
	}

	protected GridBagConstraints getGBC() {
		return getGBC(GridBagConstraints.NONE);
	}

	protected void crearPanelDerecho() {
		panel.setLayout(new GridBagLayout());
		btNuevo = new JButton("Nuevo");
		fila = 0;
		columna = 1;
		panel.add(btNuevo, getGBC());
		crearControles();
		fila++;
		columna = 1;
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		panel.add(p,getGBC());
		btGuardar = new JButton("Guardar");
		p.add(btGuardar);
		btBorrar = new JButton("Borrar");
		p.add(btBorrar);
		btNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		btGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (itemActual == null)
					return;
				if (preguntarSiBorrar())
					borrar();
			}
		});
	}

	protected void crearControles() {
		txNombre = new JTextField(16);
		fila++;
		columna = 0;
		panel.add(new JLabel("Nombre"), getGBC());
		columna = 1;
		panel.add(txNombre, getGBC(GridBagConstraints.HORIZONTAL));
	}

	public void mostrar() {
		cargaItems();
		if (!isVisible())
			MainFrame.instancia.ubicarVentana(this);
		else
			toFront();
		setVisible(true);
	}

	protected abstract void seleccionaItem();

	protected abstract void cargaItems();

	protected void guardar() {
		getSistema().guardar();
		cargaItems();
		txNombre.setText("");
		lista.clearSelection();
	}

	protected abstract void borrar();

	protected void nuevo() {
		lista.clearSelection();
	}

	protected SistemaConsultasMedicasVeterinaria getSistema() {
		return MainFrame.instancia.getSistema();
	}

	protected boolean preguntarSiBorrar() {
		int res = JOptionPane.showConfirmDialog(this, "¿Desea borrar este registro?");
		return res == JOptionPane.YES_OPTION;
	}

	protected boolean validarVacio(JTextField tx, String mensaje) {
		boolean res = tx.getText().length() > 0;
		if (!res)
			JOptionPane.showMessageDialog(this, mensaje);
		return res;
	}

}
