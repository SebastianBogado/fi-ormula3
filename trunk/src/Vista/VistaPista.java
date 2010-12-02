package Vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.Pista;
import modelo.Terreno;
import modelo.servicio.Velocidad;
import Titiritero.Imagen;
import Titiritero.MouseClickObservador;
import Titiritero.SuperficieDeDibujo;
import Titiritero.Ventana;

public class VistaPista extends Imagen implements MouseClickObservador {

	private final Velocidad velocidad;
	private final Pista pista;

	private BufferedImage superior, inferior;
	private BufferedImage tierra, ripio, asfalto;
	private VistaObstaculo vistaPozo = null, vistaLomaDeBurro = null;
	private final ControlDeCambioDeTerreno controlTerreno;
	private int desplazamiento = 0, cantFranjasPintadas = 0;
	private final int distanciaRecorrida = 0;
	private long tiempoAnterior = 0;
	private final ControlDeObstaculos controlObstaculos;

	public VistaPista(Pista pista, Velocidad vel) {
		super();
		this.pista = pista;

		this.velocidad = vel;

		this.iniciarImagenesDeTerrenos();
		controlTerreno = new ControlDeCambioDeTerreno(pista);
		controlObstaculos = new ControlDeObstaculos(pista
				.getListaDeLomasDeBurro(), pista.getListaDePozos());

		vistaPozo = new VistaPozo();
		vistaLomaDeBurro = new VistaLomaDeBurro();

		String tipoTerreno = controlTerreno.primerTerreno();

		this.primerTerreno(tipoTerreno);
		// this.primerTerreno("Asfalto");

	}

	private void primerTerreno(String tipoTerreno) {

		if (tipoTerreno == Terreno.Ripio)
			this.inferior = this.ripio;
		if (tipoTerreno == Terreno.Asfalto)
			this.inferior = this.asfalto;
		if (tipoTerreno == Terreno.Tierra)
			this.inferior = this.tierra;

		this.superior = this.inferior;

	}

	@Override
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = ((Ventana) superficeDeDibujo).getGrafico();

		if (controlTerreno.cambiarTerrno(this.cantFranjasPintadas))
			this.cambiarTerreno();
		// Todavia a que definir algunos valores
		if (tiempoAnterior == 0 || true) {

			this.desplazamiento += ((int) velocidad.y() / 8);

			tiempoAnterior = System.currentTimeMillis();
		} else {

			long tiempoActual = System.currentTimeMillis();
			long tiempo = ((tiempoActual - tiempoAnterior));

			this.tiempoAnterior = tiempoActual;

			System.out.println(tiempo);

			this.desplazamiento += (int) velocidad.y() * tiempo / (3.6 * 100);

		}

		// this.distanciaRecorrida += this.desplazamiento;

		this.pintarPista(grafico);

		this.pintarPozos(superficeDeDibujo);

		this.pintarLomasDeBurro(superficeDeDibujo);
		/*
		 * int y = 100; if (this.desplazamiento == 0) y = (int)
		 * Math.ceil(Math.random() * 500.0); vistaLomaDeBurro.dibujarEn(y,
		 * desplazamiento, superficeDeDibujo);
		 */

	}

	private void pintarPozos(SuperficieDeDibujo superficeDeDibujo) {

		ArrayList<PosicionDiscreta> posiciones = this.controlObstaculos
				.proximosPozos();

		Iterator<PosicionDiscreta> it = posiciones.iterator();

		while (it.hasNext()) {
			PosicionDiscreta posicion = null;
			posicion = it.next();

			this.vistaPozo.dibujarEn(posicion.getX(), posicion.getY(),
					superficeDeDibujo);
		}

	}

	private void pintarLomasDeBurro(SuperficieDeDibujo superficeDeDibujo) {
		ArrayList<PosicionDiscreta> posiciones = this.controlObstaculos
				.proximasLomasDeBurro();

		Iterator<PosicionDiscreta> it = posiciones.iterator();

		while (it.hasNext()) {
			PosicionDiscreta posicion = null;
			posicion = it.next();

			this.vistaPozo.dibujarEn(posicion.getX(), posicion.getY(),
					superficeDeDibujo);
		}

	}

	private void iniciarImagenesDeTerrenos() {
		this.setNombreArchivoImagen(UbicacionArchivo.ImagenAsfalto);
		System.out.println(UbicacionArchivo.ImagenAsfalto);
		this.asfalto = this.imagen;

		this.setNombreArchivoImagen(UbicacionArchivo.ImagenRipio);
		System.out.println(UbicacionArchivo.ImagenRipio);
		this.ripio = this.imagen;

		this.setNombreArchivoImagen(UbicacionArchivo.ImagenTierra);
		System.out.println(UbicacionArchivo.ImagenTierra);
		this.tierra = this.imagen;

	}

	private void cambiarTerreno() {
		String proximoTerreno = controlTerreno.proximoTerreno();

		if (proximoTerreno == Terreno.Asfalto)
			this.superior = this.asfalto;

		if (proximoTerreno == Terreno.Ripio)
			this.superior = this.ripio;

		if (proximoTerreno == Terreno.Tierra)
			this.superior = this.tierra;

	}

	private void pintarPista(Graphics grafico) {

		for (int i = 0; i < 15; i++) {
			grafico.drawImage(this.inferior, 0, 43 * i + desplazamiento, null);
		}

		for (int i = -5; i < 15; i++) {
			grafico.drawImage(this.superior, 0,
					(i * 43 + desplazamiento - 645), null);
		}

		if (desplazamiento >= 600) {
			desplazamiento = 0;
			this.inferior = this.superior;
			this.cantFranjasPintadas++;
		}
	}

	public Pista getPista() {
		return pista;
	}
}
