package co.edu.poli.pdp.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.poli.pdp.SistemaConsultasMedicasVeterinaria;
import co.edu.poli.pdp.entidades.ItemReceta;
import co.edu.poli.pdp.entidades.Medicina;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoCreacionItemReceta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ItemReceta item;
	private VentanaEditarConsulta ventana;
	private JTextField txDosis;
	private JComboBox cbMedicina;
	private JSpinner txFrecuencia;
	private JSpinner txDias;

	/**
	 * Create the dialog.
	 */
	public DialogoCreacionItemReceta(ItemReceta item, VentanaEditarConsulta ventana) {
		this.item = item;
		this.ventana = ventana;
		setTitle("\u00CDtem de receta");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblMedicina = new JLabel("Medicina");
			GridBagConstraints gbc_lblMedicina = new GridBagConstraints();
			gbc_lblMedicina.anchor = GridBagConstraints.WEST;
			gbc_lblMedicina.insets = new Insets(0, 0, 5, 5);
			gbc_lblMedicina.gridx = 0;
			gbc_lblMedicina.gridy = 0;
			contentPanel.add(lblMedicina, gbc_lblMedicina);
		}
		{
			cbMedicina = new JComboBox();
			GridBagConstraints gbc_cbMedicina = new GridBagConstraints();
			gbc_cbMedicina.insets = new Insets(0, 0, 5, 0);
			gbc_cbMedicina.fill = GridBagConstraints.HORIZONTAL;
			gbc_cbMedicina.gridx = 1;
			gbc_cbMedicina.gridy = 0;
			contentPanel.add(cbMedicina, gbc_cbMedicina);
		}
		{
			JLabel lblDsis = new JLabel("D\u00F3sis");
			GridBagConstraints gbc_lblDsis = new GridBagConstraints();
			gbc_lblDsis.anchor = GridBagConstraints.WEST;
			gbc_lblDsis.insets = new Insets(0, 0, 5, 5);
			gbc_lblDsis.gridx = 0;
			gbc_lblDsis.gridy = 1;
			contentPanel.add(lblDsis, gbc_lblDsis);
		}
		{
			txDosis = new JTextField();
			GridBagConstraints gbc_txDosis = new GridBagConstraints();
			gbc_txDosis.insets = new Insets(0, 0, 5, 0);
			gbc_txDosis.fill = GridBagConstraints.HORIZONTAL;
			gbc_txDosis.gridx = 1;
			gbc_txDosis.gridy = 1;
			contentPanel.add(txDosis, gbc_txDosis);
			txDosis.setColumns(10);
		}
		{
			JLabel lblFrecuenciahoras = new JLabel("Frecuencia (horas)");
			GridBagConstraints gbc_lblFrecuenciahoras = new GridBagConstraints();
			gbc_lblFrecuenciahoras.anchor = GridBagConstraints.WEST;
			gbc_lblFrecuenciahoras.insets = new Insets(0, 0, 5, 5);
			gbc_lblFrecuenciahoras.gridx = 0;
			gbc_lblFrecuenciahoras.gridy = 2;
			contentPanel.add(lblFrecuenciahoras, gbc_lblFrecuenciahoras);
		}
		{
			txFrecuencia = new JSpinner();
			GridBagConstraints gbc_txFrecuencia = new GridBagConstraints();
			gbc_txFrecuencia.fill = GridBagConstraints.HORIZONTAL;
			gbc_txFrecuencia.insets = new Insets(0, 0, 5, 0);
			gbc_txFrecuencia.gridx = 1;
			gbc_txFrecuencia.gridy = 2;
			contentPanel.add(txFrecuencia, gbc_txFrecuencia);
		}
		{
			JLabel lblCantidadDeDas = new JLabel("Cantidad de d\u00EDas");
			GridBagConstraints gbc_lblCantidadDeDas = new GridBagConstraints();
			gbc_lblCantidadDeDas.insets = new Insets(0, 0, 0, 5);
			gbc_lblCantidadDeDas.anchor = GridBagConstraints.WEST;
			gbc_lblCantidadDeDas.gridx = 0;
			gbc_lblCantidadDeDas.gridy = 3;
			contentPanel.add(lblCantidadDeDas, gbc_lblCantidadDeDas);
		}
		{
			txDias = new JSpinner();
			GridBagConstraints gbc_txDias = new GridBagConstraints();
			gbc_txDias.fill = GridBagConstraints.HORIZONTAL;
			gbc_txDias.gridx = 1;
			gbc_txDias.gridy = 3;
			contentPanel.add(txDias, gbc_txDias);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						guardar();
					}
				});
				buttonPane.add(btnGuardar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setItem(null);
						setVisible(false);
					}
				});
				buttonPane.add(btnCancelar);
			}
		}

		mostrarCampos();
	}

	private SistemaConsultasMedicasVeterinaria getSistema() {
		return MainFrame.instancia.getSistema();
	}

	private void mostrarCampos() {
		List<Medicina> medicinas = getSistema().getMedicina();
		new ModeloCombo<Medicina>(medicinas, getCbMedicina());
		getCbMedicina().setSelectedItem(item.getMedicina());
		getTxDosis().setText(item.getDosis());
		getTxFrecuencia().setValue(item.getFrecuenciaEnHoras());
		getTxDias().setValue(item.getCantidadDias());
	}

	private void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}

	private void guardar() {
		Medicina medicina = (Medicina) getCbMedicina().getSelectedItem();
		if (medicina == null) {
			mostrarMensaje("Debe seleccionar una medicina");
			return;
		}
		if (getTxDosis().getText().length() == 0) {
			mostrarMensaje("Debe escribir una dosis");
			return;
		}
		item.setMedicina((Medicina) getCbMedicina().getSelectedItem());
		item.setDosis(getTxDosis().getText());
		item.setFrecuenciaEnHoras((int) getTxFrecuencia().getValue());
		item.setCantidadDias((int) getTxDias().getValue());
		setVisible(false);
		ventana.adicionarItem(getItem());
	}

	public ItemReceta getItem() {
		return item;
	}

	public void setItem(ItemReceta item) {
		this.item = item;
	}

	protected JComboBox getCbMedicina() {
		return cbMedicina;
	}

	protected JTextField getTxDosis() {
		return txDosis;
	}

	protected JSpinner getTxFrecuencia() {
		return txFrecuencia;
	}

	protected JSpinner getTxDias() {
		return txDias;
	}
}
