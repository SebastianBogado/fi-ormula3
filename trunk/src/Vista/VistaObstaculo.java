package Vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Titiritero.Imagen;
import Titiritero.SuperficieDeDibujo;
import Titiritero.Ventana;

public class VistaObstaculo extends Imagen {

	protected BufferedImage imagenObstaculo;
	protected static int X = 0, Y = 0;

	public VistaObstaculo() {

	}

	public void dibujarEn(int x, int y, SuperficieDeDibujo superficeDeDibujo) {
		X = x;
		Y = y;
		this.dibujar(superficeDeDibujo);
	}

	@Override
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = ((Ventana) superficeDeDibujo).getGrafico();
		grafico.drawImage(imagenObstaculo, X, Y, null);

	}

}
