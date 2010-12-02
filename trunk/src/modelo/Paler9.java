package modelo;

import modelo.servicio.NombresDeFabricables;
import modelo.servicio.Velocidad;

public class Paler9 extends Neumaticos {
	public static final String descripcion = "Desgaste: 2% cada 3km; 6% por obstáculo";
	
	private static class Desgaste{
		public static double obstaculo = 6.0;
		public static double terreno = 2.0 / 3000.0;
	}

	@Override
	public void desgastarPorTerreno(Terreno terreno,
			Velocidad velocidadInstantanea) {
		// daño: 2% cada 3km
		double difDaño = (Desgaste.terreno);
		this.aumentarDaño(difDaño);
	}

	@Override
	public double chocarConLomaDeBurro() {
		return Desgaste.obstaculo;
	}

	@Override
	public double chocarConPozo() {
		return Desgaste.obstaculo;
	}

	@Override
	public double desgastePorTierra() {
		return Desgaste.terreno;
	}

	@Override
	public double desgastePorRipio() {
		return Desgaste.terreno;
	}

	@Override
	public double desgastePorAsfalto() {
		return Desgaste.terreno;
	}

	@Override
	public String neumaticos() {
		return NombresDeFabricables.PALER9;
	}

}
