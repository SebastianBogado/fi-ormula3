package modelo;

import modelo.excepciones.ExcepcionLimitesIncorrectosEnElTerreno;

public class Asfalto extends Terreno {

	public Asfalto(int principio, int fin) throws ExcepcionLimitesIncorrectosEnElTerreno {
		super(principio, fin);
	}

	@Override
	public double desgastar(Neumatico neumaticos) {
		return neumaticos.desgastePorAsfalto();
	}

}
