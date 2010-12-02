package Vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import modelo.Neumaticos;
import modelo.servicio.Posicion;
import modelo.servicio.Velocidad;
import Titiritero.ObjetoVivo;

public class VentanaDeInformacion extends Frame implements ObjetoVivo {

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

		this.setSize(new Dimension(200, 200));
		this.setLocation(190, 40);

		this.agregarListener();

		this.setVisible(true);
	}

	private void agregarListener() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			};
		});
	}

	@Override
	public void vivir() {

		this.boton.setLabel("Velocidad: " + Math.ceil(velocidad.rapidez())
				+ "km / h");
		this.botonDistancia.setLabel("Distanacia: "
				+ Math.ceil(posicionAuto.y()) + " m ");

		this.calcularTiempo();
		this.botonTiempo.setLabel("Tiempo: " + (tiempoPost - tiempoPre)
				/ 1000.0 + " seg");

		this.botonDaño.setLabel("Daño: "
				+ Math.ceil(this.neumaticos.dañoPorcentual()) + " %");
	}

	private void calcularTiempo() {

		if (tiempoPre == 0) {
			tiempoPre = System.currentTimeMillis();
		}
		tiempoPost = System.currentTimeMillis();

	}

}
