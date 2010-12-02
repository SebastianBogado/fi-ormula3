package modelo.servicio;

import modelo.Automovil;
import modelo.Motor;
import modelo.Neumaticos;

public class FabricaDeAutos {


	private FabricaDeAutos(){super();}
	
	static private FabricaDeAutos instancia = new FabricaDeAutos();
	private static FabricaAbstractaDeMotores fabricaDeMotores = new FabricaAbstractaDeMotores();
	private static FabricaAbstractaDeNeumaticos fabricaDeRuedas = new FabricaAbstractaDeNeumaticos();
	
		
	static public Automovil instanciarAuto(MetadataAuto metaAuto){
		Motor motor = fabricaDeMotores.instanciarMotor(metaAuto.getMotor());
		Neumaticos ruedas = fabricaDeRuedas.instanciarRuedas(metaAuto.getRuedas());
		return new Automovil(motor, ruedas);
	}

}
