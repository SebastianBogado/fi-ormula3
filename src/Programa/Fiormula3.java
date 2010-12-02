package Programa;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;

import modelo.Automovil;
import modelo.Entorno;
import modelo.Pista;
import modelo.servicio.FabricaDeAutos;
import modelo.servicio.MetadataAuto;
import modelo.servicio.NombresDeFabricables;
import Control.CambioDeCoordenadas;
import Control.OyenteTeclado;
import Titiritero.ControladorJuego;
import Titiritero.Ventana;
import Vista.MenuPrincipal;
import Vista.VentanaDeInformacion;
import Vista.VistaAutomovil;
import Vista.VistaPista;

public class Fiormula3 {

	/**
	 * @param args
	 */

	private static ControladorJuego controlador;
	private static Ventana ventana;
	private static VentanaDeInformacion ventanaInfo;

	public static void main(String[] args) {
		new MenuPrincipal();
		
//		MetadataAuto metaAuto = new MetadataAuto("Mess10",
//				"Lin64");
//		Automovil auto = FabricaDeAutos.instanciarAuto(metaAuto);
//		Pista pista = new Pista("C:/Users/seba/workspace/fi-ormula3/pistas/Default.xml");
//
//		Fiormula3.iniciarCarrera(auto, pista);
	}

	public static void iniciarCarrera(Automovil unAuto, Pista unaPista) {

		unaPista.cargarPistaEstatica();

		System.out.println(unaPista.getListaDeTerrenos().get(1).tipoTerreno());

		controlador = new ControladorJuego();

		controlador.setIntervaloSimulacion(20);
		ventana = new Ventana(500, 650, controlador);
		ventanaInfo = new VentanaDeInformacion(
				unAuto.getVelocidadInstantanea(), unAuto.getPosicionReal(),
				unAuto.getNuematicos());

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

	public static void termianarCarrera() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		controlador.detener();
		ventanaInfo.setVisible(false);
		ventana.setVisible(false);

		Frame ventanaRegistro = new Frame();
		ventanaRegistro.setLayout(new GridLayout(2, 1));

		ventanaRegistro.setLocation(300, 250);

		ventanaRegistro.setTitle("Ingrese su Nombre");

		ventanaRegistro.setSize(200, 150);

		ventanaRegistro.add(new TextField());

		ventanaRegistro.add(new Button("Aceptar"));
		ventanaRegistro.setVisible(true);

	}

	public static void carreraPerdida() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		controlador.detener();

		Frame ventanaDeAviso = new Frame();

		ventanaDeAviso.setTitle("Has Perdido....:C");
		ventanaDeAviso.setSize(200, 100);
		ventanaDeAviso.add(new Button("Aceptar"));
		ventanaDeAviso.setLocation(300, 200);
		ventanaDeAviso.setVisible(true);
	}
}
