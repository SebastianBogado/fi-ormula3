package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import titiritero.ControladorJuego;

public class VentanaPausa extends Frame {

	private final ControladorJuego controlador;

	public VentanaPausa(ControladorJuego controlador) {

		this.controlador = controlador;
		this.setTitle("Juego pausado");
		this.setSize(230, 60);

		this.setLayout(new FlowLayout());
		this.setResizable(false);

		this.setLocation(550, 330);
		JButton boton = new JButton("Reanudar");

		boton.addActionListener(new Resumir(controlador, this));
		// boton.setLabel("Reanudar");

		this.add(boton);

		this.setBackground(Color.LIGHT_GRAY);

		this.setVisible(true);

	}

	private class Resumir implements ActionListener {

		ControladorJuego controlador;
		VentanaPausa ventana;

		public Resumir(ControladorJuego cont, VentanaPausa ventana) {
			this.controlador = cont;

			this.ventana = ventana;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {

			controlador.seguir();
			ventana.setVisible(false);

		}

	}

}
