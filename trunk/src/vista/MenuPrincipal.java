package vista;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import modelo.Automovil;
import modelo.Pista;
import control.EscuchadorBotonSalir;
import control.EscuchadorComenzar;
import control.EscuchadorEleccionMotor;
import control.EscuchadorEleccionPista;
import control.EscuchadorEleccionRuedas;
import control.IniciarJuego;

/** El menu principal, que carece de botones de maximizacion y minimizacion **/
public class MenuPrincipal extends JDialog {

	private static final long serialVersionUID = 1L;
	private final IniciarJuego juego;
	private final JButton BotonPista;
	private final JButton BotonMotor;
	private final JButton BotonRuedas;
	private final JButton BotonSalir;
	private final JButton BotonComenzar;
	private String PistaSeleccionada = null;
	private String MotorSeleccionado = null;
	private String RuedasSeleccionadas = null;
	private VentanaSeleccionMotor ventanaMotor = null;
	private VentanaSeleccionRuedas ventanaRuedas = null;

	public MenuPrincipal() {

		this.setTitle("Fi-ormula3");
		this.setSize(400, 95);
		this.setLocation(400, 250);
		this.setLayout(new FlowLayout());
		this.setResizable(false);

		/** Crea los botones Nivel, Motor, Ruedas, Pista, Salir y Seguir **/
		this.BotonPista = new JButton("Elegir Pista");
		this.BotonMotor = new JButton("Elegir Motor");
		this.BotonRuedas = new JButton("Elegir Ruedas");
		this.BotonSalir = new JButton("Salir");
		this.BotonComenzar = new JButton("Comenzar");
		this.BotonComenzar.setEnabled(false);

		/** Establece los detectores de eventos para cada boton **/
		this.BotonPista.addActionListener(new EscuchadorEleccionPista(this));
		this.BotonMotor.addActionListener(new EscuchadorEleccionMotor(this));
		this.BotonRuedas.addActionListener(new EscuchadorEleccionRuedas(this));
		this.BotonSalir.addActionListener(new EscuchadorBotonSalir());

		this.BotonComenzar.addActionListener(new EscuchadorComenzar(this));

		/** Agrego los botones recientemente creados **/
		this.add(this.BotonMotor);
		this.add(this.BotonRuedas);
		this.add(this.BotonPista);
		this.add(this.BotonSalir);
		this.add(this.BotonComenzar);

		this.setVisible(true);
		juego = new IniciarJuego();
		juego.start();
	}

	/** Devuelve el string del motor seleccionado **/
	public String getMotorSeleccionado() {
		return this.MotorSeleccionado;
	}

	/** Devuelve el string de las ruedas seleccionadas **/
	public String getRuedasSeleccionadas() {
		return this.RuedasSeleccionadas;
	}

	/** Devuelve el string de la ruta de la pista **/
	public String getPistaSeleccionada() {
		return this.PistaSeleccionada;
	}

	/** Establece el string del motor seleccionado **/
	public void setMotorElegido(String motor) {
		this.MotorSeleccionado = motor;
		this.habilitarComienzo();
	}

	/** Establece el string de las ruedas seleccionadas **/
	public void setRuedasElegidas(String ruedas) {
		this.RuedasSeleccionadas = ruedas;
		this.habilitarComienzo();
	}

	/** Establece el string de la pista seleccionada **/
	public void setPistaSeleccionada(String pistaSelecc) {
		this.PistaSeleccionada = pistaSelecc;
		this.habilitarComienzo();

	}

	/** Habilita el boton de comienzo del juego **/
	private void habilitarComienzo() {
		if ((this.PistaSeleccionada != null)
				&& (this.MotorSeleccionado != null)
				&& (this.RuedasSeleccionadas != null)) {
			BotonComenzar.setEnabled(true);
		}
	}

	/** Devuelve la referencia de la ventana de seleccion de motor **/
	public VentanaSeleccionMotor ventanaSeleccionMotor() {
		return this.ventanaMotor;
	}

	/** Devuelve la referencia de la ventana de seleccion de ruedas **/
	public VentanaSeleccionRuedas ventanaSeleccionRuedas() {
		return this.ventanaRuedas;
	}

	/** Establece una referencia hacia la ventana de seleccion de motor **/
	public void setVentanaMotor(VentanaSeleccionMotor ventana) {
		this.ventanaMotor = ventana;
	}

	/** Establece una referencia hacia la ventana de seleccion de ruedas **/
	public void setVentanaRuedas(VentanaSeleccionRuedas ventana) {
		this.ventanaRuedas = ventana;
	}

	public VentanaSeleccionMotor getVentanaMotor() {

		return ventanaMotor;
	}

	public VentanaSeleccionRuedas getVentanaRuedas() {
		return ventanaRuedas;
	}

	public void cargar(Automovil auto, Pista pista) {

		this.juego.cargar(auto, pista);
	}

	public void iniciar() {

		this.juego.seguir();

	}

}
