package Vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import modelo.Pista;
import modelo.servicio.Velocidad;
import Titiritero.Imagen;
import Titiritero.SuperficieDeDibujo;
import Titiritero.Ventana;

public class VistaPista extends Imagen {

	private final Velocidad velocidad;
	private final Pista pista;
	private int distancia = 0;
	private long distanciaRecorrida = 0;
	private BufferedImage superior;
	private BufferedImage inferior;
	private BufferedImage aCambiar;
	private final BufferedImage ripio;
	private final BufferedImage asfalto;
	private final BufferedImage tierra;
	private boolean cambiarTerreno = false;

	public VistaPista(Pista pista, Velocidad vel) {
		super();
		this.pista = pista;

		this.velocidad = vel;
		this.setNombreArchivoImagen(UbicacionArchivo.ImagenAsfalto);
		this.asfalto = this.imagen;

		this.setNombreArchivoImagen(UbicacionArchivo.ImagenRipio);
		this.ripio = this.imagen;

		this.setNombreArchivoImagen(UbicacionArchivo.ImagenTierra);
		this.tierra = this.imagen;

		this.imagen = asfalto;
		superior = asfalto;
		inferior = asfalto;
	}

	@Override
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = ((Ventana) superficeDeDibujo).getGrafico();
		distancia += (int) velocidad.y() / 8;
		this.pintarPista(grafico, distancia);

		distanciaRecorrida += (long) velocidad.y() / 10;
		if (distancia > 600) {
			distancia = 0;
			if (cambiarTerreno)
				this.cambiarTerreno();
		}

		this.verificarTerreno();

	}

	private void cambiarTerreno() {
		this.superior = aCambiar;
	}

	private void verificarTerreno() {

		if (distanciaRecorrida > 2500) {
			aCambiar = this.ripio;
			cambiarTerreno = true;
		}
		if (distanciaRecorrida > 5000) {

			aCambiar = this.tierra;
			cambiarTerreno = true;
		}

		if (pista.getLargo() > distanciaRecorrida) {
			System.out.println("Se termino la pista.");
		}

	}

	private void pintarPista(Graphics grafico, int dist) {

		for (int i = 0; i < 15; i++) {
			grafico.drawImage(inferior, 0, 43 * i + distancia, null);
		}
		if (dist > 600)
			inferior = superior;

		for (int i = -10; i < 15; i++) {
			grafico.drawImage(superior, 0, (i * 43 + dist - 600), null);
		}
	}

	public Pista getPista() {
		return pista;
	}
}
