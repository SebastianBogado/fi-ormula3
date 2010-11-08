package modelo;

abstract public class CuerpoExtenso {
	protected int ancho; // ancho es en x
	protected int largo; // largo es en y
	protected Posicion posicionEsquinaSuperiorIzquierda;
	
	public int getAncho(){ return this.ancho; }
	public int getLargo(){ return this.largo; }

	public Posicion getPosicionEsquinaSuperiorIzquierda(){
		return this.posicionEsquinaSuperiorIzquierda;
	}
}
