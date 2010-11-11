package modelo;

public class Paler9 extends Neumatico {

	@Override
	public void desgastarPorTerreno(Terreno terreno,
			Velocidad velocidadInstantanea) {
		// daño: 2% cada 3km
		double difDaño = (2.0 / 3000.0);
		this.aumentarDaño(difDaño);
	}

	@Override
	public double chocarConLomaDeBurro() {
		return 6.0;
	}

	@Override
	public double chocarConPozo() {
		return 6.0;
	}

	@Override
	public double desgastePorTierra() {
		return 2.0 / 3000.0;
	}

	@Override
	public double desgastePorRipio() {
		return 2.0 / 3000.0;
	}

	@Override
	public double desgastePorAsfalto() {
		return 2.0 / 3000.0;
	}

	@Override
	public String tipo() {
		return "Paler9";
	}

}
