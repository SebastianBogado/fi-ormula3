package modelo;

import modelo.excepciones.ExcepcionLimitesIncorrectosEnElTerreno;

public class Terreno {
	private int principio;
	private int fin;
	
	/*
	 * @param principio: l�nea donde empieza el terreno
	 * @param fin: l�nea donde termina el terreno
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
}
