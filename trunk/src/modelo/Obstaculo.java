package modelo;

import java.awt.Point;

public abstract class Obstaculo extends CuerpoExtenso{
	public Obstaculo(int posicionX, int posicionY){
		this.largo = 1;
		this.posicionEsquinaSuperiorIzquierda = new Point(posicionX, posicionY);
	}

}
