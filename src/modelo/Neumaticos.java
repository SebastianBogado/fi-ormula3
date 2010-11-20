package modelo;

import modelo.servicio.Autoparte;
import modelo.servicio.Velocidad;

abstract public class Neumaticos implements Autoparte{

	private double daño = 0;

	protected void aumentarDaño(double difDaño) {
		if (this.daño <= 100 && difDaño <= 100) {
			this.daño += difDaño;
		}
	}

	/*
	 * Devuelve el daño en que se encuentra el neumatico porcentualmente (0-100)
	 */
	public double daño() {
		return daño / 100.0;
	}

	/*
	 * Devuelve una instancia de alguna clase Derivada de Neumatico segun en el
	 * parametro recibido
	 */
	public static Neumaticos NuevoNeumatico(int tipoNeumatico) {

		Neumaticos cubiertas = null;

		switch (tipoNeumatico) {
		case 1:
			cubiertas = new Mess10();
			break;
		case 2:
			cubiertas = new Paler9();
			break;
		default:
			cubiertas = new Mess10();

		}

		return cubiertas;
	}

	/*
	 * Cálculo del desgaste POR METRO. Depende de velocidad *
	 * constanteDeDesgasteDelTerreno
	 */
	public void desgastarPorTerreno(Terreno terreno,
			Velocidad velocidadInstantanea) {
		double difDaño = velocidadInstantanea.rapidez() / 1000.0; // cálculo por
		// metro
		double constanteDeDesgasteDelTerreno = terreno.desgastar(this);
		this.aumentarDaño(difDaño * constanteDeDesgasteDelTerreno);
	}

	/*
	 * Si pasamos por los obstaculos a 30km/h o menos no desgastan las ruedas
	 */
	public void desgastarPorObstaculo(Obstaculo obstaculo,
			Velocidad velocidadInstantanea) {
		if (velocidadInstantanea.rapidez() > 30) {
			double difDaño = obstaculo.chocarCon(this);
			this.aumentarDaño(difDaño);
		}
	}

	abstract public String tipo();

	/*
	 * los siguientes métodos devuelven el desgaste al chocar con lomas de burro
	 * o pozos
	 */
	public abstract double chocarConLomaDeBurro();

	abstract public double chocarConPozo();

	/*
	 * los siguientes métodos devuelven el desgaste producido por los distintos
	 * tipos de terrenos
	 */
	public abstract double desgastePorTierra();

	public abstract double desgastePorRipio();

	public abstract double desgastePorAsfalto();

}