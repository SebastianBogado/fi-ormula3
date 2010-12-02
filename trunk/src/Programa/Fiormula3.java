package Programa;

import modelo.Automovil;
import modelo.Pista;
import modelo.servicio.FabricaDeAutos;
import modelo.servicio.MetadataAuto;
import Control.ControladorDeCarrera;
import Vista.MenuPrincipal;

public class Fiormula3 {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		//new MenuPrincipal();
		
		MetadataAuto metaAuto = new MetadataAuto("Mess10",
				"Lin64");
		Automovil auto = FabricaDeAutos.instanciarAuto(metaAuto);
		Pista pista = new Pista("C:/Users/seba/workspace/fi-ormula3/pistas/Default.xml");

		new ControladorDeCarrera(auto, pista);
	}

}
