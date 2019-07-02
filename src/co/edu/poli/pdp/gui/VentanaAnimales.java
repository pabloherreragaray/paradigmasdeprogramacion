package co.edu.poli.pdp.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.poli.pdp.SistemaConsultasMedicasVeterinaria;
import co.edu.poli.pdp.entidades.Animal;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JFrame;

public class VentanaAnimales extends JInternalFrame {
	private JTable table;

	/**
	 * Create the frame.
	 */
	public VentanaAnimales() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Animales");
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 647, 474);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panel, BorderLayout.SOUTH);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaEditarAnimal v = new VentanaEditarAnimal(new Animal(), true);
				v.pack();
				MainFrame.instancia.adicionarVentana(v);
				v.setLocation(getLocation().x + getWidth(), getLocation().y);
				v.setVisible(true);
			}
		});
		panel.add(btnNuevo);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = getTable().getSelectedRow();
				if (fila < 0)
					return;
				int registro = (int) table.getModel().getValueAt(fila, 0);
				editar(registro);
			}
		});
		panel.add(btnEditar);

		JButton btnBorrar = new JButton("Borrar");
		VentanaAnimales ventana = this;
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(ventana, "¿Desea borrar este animal?");
				if (res != JOptionPane.YES_OPTION)
					return;
				int fila = getTable().getSelectedRow();
				if (fila < 0)
					return;
				int registro = (int) table.getModel().getValueAt(fila, 0);
				borrar(registro);
			}
		});
		panel.add(btnBorrar);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

	}

	public void cargarDatos() {
		JTable table = getTable();
		List<Animal> animales = getSistema().getAnimales();
		Object[][] array = new Object[animales.size()][];
		int fila = 0;
		for (Animal a : animales) {
			Object[] f = new Object[] { a.getNumeroRegistro(), a.getNombre(), a.getEspecie().getNombre(),
					a.getRaza() == null ? "" : a.getRaza().getNombre(), a.getSexo().toString() };
			array[fila] = f;
			fila++;
		}
		DefaultTableModel modelo = new DefaultTableModel(array,
				new Object[] { "Registro", "Nombre", "Especie", "Raza", "Sexo" });
		table.setModel(modelo);
	}

	protected SistemaConsultasMedicasVeterinaria getSistema() {
		return MainFrame.instancia.getSistema();
	}

	public void mostrar() {
		cargarDatos();
		if (!isVisible())
			MainFrame.instancia.ubicarVentana(this);
		else
			toFront();
		setVisible(true);
	}

	protected JTable getTable() {
		return table;
	}

	private void editar(int registro) {
		Animal animal = getSistema().getAnimales().stream().filter(a -> a.getNumeroRegistro() == registro).findFirst()
				.get();
		VentanaEditarAnimal v = new VentanaEditarAnimal(animal, false);
		v.pack();
		MainFrame.instancia.adicionarVentana(v);
		v.setLocation(getLocation().x + getWidth(), getLocation().y);
		v.setVisible(true);
	}

	private void borrar(int registro) {
		Animal animal = getSistema().getAnimales().stream().filter(a -> a.getNumeroRegistro() == registro).findFirst()
				.get();
		getSistema().getAnimales().remove(animal);
		getSistema().guardar();
		cargarDatos();
	}
}
