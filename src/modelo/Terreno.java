package modelo;

import modelo.excepciones.ExcepcionLimitesIncorrectosEnElTerreno;

import org.jdom.Element;

public abstract class Terreno {

	public static String Ripio = "Ripio";
	public static String Asfalto = "Asfalto";
	public static String Tierra = "Tierra";

	protected int principio;
	protected int fin;

	public Terreno() {

	}

	/** @param principio: línea donde empieza el terreno
	    @param fin: línea donde termina el terreno **/
	public Terreno(int principio, int fin)
			throws ExcepcionLimitesIncorrectosEnElTerreno {
		if (fin < principio) {
			throw new ExcepcionLimitesIncorrectosEnElTerreno();
		}
		this.fin = fin;
		this.principio = principio;
	}

	public int fin() {
		return this.fin;
	}

	public int principio() {
		return this.principio;
	}

	public abstract double desgastar(Neumaticos neumaticos);

	public abstract Element serializarXML();

	public abstract String tipoTerreno();
}
