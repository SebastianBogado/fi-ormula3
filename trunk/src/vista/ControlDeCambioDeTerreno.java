package Vista;

import java.util.Iterator;
import java.util.LinkedList;

import modelo.Pista;
import modelo.Terreno;

public class ControlDeCambioDeTerreno {

	private final Pista pista;
	private String proximoTerreno = null;
	private String terrenoActual = null;
	private final LinkedList<Terreno> terrenos;

	public ControlDeCambioDeTerreno(Pista unaPista) {

		this.pista = unaPista;
		this.terrenos = pista.getListaDeTerrenos();
	}

	public String primerTerreno() {

		Iterator<Terreno> it = this.terrenos.iterator();

		boolean encontrado = false;

		while (it.hasNext() && !encontrado) {

			Terreno terreno = it.next();

			if (terreno.principio() == 1 || terreno.principio() == 0) {
				encontrado = true;
				terrenoActual = terreno.tipoTerreno();
			}
		}
		
		System.out.println(terrenoActual);
		return terrenoActual;
	}

	// Defino que 10 pixeles representa un 1 metro de distancia
	public boolean cambiarTerrno(int cantFranjasPintadas) {

		Terreno t;

		Iterator<Terreno> it = this.terrenos.iterator();

		boolean encontrado = false;
		long recorrido = (cantFranjasPintadas) * 600 / 10;

		while (it.hasNext() && !encontrado) {
		
			t = it.next();
			
			if (t.principio() <= recorrido && t.fin() >= recorrido) {
				encontrado = true;
				proximoTerreno = t.tipoTerreno();
			}
		}
		return !(terrenoActual == proximoTerreno);
	}

	public String proximoTerreno() {
		return this.proximoTerreno;
	}

	public boolean finDePista(int cantDeFranjas) {

		boolean resultado = false;
		long largoDePista = pista.getLargo();

		resultado = (cantDeFranjas + 1) * 645 >= largoDePista;

		return resultado;
	}
}
