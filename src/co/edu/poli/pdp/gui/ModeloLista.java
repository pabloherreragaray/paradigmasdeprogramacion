package co.edu.poli.pdp.gui;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class ModeloLista<E> extends DefaultListModel<E> {

	public ModeloLista(List<E> elems, JList<E> lista) {
		super();
		for (E e : elems) {
			addElement(e);
		}
		lista.setModel(this);
	}

}
