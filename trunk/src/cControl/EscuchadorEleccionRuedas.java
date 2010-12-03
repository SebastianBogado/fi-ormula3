package cControl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vVista.MenuPrincipal;
import vVista.VentanaSeleccionRuedas;


public class EscuchadorEleccionRuedas extends EscuchadorMenu implements ActionListener {

	public EscuchadorEleccionRuedas(MenuPrincipal menu){
		super(menu);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		VentanaSeleccionRuedas ventana = new VentanaSeleccionRuedas("Selección del ruedas",
				new Dimension(200,150), this.menu);
		this.menu.setVentanaRuedas(ventana);
	}

}
