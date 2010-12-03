package Control;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.MenuPrincipal;
import Vista.VentanaSeleccionMotor;

public class escuchadorEleccionMotor implements ActionListener {
	MenuPrincipal menu;
	public escuchadorEleccionMotor(MenuPrincipal menu){
		this.menu = menu;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		VentanaSeleccionMotor v = new VentanaSeleccionMotor("Selección del motor",
				new Dimension(300,150), this.menu);
		this.menu.setVentanaMotor(v);
	}

}
