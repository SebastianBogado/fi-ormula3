package Programa;

import modelo.Automovil;
import modelo.Entorno;
import modelo.Pista;
import modelo.Terreno;
import modelo.servicio.FabricaDeAutos;
import modelo.servicio.MetadataAuto;
import modelo.servicio.NombresDeFabricables;
import Control.CambioDeCoordenadas;
import Control.OyenteTeclado;
import Titiritero.ControladorJuego;
import Titiritero.Ventana;
import Vista.VentanaDeInformacion;
import Vista.VistaAutomovil;
import Vista.VistaPista;

public class Fiormula3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MetadataAuto metaAuto = new MetadataAuto(NombresDeFabricables.PALER9, NombresDeFabricables.LIN64);
		Automovil auto = FabricaDeAutos.instanciarAuto(metaAuto);
		Pista p = new Pista("C:/Users/seba/workspace/fi-ormula3/pistas/Pista1.xml");
		iniciarCarrera(auto, p);
	}

	public static void iniciarCarrera(Automovil unAuto, Pista unaPista) {

		unaPista.cargarPistaEstatica();

		System.out.println(unaPista.getListaDeTerrenos().get(1).tipoTerreno());

		ControladorJuego controlador = new ControladorJuego();

		controlador.setIntervaloSimulacion(20);
		Ventana ventana = new Ventana(500, 650, controlador);
		VentanaDeInformacion ventanaInfo = new VentanaDeInformacion(unAuto
				.getVelocidadInstantanea(), unAuto.getPosicionReal(), unAuto
				.getNuematicos());

		controlador.setSuperficieDeDibujo(ventana);

		ventana.setVisible(true);
		ventana.setTitle("Fi-ormula 3...");
		ventana.setResizable(false);

		OyenteTeclado oyenteTeclado = new OyenteTeclado(unAuto);
		ventana.addKeyListener(oyenteTeclado);

		Entorno entorno = new Entorno(unAuto, unaPista);
		CambioDeCoordenadas.setEntorno(entorno);
		VistaPista vistaPista = new VistaPista(unaPista, unAuto
				.getVelocidadInstantanea());

		controlador.agregarDibujable(vistaPista);
		controlador.agregarMouseClickObservador(vistaPista);
		controlador.agregarDibujable(new VistaAutomovil(unAuto));
		controlador.agregarObjetoVivo(ventanaInfo);

		controlador.agregarObjetoVivo(entorno);

		controlador.comenzar();

	}

}
