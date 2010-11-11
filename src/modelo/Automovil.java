package modelo;

public class Automovil extends CuerpoExtenso{
	private Motor motor=null;
	private Neumatico neumaticos=null;
	private Velocidad velocidadInstantanea;
	private static int ANCHO = 1;
	private static int LARGO = 2;
	
	/*
	 * Constructor; Son recibidos como parametros los tipos Motor y Neumaticos que
	 * que debe tener el auto
	 */	
	public Automovil(int tipoMotor,int tipoNeumatico){
		
		this.motor=Motor.NuevoMotorDeTipo(tipoMotor);
		this.neumaticos=Neumatico.NuevoNeumatico(tipoNeumatico);
		this.velocidadInstantanea = new Velocidad(0, 0);
		this.ancho = Automovil.ANCHO;
		this.largo = Automovil.LARGO;
		this.posicionEsquinaInferiorIzquierda = new Posicion(0,0);
	}
	
	/* 
	 * actualiza la posición en base a un diferencial de tiempo
	 */
	public void actualizarPosicion(double difTiempoEnHoras){
		this.posicionEsquinaInferiorIzquierda.mover(this.velocidadInstantanea.variacionDePosicionEnMetros(difTiempoEnHoras));
	}
	
	public Posicion getPosicionReal(){
		return this.posicionEsquinaInferiorIzquierda;
	}
	
	public void desgastarPorObstaculo(Obstaculo obstaculo){
		this.neumaticos.desgastarPorObstaculo(obstaculo, this.velocidadInstantanea);
	}
	
	public void desgastarPorTerreno(Terreno terrenoActual){
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
	
	public Velocidad getVelocidadInstantanea(){
		return this.velocidadInstantanea;
	}

}
