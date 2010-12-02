package modelo;

import modelo.servicio.Autoparte;

abstract public class Motor implements Autoparte {
	
	protected double velocidadMaxima;
		
	public Motor(){
		
	}
	
	/*
	 * Devuelve la velocidad maxima que puede alcanzar el motor
	 */
	public double VelocidadMaxima() {
		return velocidadMaxima;
	}
	
	
	/*
	 * Devuelve la nueva velocidad que tendria el auto cuando fue acelerado un diferencial
	 * de tiempo,estando anteriormente con una cierta velocidad instantanea 
	 */
	public double acelerar(double difTiempo, double velocidadInstantanea) {
		
		double velocidadFinal=0.0;
		double tiempo=this.calcularTiempo(velocidadInstantanea);
		velocidadFinal=this.evaluarFuncionVelocidad(difTiempo,tiempo);				
		return velocidadFinal;
	}
	
	/*
	 * Devuele la velocidad que tiene que disminuir el auto en un diferencial de Tiempo
	 */
	public double frenar(double difTiempo){
		double velocidadDisminuida=-difTiempo*25;
		return velocidadDisminuida;
	}
	
	/*
	 *Calcula la nueva velocidad en funcion del el tiempo mas un
	 *diferencial de tiempo y la velocidad actual
	 */
	abstract protected double evaluarFuncionVelocidad(double difTiempo, double tiempo);
	
	/*
	 * Calcula el tiempo en que tomaria llegar a la velocidad recibida acelerando
	 */
	abstract protected double calcularTiempo(double velocidadInstantanea);
	
	/*
	 * Devuelve el tipo de motor en un String
	 */	
	abstract public String motor();


}
