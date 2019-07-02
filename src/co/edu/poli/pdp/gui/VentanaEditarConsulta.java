package co.edu.poli.pdp.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import co.edu.poli.pdp.SistemaConsultasMedicasVeterinaria;
import co.edu.poli.pdp.entidades.Animal;
import co.edu.poli.pdp.entidades.Consulta;
import co.edu.poli.pdp.entidades.Enfermedad;
import co.edu.poli.pdp.entidades.ItemReceta;
import co.edu.poli.pdp.entidades.Patologia;
import co.edu.poli.pdp.entidades.Profesional;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import javax.swing.JSeparator;

public class VentanaEditarConsulta extends JInternalFrame {

	private Consulta consulta;
	private boolean esNueva;
	private JTextField txCodigo;
	private JTextField txMotivo;
	private JTextField txExamen;
	private JTextField txTratamiento;
	private JTextField txDia;
	private JTextField txMes;
	private JTextField txAnio;
	private JComboBox cbAnimal;
	private JComboBox cbProfesional;
	private JComboBox cbPatologia;
	private JComboBox cbEnfermedadCronica;
	private JList listaReceta;

	/**
	 * Create the frame.
	 */
	public VentanaEditarConsulta(Consulta consulta, boolean esNueva) {
		setResizable(true);
		setClosable(true);
		this.consulta = consulta;
		this.esNueva = esNueva;
		if (esNueva)
			setTitle("Nueva consulta");
		else
			setTitle("Editar consulta");

		setBounds(100, 100, 565, 514);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblCodigo = new JLabel("Codigo");
		GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
		gbc_lblCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigo.anchor = GridBagConstraints.WEST;
		gbc_lblCodigo.gridx = 0;
		gbc_lblCodigo.gridy = 0;
		getContentPane().add(lblCodigo, gbc_lblCodigo);

		txCodigo = new JTextField();
		GridBagConstraints gbc_txCodigo = new GridBagConstraints();
		gbc_txCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_txCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txCodigo.gridx = 1;
		gbc_txCodigo.gridy = 0;
		getContentPane().add(txCodigo, gbc_txCodigo);
		txCodigo.setColumns(10);

		JLabel lblNewLabel = new JLabel("Fecha (d/m/a)");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		getContentPane().add(panel_2, gbc_panel_2);

		txDia = new JTextField();
		panel_2.add(txDia);
		txDia.setColumns(2);

		JLabel label = new JLabel("/");
		panel_2.add(label);

		txMes = new JTextField();
		panel_2.add(txMes);
		txMes.setColumns(2);

		JLabel label_1 = new JLabel("/");
		panel_2.add(label_1);

		txAnio = new JTextField();
		panel_2.add(txAnio);
		txAnio.setColumns(4);

		JLabel lblAnimal = new JLabel("Animal");
		GridBagConstraints gbc_lblAnimal = new GridBagConstraints();
		gbc_lblAnimal.anchor = GridBagConstraints.WEST;
		gbc_lblAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnimal.gridx = 0;
		gbc_lblAnimal.gridy = 2;
		getContentPane().add(lblAnimal, gbc_lblAnimal);

		cbAnimal = new JComboBox();
		GridBagConstraints gbc_cbAnimal = new GridBagConstraints();
		gbc_cbAnimal.insets = new Insets(0, 0, 5, 0);
		gbc_cbAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbAnimal.gridx = 1;
		gbc_cbAnimal.gridy = 2;
		getContentPane().add(cbAnimal, gbc_cbAnimal);

		JLabel lblMotivo = new JLabel("Motivo");
		GridBagConstraints gbc_lblMotivo = new GridBagConstraints();
		gbc_lblMotivo.anchor = GridBagConstraints.WEST;
		gbc_lblMotivo.insets = new Insets(0, 0, 5, 5);
		gbc_lblMotivo.gridx = 0;
		gbc_lblMotivo.gridy = 3;
		getContentPane().add(lblMotivo, gbc_lblMotivo);

		txMotivo = new JTextField();
		GridBagConstraints gbc_txMotivo = new GridBagConstraints();
		gbc_txMotivo.insets = new Insets(0, 0, 5, 0);
		gbc_txMotivo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txMotivo.gridx = 1;
		gbc_txMotivo.gridy = 3;
		getContentPane().add(txMotivo, gbc_txMotivo);
		txMotivo.setColumns(10);

		JLabel lblExamenFsico = new JLabel("Examen f\u00EDsico");
		GridBagConstraints gbc_lblExamenFsico = new GridBagConstraints();
		gbc_lblExamenFsico.anchor = GridBagConstraints.WEST;
		gbc_lblExamenFsico.insets = new Insets(0, 0, 5, 5);
		gbc_lblExamenFsico.gridx = 0;
		gbc_lblExamenFsico.gridy = 4;
		getContentPane().add(lblExamenFsico, gbc_lblExamenFsico);

		txExamen = new JTextField();
		GridBagConstraints gbc_txExamen = new GridBagConstraints();
		gbc_txExamen.insets = new Insets(0, 0, 5, 0);
		gbc_txExamen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txExamen.gridx = 1;
		gbc_txExamen.gridy = 4;
		getContentPane().add(txExamen, gbc_txExamen);
		txExamen.setColumns(10);

		JLabel lblTratamiento = new JLabel("Tratamiento");
		GridBagConstraints gbc_lblTratamiento = new GridBagConstraints();
		gbc_lblTratamiento.anchor = GridBagConstraints.WEST;
		gbc_lblTratamiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblTratamiento.gridx = 0;
		gbc_lblTratamiento.gridy = 5;
		getContentPane().add(lblTratamiento, gbc_lblTratamiento);

		txTratamiento = new JTextField();
		GridBagConstraints gbc_txTratamiento = new GridBagConstraints();
		gbc_txTratamiento.insets = new Insets(0, 0, 5, 0);
		gbc_txTratamiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txTratamiento.gridx = 1;
		gbc_txTratamiento.gridy = 5;
		getContentPane().add(txTratamiento, gbc_txTratamiento);
		txTratamiento.setColumns(10);

		JLabel lblProfesional = new JLabel("Profesional");
		GridBagConstraints gbc_lblProfesional = new GridBagConstraints();
		gbc_lblProfesional.anchor = GridBagConstraints.WEST;
		gbc_lblProfesional.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesional.gridx = 0;
		gbc_lblProfesional.gridy = 6;
		getContentPane().add(lblProfesional, gbc_lblProfesional);

		cbProfesional = new JComboBox();
		GridBagConstraints gbc_cbProfesional = new GridBagConstraints();
		gbc_cbProfesional.insets = new Insets(0, 0, 5, 0);
		gbc_cbProfesional.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbProfesional.gridx = 1;
		gbc_cbProfesional.gridy = 6;
		getContentPane().add(cbProfesional, gbc_cbProfesional);

		JLabel lblPatologa = new JLabel("Patolog\u00EDa");
		GridBagConstraints gbc_lblPatologa = new GridBagConstraints();
		gbc_lblPatologa.anchor = GridBagConstraints.WEST;
		gbc_lblPatologa.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatologa.gridx = 0;
		gbc_lblPatologa.gridy = 7;
		getContentPane().add(lblPatologa, gbc_lblPatologa);

		cbPatologia = new JComboBox();
		GridBagConstraints gbc_cbPatologia = new GridBagConstraints();
		gbc_cbPatologia.insets = new Insets(0, 0, 5, 0);
		gbc_cbPatologia.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbPatologia.gridx = 1;
		gbc_cbPatologia.gridy = 7;
		getContentPane().add(cbPatologia, gbc_cbPatologia);

		JLabel lblEnfermedadCrnica = new JLabel("Enfermedad cr\u00F3nica");
		GridBagConstraints gbc_lblEnfermedadCrnica = new GridBagConstraints();
		gbc_lblEnfermedadCrnica.anchor = GridBagConstraints.WEST;
		gbc_lblEnfermedadCrnica.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnfermedadCrnica.gridx = 0;
		gbc_lblEnfermedadCrnica.gridy = 8;
		getContentPane().add(lblEnfermedadCrnica, gbc_lblEnfermedadCrnica);

		cbEnfermedadCronica = new JComboBox();
		GridBagConstraints gbc_cbEnfermedadCronica = new GridBagConstraints();
		gbc_cbEnfermedadCronica.insets = new Insets(0, 0, 5, 0);
		gbc_cbEnfermedadCronica.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbEnfermedadCronica.gridx = 1;
		gbc_cbEnfermedadCronica.gridy = 8;
		getContentPane().add(cbEnfermedadCronica, gbc_cbEnfermedadCronica);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Receta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 9;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));

		listaReceta = new JList();
		listaReceta.setPreferredSize(new Dimension(350, 80));
		panel.add(listaReceta, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.EAST);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 115, 0 };
		gbl_panel_3.rowHeights = new int[] { 25, 0, 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JButton btnAdicionartem = new JButton("Adicionar \u00EDtem");
		VentanaEditarConsulta ventana = this;
		btnAdicionartem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogoCreacionItemReceta d = new DialogoCreacionItemReceta(new ItemReceta(), ventana);
				d.pack();
				d.setLocation(ventana.getLocation().x, ventana.getLocation().y + 200);
				d.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnAdicionartem = new GridBagConstraints();
		gbc_btnAdicionartem.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdicionartem.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAdicionartem.gridx = 0;
		gbc_btnAdicionartem.gridy = 0;
		panel_3.add(btnAdicionartem, gbc_btnAdicionartem);

		JButton btnBorrartem = new JButton("Borrar \u00EDtem");
		btnBorrartem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarItem();
			}
		});
		GridBagConstraints gbc_btnBorrartem = new GridBagConstraints();
		gbc_btnBorrartem.anchor = GridBagConstraints.WEST;
		gbc_btnBorrartem.insets = new Insets(0, 0, 5, 0);
		gbc_btnBorrartem.gridx = 0;
		gbc_btnBorrartem.gridy = 1;
		panel_3.add(btnBorrartem, gbc_btnBorrartem);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		panel_3.add(separator, gbc_separator);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 10;
		getContentPane().add(panel_1, gbc_panel_1);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel_1.add(btnGuardar);

	}

	protected SistemaConsultasMedicasVeterinaria getSistema() {
		return MainFrame.instancia.getSistema();
	}

	public void adicionarItem(ItemReceta item) {
		if (consulta.getReceta() == null)
			consulta.setReceta(new ArrayList<ItemReceta>());
		consulta.getReceta().add(item);
		cargarReceta();
	}

	protected void cargarReceta() {
		List<ItemReceta> receta = consulta.getReceta() == null ? new ArrayList<ItemReceta>() : consulta.getReceta();
		new ModeloLista<ItemReceta>(receta, getListaReceta());
	}

	protected void cargarCampos() {
		List<Animal> animales = getSistema().getAnimales();
		new ModeloCombo<Animal>(animales, getCbAnimal());
		List<Profesional> profesionales = getSistema().getProfesionales();
		new ModeloCombo<Profesional>(profesionales, getCbProfesional());
		List<Patologia> patologias = getSistema().getPatologias();
		new ModeloCombo<Patologia>(patologias, getCbPatologia());
		List<Enfermedad> enfermedades = getSistema().getEnfermedades();
		new ModeloCombo<Enfermedad>(enfermedades, getCbEnfermedadCronica());
		getTxCodigo().setText(consulta.getCodigo());
		Calendar cal = Calendar.getInstance();
		if (consulta.getFecha() != null)
			cal.setTime(consulta.getFecha());
		getTxDia().setText(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
		getTxMes().setText(String.valueOf(cal.get(Calendar.MONTH) + 1));
		getTxAnio().setText(String.valueOf(cal.get(Calendar.YEAR)));
		getTxExamen().setText(consulta.getExamenFisico());
		getTxMotivo().setText(consulta.getMotivo());
		getTxTratamiento().setText(consulta.getTratamiento());
		getCbAnimal().setSelectedItem(consulta.getAnimal());
		getCbEnfermedadCronica().setSelectedItem(consulta.getEnfermedadCronica());
		getCbPatologia().setSelectedItem(consulta.getPatologia());
		getCbProfesional().setSelectedItem(consulta.getProfesional());
		cargarReceta();
	}

	protected void borrarItem() {
		ItemReceta item = (ItemReceta) getListaReceta().getSelectedValue();
		if (item == null)
			return;
		consulta.getReceta().remove(item);
		cargarReceta();
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

	private Date getFecha() {
		int dia = 0, mes = 0, anio = 0;
		try {
			dia = Integer.parseInt(getTxDia().getText());
			if (dia < 1 || dia > 31)
				throw new Exception();
		} catch (Exception e) {
			mostrarMensaje("El día debe ser un número entre 1 y 31");
			return null;
		}
		try {
			mes = Integer.parseInt(getTxMes().getText());
			if (mes < 1 || mes > 12)
				throw new Exception();
		} catch (Exception e) {
			mostrarMensaje("El mes debe ser un número entre 1 y 12");
			return null;
		}
		try {
			anio = Integer.parseInt(getTxAnio().getText());
			if (anio < 2000 || anio > Calendar.getInstance().get(Calendar.YEAR))
				throw new Exception();
		} catch (Exception e) {
			mostrarMensaje("El año debe ser un número entre 2000 y "
					+ String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
			return null;
		}
		return new Date(anio, mes - 1, dia);
	}

	protected void guardar() {
		if (!validarSiVacio(getTxCodigo(), "Debe escribir un código")
				|| !validarSiVacio(getTxExamen(), "Debe escribir un examen físico")
				|| !validarSiVacio(getTxMotivo(), "Debe escribir un motivo de consulta")
				|| !validarSiVacio(getTxTratamiento(), "Debe escribir un tratamiento")
				|| !validarSiSeleccionado(getCbAnimal(), "Debe seleccionar un animal")
				|| !validarSiSeleccionado(getCbPatologia(), "Debe seleccionar una patología")
				|| !validarSiSeleccionado(getCbProfesional(), "Debe seleccionar un profesional"))
			return;
		Date fecha = getFecha();
		if (fecha == null)
			return;
		if (getSistema().getConsultaPorCodigo(getTxCodigo().getText()) != null) {
			mostrarMensaje("El código " + getTxCodigo().getText() + " ya está en uso");
			return;
		}
		consulta.setCodigo(getTxCodigo().getText());
		consulta.setAnimal((Animal) getCbAnimal().getSelectedItem());
		consulta.setEnfermedadCronica((Enfermedad) getCbEnfermedadCronica().getSelectedItem());
		consulta.setExamenFisico(getTxExamen().getText());
		consulta.setFecha(fecha);
		consulta.setMotivo(getTxMotivo().getText());
		consulta.setPatologia((Patologia) getCbPatologia().getSelectedItem());
		consulta.setProfesional((Profesional) getCbProfesional().getSelectedItem());
		consulta.setTratamiento(getTxTratamiento().getText());
		List<ItemReceta> receta = new ArrayList<ItemReceta>();
		ModeloLista<ItemReceta> modelo = (ModeloLista<ItemReceta>) getListaReceta().getModel();
		for (int i = 0; i < modelo.getSize(); i++) {
			receta.add(modelo.getElementAt(i));
		}
		consulta.setReceta(receta);
		if (esNueva) {
			getSistema().registrarConsulta(consulta);
			esNueva = false;
			setTitle("Editar consulta");
		}
		getSistema().guardar();
		MainFrame.instancia.consultas.cargarDatos();
	}

	public void mostrar() {
		cargarCampos();
		setVisible(true);
	}

	protected JTextField getTxCodigo() {
		return txCodigo;
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

	protected JComboBox getCbAnimal() {
		return cbAnimal;
	}

	protected JTextField getTxMotivo() {
		return txMotivo;
	}

	protected JTextField getTxExamen() {
		return txExamen;
	}

	protected JTextField getTxTratamiento() {
		return txTratamiento;
	}

	protected JComboBox getCbProfesional() {
		return cbProfesional;
	}

	protected JComboBox getCbPatologia() {
		return cbPatologia;
	}

	protected JComboBox getCbEnfermedadCronica() {
		return cbEnfermedadCronica;
	}

	protected JList getListaReceta() {
		return listaReceta;
	}
}
