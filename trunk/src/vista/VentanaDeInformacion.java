package vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

import modelo.Neumaticos;
import modelo.servicio.Posicion;
import modelo.servicio.Velocidad;
import titiritero.ObjetoVivo;

public class VentanaDeInformacion extends JFrame implements ObjetoVivo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Velocidad velocidad;

	private final Button boton;
	private final Button botonDistancia;
	private final Button botonTiempo;
	private final Posicion posicionAuto;
	private final Button botonDaño;
	private final Button x, y;
	private final Neumaticos neumaticos;
	private long tiempoPost = 0, tiempoPre = 0;

	// private final Graphics grafico;

	public VentanaDeInformacion(Velocidad v, Posicion posAuto,
			Neumaticos neumaticos) {
		this.velocidad = v;
		this.posicionAuto = posAuto;
		this.neumaticos = neumaticos;

		this.setMaximumSize(new Dimension(300, 200));

		this.setAlwaysOnTop(false);

		this.setLayout(new GridLayout(4, 1));

		boton = new Button();
		boton.setBackground(Color.green);
		this.add(boton);

		botonDistancia = new Button();
		botonDistancia.setBackground(Color.GRAY);
		this.add(botonDistancia);

		botonTiempo = new Button();
		botonTiempo.setBackground(Color.GRAY);
		this.add(botonTiempo);

		botonDaño = new Button();
		botonDaño.setBackground(Color.red);
		this.add(botonDaño);

		x = new Button();
		y = new Button();

		// this.add(x);
		// this.add(y);

		this.setSize(new Dimension(200, 200));
		this.setLocation(190, 40);

		this.setVisible(true);
	}

	@Override
	public void vivir() {

		this.boton.setLabel("Velocidad: " + Math.ceil(velocidad.rapidez())
				+ "km / h");
		this.botonDistancia.setLabel("Distancia: "
				+ Math.ceil(posicionAuto.y()) + " m ");

		this.calcularTiempo();
		this.botonTiempo.setLabel("Tiempo: "
				+ Math.ceil((tiempoPost - tiempoPre) / 1000.0) + " seg");

		this.botonDaño.setLabel("Daño: "
				+ Math.ceil(this.neumaticos.dañoDiscreto()) + " %");

		// this.x.setLabel("X: " + CambioDeCoordenadas.posicionAuto.x());
		// this.y.setLabel("Y: " + CambioDeCoordenadas.posicionAuto.y());
	}

	// Math.ceil(this.neumaticos.dañoDiscreto())
	private void calcularTiempo() {

		if (tiempoPre == 0) {
			tiempoPre = System.currentTimeMillis();
		}
		tiempoPost = System.currentTimeMillis();

	}

}
