package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.MenuPrincipal;
import Vista.VentanaSeleccionPista;

public class EscuchadorEleccionPista extends EscuchadorMenu implements ActionListener {

	public EscuchadorEleccionPista(MenuPrincipal menu){
		super(menu);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new VentanaSeleccionPista(this.menu);
	}

}
