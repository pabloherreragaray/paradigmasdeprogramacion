package co.edu.poli.pdp.gui;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class ModeloCombo<E> extends DefaultComboBoxModel<E> {

	public ModeloCombo(List<E> elems, JComboBox lista) {
		super();
		for (E e : elems) {
			addElement(e);
		}
		lista.setModel(this);
	}

}
