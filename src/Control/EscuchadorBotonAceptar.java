package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.VentanaSeleccion;

public class EscuchadorBotonAceptar implements ActionListener {
	private VentanaSeleccion ventana;
	
	public EscuchadorBotonAceptar(VentanaSeleccion ventanaSeleccion) {
		this.ventana = ventanaSeleccion;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.ventana.setVisible(false);
	}

}
