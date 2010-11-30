package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.Automovil;

public class OyenteTeclado implements KeyListener {

	private final Automovil auto;
	private long tiempo = 0;

	public OyenteTeclado(Automovil automovil) {
		this.auto = automovil;
	}

	public void keyPressed(KeyEvent e) {

		long diferenciaDeTiempo = 0;

		if (tiempo == 0) {
			diferenciaDeTiempo = 36;
		} else
			diferenciaDeTiempo = e.getWhen() - tiempo;

		tiempo = e.getWhen();

		if (e.getKeyCode() == KeyEvent.VK_UP) {

			this.acelerarAutomovil(diferenciaDeTiempo);
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			this.frenarAutomovil(diferenciaDeTiempo);
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			this.doblarIzquierda();
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			this.doblarDerecha();

	}

	private void doblarDerecha() {
		this.auto.doblarALaDerecha();
		this.auto.actualizarPosicion(0.001);

	}

	private void doblarIzquierda() {
		this.auto.doblarALaIzquierda();
		this.auto.actualizarPosicion(0.001);

	}

	private void frenarAutomovil(long diferenciaDeTiempo) {
		auto.frenar(diferenciaDeTiempo / 1000.0);

	}

	private void acelerarAutomovil(long diferenciaDeTiempo) {

		auto.acelerar(diferenciaDeTiempo / 1000.0);

	}

	public void keyReleased(KeyEvent arg0) {
		tiempo = 0;
	}

	public void keyTyped(KeyEvent arg0) {

	}

}
