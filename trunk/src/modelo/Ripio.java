package modelo;

import modelo.excepciones.ExcepcionLimitesIncorrectosEnElTerreno;

public class Ripio extends Terreno {

	public Ripio(int principio, int fin) throws ExcepcionLimitesIncorrectosEnElTerreno {
		super(principio, fin);
	}

}
