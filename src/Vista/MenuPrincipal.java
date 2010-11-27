package Vista;

import javax.swing.*;

import javax.swing.*;

import MenuPrincipal.VentanaOpciones;
import MenuPrincipal.VentanaOpciones.ManejadorDeEvento;
import MenuPrincipal.VentanaOpciones.ManejadorDeOpciones;

import java.awt.*;
import java.awt.event.*;

/* el menu principal, que carece de botones de maximizacion y minimizacion*/
public class MenuPrincipal extends JDialog{
	
	private static final long serialVersionUID = 1L;

	private JButton BotonPista;
	private JButton BotonNivel;
	private JButton BotonMotor;
	private JButton BotonRuedas;
	private JButton BotonSalir;
	private JButton BotonSeguir;
	private String PistaSeleccionada=null;
	private String NivelSeleccionado=null;
	private String MotorSeleccionado=null;
	private String RuedasSeleccionadas=null;
	private boolean Seguir;

	public MenuPrincipal(){
		
		this.setTitle("Fi-ormula3");
		this.setSize(500,200);
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		
		/* crea los botones Nivel, Motor, Ruedas, Pista, Salir y Seguir*/
		
		this.BotonPista = new JButton("Elegir Pista");
		this.BotonPista.setActionCommand("Pista");
				
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
		
		ManejadorDeEventosMenuPpal manejadorMenuPpal = new ManejadorDeEventosMenuPpal();
		
		/* Establece para cada boton cual va a ser su detector de eventos*/
		this.BotonPista.addActionListener(manejadorMenuPpal);
		this.BotonMotor.addActionListener(manejadorMenuPpal);
		this.BotonRuedas.addActionListener(manejadorMenuPpal);
		this.BotonSalir.addActionListener(manejadorMenuPpal);
		this.BotonSeguir.addActionListener(manejadorMenuPpal);
		
		/* Agrego los botones recientemente creados*/
		this.add(this.BotonPista);
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
	
	public String getPistaSeleccionada(){
		return this.PistaSeleccionada;
	}
	
	public boolean getSeguir(){
		return this.Seguir;
	}

	/* Clase privada que representa la ventana de opciones para elegir la pista	 */
	private class VentanaSeleccionPista extends JFrame{
			
		private static final long serialVersionUID = 1L;
			
		private JComboBox ConjuntoPistas;	
		private JButton BotonAceptar;
		private JButton BotonSalir;
		
		public VentanaSeleccionPista(){
			
			this.setTitle("Pista");
			this.setSize(300,150);
			this.setVisible(true);
			this.setLayout(new FlowLayout());
				
			this.ConjuntoPistas = new JComboBox(pistas);
			
			this.BotonSalir = new JButton ("Salir");
			this.BotonSalir.setActionCommand("Salir");
			
			this.BotonAceptar = new JButton("Aceptar");
			this.BotonAceptar.setActionCommand("Aceptar");
			this.BotonAceptar.setEnabled(false);
				
			ManejadorDeEvento manejadoreventos = new ManejadorDeEvento();
			ManejadorDeOpciones manejadoropciones = new ManejadorDeOpciones();
		
			this.ConjuntoPistas.addItemListener(manejadoropciones);
			this.BotonAceptar.addActionListener(manejadoreventos);
			this.BotonSalir.addActionListener(manejadoreventos);
			
			this.add(this.ConjuntoPistas);
			this.add(this.BotonAceptar);	
		}
	}
		
	/* Clase privada que representa la ventana de opciones para elegir el motor	 */
	private class VentanaSeleccionMotor extends JFrame{
				
		private static final long serialVersionUID = 1L;

		private JButton BotonWin32;
		private JButton BotonMacX;
		private JButton BotonLin64;
		private JButton BotonAceptar;
		private JButton BotonSalir;		
		
		public VentanaSeleccionMotor(){
				
			this.setTitle("Motor");
			this.setSize(300,150);
			this.setVisible(true);
			this.setLayout(new FlowLayout());
	
			this.BotonWin32 = new JButton("Win32");
			this.BotonWin32.setActionCommand("Win32");
	
			this.BotonMacX = new JButton("MacX");
			this.BotonMacX.setActionCommand("MacX");
				
			this.BotonLin64 = new JButton("Lin64");
			this.BotonLin64.setActionCommand("Lin64");
				
			this.BotonSalir = new JButton ("Salir");
			this.BotonSalir.setActionCommand("Salir");
			
			this.BotonAceptar = new JButton("Aceptar");
			this.BotonAceptar.setActionCommand("Aceptar");
			this.BotonAceptar.setEnabled(false);
					
			ManejadorDeEventosSeleccionMotor manejadorEventosMotor = new ManejadorDeEventosSeleccionMotor();
				
			
			this.BotonWin32.addActionListener(manejadorEventosMotor);
			this.BotonMacX.addActionListener(manejadorEventosMotor);
			this.BotonLin64.addActionListener(manejadorEventosMotor);
			this.BotonSalir.addActionListener(manejadorEventosMotor);
			this.BotonAceptar.addActionListener(manejadorEventosMotor);
	
			this.add(this.BotonWin32);
			this.add(this.BotonMacX);
			this.add(this.BotonLin64);
			this.add(this.BotonAceptar);
			this.add(this.BotonSalir);	
		}
	}
		
	/* Clase privada que representa la ventana de opciones para elegir el motor */
	private class VentanaSeleccionRuedas extends JFrame{
					
		private static final long serialVersionUID = 1L;

		private JButton BotonPaler9;
		private JButton BotonMess10;
		private JButton BotonAceptar;
		private JButton BotonSalir;
		
			public VentanaSeleccionRuedas(){
					
				this.setTitle("Motor");
				this.setSize(300,150);
				this.setVisible(true);
				this.setLayout(new FlowLayout());
		
				this.BotonPaler9 = new JButton("Paler9");
				this.BotonPaler9.setActionCommand("Paler9");
		
				this.BotonMess10 = new JButton("Mess10");
				this.BotonMess10.setActionCommand("Mess10");
		
				this.BotonSalir = new JButton ("Salir");
				this.BotonSalir.setActionCommand("Salir");
				
				this.BotonAceptar = new JButton("Aceptar");
				this.BotonAceptar.setActionCommand("Aceptar");
				this.BotonAceptar.setEnabled(false);
						
				ManejadorDeEventoSeleccionRuedas manejadorEventosRuedas = new ManejadorDeEventoSeleccionRuedas();
						
				this.BotonPaler9.addActionListener(manejadorEventosRuedas);
				this.BotonMess10.addActionListener(manejadorEventosRuedas);
				this.BotonSalir.addActionListener(manejadorEventosRuedas);
				this.BotonAceptar.addActionListener(manejadorEventosRuedas);
		
				this.add(this.BotonPaler9);
				this.add(this.BotonMess10);
				this.add(this.BotonSalir);
				this.add(this.BotonAceptar);
				
					
				}
	}
	
	private class ManejadorDeEventosMenuPpal implements ActionListener{
		
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e){
			
			if (e.getActionCommand().equals("Salir")){
				int opcion = JOptionPane.showConfirmDialog(null, " ¿Desea Salir?");
				if (opcion == 0) {
					Seguir = false;
					System.exit(0);
				}
			}
			
			if (e.getActionCommand().equals("Nivel")){
				String nivelelegido = null;
				boolean nivelValido = false;
				while (nivelValido==false){
					nivelelegido = JOptionPane.showInputDialog("Seleccionar Nivel de dificultad (1-3) : ");
					nivelValido = ((nivelelegido.equals("1")) || (nivelelegido.equals("2")) || (nivelelegido.equals("3")));
				}
				NivelSeleccionado = nivelelegido;
				if (PistaSeleccionada!=null && RuedasSeleccionadas!=null && MotorSeleccionado!= null)
					BotonSeguir.setEnabled(true);
			}
			
			if (e.getActionCommand().equals("Pista")){
				new VentanaSeleccionPista();
				if (NivelSeleccionado!=null && RuedasSeleccionadas!=null && MotorSeleccionado!= null)
					BotonSeguir.setEnabled(true);
			}
			
			if (e.getActionCommand().equals("Motor")){
				new VentanaSeleccionMotor();
				if (NivelSeleccionado!=null && RuedasSeleccionadas!=null && PistaSeleccionada!= null)
					BotonSeguir.setEnabled(true);
			}
			
			if (e.getActionCommand().equals("Ruedas")){
				new VentanaSeleccionRuedas();
				if (PistaSeleccionada!=null && NivelSeleccionado!=null && MotorSeleccionado!= null)
					BotonSeguir.setEnabled(true);
			}
			
			if (e.getActionCommand().equals("Comenzar")) {
				Seguir = true;
				setVisible(false);
				
			}
		} 
	}

