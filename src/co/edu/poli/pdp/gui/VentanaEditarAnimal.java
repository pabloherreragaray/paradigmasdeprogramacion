package co.edu.poli.pdp.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import co.edu.poli.pdp.SistemaConsultasMedicasVeterinaria;
import co.edu.poli.pdp.entidades.Animal;
import co.edu.poli.pdp.entidades.Especie;
import co.edu.poli.pdp.entidades.Propietario;
import co.edu.poli.pdp.entidades.Raza;
import co.edu.poli.pdp.entidades.Sexo;

import java.awt.Insets;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEditarAnimal extends JInternalFrame {
	private JTextField txRegistro;
	private JTextField txNombre;
	private JComboBox cbEspecie;
	private JComboBox cbSexo;
	private JComboBox cbMadre;
	private JComboBox cbPadre;
	private JComboBox cbPropietario;
	private Animal animal;
	private boolean esNuevo;
	private JTextField txDia;
	private JTextField txMes;
	private JTextField txAnio;
	private JComboBox cbRaza;

	/**
	 * Create the frame.
	 */
	public VentanaEditarAnimal(Animal animal, boolean esNuevo) {
		setResizable(true);
		setClosable(true);
		this.animal = animal;
		this.esNuevo = esNuevo;
		if (esNuevo)
			setTitle("Nuevo animal");
		else
			setTitle("Editar animal");

		setBounds(100, 100, 484, 493);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblNmeroDeRegistro = new JLabel("N\u00FAmero de registro");
		GridBagConstraints gbc_lblNmeroDeRegistro = new GridBagConstraints();
		gbc_lblNmeroDeRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmeroDeRegistro.anchor = GridBagConstraints.WEST;
		gbc_lblNmeroDeRegistro.gridx = 0;
		gbc_lblNmeroDeRegistro.gridy = 0;
		getContentPane().add(lblNmeroDeRegistro, gbc_lblNmeroDeRegistro);

		txRegistro = new JTextField();
		GridBagConstraints gbc_txRegistro = new GridBagConstraints();
		gbc_txRegistro.insets = new Insets(0, 0, 5, 0);
		gbc_txRegistro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txRegistro.gridx = 1;
		gbc_txRegistro.gridy = 0;
		getContentPane().add(txRegistro, gbc_txRegistro);
		txRegistro.setColumns(10);

		JLabel lblEspecie = new JLabel("Especie");
		GridBagConstraints gbc_lblEspecie = new GridBagConstraints();
		gbc_lblEspecie.anchor = GridBagConstraints.WEST;
		gbc_lblEspecie.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspecie.gridx = 0;
		gbc_lblEspecie.gridy = 1;
		getContentPane().add(lblEspecie, gbc_lblEspecie);

		cbEspecie = new JComboBox();
		cbEspecie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarRazas();
			}
		});
		GridBagConstraints gbc_cbEspecie = new GridBagConstraints();
		gbc_cbEspecie.insets = new Insets(0, 0, 5, 0);
		gbc_cbEspecie.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbEspecie.gridx = 1;
		gbc_cbEspecie.gridy = 1;
		getContentPane().add(cbEspecie, gbc_cbEspecie);

		JLabel lblRaza = new JLabel("Raza");
		GridBagConstraints gbc_lblRaza = new GridBagConstraints();
		gbc_lblRaza.anchor = GridBagConstraints.WEST;
		gbc_lblRaza.insets = new Insets(0, 0, 5, 5);
		gbc_lblRaza.gridx = 0;
		gbc_lblRaza.gridy = 2;
		getContentPane().add(lblRaza, gbc_lblRaza);

		cbRaza = new JComboBox();
		GridBagConstraints gbc_cbRaza = new GridBagConstraints();
		gbc_cbRaza.insets = new Insets(0, 0, 5, 0);
		gbc_cbRaza.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbRaza.gridx = 1;
		gbc_cbRaza.gridy = 2;
		getContentPane().add(cbRaza, gbc_cbRaza);

		JLabel lblFechaDeNacimiento = new JLabel("Nombre");
		GridBagConstraints gbc_lblFechaDeNacimiento = new GridBagConstraints();
		gbc_lblFechaDeNacimiento.anchor = GridBagConstraints.WEST;
		gbc_lblFechaDeNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeNacimiento.gridx = 0;
		gbc_lblFechaDeNacimiento.gridy = 3;
		getContentPane().add(lblFechaDeNacimiento, gbc_lblFechaDeNacimiento);

		txNombre = new JTextField();
		GridBagConstraints gbc_txNombre = new GridBagConstraints();
		gbc_txNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txNombre.gridx = 1;
		gbc_txNombre.gridy = 3;
		getContentPane().add(txNombre, gbc_txNombre);
		txNombre.setColumns(10);

		JLabel lblNombre = new JLabel("Sexo");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 4;
		getContentPane().add(lblNombre, gbc_lblNombre);

		cbSexo = new JComboBox();
		GridBagConstraints gbc_cbSexo = new GridBagConstraints();
		gbc_cbSexo.insets = new Insets(0, 0, 5, 0);
		gbc_cbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSexo.gridx = 1;
		gbc_cbSexo.gridy = 4;
		getContentPane().add(cbSexo, gbc_cbSexo);

		JLabel lblFechaDeNacimiento_1 = new JLabel("Fecha de nacimiento (d/m/a)");
		GridBagConstraints gbc_lblFechaDeNacimiento_1 = new GridBagConstraints();
		gbc_lblFechaDeNacimiento_1.anchor = GridBagConstraints.WEST;
		gbc_lblFechaDeNacimiento_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeNacimiento_1.gridx = 0;
		gbc_lblFechaDeNacimiento_1.gridy = 5;
		getContentPane().add(lblFechaDeNacimiento_1, gbc_lblFechaDeNacimiento_1);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 5;
		getContentPane().add(panel_1, gbc_panel_1);

		txDia = new JTextField();
		panel_1.add(txDia);
		txDia.setColumns(2);

		JLabel label = new JLabel("/");
		panel_1.add(label);

		txMes = new JTextField();
		panel_1.add(txMes);
		txMes.setColumns(2);

		JLabel label_1 = new JLabel("/");
		panel_1.add(label_1);

		txAnio = new JTextField();
		panel_1.add(txAnio);
		txAnio.setColumns(4);

		JLabel lblMadre = new JLabel("Madre");
		GridBagConstraints gbc_lblMadre = new GridBagConstraints();
		gbc_lblMadre.anchor = GridBagConstraints.WEST;
		gbc_lblMadre.insets = new Insets(0, 0, 5, 5);
		gbc_lblMadre.gridx = 0;
		gbc_lblMadre.gridy = 6;
		getContentPane().add(lblMadre, gbc_lblMadre);

		cbMadre = new JComboBox();
		GridBagConstraints gbc_cbMadre = new GridBagConstraints();
		gbc_cbMadre.insets = new Insets(0, 0, 5, 0);
		gbc_cbMadre.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbMadre.gridx = 1;
		gbc_cbMadre.gridy = 6;
		getContentPane().add(cbMadre, gbc_cbMadre);

		JLabel lblPadre = new JLabel("Padre");
		GridBagConstraints gbc_lblPadre = new GridBagConstraints();
		gbc_lblPadre.anchor = GridBagConstraints.WEST;
		gbc_lblPadre.insets = new Insets(0, 0, 5, 5);
		gbc_lblPadre.gridx = 0;
		gbc_lblPadre.gridy = 7;
		getContentPane().add(lblPadre, gbc_lblPadre);

		cbPadre = new JComboBox();
		GridBagConstraints gbc_cbPadre = new GridBagConstraints();
		gbc_cbPadre.insets = new Insets(0, 0, 5, 0);
		gbc_cbPadre.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbPadre.gridx = 1;
		gbc_cbPadre.gridy = 7;
		getContentPane().add(cbPadre, gbc_cbPadre);

		JLabel lblPropietario = new JLabel("Propietario");
		GridBagConstraints gbc_lblPropietario = new GridBagConstraints();
		gbc_lblPropietario.anchor = GridBagConstraints.WEST;
		gbc_lblPropietario.insets = new Insets(0, 0, 5, 5);
		gbc_lblPropietario.gridx = 0;
		gbc_lblPropietario.gridy = 8;
		getContentPane().add(lblPropietario, gbc_lblPropietario);

		cbPropietario = new JComboBox();
		GridBagConstraints gbc_cbPropietario = new GridBagConstraints();
		gbc_cbPropietario.insets = new Insets(0, 0, 5, 0);
		gbc_cbPropietario.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbPropietario.gridx = 1;
		gbc_cbPropietario.gridy = 8;
		getContentPane().add(cbPropietario, gbc_cbPropietario);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 9;
		getContentPane().add(panel, gbc_panel);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);

		llenarCampos();
	}

	protected JComboBox getCbEspecie() {
		return cbEspecie;
	}

	protected JComboBox getCbSexo() {
		return cbSexo;
	}

	protected JComboBox getCbMadre() {
		return cbMadre;
	}

	protected JComboBox getCbPadre() {
		return cbPadre;
	}

	protected JComboBox getCbPropietario() {
		return cbPropietario;
	}

	protected SistemaConsultasMedicasVeterinaria getSistema() {
		return MainFrame.instancia.getSistema();
	}

	private void cargarRazas() {
		Especie especie = (Especie) getCbEspecie().getSelectedItem();
		List<Raza> razas = getSistema().getRazas().stream().filter(r -> r.getEspecie() == especie)
				.collect(Collectors.toList());
		new ModeloCombo<Raza>(razas, getCbRaza());
	}

	private void llenarCampos() {
		List<Especie> especies = getSistema().getEspecies();
		new ModeloCombo<Especie>(especies, getCbEspecie());
		List<Animal> padres = getSistema().getAnimales();
		new ModeloCombo<Animal>(padres, getCbPadre());
		new ModeloCombo<Animal>(padres, getCbMadre());
		DefaultComboBoxModel<String> sexos = new DefaultComboBoxModel<String>();
		sexos.addElement("Macho");
		sexos.addElement("Hembra");
		getCbSexo().setModel(sexos);
		List<Propietario> propietarios = getSistema().getPropietarios();
		new ModeloCombo<Propietario>(propietarios, getCbPropietario());
		getTxRegistro().setText(String.valueOf(animal.getNumeroRegistro()));
		getTxNombre().setText(animal.getNombre());
		if (animal.getFechaNacimiento() == null) {
			getTxDia().setText("");
			getTxMes().setText("");
			getTxAnio().setText("");
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(animal.getFechaNacimiento());
			getTxDia().setText(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
			getTxMes().setText(String.valueOf(cal.get(Calendar.MONTH) + 1));
			getTxAnio().setText(String.valueOf(cal.get(Calendar.YEAR)));
		}
		getCbEspecie().setSelectedItem(animal.getEspecie());
		getCbMadre().setSelectedItem(animal.getMadre());
		getCbPadre().setSelectedItem(animal.getPadre());
		getCbPropietario().setSelectedItem(animal.getPropietario());
		cargarRazas();
		getCbRaza().setSelectedItem(animal.getRaza());
		if (animal.getSexo() != null) {
			getCbSexo().setSelectedItem(animal.getSexo().toString());
		}
	}

	private void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}

	private boolean validarSiVacio(JTextField tx, String mensaje) {
		boolean res = tx.getText().length() > 0;
		if (!res)
			mostrarMensaje(mensaje);
		return res;
	}

	private boolean validarSiSeleccionado(JComboBox cb, String mensaje) {
		boolean res = cb.getSelectedItem() != null;
		if (!res)
			mostrarMensaje(mensaje);
		return res;
	}

	protected void guardar() {
		if (!validarSiVacio(getTxRegistro(), "Debe escribir el número de registro")
				|| !validarSiVacio(getTxNombre(), "Debe escribir el nombre del animal")
				|| !validarSiVacio(getTxDia(), "Debe escribir el día de nacimiento")
				|| !validarSiVacio(getTxMes(), "Debe escribir el mes de nacimiento")
				|| !validarSiVacio(getTxAnio(), "Debe escribir el año de nacimiento")
				|| !validarSiSeleccionado(getCbEspecie(), "Debe seleccionar una especie")
				|| !validarSiSeleccionado(getCbPropietario(), "Debe seleccionar un propietario"))
			return;
		int registro = 0, dia = 0, mes = 0, anio = 0;
		try {
			registro = Integer.parseInt(getTxRegistro().getText());
		} catch (Exception er) {
			mostrarMensaje("El número de registro debe ser un número");
			return;
		}
		try {
			dia = Integer.parseInt(getTxDia().getText());
			if (dia < 1 || dia > 31)
				throw new Exception();
		} catch (Exception er) {
			mostrarMensaje("El día de nacimiento debe ser un número de 1 a 31");
			return;
		}
		try {
			mes = Integer.parseInt(getTxMes().getText());
			if (mes < 1 || mes > 12)
				throw new Exception();
		} catch (Exception er) {
			mostrarMensaje("El mes de nacimiento debe ser un número de 1 a 12");
			return;
		}
		try {
			anio = Integer.parseInt(getTxAnio().getText());
			if (anio < 1900 || anio > Calendar.getInstance().get(Calendar.YEAR))
				throw new Exception();
		} catch (Exception er) {
			mostrarMensaje("El año de nacimiento debe ser un número de 1900 a "
					+ String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
			return;
		}
		animal.setNumeroRegistro(registro);
		animal.setNombre(getTxNombre().getText());
		animal.setFechaNacimiento(new Date(anio, mes - 1, dia));
		animal.setEspecie((Especie) getCbEspecie().getSelectedItem());
		/*
		 * Object raza = getCbRaza().getSelectedItem(); if (raza != null)
		 * animal.setRaza((Raza) raza); else animal.setRaza(null); if
		 * (getCbSexo().getSelectedIndex() == 0) animal.setSexo(Sexo.Macho); else
		 * animal.setSexo(Sexo.Hembra); Object padre = getCbPadre().getSelectedItem();
		 * if (padre != null) animal.setPadre((Animal) padre); else
		 * animal.setPadre(null); Object madre = getCbMadre().getSelectedItem(); if
		 * (madre != null) animal.setMadre((Animal) madre); else animal.setMadre(null);
		 */
		animal.setRaza((Raza) getCbRaza().getSelectedItem());
		animal.setSexo(getCbSexo().getSelectedIndex() == 0 ? Sexo.Macho : Sexo.Hembra);
		animal.setPadre((Animal) getCbPadre().getSelectedItem());
		animal.setMadre((Animal) getCbMadre().getSelectedItem());
		Propietario propietario = (Propietario) getCbPropietario().getSelectedItem();
		if (esNuevo) {
			getSistema().registrarAnimal(animal);
			animal.setPrimerPropietario(propietario, new Date());
		} else {
			if (propietario != animal.getPropietario()) {
				animal.cambiarPropietario(propietario, new Date());
			}
		}
		getSistema().guardar();
		MainFrame.instancia.animales.cargarDatos();
		esNuevo = false;
		setTitle("Editar animal");
	}

	protected JTextField getTxDia() {
		return txDia;
	}

	protected JTextField getTxMes() {
		return txMes;
	}

	protected JTextField getTxAnio() {
		return txAnio;
	}

	protected JTextField getTxRegistro() {
		return txRegistro;
	}

	protected JTextField getTxNombre() {
		return txNombre;
	}

	protected JComboBox getCbRaza() {
		return cbRaza;
	}
}
