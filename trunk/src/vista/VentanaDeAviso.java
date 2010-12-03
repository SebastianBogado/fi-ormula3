package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;

public class VentanaDeAviso extends Frame {

	private final String aviso;
	private final Button botonAceptar;

	public VentanaDeAviso(String aviso) {
		this.aviso = aviso;
		this.setLayout(new GridLayout(2, 1));
		Cliqueador oyente = new Cliqueador(this);

		this.setSize(400, 100);
		this.setResizable(false);
		this.setLocation(400, 200);

		this.agregarListerner();

		this.setBackground(Color.LIGHT_GRAY);

		for (int i = 1; i < 2; i++) {
			JLabel label = new JLabel();
			if (i == 1) {
				label.setText("          " + this.aviso);
				label.setAlignmentX(CENTER_ALIGNMENT);
			} else
				label.setMaximumSize(new Dimension(20, 20));
			label.setVisible(true);
			this.add(label, BorderLayout.NORTH);
		}

		botonAceptar = new Button();
		botonAceptar.addActionListener(oyente);
		this.add(botonAceptar, BorderLayout.CENTER);
		botonAceptar.setLabel("Aceptar");

		for (int i = 0; i < 1; i++) {
			// this.add(new JLabel(), BorderLayout.WEST);
			// this.add(new JLabel(), BorderLayout.EAST);
		}

		this.setVisible(true);
	}

	private void agregarListerner() {

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private class Cliqueador implements ActionListener {

		private final VentanaDeAviso ventana;

		public Cliqueador(VentanaDeAviso ventanaDeAviso) {
			this.ventana = ventanaDeAviso;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {

			ventana.setVisible(false);
		}

	}

}
