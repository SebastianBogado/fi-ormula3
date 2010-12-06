package vista;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import modelo.Pista;
import modelo.servicio.Tiempo;

public class VentanaDeRegistro extends Frame {

	private final Button botonAceptar;
	public final TextField texto;

	public VentanaDeRegistro(long tiempoJugado) {

		this.setTitle("Felicidades, completaste la Pista: Ingrese su nombre");

		this.agregarListerner();
		this.setResizable(false);

		botonAceptar = new Button();
		botonAceptar.setLabel("Guardar Record");

		texto = new TextField();

		this.setLayout(new GridLayout(1, 2));

		this.add(texto);
		this.add(botonAceptar);

		Cliqueador accionDeBoton = new Cliqueador(this, tiempoJugado);

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
		private final long timepoJugado;

		public Cliqueador(VentanaDeRegistro ventana, long tiempoJugado) {
			this.ventana = ventana;
			this.timepoJugado = tiempoJugado;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (!(ventana.texto.getText().isEmpty())) {

				Tiempo nuevoTiempo = new Tiempo(ventana.texto.getText(),
						timepoJugado);

				Pista.instancia.intentarAgregarNuevoTiempo(nuevoTiempo);
				Pista.instancia.guardarEnXML();

				System.out.println("Serializado");

				new VentanaDeMejoresTiempos(Pista.instancia
						.getListaDeMejoresTiempos());
				
				this.ventana.setVisible(false);

			}

		}
	}

}
