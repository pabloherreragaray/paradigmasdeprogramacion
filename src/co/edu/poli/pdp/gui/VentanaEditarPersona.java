package co.edu.poli.pdp.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import co.edu.poli.pdp.SistemaConsultasMedicasVeterinaria;
import co.edu.poli.pdp.entidades.Especialidad;
import co.edu.poli.pdp.entidades.Persona;
import co.edu.poli.pdp.entidades.Profesional;
import co.edu.poli.pdp.entidades.Propietario;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import javax.swing.JSeparator;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaEditarPersona extends JInternalFrame {

	protected boolean esNuevo;
	protected Persona persona;
	private JTextField txNombre;
	private JTextField txApellido;
	private JTextField txDireccion;
	private JTextField txDocumento;
	private JTextField txTelefono;
	private JTextField txCelular;
	private JTextField txRegistro;
	private JList listEspecialidades;
	private JButton btnGuardar;
	private JPanel panelProfesional;

	/**
	 * Create the frame.
	 */
	public VentanaEditarPersona(Persona persona, boolean esNuevo) {
		setClosable(true);
		setResizable(true);
		this.esNuevo = esNuevo;
		this.persona = persona;
		if (persona instanceof Profesional) {
			if (esNuevo)
				setTitle("Nuevo profesional");
			else
				setTitle("Editar profesional");
		} else {
			if (esNuevo)
				setTitle("Nuevo propietario");
			else
				setTitle("Editar propietario");
		}
		setBounds(100, 100, 476, 554);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 200 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0 };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("N\u00FAmero de documento");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		txDocumento = new JTextField();
		GridBagConstraints gbc_txDocumento = new GridBagConstraints();
		gbc_txDocumento.insets = new Insets(0, 0, 5, 0);
		gbc_txDocumento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txDocumento.gridx = 1;
		gbc_txDocumento.gridy = 0;
		getContentPane().add(txDocumento, gbc_txDocumento);
		txDocumento.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		getContentPane().add(lblNombre, gbc_lblNombre);

		txNombre = new JTextField();
		GridBagConstraints gbc_txNombre = new GridBagConstraints();
		gbc_txNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txNombre.gridx = 1;
		gbc_txNombre.gridy = 1;
		getContentPane().add(txNombre, gbc_txNombre);
		txNombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.WEST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 2;
		getContentPane().add(lblApellido, gbc_lblApellido);

		txApellido = new JTextField();
		GridBagConstraints gbc_txApellido = new GridBagConstraints();
		gbc_txApellido.insets = new Insets(0, 0, 5, 0);
		gbc_txApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txApellido.gridx = 1;
		gbc_txApellido.gridy = 2;
		getContentPane().add(txApellido, gbc_txApellido);
		txApellido.setColumns(10);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		GridBagConstraints gbc_lblDireccin = new GridBagConstraints();
		gbc_lblDireccin.anchor = GridBagConstraints.WEST;
		gbc_lblDireccin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccin.gridx = 0;
		gbc_lblDireccin.gridy = 3;
		getContentPane().add(lblDireccin, gbc_lblDireccin);

		txDireccion = new JTextField();
		GridBagConstraints gbc_txDireccion = new GridBagConstraints();
		gbc_txDireccion.insets = new Insets(0, 0, 5, 0);
		gbc_txDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txDireccion.gridx = 1;
		gbc_txDireccion.gridy = 3;
		getContentPane().add(txDireccion, gbc_txDireccion);
		txDireccion.setColumns(10);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		GridBagConstraints gbc_lblTelfono = new GridBagConstraints();
		gbc_lblTelfono.anchor = GridBagConstraints.WEST;
		gbc_lblTelfono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelfono.gridx = 0;
		gbc_lblTelfono.gridy = 4;
		getContentPane().add(lblTelfono, gbc_lblTelfono);

		txTelefono = new JTextField();
		GridBagConstraints gbc_txTelefono = new GridBagConstraints();
		gbc_txTelefono.insets = new Insets(0, 0, 5, 0);
		gbc_txTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txTelefono.gridx = 1;
		gbc_txTelefono.gridy = 4;
		getContentPane().add(txTelefono, gbc_txTelefono);
		txTelefono.setColumns(10);

		JLabel lblCelular = new JLabel("Celular");
		GridBagConstraints gbc_lblCelular = new GridBagConstraints();
		gbc_lblCelular.anchor = GridBagConstraints.WEST;
		gbc_lblCelular.insets = new Insets(0, 0, 5, 5);
		gbc_lblCelular.gridx = 0;
		gbc_lblCelular.gridy = 5;
		getContentPane().add(lblCelular, gbc_lblCelular);

		txCelular = new JTextField();
		GridBagConstraints gbc_txCelular = new GridBagConstraints();
		gbc_txCelular.insets = new Insets(0, 0, 5, 0);
		gbc_txCelular.fill = GridBagConstraints.HORIZONTAL;
		gbc_txCelular.gridx = 1;
		gbc_txCelular.gridy = 5;
		getContentPane().add(txCelular, gbc_txCelular);
		txCelular.setColumns(10);

		panelProfesional = new JPanel();
		panelProfesional.setBorder(
				new TitledBorder(null, "Datos del profesional", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelProfesional = new GridBagConstraints();
		gbc_panelProfesional.insets = new Insets(0, 0, 5, 0);
		gbc_panelProfesional.gridwidth = 2;
		gbc_panelProfesional.fill = GridBagConstraints.BOTH;
		gbc_panelProfesional.gridx = 0;
		gbc_panelProfesional.gridy = 6;
		getContentPane().add(panelProfesional, gbc_panelProfesional);
		GridBagLayout gbl_panelProfesional = new GridBagLayout();
		gbl_panelProfesional.columnWidths = new int[] { 100, 200 };
		gbl_panelProfesional.rowHeights = new int[] { 0 };
		gbl_panelProfesional.columnWeights = new double[] { 0.0, 1.0 };
		gbl_panelProfesional.rowWeights = new double[] { 0.0, 1.0 };
		panelProfesional.setLayout(gbl_panelProfesional);

		JLabel lblNmeroDeRegistro = new JLabel("N\u00FAmero de registro");
		GridBagConstraints gbc_lblNmeroDeRegistro = new GridBagConstraints();
		gbc_lblNmeroDeRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmeroDeRegistro.anchor = GridBagConstraints.WEST;
		gbc_lblNmeroDeRegistro.gridx = 0;
		gbc_lblNmeroDeRegistro.gridy = 0;
		panelProfesional.add(lblNmeroDeRegistro, gbc_lblNmeroDeRegistro);

		txRegistro = new JTextField();
		GridBagConstraints gbc_txRegistro = new GridBagConstraints();
		gbc_txRegistro.insets = new Insets(0, 0, 5, 0);
		gbc_txRegistro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txRegistro.gridx = 1;
		gbc_txRegistro.gridy = 0;
		panelProfesional.add(txRegistro, gbc_txRegistro);
		txRegistro.setColumns(10);

		JLabel lblEspecialidades = new JLabel("Especialidades");
		GridBagConstraints gbc_lblEspecialidades = new GridBagConstraints();
		gbc_lblEspecialidades.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblEspecialidades.insets = new Insets(0, 0, 0, 5);
		gbc_lblEspecialidades.gridx = 0;
		gbc_lblEspecialidades.gridy = 1;
		panelProfesional.add(lblEspecialidades, gbc_lblEspecialidades);

		listEspecialidades = new JList();
		listEspecialidades.setPreferredSize(new Dimension(150, 100));
		GridBagConstraints gbc_listEspecialidades = new GridBagConstraints();
		gbc_listEspecialidades.anchor = GridBagConstraints.NORTH;
		gbc_listEspecialidades.fill = GridBagConstraints.HORIZONTAL;
		gbc_listEspecialidades.gridx = 1;
		gbc_listEspecialidades.gridy = 1;
		panelProfesional.add(listEspecialidades, gbc_listEspecialidades);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridwidth = 2;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 7;
		getContentPane().add(separator, gbc_separator);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 8;
		getContentPane().add(panel, gbc_panel);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);

		mostrarEnCampos();
	}

	protected JTextField getTxDocumento() {
		return txDocumento;
	}

	protected JTextField getTxNombre() {
		return txNombre;
	}

	protected JTextField getTxApellido() {
		return txApellido;
	}

	protected JTextField getTxDireccion() {
		return txDireccion;
	}

	protected JTextField getTxTelefono() {
		return txTelefono;
	}

	protected JTextField getTxCelular() {
		return txCelular;
	}

	protected JTextField getTxRegistro() {
		return txRegistro;
	}

	protected JList getListEspecialidades() {
		return listEspecialidades;
	}

	protected JButton getBtnGuardar() {
		return btnGuardar;
	}

	protected void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}

	protected boolean validarSiVacio(JTextField tx, String mensaje) {
		boolean res = tx.getText().length() > 0;
		if (!res)
			mostrarMensaje(mensaje);
		return res;
	}

	protected void guardar() {
		if (!validarSiVacio(getTxDocumento(), "Debe escribir un número de documento")
				|| !validarSiVacio(getTxNombre(), "Debe escribir un nombre")
				|| !validarSiVacio(getTxApellido(), "Debe escribir un apellido")
				|| !validarSiVacio(getTxDireccion(), "Debe escribir una dirección")
				|| !validarSiVacio(getTxTelefono(), "Debe escribir un teléfono")
				|| !validarSiVacio(getTxCelular(), "Debe escribir un celular"))
			return;
		long documento = 0;
		try {
			documento = Long.parseLong(getTxDocumento().getText());
		} catch (Exception e) {
			mostrarMensaje("El documento debe ser un número");
			return;
		}
		long telefono = 0;
		try {
			telefono = Long.parseLong(getTxTelefono().getText());
		} catch (Exception e) {
			mostrarMensaje("El teléfono debe ser un número");
			return;
		}
		long celular = 0;
		try {
			celular = Long.parseLong(getTxCelular().getText());
		} catch (Exception e) {
			mostrarMensaje("El celular debe ser un número");
			return;
		}
		boolean enUso;
		if (persona instanceof Profesional)
			enUso = getSistema().getProfesionalPorNumeroDocumento(documento) != null;
		else
			enUso = getSistema().getPropietarioPorNumeroDocumento(documento) != null;
		if (enUso) {
			mostrarMensaje("El documento " + String.valueOf(documento) + " ya está en uso");
			return;
		}
		persona.setNumeroDocumento(documento);
		persona.setNombre(getTxNombre().getText());
		persona.setApellido(getTxApellido().getText());
		persona.setDireccion(getTxDireccion().getText());
		persona.setTelefono(telefono);
		persona.setCelular(celular);
		if (persona instanceof Profesional) {
			if (!validarSiVacio(getTxRegistro(), "Debe escribir un número de registro"))
				return;
			int registro = 0;
			try {
				registro = Integer.parseInt(getTxRegistro().getText());
			} catch (Exception e) {
				mostrarMensaje("El número de registro debe ser un número");
				return;
			}
			Profesional profesional = (Profesional) persona;
			profesional.setNumeroRegistro(registro);
			profesional.getEspecialidades().clear();
			JList lista = getListEspecialidades();
			for (int i : lista.getSelectedIndices()) {
				Especialidad e = (Especialidad) lista.getModel().getElementAt(i);
				profesional.adicionarEspecialidad(e);
			}
			if (esNuevo)
				getSistema().getProfesionales().add(profesional);
		} else {
			if (esNuevo)
				getSistema().getPropietarios().add((Propietario) persona);
		}
		getSistema().guardar();
		if (persona instanceof Profesional) {
			// mostrarMensaje("Profesional guardado");
			MainFrame.instancia.profesionales.cargarDatos();
		} else {
			// mostrarMensaje("Propietario guardado");
			MainFrame.instancia.propietarios.cargarDatos();
		}
		esNuevo = false;
		if (persona instanceof Profesional)
			setTitle("Editar profesional");
		else
			setTitle("Editar propietario");
	}

	protected void mostrarEnCampos() {
		getTxDocumento().setText(String.valueOf(persona.getNumeroDocumento()));
		getTxNombre().setText(persona.getNombre());
		getTxApellido().setText(persona.getApellido());
		getTxDireccion().setText(persona.getDireccion());
		getTxTelefono().setText(String.valueOf(persona.getTelefono()));
		getTxCelular().setText(String.valueOf(persona.getCelular()));
		if (persona instanceof Profesional) {
			getPanelProfesional().setVisible(true);
			Profesional profesional = (Profesional) persona;
			getTxRegistro().setText(String.valueOf(profesional.getNumeroRegistro()));
			JList lista = getListEspecialidades();
			List<Especialidad> especialidades = getSistema().getEspecialidades();
			List<Especialidad> seleccionadas = profesional.getEspecialidades();
			new ModeloLista<Especialidad>(especialidades, lista);
			List<Integer> indices = new ArrayList<Integer>();
			for (int i = 0; i < especialidades.size(); i++) {
				Especialidad e = especialidades.get(i);
				if (seleccionadas.contains(e)) {
					indices.add(i);
				}
			}
			int[] iindices = new int[indices.size()];
			for (int i = 0; i < indices.size(); i++) {
				iindices[i] = indices.get(i).intValue();
			}
			lista.setSelectedIndices(iindices);
		} else {
			getPanelProfesional().setVisible(false);
		}
	}

	protected JPanel getPanelProfesional() {
		return panelProfesional;
	}

	private SistemaConsultasMedicasVeterinaria getSistema() {
		return MainFrame.instancia.getSistema();
	}
}
