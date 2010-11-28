package modelo;

import modelo.servicio.CuerpoExtenso;
import modelo.servicio.Posicion;

public abstract class Obstaculo extends CuerpoExtenso{
	
	public Obstaculo(){
		this.largo = 1;
		this.posicionEsquinaInferiorIzquierda = new Posicion();
	}
	
	public Obstaculo(int posicionX, int posicionY){
		this.largo = 1;
		this.posicionEsquinaInferiorIzquierda = new Posicion(posicionX, posicionY);
	}
	
	
	
	abstract public double chocarCon(Neumaticos neumaticos);
}
