package modelo;

public class Paler9 extends Neumatico{

	@Override
	public void desgastarPorTerreno(Terreno terreno, Velocidad velocidadInstantanea) {
		// da�o: 2% cada 3km
		double difDa�o = (2.0/3000.0);
		this.aumentarDa�o(difDa�o);		
	}

	@Override
	public void desgastarPorObstaculo(Obstaculo obstaculo) {
		double difDa�o = 6;
		this.aumentarDa�o(difDa�o);
		
	}

}
