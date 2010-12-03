package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.MenuPrincipal;
import Vista.VentanaSeleccionPista;

public class escuchadorEleccionPista implements ActionListener {
	
	MenuPrincipal menu;

	public escuchadorEleccionPista(MenuPrincipal menu){
		this.menu = menu;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new VentanaSeleccionPista(this.menu);
	}

}
