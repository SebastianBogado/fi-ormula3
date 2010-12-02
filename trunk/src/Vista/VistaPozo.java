package Vista;

public class VistaPozo extends VistaObstaculo {

	public VistaPozo() {

		if (imagenObstaculo == null) {
			this.setNombreArchivoImagen(UbicacionArchivo.ImagenPozo);

			imagenObstaculo = this.imagen;
		}

	}

}
