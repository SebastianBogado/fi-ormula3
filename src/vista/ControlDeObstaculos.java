package vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import control.CambioDeCoordenadas;


import modelo.LomaDeBurro;
import modelo.Pozo;

public class ControlDeObstaculos {

	private final LinkedList<LomaDeBurro> lomasDeBurro;
	private final LinkedList<Pozo> pozos;

	public ControlDeObstaculos(LinkedList<LomaDeBurro> listaDeLomasDeBurro,
			LinkedList<Pozo> listaDePozos) {
		this.lomasDeBurro = listaDeLomasDeBurro;
		this.pozos = listaDePozos;

	}

	public ArrayList<PosicionDiscreta> proximasLomasDeBurro() {
		ArrayList<PosicionDiscreta> resultados = new ArrayList<PosicionDiscreta>();

		java.util.Iterator<LomaDeBurro> it = this.lomasDeBurro.iterator();

		while (it.hasNext()) {
			LomaDeBurro unaLoma = it.next();

			PosicionDiscreta posicion = CambioDeCoordenadas
					.realizarCambio(unaLoma.posicionEsquinaInferiorIzquierda());

			if (posicion.getY() > 0 && posicion.getY() < 800)
				resultados.add(posicion);
		}

		return resultados;
	}

	public ArrayList<PosicionDiscreta> proximosPozos() {
		ArrayList<PosicionDiscreta> resultados = new ArrayList<PosicionDiscreta>();

		Iterator<Pozo> it = this.pozos.iterator();

		while (it.hasNext()) {

			Pozo unPozo = it.next();

			PosicionDiscreta posicion = CambioDeCoordenadas
					.realizarCambio(unPozo.posicionEsquinaInferiorIzquierda());

			if (posicion.getY() > 0 && posicion.getY() < 800)
				resultados.add(posicion);
		}

		return resultados;
	}
}
