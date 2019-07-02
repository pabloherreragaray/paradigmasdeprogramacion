package co.edu.poli.pdp.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaMenuPrincipal extends JInternalFrame {
	/**
	 * Create the frame.
	 */
	public VentanaMenuPrincipal() {
		setTitle("Men\u00FA principal");
		setBounds(100, 100, 270, 292);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 200 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		getContentPane().setLayout(gridBagLayout);

		JPanel panelAdministracion = new JPanel();
		panelAdministracion.setBorder(
				new TitledBorder(null, "Administraci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelAdministracion = new GridBagConstraints();
		gbc_panelAdministracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelAdministracion.insets = new Insets(0, 0, 5, 0);
		gbc_panelAdministracion.gridx = 0;
		gbc_panelAdministracion.gridy = 0;
		getContentPane().add(panelAdministracion, gbc_panelAdministracion);
		panelAdministracion.setLayout(new GridLayout(3, 1, 0, 0));

		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.instancia.consultas.mostrar();
			}
		});
		panelAdministracion.add(btnConsultas);

		JButton btnPropietarios = new JButton("Propietarios");
		btnPropietarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.instancia.propietarios.mostrar();
			}
		});
		panelAdministracion.add(btnPropietarios);

		JButton btnProfesionales = new JButton("Profesionales");
		btnProfesionales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.instancia.profesionales.mostrar();
			}
		});
		panelAdministracion.add(btnProfesionales);

		JButton btnAnimales = new JButton("Animales");
		btnAnimales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.instancia.animales.mostrar();
			}
		});
		panelAdministracion.add(btnAnimales);

		JPanel panelMaestros = new JPanel();
		panelMaestros.setBorder(new TitledBorder(null, "Maestros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelMaestros = new GridBagConstraints();
		gbc_panelMaestros.insets = new Insets(0, 0, 5, 0);
		gbc_panelMaestros.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelMaestros.gridx = 0;
		gbc_panelMaestros.gridy = 1;
		getContentPane().add(panelMaestros, gbc_panelMaestros);
		panelMaestros.setLayout(new GridLayout(3, 2, 0, 0));

		JButton btnEspecies = new JButton("Especies");
		btnEspecies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.instancia.especies.mostrar();
			}
		});
		panelMaestros.add(btnEspecies);

		JButton btnEnfermedades = new JButton("Enfermedades");
		btnEnfermedades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.instancia.enfermedades.mostrar();
			}
		});
		panelMaestros.add(btnEnfermedades);

		JButton btnPatologas = new JButton("Patolog\u00EDas");
		btnPatologas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.instancia.patologias.mostrar();
			}
		});
		panelMaestros.add(btnPatologas);

		JButton btnMedicinas = new JButton("Medicinas");
		btnMedicinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.instancia.medicinas.mostrar();
			}
		});
		panelMaestros.add(btnMedicinas);

		JButton btnEspecialidades = new JButton("Especialidades");
		btnEspecialidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.instancia.especialidades.mostrar();
			}
		});
		panelMaestros.add(btnEspecialidades);

		JButton btnAcercaDelPrograma = new JButton("Acerca del programa");
		btnAcercaDelPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogoAcercaDe d = new DialogoAcercaDe();
				d.pack();
				d.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnAcercaDelPrograma = new GridBagConstraints();
		gbc_btnAcercaDelPrograma.gridx = 0;
		gbc_btnAcercaDelPrograma.gridy = 2;
		getContentPane().add(btnAcercaDelPrograma, gbc_btnAcercaDelPrograma);

	}
}
