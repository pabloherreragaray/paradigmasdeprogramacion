package co.edu.poli.pdp.gui;

import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import co.edu.poli.pdp.SistemaConsultasMedicasVeterinaria;
import co.edu.poli.pdp.persistencia.DALSerializable;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 7997475139404823385L;
	public static MainFrame instancia;

	private SistemaConsultasMedicasVeterinaria sistema = SistemaConsultasMedicasVeterinaria.getInstancia();
	private JDesktopPane dpAreaVentanas;
	public VentanaMenuPrincipal menuPrincipal;
	public VentanaEspecies especies;
	public VentanaRazas razas;
	public VentanaEnfermedades enfermedades;
	public VentanaPatologias patologias;
	public VentanaMedicinas medicinas;
	public VentanaEspecialidades especialidades;
	public VentanaPersonas profesionales;
	public VentanaPersonas propietarios;
	public VentanaAnimales animales;

	public MainFrame() {
		super("Sistema de Consultas Médicas Veterinarias");
		instancia = this;
		sistema.setDal(new DALSerializable());
		sistema.cargar();
		crearUI();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
	}

	private void crearUI() {
		dpAreaVentanas = new JDesktopPane();
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(dpAreaVentanas, BorderLayout.CENTER);
		menuPrincipal = new VentanaMenuPrincipal();
		menuPrincipal.pack();
		menuPrincipal.setLocation(0, 0);
		menuPrincipal.setVisible(true);
		especies = new VentanaEspecies();
		especies.pack();
		razas = new VentanaRazas();
		razas.pack();
		enfermedades = new VentanaEnfermedades();
		enfermedades.pack();
		patologias = new VentanaPatologias();
		patologias.pack();
		medicinas = new VentanaMedicinas();
		medicinas.pack();
		especialidades = new VentanaEspecialidades();
		especialidades.pack();
		profesionales = new VentanaPersonas(true);
		profesionales.pack();
		propietarios = new VentanaPersonas(false);
		propietarios.pack();
		animales = new VentanaAnimales();
		animales.pack();
		JInternalFrame[] ventanas = new JInternalFrame[] { menuPrincipal, especies, razas, enfermedades, patologias,
				medicinas, especialidades, profesionales, propietarios, animales };
		for (JInternalFrame f : ventanas) {
			dpAreaVentanas.add(f);
		}
	}

	public SistemaConsultasMedicasVeterinaria getSistema() {
		return sistema;
	}

	public void ubicarVentana(JInternalFrame f) {
		f.setLocation(menuPrincipal.getLocation().x + menuPrincipal.getWidth(), menuPrincipal.getLocation().y);
	}

	public void adicionarVentana(JInternalFrame v) {
		dpAreaVentanas.add(v);
	}

}
