package vVista;

public class VistaLomaDeBurro extends VistaObstaculo {

	public VistaLomaDeBurro() {
		if (imagenObstaculo == null) {
			this.setNombreArchivoImagen(UbicacionArchivo.ImagenLomaDeBurro);

			imagenObstaculo = this.imagen;
		}

	}

}
