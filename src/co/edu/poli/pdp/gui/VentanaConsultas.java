package co.edu.poli.pdp.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.poli.pdp.SistemaConsultasMedicasVeterinaria;
import co.edu.poli.pdp.entidades.Animal;
import co.edu.poli.pdp.entidades.Consulta;
import co.edu.poli.pdp.entidades.Especie;
import co.edu.poli.pdp.entidades.Profesional;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class VentanaConsultas extends JInternalFrame {
	private JTable table;
	private JTextField txCodigo;
	private JComboBox cbAnimal;
	private JComboBox cbProfesional;
	private JComboBox cbEspecie;

	/**
	 * Create the frame.
	 */
	public VentanaConsultas() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(true);
		setClosable(true);
		setTitle("Consultas");
		setBounds(100, 100, 657, 503);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panel, BorderLayout.SOUTH);

		JButton btnNueva = new JButton("Nueva");
		btnNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEditarConsulta v = new VentanaEditarConsulta(new Consulta(), true);
				v.pack();
				MainFrame.instancia.adicionarVentana(v);
				v.setLocation(getLocation().x + getWidth(), getLocation().y);
				v.mostrar();
			}
		});
		panel.add(btnNueva);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = getTable().getSelectedRow();
				if (fila < 0)
					return;
				editar(getTable().getModel().getValueAt(fila, 0).toString());
			}
		});
		panel.add(btnEditar);

		JButton btnBorrar = new JButton("Borrar");
		VentanaConsultas ventana = this;
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(ventana, "¿Desea borrar esta consulta?");
				if (res != JOptionPane.YES_OPTION)
					return;
				int fila = getTable().getSelectedRow();
				if (fila < 0)
					return;
				borrar(getTable().getModel().getValueAt(fila, 0).toString());
			}
		});
		panel.add(btnBorrar);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel_1, BorderLayout.NORTH);

		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		panel_1.add(lblFiltrarPor);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		panel_1.add(lblCdigo);

		txCodigo = new JTextField();
		txCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatos();
			}
		});
		panel_1.add(txCodigo);
		txCodigo.setColumns(10);

		JLabel lblEspecie = new JLabel("Especie:");
		panel_1.add(lblEspecie);

		cbEspecie = new JComboBox();
		cbEspecie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAnimales();
			}
		});
		panel_1.add(cbEspecie);

		JLabel lblAnimal = new JLabel("Animal:");
		panel_1.add(lblAnimal);

		cbAnimal = new JComboBox();
		cbAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatos();
			}
		});
		panel_1.add(cbAnimal);

		JLabel lblProfesional = new JLabel("Profesional:");
		panel_1.add(lblProfesional);

		cbProfesional = new JComboBox();
		cbProfesional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatos();
			}
		});
		panel_1.add(cbProfesional);

		cargarFiltros();

	}

	protected JTable getTable() {
		return table;
	}

	protected SistemaConsultasMedicasVeterinaria getSistema() {
		return MainFrame.instancia.getSistema();
	}

	protected void cargarAnimales() {
		Especie e = (Especie) getCbEspecie().getSelectedItem();
		List<Animal> animales = getSistema().getAnimales().stream()
				.filter(a -> (e.getNombre().equals("Todas") || a.getEspecie() == e)).collect(Collectors.toList());
		Animal a = new Animal();
		a.setNombre("Todos");
		animales.add(0, a);
		new ModeloCombo<Animal>(animales, getCbAnimal());
	}

	protected void cargarFiltros() {
		List<Especie> especies = (List<Especie>) ((ArrayList<Especie>) getSistema().getEspecies()).clone();
		Especie e = new Especie();
		e.setNombre("Todas");
		especies.add(0, e);
		new ModeloCombo<Especie>(especies, getCbEspecie());
		cargarAnimales();
		List<Profesional> profesionales = (List<Profesional>) ((ArrayList<Profesional>) getSistema().getProfesionales())
				.clone();
		Profesional p = new Profesional();
		p.setNombre("Todos");
		p.setApellido("");
		profesionales.add(0, p);
		new ModeloCombo<Profesional>(profesionales, getCbProfesional());
	}

	public void cargarDatos() {
		Especie e = (Especie) getCbEspecie().getSelectedItem();
		Animal a = (Animal) getCbAnimal().getSelectedItem();
		String codigo = getTxCodigo().getText();
		Profesional p = (Profesional) getCbProfesional().getSelectedItem();
		List<Consulta> consultas = getSistema()
				.reporteConsultas(null, null, a.getNumeroRegistro() == 0 ? null : a,
						p.getNumeroDocumento() == 0 ? null : p, e.getNombre().equals("Todas") ? null : e, null, null,
						null, null)
				.stream().filter(c -> codigo.length() == 0 || c.getCodigo().contains(codigo))
				.collect(Collectors.toList());
		Object[][] array = new Object[consultas.size()][];
		int fila = 0;
		for (Consulta c : consultas) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			array[fila] = new Object[] { c.getCodigo(), c.getAnimal().toString(), sdf.format(c.getFecha()),
					c.getProfesional().toString() };
			fila++;
		}
		DefaultTableModel modelo = new DefaultTableModel(array,
				new Object[] { "Código", "Animal", "Fecha", "Profesional" });
		getTable().setModel(modelo);
	}

	protected void borrar(String codigo) {
		Consulta c = getSistema().getConsultas().stream().filter(con -> con.getCodigo().equals(codigo)).findFirst()
				.get();
		if (c == null)
			return;
		getSistema().getConsultas().remove(c);
		getSistema().guardar();
		cargarDatos();
	}

	protected void editar(String codigo) {
		Consulta c = getSistema().getConsultas().stream().filter(con -> con.getCodigo().equals(codigo)).findFirst()
				.get();
		if (c == null)
			return;
		VentanaEditarConsulta v = new VentanaEditarConsulta(c, false);
		v.pack();
		MainFrame.instancia.adicionarVentana(v);
		v.setLocation(getLocation().x + getWidth(), getLocation().y);
		v.mostrar();
	}

	public void mostrar() {
		cargarDatos();
		if (!isVisible())
			MainFrame.instancia.ubicarVentana(this);
		else
			toFront();
		setVisible(true);
	}

	protected JTextField getTxCodigo() {
		return txCodigo;
	}

	protected JComboBox getCbAnimal() {
		return cbAnimal;
	}

	protected JComboBox getCbProfesional() {
		return cbProfesional;
	}

	protected JComboBox getCbEspecie() {
		return cbEspecie;
	}
}
