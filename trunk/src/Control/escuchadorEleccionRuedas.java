package Control;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.MenuPrincipal;
import Vista.VentanaSeleccionRuedas;

public class escuchadorEleccionRuedas implements ActionListener {
	MenuPrincipal menu;
	
	public escuchadorEleccionRuedas(MenuPrincipal menu){
		this.menu = menu;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		VentanaSeleccionRuedas ventana = new VentanaSeleccionRuedas("Selección del ruedas",
				new Dimension(200,150), this.menu);
		this.menu.setVentanaRuedas(ventana);
	}

}
