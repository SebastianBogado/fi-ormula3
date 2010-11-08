package modelo;

public class Mess10 extends Neumatico{

	@Override
	/*
	 * Da�o por kil�metro:
	 * -asfalto: 0%
	 * -ripo: velocidad/100
	 * -tierra: velocidad/80
	 */
	public void desgastarPorTerreno(Terreno terreno, Velocidad velocidadInstantanea) {
		double difDa�o = velocidadInstantanea.rapidez() / 1000.0; //c�lculo por metro

		if (terreno instanceof Ripio){
			difDa�o /= 100.0;
		}
		else{
			if (terreno instanceof Tierra){
				difDa�o /= 70.0;
			}
			else{
				difDa�o = 0;
			}
		}
		
		this.aumentarDa�o(difDa�o);	
	}

	@Override
	public void desgastarPorObstaculo(Obstaculo obstaculo) {
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
		}		
	}

}
