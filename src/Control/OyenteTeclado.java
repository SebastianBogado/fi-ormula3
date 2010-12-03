package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.Automovil;
import modelo.servicio.DiferencialDeTiempo;

public class OyenteTeclado implements KeyListener {

	private final Automovil auto;
	private long tiempo = 0;

	public OyenteTeclado(Automovil automovil) {
		this.auto = automovil;
	}

	public void keyPressed(KeyEvent e) {

		long diferenciaDeTiempo = 0, aux = 0;

		if (tiempo == 0) {
			diferenciaDeTiempo = DiferencialDeTiempo.ms;
		} else {
			aux = e.getWhen();
			diferenciaDeTiempo = aux - tiempo;
			tiempo = aux;
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) 
			this.acelerarAutomovil(diferenciaDeTiempo);
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			this.frenarAutomovil(diferenciaDeTiempo);
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			this.doblarIzquierda();
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			this.doblarDerecha();
	}

	private void doblarDerecha() {
		this.auto.doblarALaDerecha();
	}

	private void doblarIzquierda() {
		this.auto.doblarALaIzquierda();
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
