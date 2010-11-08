package modelo;

public abstract class Obstaculo extends CuerpoExtenso{
	public Obstaculo(int posicionX, int posicionY){
		this.largo = 1;
		this.posicionEsquinaInferiorIzquierda = new Posicion(posicionX, posicionY);
	}

}
