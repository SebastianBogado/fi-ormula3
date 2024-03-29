package control;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.MenuPrincipal;
import vista.VentanaSeleccionRuedas;

public class EscuchadorEleccionRuedas extends EscuchadorMenu implements
		ActionListener {

	public EscuchadorEleccionRuedas(MenuPrincipal menu) {
		super(menu);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (this.menu.getVentanaRuedas() == null) {
			VentanaSeleccionRuedas ventana = new VentanaSeleccionRuedas(
					"Selecci�n del ruedas", new Dimension(200, 150), this.menu);
			this.menu.setVentanaRuedas(ventana);
		} else {
			this.menu.getVentanaRuedas().setVisible(true);
		}
	}

}
