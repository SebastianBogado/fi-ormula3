package modelo;

import org.jdom.Element;

import modelo.excepciones.ExcepcionLimitesIncorrectosEnElTerreno;

public abstract class Terreno {
	protected int principio;
	protected int fin;
	
	
	public Terreno(){
		
	}
	/*
	 * @param principio: línea donde empieza el terreno
	 * @param fin: línea donde termina el terreno
	 */
	public Terreno(int principio, int fin) throws ExcepcionLimitesIncorrectosEnElTerreno{
		if (fin < principio) { throw new ExcepcionLimitesIncorrectosEnElTerreno(); }
		this.fin = fin;
		this.principio = principio;
	}
	
	public int fin(){
		return this.fin;
	}
	
	public int principio(){
		return this.principio;
	}

	public abstract double desgastar(Neumaticos neumaticos);

	public abstract Element serializarXML();
}
