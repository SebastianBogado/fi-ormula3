package vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.Pista;
import modelo.Terreno;
import modelo.servicio.Velocidad;
import titiritero.Imagen;
import titiritero.MouseClickObservador;
import titiritero.SuperficieDeDibujo;
import titiritero.Ventana;
import control.CambioDeCoordenadas;

public class VistaPista extends Imagen implements MouseClickObservador {

	private final Velocidad velocidad;
	private final Pista pista;

	private BufferedImage superior, inferior, bandera;
	private BufferedImage tierra, ripio, asfalto;
	private VistaObstaculo vistaPozo = null, vistaLomaDeBurro = null;
	private final ControlDeCambioDeTerreno controlTerreno;
	private int desplazamiento = 0, cantFranjasPintadas = 0;
	private final int distanciaRecorrida = 0;
	private long tiempoAnterior = 0;
	private final ControlDeObstaculos controlObstaculos;
	private boolean finalDePista;
	private boolean mostrarBanderaInicio = false;
	private boolean mostrarBanderaLlegada = false;
	private int desplazamientoBanderaLlegada = 0;
	private BufferedImage aCambiar;
	private boolean TieneQueCambiarTerreno=false;

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

		if (controlTerreno.cambiarTerreno())
			this.cambiarTerreno();


		this.desplazamiento += ((int) velocidad.y() / 7);

		tiempoAnterior = System.currentTimeMillis();

		if (mostrarBanderaLlegada) {
			this.desplazamientoBanderaLlegada += ((int) velocidad.y() / 7);
		}

		this.pintarPista(grafico);

		this.pintarPozos(superficeDeDibujo);

		this.pintarLomasDeBurro(superficeDeDibujo);

		finalDePista = this.controlTerreno.finDePista();

	}

	private void pintarPozos(SuperficieDeDibujo superficeDeDibujo) {

		ArrayList<PosicionDiscreta> posiciones = this.controlObstaculos
				.proximosPozos();

		Iterator<PosicionDiscreta> it = posiciones.iterator();

		while (it.hasNext()) {
			PosicionDiscreta posicion;
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

			this.vistaLomaDeBurro.dibujarEn(posicion.getX(), posicion.getY(),
					superficeDeDibujo);
		}

	}

	private void iniciarImagenesDeTerrenos() {
		this.setNombreArchivoImagen(UbicacionArchivo.ImagenAsfalto);

		this.asfalto = this.imagen;

		this.setNombreArchivoImagen(UbicacionArchivo.ImagenRipio);

		this.ripio = this.imagen;

		this.setNombreArchivoImagen(UbicacionArchivo.ImagenTierra);

		this.tierra = this.imagen;

		this.setNombreArchivoImagen(UbicacionArchivo.ImagenBandera);

		this.bandera = this.imagen;

	}

	private void cambiarTerreno() {
		String proximoTerreno = controlTerreno.proximoTerreno();

		if (proximoTerreno == Terreno.Asfalto){
			this.aCambiar = this.asfalto;
			this.TieneQueCambiarTerreno=true;
		}

		if (proximoTerreno == Terreno.Ripio){
			this.aCambiar = this.ripio;
			this.TieneQueCambiarTerreno=true;
		}

		if (proximoTerreno == Terreno.Tierra){
			this.aCambiar = this.tierra;
			this.TieneQueCambiarTerreno=true;
		}
		
	}

	private void pintarPista(Graphics grafico) {

		for (int i = 0; i < 15; i++) {
			grafico.drawImage(this.inferior, 0, 43 * i + desplazamiento, null);
		}

		for (int i = -5; i < 15; i++) {
			grafico.drawImage(this.superior, 0,
					(i * 43 + desplazamiento - 645), null);
		}

		this.pintarBanderas(grafico);

		if (desplazamiento >= 600) {
			desplazamiento = 0;
			this.inferior = this.superior;
			if(this.TieneQueCambiarTerreno){
				this.superior=this.aCambiar;
				this.TieneQueCambiarTerreno=false;
				
			}
			this.cantFranjasPintadas++;
		}
	}

	private void pintarBanderas(Graphics grafico) {

		if (!mostrarBanderaInicio) {
			grafico.drawImage(this.bandera, 0, 12 * 43 + desplazamiento, null);
			if (this.desplazamiento > 200)
				mostrarBanderaInicio = true;
		}

		if (pista.getLargo() - (long) CambioDeCoordenadas.posicionAuto.y() <= 45) {
			grafico.drawImage(this.bandera, 0, desplazamientoBanderaLlegada,
					null);
			mostrarBanderaLlegada = true;

		}

	}

	public Pista getPista() {
		return pista;
	}
}
