package Control;

import modelo.Entorno;

public class CambioDeCoordenadas {

	private static Entorno entorno;

	public static void setEntorno(Entorno ent) {
		entorno = ent;
	}

	public static long realizarCambio(long x) {

		long nuevaPosicion = 0, posicionActual = x;

		nuevaPosicion = posicionActual - entorno.getPosicionAutoDiscretaEnX();

		return nuevaPosicion;

	}
}
