package modelo;

public class Mess10 extends Neumaticos {

	@Override
	public double chocarConLomaDeBurro() {
		return 10.0;
	}

	@Override
	public double chocarConPozo() {
		return 5.0;
	}

	@Override
	public double desgastePorTierra() {
		return 1.0 / 70.0;
	}

	@Override
	public double desgastePorRipio() {
		return 1.0 / 100.0;
	}

	@Override
	public double desgastePorAsfalto() {
		return 0;
	}

	@Override
	public String tipo() {
		return "Mess10";
	}
}
