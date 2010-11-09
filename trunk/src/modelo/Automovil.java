package modelo;

import modelo.excepciones.ExcepcionObstaculoInvalido;
import modelo.excepciones.ExcepcionTerrenoInvalido;

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
		this.posicionEsquinaInferiorIzquierda = new Posicion(0,0);
	}
	
	/* 
	 * actualiza la posición en base a un diferencial de tiempo
	 */
	public void actualizarPosicion(double difTiempo){
		this.posicionEsquinaInferiorIzquierda.mover(this.velocidadInstantanea.variacionDePosicion(difTiempo));
	}
	
	public Posicion getPosicionReal(){
		return this.posicionEsquinaInferiorIzquierda;
	}
	
	public void desgastarPorObstaculo(Obstaculo obstaculo) throws ExcepcionObstaculoInvalido{
		this.neumaticos.desgastarPorObstaculo(obstaculo);
	}
	
	public void desgastarPorTerreno(Terreno terrenoActual) throws ExcepcionTerrenoInvalido{
		this.neumaticos.desgastarPorTerreno(terrenoActual, this.velocidadInstantanea);
	}
	
	/*
	 * Produce una aumento de la velocidad en un diferencial de Tiempo (grande o pequeño)
	 * 
	 */	
	public void acelerar(double difTiempo){
		
		if(velocidadInstantanea.y() < motor.VelocidadMaxima()){
		
			velocidadInstantanea.y(motor.acelerar(difTiempo,velocidadInstantanea.y())
			-motor.VelocidadMaxima()*neumaticos.daño());
		
		}
		
	}
	
	/*
	 * Produce una disminucion de la velocidad en un diferencial de Tiempo (grande o pequeño)
	 */	
	public void frenar(double difTiempo){
		
		velocidadInstantanea.y(velocidadInstantanea.y() + motor.frenar(difTiempo));
		
		if (velocidadInstantanea.y()<0)
			velocidadInstantanea.y(0);
	}
	
	public void doblarALaIzquierda(){
		//TODO
	}
	
	public void doblarALaDerecha(){
		//TODO
	}
	
	/*
	 * Devuelve de que tipo es el motor
	 */
	public String motor() {
		
		return motor.motor();
	}
	

}
