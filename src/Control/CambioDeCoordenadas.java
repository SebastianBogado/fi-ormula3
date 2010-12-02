package Control;

import modelo.Entorno;
import modelo.servicio.Posicion;
import Vista.PosicionDiscreta;

public class CambioDeCoordenadas {

	private static Entorno entorno;
	private static Posicion posicionAuto;

	public static void setEntorno(Entorno ent) {
		entorno = ent;
		posicionAuto = entorno.getPosicionAuto();

	}

	public static long realizarCambio(long y) {

		long nuevaPosicion = 0;

		nuevaPosicion = y - ((long) posicionAuto.y()) + 645;// 645 es
		// el
		// largo
		// de la
		// ventana

		return nuevaPosicion;

	}

	public static PosicionDiscreta realizarCambio(Posicion posicionObstaculo) {

		if (posicionObstaculo != null) {

			PosicionDiscreta nuevaPosicion = new PosicionDiscreta();
			nuevaPosicion.setY((int) ((int) Math.ceil(posicionObstaculo.y())
					- Math.ceil(posicionAuto.y()) + 645));

			nuevaPosicion
					.setX((int) ((long) posicionObstaculo.x() - posicionAuto
							.x()));

			return nuevaPosicion;
		} else
			return null;
	}
}
