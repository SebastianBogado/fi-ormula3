package modelo;

import modelo.servicio.Autoparte;
import modelo.servicio.Velocidad;

abstract public class Neumaticos implements Autoparte {

	private double daño = 0;
	private static int velocidadParaQueNoSeDañen = 30;

	protected void aumentarDaño(double difDaño) {
		if (this.daño <= 100) {
			this.daño += difDaño;
		}
		if (this.daño > 100) {
			this.daño = 100;
		}
	}

	/** Devuelve el daño en que se encuentra el neumatico porcentualmente (0-100) **/
	public double dañoPorcentual() {
		return (daño / 100.0);
	}

	public double dañoDiscreto() {
		return this.daño;
	}

	/** Cálculo del desgaste POR METRO. Depende de velocidad *
	  constanteDeDesgasteDelTerreno **/
	public void desgastarPorTerreno(Terreno terreno,
			Velocidad velocidadInstantanea) {
		if (daño >= 100) {
			velocidadInstantanea.y(0);
		}

		double difDaño = velocidadInstantanea.rapidez() / 1000.0; // cálculo por
		// metro
		double constanteDeDesgasteDelTerreno = terreno.desgastar(this);
		this.aumentarDaño(difDaño * constanteDeDesgasteDelTerreno);

	}

	/** Si pasamos por los obstaculos a 30km/h o menos no desgastan las ruedas **/
	public void desgastarPorObstaculo(Obstaculo obstaculo,
			Velocidad velocidadInstantanea) {
		if (velocidadInstantanea.rapidez() > velocidadParaQueNoSeDañen) {
			double difDaño = obstaculo.chocarCon(this);
			this.aumentarDaño(difDaño);
		}
	}

	abstract public String neumaticos();

	/** los siguientes métodos devuelven el desgaste al chocar con lomas de burro
	 *  o pozos **/
	public abstract double chocarConLomaDeBurro();

	abstract public double chocarConPozo();

	/** los siguientes métodos devuelven el desgaste producido por los distintos
	tipos de terrenos **/
	public abstract double desgastePorTierra();

	public abstract double desgastePorRipio();

	public abstract double desgastePorAsfalto();

}