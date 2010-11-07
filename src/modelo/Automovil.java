package modelo;

public class Automovil {
	private Motor motor=null;
	private Neumatico neumaticos=null;
	private double velocidadInstantanea=0;
	
	/*
	 * Constructor; Son recibidos como parametros los tipos Motor y Neumaticos que
	 * que debe tener el auto
	 */	
	public Automovil(int tipoMotor,int tipoNeumatico){
		
		motor=Motor.NuevoMotorDeTipo(tipoMotor);
		neumaticos=Neumatico.NuevoNeumatico(tipoNeumatico);
		
	}
	
	/*
	 * Produce una aumento de la veloicdad en un diferencial de Tiempo (grande o pequeño)
	 * 
	 */	
	public void acelerar(double difTiempo){
		
		if(velocidadInstantanea<motor.VelocidadMaxima()){
		
			velocidadInstantanea=motor.acelerar(difTiempo,velocidadInstantanea)
			-motor.VelocidadMaxima()*neumaticos.daño();
		
		}
		
	}
	
	/*
	 * Produce una disminucion de la velocidad en un diferencial de Tiempo (grande o pequeño)
	 */	
	public void frenar(double difTiempo){
		
		velocidadInstantanea=velocidadInstantanea+motor.frenar(difTiempo);
		
		if (velocidadInstantanea<0)
			velocidadInstantanea=0;
	}
	
	
	/*
	 * Devuelve la velocidad instantanea del auto 
	 */	
	public double velocidad() {
		
		return velocidadInstantanea;
	}
	
	
	/*
	 * Devuelve de que tipo es el motor
	 */
	public String motor() {
		
		return motor.motor();
	}
	

}
