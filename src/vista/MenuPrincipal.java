package vista;

import javax.swing.*;

import control.EscuchadorComenzar;
import control.EscuchadorEleccionMotor;
import control.EscuchadorEleccionPista;
import control.EscuchadorEleccionRuedas;


import java.awt.*;
import java.awt.event.*;

/** El menu principal, que carece de botones de maximizacion y minimizacion **/
public class MenuPrincipal extends JDialog{
	
	private static final long serialVersionUID = 1L;

	private JButton BotonPista;
	private JButton BotonMotor;
	private JButton BotonRuedas;
	private JButton BotonSalir;
	private JButton BotonComenzar;
	private String PistaSeleccionada = null;
	private String MotorSeleccionado = null;
	private String RuedasSeleccionadas = null;
	private VentanaSeleccionMotor ventanaMotor = null ;
	private VentanaSeleccionRuedas ventanaRuedas = null;
	
	public MenuPrincipal(){
		
		this.setTitle("Fi-ormula3");
		this.setSize(400,200);
		this.setLayout(new FlowLayout());
		
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
		this.BotonSalir.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}	
		});
		
		this.BotonComenzar.addActionListener(new EscuchadorComenzar(this));
		
		/** Agrego los botones recientemente creados **/
		this.add(this.BotonMotor);
		this.add(this.BotonRuedas);
		this.add(this.BotonPista);
		this.add(this.BotonSalir);
		this.add(this.BotonComenzar);
		this.setVisible(true);
	}

	/** Devuelve el string del motor seleccionado **/
	public String getMotorSeleccionado(){
		return this.MotorSeleccionado;
	}
	
	/** Devuelve el string de las ruedas seleccionadas **/
	public String getRuedasSeleccionadas(){
		return this.RuedasSeleccionadas;
	}
	
	/** Devuelve el string de la ruta de la pista **/
	public String getPistaSeleccionada(){
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
	private void habilitarComienzo(){
		if ((this.PistaSeleccionada != null) && 
			(this.MotorSeleccionado != null) &&
			(this.RuedasSeleccionadas != null)){
				BotonComenzar.setEnabled(true);
		}
	}
	
	/** Devuelve la referencia de la ventana de seleccion de motor **/
	public VentanaSeleccionMotor ventanaSeleccionMotor(){
		return this.ventanaMotor;
	}
	
	/** Devuelve la referencia de la ventana de seleccion de ruedas **/
	public VentanaSeleccionRuedas ventanaSeleccionRuedas(){
		return this.ventanaRuedas;
	}

	/** Establece una referencia hacia la ventana de seleccion de motor **/
	public void setVentanaMotor(VentanaSeleccionMotor ventana){
		this.ventanaMotor = ventana;
	}
	
	/** Establece una referencia hacia la ventana de seleccion de ruedas **/
	public void setVentanaRuedas(VentanaSeleccionRuedas ventana){
		this.ventanaRuedas = ventana;
	}
	
}	
	