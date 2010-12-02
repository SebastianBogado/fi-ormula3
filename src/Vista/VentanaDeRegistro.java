package Vista;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaDeRegistro extends Frame {

	private final Button botonAceptar;
	public final TextField texto;

	public VentanaDeRegistro() {

		this.setTitle("Felicidadez Completastes la Pista: Ingrese su nombre");

		this.agregarListerner();
		this.setResizable(false);

		botonAceptar = new Button();
		botonAceptar.setLabel("Guardar Record");

		texto = new TextField();

		this.setLayout(new GridLayout(1, 2));

		this.add(texto);
		this.add(botonAceptar);

		Cliqueador accionDeBoton = new Cliqueador(this);

		this.botonAceptar.addActionListener(accionDeBoton);

		this.setLocation(400, 300);
		this.setSize(330, 50);

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

		private final VentanaDeRegistro ventana;

		public Cliqueador(VentanaDeRegistro ventana) {
			this.ventana = ventana;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (!(ventana.texto.getText() == " "))
				ventana.setVisible(false);

		}

	}

}
