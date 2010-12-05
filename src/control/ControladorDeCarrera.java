package control;

import modelo.Automovil;
import modelo.Entorno;
import modelo.Pista;
import titiritero.ControladorJuego;
import titiritero.Ventana;
import vista.VentanaDeAviso;
import vista.VentanaDeInformacion;
import vista.VentanaDeRegistro;
import vista.VistaAutomovil;
import vista.VistaPista;

public class ControladorDeCarrera {
	private static ControladorJuego controlador;
	public static Ventana ventana;
	private static VentanaDeInformacion ventanaInfo;

	public ControladorDeCarrera(Automovil unAuto, Pista unaPista) {

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

		OyenteTeclado oyenteTeclado = new OyenteTeclado(unAuto, controlador);
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

	public static void terminarCarrera(long tiempoJugado, Pista pistaDeAutos) {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		controlador.detener();
		// ventanaInfo.setVisible(false);
		// ventana.setVisible(false);

		new VentanaDeRegistro();
	}

	public static void carreraPerdida() {
		controlador.detener();

		new VentanaDeAviso("Has perdido");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
