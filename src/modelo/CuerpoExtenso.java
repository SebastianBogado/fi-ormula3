package modelo;

import java.awt.Point;

abstract public class CuerpoExtenso {
	protected int ancho;
	protected int largo;
	protected Point posicionEsquinaSuperiorIzquierda;
	
	public int getAncho(){ return this.ancho; }
	public int getLargo(){ return this.largo; }
	public Point getPosicionEsquinaSuperiorIzquierda(){
		return this.posicionEsquinaSuperiorIzquierda;
	}
}
