package cControl;

import vVista.PosicionDiscreta;
import modelo.Entorno;
import modelo.servicio.Posicion;

public class CambioDeCoordenadas {

	private static Entorno entorno;
	public static Posicion posicionAuto;

	public static void setEntorno(Entorno ent) {
		entorno = ent;
		posicionAuto = entorno.getPosicionAuto();

	}

	public static long realizarCambio(long y) {

		long nuevaPosicion = 0;

		nuevaPosicion = y - ((long) posicionAuto.y()) + 645;// 645 es
		// el largo
		// de la
		// ventana

		return nuevaPosicion;
	}

	public static PosicionDiscreta realizarCambio(Posicion posicionObstaculo) {

		if (posicionObstaculo != null) {

			PosicionDiscreta nuevaPosicion = new PosicionDiscreta();
			nuevaPosicion.setY((int) ((int) ((int) -Math.ceil(posicionObstaculo
					.y()) + Math.ceil(posicionAuto.y())) * 13.2 + 640));

			nuevaPosicion.setX((int) (((long) posicionObstaculo.x()) * 100));

			return nuevaPosicion;
		
		} else
		
			return null;
	
	}

}
