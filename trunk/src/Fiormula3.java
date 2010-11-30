import modelo.Automovil;
import modelo.Entorno;
import modelo.Pista;
import Control.CambioDeCoordenadas;
import Control.OyenteTeclado;
import Titiritero.ControladorJuego;
import Titiritero.Ventana;
import Vista.VistaAutomovil;

public class Fiormula3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public static void iniciarCarrera(Automovil unAuto, Pista unaPista) {

		ControladorJuego controlador = new ControladorJuego();
		Ventana ventana = new Ventana(500, 700, controlador);
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setResizable(false);

		OyenteTeclado oyenteTeclado = new OyenteTeclado(unAuto);
		ventana.addKeyListener(oyenteTeclado);

		VistaAutomovil vistaAuto = new VistaAutomovil(unAuto);

		Entorno entorno = new Entorno(unAuto, unaPista);
		CambioDeCoordenadas.setEntorno(entorno);

	}

}
