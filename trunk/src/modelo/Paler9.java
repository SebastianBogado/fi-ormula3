package modelo;

public class Paler9 extends Neumatico{

	@Override
	public void desgastarPorTerreno(Terreno terreno, Velocidad velocidadInstantanea) {
		// daño: 2% cada 3km
		double difDaño = (2.0/3000.0);
		this.aumentarDaño(difDaño);		
	}

	@Override
	public void desgastarPorObstaculo(Obstaculo obstaculo) {
		double difDaño = 6;
		this.aumentarDaño(difDaño);
		
	}

}
