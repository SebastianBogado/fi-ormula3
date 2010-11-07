package modelo;

public class Lin64 extends Motor{

	/*
	 * Constructor; Se define la velocidad Maxima
	 */
	public Lin64(){
		velocidadMaxima=120;
	}
	
	//Metodo Sobreescrito
	protected double calcularTiempo(double velocidadInstantanea) {
		
		double tiempo=-2*Math.log(1.0-velocidadInstantanea/velocidadMaxima);
		
		if (1/tiempo == 0)
			tiempo=100.0;
		
		return tiempo;
	}

	//Metodo Sobreescrito
	protected double evaluarFuncionVelocidad(double difTiempo, double tiempo) {
		
		double velocidad=velocidadMaxima*(1.0-Math.exp(-(tiempo+difTiempo)/2.0));
		
		return velocidad;
	}
	
	//Metodo Sobreescrito
	public String motor() {
		return "Lin64";
	}
	

}
