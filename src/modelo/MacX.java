package modelo;

import modelo.servicio.NombresDeFabricables;

public class MacX extends Motor{
	public static final String descripcion = "<html>" + "De 0 a 80km/h en 2 segundos" + 
	"<br>" + "De 80 a 150 en 15 segundos" + "</html>";

	/** Constructor, Se define la velocidad Maxima **/
	public MacX(){
		velocidadMaxima=150.0;
	}
	
	//Metodo Sobreescrito
	protected double calcularTiempo(double velocidadInstantanea) {
		
		double tiempo=0.0;
		
		if(velocidadInstantanea >= 0 && velocidadInstantanea < 80.0-0.1){
			
			tiempo = (double)2.0 - Math.sqrt((80.0 - velocidadInstantanea)/20.0);
			
		}else if(velocidadInstantanea >= 80 - 0.1){
			
			tiempo=(15.0 / 70.0) * (velocidadInstantanea - 80.0 + 140.0 / 15.0);			
					
			if(tiempo < 2.0)
				tiempo = 2.01;
		
		}		
		
		return tiempo;
	}

	//Metodo Sobreescrito
	protected double evaluarFuncionVelocidad(double difTiempo, double tiempo) {
		
		double velocidad = 0;
		
		if(tiempo < 2.0){
					
			velocidad = -20.0 * Math.pow((tiempo + difTiempo - 2.0), 2.0) + 80.0;
			
		}else if(tiempo >= 2.0){
					
			velocidad = (double) 70.0 / 15.0 * (tiempo + difTiempo) + 80.0 - 140.0 / 15.0;
			
			if(velocidad > velocidadMaxima)
				velocidad = velocidadMaxima;
			
		}
				
		return velocidad;
	}

	//Metodo Sobreescrito
	public String motor() {
		
		return NombresDeFabricables.MACX;
	}

}
