package vista;

import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.servicio.Tiempo;

public class VentanaDeMejoresTiempos extends JFrame {

	public VentanaDeMejoresTiempos(LinkedList<Tiempo> listaDeMejoresTiempos) {

		this.setLayout(new GridLayout(1, 1));

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		this.setLocation(500, 160);

		panel1.setLayout(new GridLayout(11, 1));
		panel2.setLayout(new GridLayout(11, 1));

		panel1.add(new JLabel("Nombre"));
		panel2.add(new JLabel("Tiempo"));

		java.util.Iterator<Tiempo> it = listaDeMejoresTiempos.iterator();

		while (it.hasNext()) {

			Tiempo unTiempo = it.next();

			panel1.add(new JLabel(unTiempo.getNombre()));
			panel2.add(new JLabel(unTiempo.getTiempo() + ""));

		}

		this.add(panel1);
		this.add(panel2);

		this.setSize(220, 400);

		this.setVisible(true);

	}

}
