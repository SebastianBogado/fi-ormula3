package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.MenuPrincipal;

public class EscuchadorBotonSeleccionRuedas implements ActionListener {
	private MenuPrincipal menu;
	public EscuchadorBotonSeleccionRuedas(MenuPrincipal menu) {
		this.menu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		menu.setRuedasElegidas(arg.getActionCommand());
		this.menu.ventanaSeleccionRuedas().habilitarAceptar();
	}

}