	/* Clase que maneja el evento correspondiente los botones de la ventana seleccion de motor */
	private class ManejadorDeEventoSeleccionMotor implements ActionListener{
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e){
					
			if (e.getActionCommand().equals("Salir")){
				int opcion = JOptionPane.showConfirmDialog(null, " ¿Desea Salir?");
				if (opcion == 0) {
					Seguir = false;
					System.exit(0);
				}
			}
				
			if (e.getActionCommand().equals("Aceptar")){
				setVisible(false);				
			}
					
			if (e.getActionCommand().equals("Win32")){
				MotorSeleccionado = "Win32";
				BotonAceptar.setEnabled(true);
				if (PistaSeleccionada!=null && RuedasSeleccionadas!=null && MotorSeleccionado!= null)
					BotonSeguir.setEnabled(true);
			}
			
			if (e.getActionCommand().equals("MacX")){
				MotorSeleccionado = "MacX";
				BotonAceptar.setEnabled(true);
				if (PistaSeleccionada!=null && RuedasSeleccionadas!=null && MotorSeleccionado!= null)
					BotonSeguir.setEnabled(true);
			}
			
			if (e.getActionCommand().equals("Lin64")){
				MotorSeleccionado = "Lin64";
				BotonAceptar.setEnabled(true);
				if (PistaSeleccionada!=null && RuedasSeleccionadas!=null && MotorSeleccionado!= null)
					BotonSeguir.setEnabled(true);
			}
		
		}
	}
	
	/* Clase que maneja el evento correspondiente al botones de la ventana seleccion de ruedas */
	private class ManejadorDeEventoSeleccionRuedas implements ActionListener{
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e){
					
			if (e.getActionCommand().equals("Salir")){
				int opcion = JOptionPane.showConfirmDialog(null, " ¿Desea Salir?");
				if (opcion == 0) {
					Seguir = false;
					System.exit(0);
				}
			}
				
			if (e.getActionCommand().equals("Aceptar")){
				setVisible(false);				
			}
					
			if (e.getActionCommand().equals("Paler9")){
				RuedasSeleccionadas = "Paler9";
				BotonAceptar.setEnabled(true);
				if (PistaSeleccionada!=null && RuedasSeleccionadas!=null && MotorSeleccionado!= null)
					BotonSeguir.setEnabled(true);
			}
					
			if (e.getActionCommand().equals("Mess10")){
				RuedasSeleccionadas = "Mess10";
				BotonAceptar.setEnabled(true);
				if (PistaSeleccionada!=null && RuedasSeleccionadas!=null && MotorSeleccionado!= null)
					BotonSeguir.setEnabled(true);
			}
		}			
	}	
}