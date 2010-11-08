package modelo;

import java.awt.Point;

public class Automovil extends CuerpoExtenso{
	private Motor motor=null;
	private Neumatico neumaticos=null;
	private Velocidad velocidadInstantanea;
	
	/*
	 * Constructor; Son recibidos como parametros los tipos Motor y Neumaticos que
	 * que debe tener el auto
	 */	
	public Automovil(int tipoMotor,int tipoNeumatico){
		
		this.motor=Motor.NuevoMotorDeTipo(tipoMotor);
		this.neumaticos=Neumatico.NuevoNeumatico(tipoNeumatico);
		this.velocidadInstantanea = new Velocidad(0, 0);
		this.ancho = 1;
		this.largo = 2;
		this.posicionEsquinaSuperiorIzquierda = new Point(0,0);
	}
	
	
	/*
	 * Produce una aumento de la velocidad en un diferencial de Tiempo (grande o pequeño)
	 * 
	 */	
	public void acelerar(double difTiempo){
		
		if(velocidadInstantanea.y() < motor.VelocidadMaxima()){
		
			velocidadInstantanea.setY(motor.acelerar(difTiempo,velocidadInstantanea.y())
			-motor.VelocidadMaxima()*neumaticos.daño());
		
		}
		
	}
	
	/*
	 * Produce una disminucion de la velocidad en un diferencial de Tiempo (grande o pequeño)
	 */	
	public void frenar(double difTiempo){
		
		velocidadInstantanea.setY(velocidadInstantanea.y() + motor.frenar(difTiempo));
		
		if (velocidadInstantanea.y()<0)
			velocidadInstantanea.setY(0);
	}
	
	
	/*
	 * Devuelve la velocidad instantanea del auto 
	 */	
	public Velocidad velocidad() {
		
		return velocidadInstantanea;
	}
	
	
	/*
	 * Devuelve de que tipo es el motor
	 */
	public String motor() {
		
		return motor.motor();
	}
	

}
