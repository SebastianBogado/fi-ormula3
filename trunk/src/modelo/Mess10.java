package modelo;

import modelo.servicio.NombresDeFabricables;

public class Mess10 extends Neumaticos {
	public static final String descripcion = "Asfalto: no hay desgaste; ripio: velocidad/100; tierra: velocidad/70. Pozo daña 5%; loma de burro: 10%";
	
	private static class Desgaste{
		public static double lomaDeBurro = 10.0;
		public static double pozo = 5.0;
		public static double tierra = 1.0 / 70.0;
		public static double ripio = 1.0 / 100.0;
		public static double asfalto = 0;
	}

	@Override
	public double chocarConLomaDeBurro() {
		return Desgaste.lomaDeBurro;
	}

	@Override
	public double chocarConPozo() {
		return Desgaste.pozo;
	}

	@Override
	public double desgastePorTierra() {
		return Desgaste.tierra;
	}

	@Override
	public double desgastePorRipio() {
		return Desgaste.ripio;
	}

	@Override
	public double desgastePorAsfalto() {
		return Desgaste.asfalto;
	}

	@Override
	public String neumaticos() {
		return NombresDeFabricables.MESS10;
	}

}