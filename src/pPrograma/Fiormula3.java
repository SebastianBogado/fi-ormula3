package pPrograma;

import vVista.MenuPrincipal;
import cControl.ControladorDeCarrera;
import modelo.Automovil;
import modelo.Pista;
import modelo.servicio.FabricaDeAutos;
import modelo.servicio.MetadataAuto;

public class Fiormula3 {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		//new MenuPrincipal();
		
		MetadataAuto metaAuto = new MetadataAuto("Mess10",
				"Lin64");
		Automovil auto = FabricaDeAutos.instanciarAuto(metaAuto);
		Pista pista = new Pista("\\pistas\\Default.xml");

		new ControladorDeCarrera(auto, pista);
	}

}
