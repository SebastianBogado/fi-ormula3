package modelo;

import java.awt.Point;

public class Velocidad {
	private Point velocidad;
	
	public Velocidad(double x, double y){
		velocidad.setLocation(x, y);
	}
	public double x(){
		return velocidad.getX();
	}
	public double y(){
		return velocidad.getY();
	}
	public void setX(double x){
		velocidad.setLocation(x, velocidad.getY());
	}
	public void setY(double y){
		velocidad.setLocation(velocidad.getX(), y);
	}
}
