package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class EscuchadorBotonSalir implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int opcion = JOptionPane.showConfirmDialog(null, "¿Desea Salir?");
		if (opcion == 0) 
			System.exit(0);
	}

}
