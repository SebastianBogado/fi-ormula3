package modelo;

import java.util.Observable;

import modelo.excepciones.ExcepcionPistaFinalizada;
import modelo.servicio.Colisionador;
import modelo.servicio.DiferencialDeTiempo;
import modelo.servicio.Posicion;
import titiritero.ObjetoVivo;
import control.ControladorDeCarrera;

public class Entorno extends Observable implements ObjetoVivo {

	private long posicionAutoDiscretaEnX;
	private long posicionAutoDiscretaEnY;

	private double variacionPosicionDiscretaEnY;

	private final Automovil unAutomovil;

	private boolean autoAvanzoUnMetro;

	private Obstaculo obstaculoYaChocado;
	private Obstaculo obstaculoSiguiente;

	private final Pista pistaDeAutos;
	private long tiempoIncial = 0;
	private boolean yaIniciado = false;
	private long tiempoFinal;

	/*
	 * Para crearse, necesita el auto, en esta primer entrega Más tarde, habrá
	 * para elegir entre pista aleatoria y una ubicación, donde estará una pista
	 * interpretable en XML
	 */

	public Entorno(Automovil auto, Pista pista) {
		this.unAutomovil = auto;
		this.pistaDeAutos = pista;
		obstaculoSiguiente = this.pistaDeAutos.getObstaculoSiguiente();
		this.darTresSegundosPrevios();

		this.iniciarSecuencia();

	}

	private void iniciarSecuencia() {
		// cicloConstante = new Timer(diferencialDeTiempo);
		// cicloConstante.setInitialDelay(0);
		// cicloConstante.start();
	}

	/*
	 * GENTLEMEN, START YOUR ENGINES! 3...2...1..GO! es la idea de esto. No es
	 * primordial
	 */
	private void darTresSegundosPrevios() {
		// TODO Auto-generated method stub

	}

	private void actualizarPosicion() {
		unAutomovil.actualizarPosicion(DiferencialDeTiempo.horas);
		double auxPosicionX = unAutomovil.getPosicionReal().x();
		this.posicionAutoDiscretaEnX = Math.round(auxPosicionX);

		double auxPosicionY = unAutomovil.getPosicionReal().y();
		this.variacionPosicionDiscretaEnY = (Math.round(auxPosicionY) - posicionAutoDiscretaEnY);
		this.posicionAutoDiscretaEnY = (Math.round(auxPosicionY));

		if (variacionPosicionDiscretaEnY == 1) {
			autoAvanzoUnMetro = true;
		} else {
			autoAvanzoUnMetro = false;
		}

	}

	private void chequearColisiones() {

		Colisionador unColisionador = new Colisionador();

		if (unColisionador.pasoElObstaculo(obstaculoSiguiente, unAutomovil)) {
			obstaculoYaChocado = null;
			obstaculoSiguiente = pistaDeAutos.getObstaculoSiguiente();
		} else {
			if (unColisionador.coinciden(obstaculoSiguiente, unAutomovil)) {
				this.informarColision(obstaculoSiguiente);
				obstaculoYaChocado = obstaculoSiguiente;
				obstaculoSiguiente = pistaDeAutos.getObstaculoSiguiente();
			}
		}
	}

	/*
	 * PRE: sólo puede ser llamado por this.chequearColisiones()
	 */
	private void informarColision(Obstaculo obstaculoChocado) {
		if (obstaculoYaChocado != obstaculoChocado) {
			unAutomovil.desgastarPorObstaculo(obstaculoChocado);
		}
	}

	private void informarTerreno() {
		if (autoAvanzoUnMetro) {
			unAutomovil.desgastarPorTerreno(pistaDeAutos
					.getTerreno(posicionAutoDiscretaEnY));
		}
	}

	private void chequearFinDePista() throws ExcepcionPistaFinalizada {

		if (this.posicionAutoDiscretaEnY >= this.pistaDeAutos.getLargo()) {
			this.registrarTiempo();
			throw new ExcepcionPistaFinalizada();
		}
	}

	/*
	 * Con este método se registra el tiempo que tardó en correr la pista
	 */
	private void registrarTiempo() {
		// TODO Auto-generated method stub

	}

	public void setPosicionAutoDiscretaEnX(long posicionAutoDiscretaEnX) {
		this.posicionAutoDiscretaEnX = posicionAutoDiscretaEnX;
	}

	public long getPosicionAutoDiscretaEnX() {
		return posicionAutoDiscretaEnX;
	}

	public void vivir() {
		if (!yaIniciado) {
			yaIniciado = true;
			tiempoIncial = System.currentTimeMillis();
		}

		this.actualizarPosicion();
		this.chequearColisiones();
		this.informarTerreno();
		try {
			this.chequearFinDePista();
		} catch (ExcepcionPistaFinalizada e) {

			tiempoFinal = System.currentTimeMillis();

			long tiempoJugado = (tiempoFinal - tiempoIncial) / 1000;
			ControladorDeCarrera.terminarCarrera(tiempoJugado,
					this.pistaDeAutos);
		}

		if (unAutomovil.getNuematicos().dañoDiscreto() >= 100)
			ControladorDeCarrera.carreraPerdida();

	}

	public Posicion getPosicionAuto() {

		return this.unAutomovil.posicionEsquinaInferiorIzquierda();
	}

}
