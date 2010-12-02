package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.MenuPrincipal;

public class EscuchadorBotonSeleccionMotor implements ActionListener {
	private MenuPrincipal menu;
	public EscuchadorBotonSeleccionMotor(MenuPrincipal menu) {
		this.menu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		this.menu.setMotorElegido(arg.getActionCommand());
		this.menu.ventanaSeleccionMotor().habilitarAceptar();
	}

}
