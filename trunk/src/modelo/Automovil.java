package modelo;

import modelo.servicio.CuerpoExtenso;
import modelo.servicio.Posicion;
import modelo.servicio.Velocidad;

public class Automovil extends CuerpoExtenso {
	private Motor motor = null;
	private Neumaticos neumaticos = null;
	private final Velocidad velocidadInstantanea;
	private static int ANCHO = 1;
	private static int LARGO = 2;

	public Automovil(Motor motor, Neumaticos ruedas) {
		this.motor = motor;
		this.neumaticos = ruedas;
		this.velocidadInstantanea = new Velocidad(0, 0);
		this.ancho = Automovil.ANCHO;
		this.largo = Automovil.LARGO;
		this.posicionEsquinaInferiorIzquierda = new Posicion(0, 0);
	}

	/*
	 * actualiza la posición en base a un diferencial de tiempo
	 */
	public void actualizarPosicion(double difTiempoEnHoras) {
		this.posicionEsquinaInferiorIzquierda.mover(this.velocidadInstantanea
				.variacionDePosicionEnMetros(difTiempoEnHoras));
		if (this.velocidadInstantanea.x() != 0) {
			this.dejarDeDoblar();
		}
	}

	private void dejarDeDoblar() {
		this.velocidadInstantanea.x(0.0);
	}

	public Posicion getPosicionReal() {
		return this.posicionEsquinaInferiorIzquierda;
	}

	public void desgastarPorObstaculo(Obstaculo obstaculo) {
		this.neumaticos.desgastarPorObstaculo(obstaculo,
				this.velocidadInstantanea);
	}

	public void desgastarPorTerreno(Terreno terrenoActual) {
		this.neumaticos.desgastarPorTerreno(terrenoActual,
				this.velocidadInstantanea);
	}

	/*
	 * Produce una aumento de la velocidad en un diferencial de Tiempo (grande o
	 * pequeño)
	 */
	public void acelerar(double difTiempo) {

		if (velocidadInstantanea.y() < motor.VelocidadMaxima()) {

			velocidadInstantanea.y(motor.acelerar(difTiempo,
					velocidadInstantanea.y())
					- motor.VelocidadMaxima() * neumaticos.dañoPorcentual());

		}

	}

	/*
	 * Produce una disminucion de la velocidad en un diferencial de Tiempo
	 * (grande o pequeño)
	 */
	public void frenar(double difTiempo) {

		velocidadInstantanea.y(velocidadInstantanea.y()
				+ motor.frenar(difTiempo));

		if (velocidadInstantanea.y() < 0)
			velocidadInstantanea.y(0);
	}

	/*
	 * 100km/h hacia la dirección a doblar para que doble en un dt = 36ms. Luego
	 * de doblar, se vuelve a cero la velocidad en X (desde otro método)
	 */
	public void doblarALaIzquierda() {
		double velocidadX = -100.0;
		this.velocidadInstantanea.x(velocidadX);
	}

	public void doblarALaDerecha() {
		double velocidadX = 100.0;
		this.velocidadInstantanea.x(velocidadX);
	}

	/*
	 * Devuelve de que tipo es el motor
	 */
	public String motor() {

		return motor.motor();
	}
	
	public String neumaticos(){
		return neumaticos.neumaticos();
	}
	
	public Velocidad getVelocidadInstantanea() {

		return this.velocidadInstantanea;
	}

	public Neumaticos getNuematicos() {
		// TODO Auto-generated method stub
		return this.neumaticos;
	}

}
