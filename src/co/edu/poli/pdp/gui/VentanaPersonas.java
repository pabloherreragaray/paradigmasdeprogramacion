package co.edu.poli.pdp.gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.poli.pdp.SistemaConsultasMedicasVeterinaria;
import co.edu.poli.pdp.entidades.Persona;
import co.edu.poli.pdp.entidades.Profesional;
import co.edu.poli.pdp.entidades.Propietario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class VentanaPersonas extends JInternalFrame {

	public boolean esProfesional = false;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public VentanaPersonas(boolean esProfesional) {
		this.esProfesional = esProfesional;
		setTitle(esProfesional ? "Profesionales" : "Propietarios");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 711, 479);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel panelBoton = new JPanel();
		GridBagConstraints gbc_panelBoton = new GridBagConstraints();
		gbc_panelBoton.fill = GridBagConstraints.BOTH;
		gbc_panelBoton.gridx = 0;
		gbc_panelBoton.gridy = 0;
		panel.add(panelBoton, gbc_panelBoton);
		panelBoton.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Persona p = esProfesional ? new Profesional() : new Propietario();
				VentanaEditarPersona v = new VentanaEditarPersona(p, true);
				v.pack();
				MainFrame.instancia.adicionarVentana(v);
				v.setLocation(getLocation().x + getWidth(), getLocation().y);
				v.setVisible(true);
			}
		});
		panelBoton.add(btnNuevo);

		VentanaPersonas ventana = this;

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				if (fila < 0)
					return;
				long documento = (long) table.getModel().getValueAt(fila, 0);
				editar(documento);
			}
		});
		panelBoton.add(btnEditar);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				if (fila < 0)
					return;
				int res = JOptionPane.showConfirmDialog(ventana, "¿Desea borrar el registro seleccionado?");
				if (res != JOptionPane.YES_OPTION)
					return;
				long documento = (long) table.getModel().getValueAt(fila, 0);
				borrar(documento);
			}
		});
		panelBoton.add(btnBorrar);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
				table = new JTable();
				scrollPane.setViewportView(table);
				table.setPreferredSize(new Dimension(500, 300));

	}

	public void cargarDatos() {
		List<Persona> personas = new ArrayList<Persona>();
		if (esProfesional) {
			for (Profesional p : getSistema().getProfesionales()) {
				personas.add(p);
			}
		} else {
			for (Propietario p : getSistema().getPropietarios()) {
				personas.add(p);
			}
		}
		Object[][] array = new Object[personas.size()][];
		int fila = 0;
		for (Persona p : personas) {
			Object[] interno = new Object[] { p.getNumeroDocumento(), p.getNombre() + " " + p.getApellido(),
					p.getDireccion(), p.getTelefono(), p.getCelular() };
			array[fila] = interno;
		}
		JTable table = getTable();
		DefaultTableModel modelo = new DefaultTableModel(array,
				new Object[] { "Documento", "Nombre completo", "Dirección", "Teléfono", "Celular" });
		table.setModel(modelo);
	}

	public void mostrar() {
		cargarDatos();
		if (!isVisible())
			MainFrame.instancia.ubicarVentana(this);
		else
			toFront();
		setVisible(true);
	}

	protected SistemaConsultasMedicasVeterinaria getSistema() {
		return MainFrame.instancia.getSistema();
	}

	protected JTable getTable() {
		return table;
	}

	protected void borrar(long documento) {
		if (esProfesional) {
			Profesional p = getSistema().getProfesionales().stream()
					.filter(pro -> pro.getNumeroDocumento() == documento).findFirst().get();
			if (p != null)
				getSistema().getProfesionales().remove(p);
		} else {
			Propietario p = getSistema().getPropietarios().stream().filter(pro -> pro.getNumeroDocumento() == documento)
					.findFirst().get();
			if (p != null)
				getSistema().getPropietarios().remove(p);
		}
		getSistema().guardar();
		cargarDatos();
	}

	protected void editar(long documento) {
		Persona p = null;
		if (esProfesional) {
			p = getSistema().getProfesionales().stream().filter(pro -> pro.getNumeroDocumento() == documento)
					.findFirst().get();
		} else {
			p = getSistema().getPropietarios().stream().filter(pro -> pro.getNumeroDocumento() == documento).findFirst()
					.get();
		}
		VentanaEditarPersona v = new VentanaEditarPersona(p, false);
		v.pack();
		MainFrame.instancia.adicionarVentana(v);
		v.setLocation(getLocation().x + getWidth(), getLocation().y);
		v.setVisible(true);
	}
}
