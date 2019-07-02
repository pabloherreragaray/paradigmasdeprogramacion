package co.edu.poli.pdp;

import javax.swing.UIManager;

import co.edu.poli.pdp.entidades.Especie;
import co.edu.poli.pdp.gui.MainFrame;
import co.edu.poli.pdp.persistencia.DALInterface;
import co.edu.poli.pdp.persistencia.DALSerializable;

/**
 * Clse principal de ejecución del programa
 *
 */
public class Main {

	/**
	 * Método de ejecución
	 * 
	 * @param args Argumentos
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		}
		MainFrame main = new MainFrame();
		main.setVisible(true);
	}

}
