package modelo;

import modelo.excepciones.ExcepcionObstaculoInvalido;
import modelo.excepciones.ExcepcionTerrenoInvalido;

public class Mess10 extends Neumatico{

	@Override
	/*
	 * Daño por kilómetro:
	 * -asfalto: 0%
	 * -ripo: velocidad/100
	 * -tierra: velocidad/80
	 */
	public void desgastarPorTerreno(Terreno terreno, Velocidad velocidadInstantanea) 
				throws ExcepcionTerrenoInvalido {
		double difDaño = velocidadInstantanea.rapidez() / 1000.0; //cálculo por metro

		if (terreno instanceof Ripio){
			difDaño /= 100.0;
		}
		else{
			if (terreno instanceof Tierra){
				difDaño /= 70.0;
			}
			else{
				if (terreno instanceof Asfalto){
					difDaño = 0;
				}
				else{ throw new ExcepcionTerrenoInvalido(); }
			}
		}
		
		this.aumentarDaño(difDaño);	
	}

	@Override
	public void desgastarPorObstaculo(Obstaculo obstaculo) throws ExcepcionObstaculoInvalido {
		double difDaño;
		if (obstaculo instanceof LomaDeBurro){
			difDaño = 10;
			this.aumentarDaño(difDaño);
		}
		else{
			if (obstaculo instanceof Pozo){
				difDaño = 5;
				this.aumentarDaño(difDaño);
			}
			else{ throw new ExcepcionObstaculoInvalido(); }
			}
	}		
}


