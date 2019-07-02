package co.edu.poli.pdp.gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DialogoAcercaDe extends JDialog {

	/**
	 * Create the dialog.
	 */
	public DialogoAcercaDe() {
		setTitle("Acerca del programa");
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblProgramaElaboradoPor = new JLabel("Programa elaborado por:");
		GridBagConstraints gbc_lblProgramaElaboradoPor = new GridBagConstraints();
		gbc_lblProgramaElaboradoPor.ipady = 10;
		gbc_lblProgramaElaboradoPor.ipadx = 10;
		gbc_lblProgramaElaboradoPor.insets = new Insets(20, 20, 5, 5);
		gbc_lblProgramaElaboradoPor.gridx = 0;
		gbc_lblProgramaElaboradoPor.gridy = 0;
		getContentPane().add(lblProgramaElaboradoPor, gbc_lblProgramaElaboradoPor);

		JLabel lblcdigo = new JLabel("C\u00F3digo");
		GridBagConstraints gbc_lblcdigo = new GridBagConstraints();
		gbc_lblcdigo.insets = new Insets(20, 0, 5, 20);
		gbc_lblcdigo.gridx = 1;
		gbc_lblcdigo.gridy = 0;
		getContentPane().add(lblcdigo, gbc_lblcdigo);

		JLabel lblPabloHerreraGaray = new JLabel("PABLO GERARDO HERRERA GARAY");
		lblPabloHerreraGaray.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblPabloHerreraGaray = new GridBagConstraints();
		gbc_lblPabloHerreraGaray.ipady = 10;
		gbc_lblPabloHerreraGaray.ipadx = 10;
		gbc_lblPabloHerreraGaray.anchor = GridBagConstraints.WEST;
		gbc_lblPabloHerreraGaray.insets = new Insets(0, 20, 5, 5);
		gbc_lblPabloHerreraGaray.gridx = 0;
		gbc_lblPabloHerreraGaray.gridy = 1;
		getContentPane().add(lblPabloHerreraGaray, gbc_lblPabloHerreraGaray);

		JLabel label_1 = new JLabel("1721024509");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.ipady = 10;
		gbc_label_1.ipadx = 10;
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 20);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 1;
		getContentPane().add(label_1, gbc_label_1);

		JLabel lblNewLabel = new JLabel("ESTEFANIA CRISTANCHO PINZON");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.ipady = 10;
		gbc_lblNewLabel.ipadx = 10;
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 20, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		JLabel label = new JLabel("1721022200");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.ipady = 10;
		gbc_label.ipadx = 10;
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 20);
		gbc_label.gridx = 1;
		gbc_label.gridy = 2;
		getContentPane().add(label, gbc_label);

		JLabel lblJhonElicerGuauqueta = new JLabel("JHON ELICER GUAUQUETA CASTRO");
		lblJhonElicerGuauqueta.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblJhonElicerGuauqueta = new GridBagConstraints();
		gbc_lblJhonElicerGuauqueta.ipady = 10;
		gbc_lblJhonElicerGuauqueta.ipadx = 10;
		gbc_lblJhonElicerGuauqueta.anchor = GridBagConstraints.WEST;
		gbc_lblJhonElicerGuauqueta.insets = new Insets(0, 20, 5, 5);
		gbc_lblJhonElicerGuauqueta.gridx = 0;
		gbc_lblJhonElicerGuauqueta.gridy = 3;
		getContentPane().add(lblJhonElicerGuauqueta, gbc_lblJhonElicerGuauqueta);

		JLabel label_2 = new JLabel("1721022597");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.ipady = 10;
		gbc_label_2.ipadx = 10;
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 20);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 3;
		getContentPane().add(label_2, gbc_label_2);

		JLabel lblArenasRiveroIvan = new JLabel("ARENAS RIVERO IVAN DARIO");
		lblArenasRiveroIvan.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblArenasRiveroIvan = new GridBagConstraints();
		gbc_lblArenasRiveroIvan.ipady = 10;
		gbc_lblArenasRiveroIvan.ipadx = 10;
		gbc_lblArenasRiveroIvan.anchor = GridBagConstraints.WEST;
		gbc_lblArenasRiveroIvan.insets = new Insets(0, 20, 5, 5);
		gbc_lblArenasRiveroIvan.gridx = 0;
		gbc_lblArenasRiveroIvan.gridy = 4;
		getContentPane().add(lblArenasRiveroIvan, gbc_lblArenasRiveroIvan);

		JLabel label_3 = new JLabel("1811023081");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.ipady = 10;
		gbc_label_3.ipadx = 10;
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 20);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 4;
		getContentPane().add(label_3, gbc_label_3);

		JLabel lblCesarAugustoSuaza = new JLabel("CESAR AUGUSTO SUAZA RODRIGUEZ");
		lblCesarAugustoSuaza.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblCesarAugustoSuaza = new GridBagConstraints();
		gbc_lblCesarAugustoSuaza.ipady = 10;
		gbc_lblCesarAugustoSuaza.ipadx = 10;
		gbc_lblCesarAugustoSuaza.anchor = GridBagConstraints.WEST;
		gbc_lblCesarAugustoSuaza.insets = new Insets(0, 20, 5, 5);
		gbc_lblCesarAugustoSuaza.gridx = 0;
		gbc_lblCesarAugustoSuaza.gridy = 5;
		getContentPane().add(lblCesarAugustoSuaza, gbc_lblCesarAugustoSuaza);

		JLabel label_4 = new JLabel("1721022888");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.ipady = 10;
		gbc_label_4.ipadx = 10;
		gbc_label_4.insets = new Insets(0, 0, 5, 20);
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 5;
		getContentPane().add(label_4, gbc_label_4);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.insets = new Insets(10, 0, 20, 20);
		gbc_btnCerrar.gridx = 1;
		gbc_btnCerrar.gridy = 6;
		getContentPane().add(btnCerrar, gbc_btnCerrar);

	}

}
