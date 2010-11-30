package Programa;
import modelo.Automovil;
import modelo.Entorno;
import modelo.Pista;
import Titiritero.ControladorJuego;
import Titiritero.Ventana;

public class Fiormula3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public static void iniciarCarrera(Automovil unAuto, Pista unaPista) {

		ControladorJuego controlador = new ControladorJuego();
		Ventana ventana = new Ventana(500, 700, controlador);
		ventana.setResizable(false);

		Entorno entorno = new Entorno(unAuto, unaPista);

	}

}
