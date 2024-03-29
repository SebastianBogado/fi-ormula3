package titiritero;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;

/*
 * Esta clase representa una imagen JPG abstrayendo al usuario de los detalles de Java2D
 * Simplemente requiere de una referencia al nombre del archivo JPG
 */
public class Imagen implements Dibujable {

	private String nombreArchivoImagen;

	protected BufferedImage imagen;
	private Posicionable posicionable;

	public Imagen() {

	}

	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = ((Ventana) superficeDeDibujo).getGrafico();
		grafico.drawImage(this.imagen, this.posicionable.getX(),
				this.posicionable.getY(), null);

	}

	public String getNombreArchivoImagen() {
		return nombreArchivoImagen;
	}

	public void setNombreArchivoImagen(String nombreArchivoImagen) {
		this.nombreArchivoImagen = nombreArchivoImagen;
		InputStream in = null;
		try {
			in = new FileInputStream(nombreArchivoImagen);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if (in == null)
			System.out.println("NULO");
		JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(in);
		try {
			this.imagen = decoder.decodeAsBufferedImage();
			in.close();
		} catch (Exception ex) {

		}
	}

	public Posicionable getPosicionable() {
		return posicionable;
	}

	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;
	}

	public void MouseClick(int x, int y) {
		System.out.println("Click;" + x + "," + y);

	}

}
