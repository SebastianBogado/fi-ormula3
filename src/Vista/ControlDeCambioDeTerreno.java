package Vista;

import modelo.Pista;
import modelo.Terreno;

public class ControlDeCambioDeTerreno {

	private final Pista pista;
	private String proximoTerreno = null;

	public ControlDeCambioDeTerreno(Pista unaPista) {

		this.pista = unaPista;

	}

	public String primerTerreno() {

		Terreno terreno = pista.getTerreno(1);

		return terreno.tipoTerreno();
	}

	// Defino que 10 pixeles representa un 1 metro de distancia

	public boolean cambiarTerrno(int cantFranjasPintadas) {

		Terreno t1, t2;
		t1 = this.pista.getTerreno((cantFranjasPintadas + 1) * 645 / 10);
		t2 = this.pista.getTerreno((cantFranjasPintadas) * 645 / 10);

		this.proximoTerreno = t1.tipoTerreno();
		return !(t1 == t2);
	}

	public String proximoTerreno() {
		return this.proximoTerreno;
	}

}
