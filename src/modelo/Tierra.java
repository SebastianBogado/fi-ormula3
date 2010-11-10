package modelo;

import modelo.excepciones.ExcepcionLimitesIncorrectosEnElTerreno;

public class Tierra extends Terreno {

	public Tierra(int principio, int fin) throws ExcepcionLimitesIncorrectosEnElTerreno {
		super(principio, fin);
	}

	@Override
	public double desgastar(Neumatico neumaticos) {
		return neumaticos.desgastePorTierra();
	}

}
