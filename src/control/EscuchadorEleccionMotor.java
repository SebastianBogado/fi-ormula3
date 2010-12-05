package control;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.MenuPrincipal;
import vista.VentanaSeleccionMotor;

public class EscuchadorEleccionMotor extends EscuchadorMenu implements
		ActionListener {

	public EscuchadorEleccionMotor(MenuPrincipal menu) {
		super(menu);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (this.menu.getVentanaMotor() == null) {
			VentanaSeleccionMotor ventana = new VentanaSeleccionMotor(
					"Selección del motor", new Dimension(300, 150), this.menu);
			this.menu.setVentanaMotor(ventana);
		} else {
			this.menu.getVentanaMotor().setVisible(true);
		}
	}

}
