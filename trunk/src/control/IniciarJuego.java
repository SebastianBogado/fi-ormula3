package control;

import modelo.Automovil;
import modelo.Pista;

public class IniciarJuego extends Thread {

	private boolean parado = true;
	private Automovil automovil;
	private Pista pista;

	public IniciarJuego() {

	}

	@Override
	public void start() {

		while (parado) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		new ControladorDeCarrera(automovil, pista);
	}

	public void parar() {
		parado = true;
	}

	public void seguir() {
		parado = false;
	}

	public boolean parado() {
		return parado;
	}

	public void cargar(Automovil auto, Pista pista) {
		this.automovil = auto;
		this.pista = pista;

	}

}
