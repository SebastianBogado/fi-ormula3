package titiritero;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClickController extends MouseAdapter {

	private final ControladorJuego controlador;

	public MouseClickController(ControladorJuego unControlador) {
		this.controlador = unControlador;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.controlador.despacharMouseClick(e.getX(), e.getY());
	}

}