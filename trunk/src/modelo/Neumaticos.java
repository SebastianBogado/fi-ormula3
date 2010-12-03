package modelo;

import modelo.servicio.Autoparte;
import modelo.servicio.Velocidad;

abstract public class Neumaticos implements Autoparte {

	private double da�o = 0;
	private static int velocidadParaQueNoSeDa�en = 30;

	protected void aumentarDa�o(double difDa�o) {
		if (this.da�o <= 100) {
			this.da�o += difDa�o;
		}
		if (this.da�o > 100) {
			this.da�o = 100;
		}
	}

	/** Devuelve el da�o en que se encuentra el neumatico porcentualmente (0-100) **/
	public double da�oPorcentual() {
		return (da�o / 100.0);
	}

	public double da�oDiscreto() {
		return this.da�o;
	}

	/** C�lculo del desgaste POR METRO. Depende de velocidad *
	  constanteDeDesgasteDelTerreno **/
	public void desgastarPorTerreno(Terreno terreno,
			Velocidad velocidadInstantanea) {
		if (da�o >= 100) {
			velocidadInstantanea.y(0);
		}

		double difDa�o = velocidadInstantanea.rapidez() / 1000.0; // c�lculo por
		// metro
		double constanteDeDesgasteDelTerreno = terreno.desgastar(this);
		this.aumentarDa�o(difDa�o * constanteDeDesgasteDelTerreno);

	}

	/** Si pasamos por los obstaculos a 30km/h o menos no desgastan las ruedas **/
	public void desgastarPorObstaculo(Obstaculo obstaculo,
			Velocidad velocidadInstantanea) {
		if (velocidadInstantanea.rapidez() > velocidadParaQueNoSeDa�en) {
			double difDa�o = obstaculo.chocarCon(this);
			this.aumentarDa�o(difDa�o);
		}
	}

	abstract public String neumaticos();

	/** los siguientes m�todos devuelven el desgaste al chocar con lomas de burro
	 *  o pozos **/
	public abstract double chocarConLomaDeBurro();

	abstract public double chocarConPozo();

	/** los siguientes m�todos devuelven el desgaste producido por los distintos
	tipos de terrenos **/
	public abstract double desgastePorTierra();

	public abstract double desgastePorRipio();

	public abstract double desgastePorAsfalto();

}