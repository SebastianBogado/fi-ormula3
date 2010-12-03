package vista;

import java.awt.Graphics;

import titiritero.Imagen;
import titiritero.SuperficieDeDibujo;
import titiritero.Ventana;

import modelo.Automovil;
import modelo.servicio.Velocidad;

public class VistaAutomovil extends Imagen {

	private final Automovil auto;
	private final PosicionDiscreta posicion;
	private final Velocidad velocidad;
	private final boolean iniciado = false;

	public VistaAutomovil(Automovil auto) {

		this.setNombreArchivoImagen(UbicacionArchivo.ImagenAutomovil);

		posicion = new PosicionDiscreta(200, 500);
		this.setPosicionable(posicion);
		this.auto = auto;
		velocidad = auto.getVelocidadInstantanea();
	}

	@Override
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		this.actualizarPosicion();

		Graphics g = ((Ventana) superficeDeDibujo).getGrafico();

		super.dibujar(superficeDeDibujo);

	}

	private void actualizarPosicion() {

		this.posicion.setX((int) auto.posicionEsquinaInferiorIzquierda().x());

	}

}