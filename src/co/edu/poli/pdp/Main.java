package co.edu.poli.pdp;

import javax.swing.UIManager;

import co.edu.poli.pdp.entidades.Especie;
import co.edu.poli.pdp.gui.MainFrame;
import co.edu.poli.pdp.persistencia.DALInterface;
import co.edu.poli.pdp.persistencia.DALSerializable;

/**
 * Clse principal de ejecuci�n del programa
 *
 */
public class Main {

	/**
	 * M�todo de ejecuci�n
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
