package Vista;

import javax.swing.*;

import src.Vista.MenuPrincipal.ManejadorDeEventos;

import java.awt.*;
import java.awt.event.*;

// el menu principal, que carece de botones de maximizacion y minimizacion
public class MenuPrincipal extends JDialog{
	
	private static final long serialVersionUID = 1L;

	private JButton BotonNivel;
	private JButton BotonMotor;
	private JButton BotonRuedas;
	private JButton BotonSalir;
	private JButton BotonSeguir;
	private String NivelSeleccionado=null;
	private String MotorSeleccionado=null;
	private String RuedasSeleccionadas=null;
	private boolean Seguir;

	public MenuPrincipal(){
		
		this.setTitle("Fi-ormula3");
		this.setSize(500,200);
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		
		// crea los botones Nivel, Motor y Ruedas, Salir y Seguir
		this.BotonNivel = new JButton("Elegir Nivel");
		this.BotonNivel.setActionCommand("Nivel");
		
		this.BotonMotor = new JButton("Elegir Motor");
		this.BotonMotor.setActionCommand("Motor");
			
		this.BotonRuedas = new JButton("Elegir Ruedas");
		this.BotonRuedas.setActionCommand("Ruedas");
		
		this.BotonSalir = new JButton("Salir");
		this.BotonSalir.setActionCommand("Salir");
		
		this.BotonSeguir = new JButton("Comenzar");
		this.BotonSeguir.setActionCommand("Comenzar");
		this.BotonSeguir.setEnabled(false);
		
		ManejadorDeEventos manejador = new ManejadorDeEventos();
		
		// establece para cada boton cual va a ser su detector de eventos
		this.BotonMotor.addActionListener(manejador);
		this.BotonRuedas.addActionListener(manejador);
		this.BotonSalir.addActionListener(manejador);
		this.BotonSeguir.addActionListener(manejador);
		
		// agrego los botones recientemente creados
		this.add(this.BotonMotor);
		this.add(this.BotonRuedas);
		this.add(this.BotonSalir);
		this.add(this.BotonSeguir);

}
	
	public String getNivelSeleccionado(){
		return this.NivelSeleccionado;
	}
	
	public String getMotorSeleccionado(){
		return this.MotorSeleccionado;
	}
	
	public String getRuedasSeleccionadas(){
		return this.RuedasSeleccionadas;
	}
	
	public boolean getSeguir(){
		return this.Seguir;
	}

	
	
	
}