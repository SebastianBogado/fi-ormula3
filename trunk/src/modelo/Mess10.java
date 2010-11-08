package modelo;

import modelo.excepciones.ExcepcionObstaculoInvalido;
import modelo.excepciones.ExcepcionTerrenoInvalido;

public class Mess10 extends Neumatico{

	@Override
	/*
	 * Da�o por kil�metro:
	 * -asfalto: 0%
	 * -ripo: velocidad/100
	 * -tierra: velocidad/80
	 */
	public void desgastarPorTerreno(Terreno terreno, Velocidad velocidadInstantanea) 
				throws ExcepcionTerrenoInvalido {
		double difDa�o = velocidadInstantanea.rapidez() / 1000.0; //c�lculo por metro

		if (terreno instanceof Ripio){
			difDa�o /= 100.0;
		}
		else{
			if (terreno instanceof Tierra){
				difDa�o /= 70.0;
			}
			else{
				if (terreno instanceof Asfalto){
					difDa�o = 0;
				}
				else{ throw new ExcepcionTerrenoInvalido(); }
			}
		}
		
		this.aumentarDa�o(difDa�o);	
	}

	@Override
	public void desgastarPorObstaculo(Obstaculo obstaculo) throws ExcepcionObstaculoInvalido {
		double difDa�o;
		if (obstaculo instanceof LomaDeBurro){
			difDa�o = 10;
			this.aumentarDa�o(difDa�o);
		}
		else{
			if (obstaculo instanceof Pozo){
				difDa�o = 5;
				this.aumentarDa�o(difDa�o);
			}
			else{ throw new ExcepcionObstaculoInvalido(); }
			}
	}		
}


