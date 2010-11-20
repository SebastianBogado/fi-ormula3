package modelo.servicio;


abstract public class CuerpoExtenso {
	protected int ancho; // ancho es en x
	protected int largo; // largo es en y
	protected Posicion posicionEsquinaInferiorIzquierda;
	
	public int getAncho(){ return this.ancho; }
	public int getLargo(){ return this.largo; }

	public Posicion posicionEsquinaInferiorIzquierda(){
		return this.posicionEsquinaInferiorIzquierda;
	}
}
