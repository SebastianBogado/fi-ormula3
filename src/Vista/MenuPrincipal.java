package Vista;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

/** El menu principal, que carece de botones de maximizacion y minimizacion **/
public class MenuPrincipal extends JDialog{
	
	private static final long serialVersionUID = 1L;

	private JButton BotonPista;
	private JButton BotonNivel;
	private JButton BotonMotor;
	private JButton BotonRuedas;
	private JButton BotonSalir;
	private JButton BotonComenzar;
	private String PistaSeleccionada = null;
	private String NivelSeleccionado = null;
	private String MotorSeleccionado = null;
	private String RuedasSeleccionadas = null;
	private VentanaSeleccionMotor ventanaMotor = null ;
	private VentanaSeleccionRuedas ventanaRuedas = null;
	
	public MenuPrincipal(){
		
		this.setTitle("Fi-ormula3");
		this.setSize(500,200);
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		
		/** Crea los botones Nivel, Motor, Ruedas, Pista, Salir y Seguir **/
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
		
		this.BotonComenzar = new JButton("Comenzar");
		this.BotonComenzar.setActionCommand("Comenzar");
		this.BotonComenzar.setEnabled(false);
		
		ManejadorDeEventosMenuPpal manejadorMenuPpal = new ManejadorDeEventosMenuPpal();
		
		/** Establece el detector de eventos para cada boton **/
		this.BotonPista.addActionListener(manejadorMenuPpal);
		this.BotonMotor.addActionListener(manejadorMenuPpal);
		this.BotonRuedas.addActionListener(manejadorMenuPpal);
		this.BotonSalir.addActionListener(manejadorMenuPpal);
		this.BotonComenzar.addActionListener(manejadorMenuPpal);
		this.BotonNivel.addActionListener(manejadorMenuPpal);
		
		/** Agrego los botones recientemente creados **/
		this.add(this.BotonMotor);
		this.add(this.BotonRuedas);
		this.add(this.BotonPista);
		this.add(this.BotonNivel);
		this.add(this.BotonSalir);
		this.add(this.BotonComenzar);
	
		/** Creo las ventanas de seleccion **/
		ventanaMotor = new VentanaSeleccionMotor();
		ventanaRuedas = new VentanaSeleccionRuedas();
	}
  
	/** Clase privada que representa la ventana de seleccion de la pista **/
	private class VentanaSeleccionPista extends JFrame{
			
		private static final long serialVersionUID = 1L;
			
		public VentanaSeleccionPista(){
			/** Se crea un file browser **/
			JFileChooser ventanaSelectora = new JFileChooser();
			FileFilter filtroExtension = new FileNameExtensionFilter("Pistas en xml", "xml");
			ventanaSelectora.addChoosableFileFilter(filtroExtension);
			int returnVal = ventanaSelectora.showOpenDialog(this);
			/** Si se puede abrir se guarda la ruta **/
			if(returnVal == JFileChooser.APPROVE_OPTION){
				File pista = ventanaSelectora.getSelectedFile();
				PistaSeleccionada = pista.getAbsolutePath();
			}			
		}
	}
		
	/** Clase privada que representa la ventana de seleccion del motor **/
	private class VentanaSeleccionMotor extends JFrame{
				
		private static final long serialVersionUID = 1L;

		private JButton BotonWin32;
		private JButton BotonMacX;
		private JButton BotonLin64;
		private JButton BotonAceptar;
		private JButton BotonSalir;		
		
		public VentanaSeleccionMotor(){
				
			this.setTitle("Seleccion de Motor");
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
		
	/** Clase privada que representa la ventana de seleccion de las ruedas **/
	private class VentanaSeleccionRuedas extends JFrame{
					
		private static final long serialVersionUID = 1L;

		private JButton BotonPaler9;
		private JButton BotonMess10;
		private JButton BotonAceptar;
		private JButton BotonSalir;
		
		public VentanaSeleccionRuedas(){
					
			this.setTitle("Seleccion de Ruedas");
			this.setSize(200,150);
			this.setVisible(true);
			this.setLayout(new FlowLayout());
	
			/** Crea los botones Paler9, Mess10, aceptar y Salir **/
			this.BotonPaler9 = new JButton("Paler9");
			this.BotonPaler9.setActionCommand("Paler9");
		
			this.BotonMess10 = new JButton("Mess10");
			this.BotonMess10.setActionCommand("Mess10");
		
			this.BotonSalir = new JButton ("Salir");
			this.BotonSalir.setActionCommand("Salir");
				
			this.BotonAceptar = new JButton("Aceptar");
			this.BotonAceptar.setActionCommand("Aceptar");
			this.BotonAceptar.setEnabled(false);
				
			ManejadorDeEventosSeleccionRuedas manejadorEventosRuedas = new ManejadorDeEventosSeleccionRuedas();

			/** Establece el detector de eventos para cada boton **/
			this.BotonPaler9.addActionListener(manejadorEventosRuedas);
			this.BotonMess10.addActionListener(manejadorEventosRuedas);
			this.BotonSalir.addActionListener(manejadorEventosRuedas);
			this.BotonAceptar.addActionListener(manejadorEventosRuedas);
		
			/** Agrego los botones recientemente creados **/
			this.add(this.BotonPaler9);
			this.add(this.BotonMess10);
			this.add(this.BotonAceptar);
			this.add(this.BotonSalir);
				
		}
	}
	
	private class ManejadorDeEventosMenuPpal implements ActionListener{
		
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e){
			
			if (e.getActionCommand().equals("Salir")){
				int opcion = JOptionPane.showConfirmDialog(null, "¿Desea Salir?");
				if (opcion == 0) 
					System.exit(0);				
			}
			
			if (e.getActionCommand().equals("Nivel")){
				String nivelelegido = null;
				boolean nivelValido = false;
				while (nivelValido == false){
					nivelelegido = JOptionPane.showInputDialog("Seleccionar Nivel de dificultad (1-3) : ");
					nivelValido = ((nivelelegido.equals("1")) || (nivelelegido.equals("2")) || (nivelelegido.equals("3")));
				}
				NivelSeleccionado = nivelelegido;
				if (PistaSeleccionada != null && RuedasSeleccionadas != null && MotorSeleccionado != null)
					BotonComenzar.setEnabled(true);
			}
			
			if (e.getActionCommand().equals("Pista")){
				new VentanaSeleccionPista();
				if (NivelSeleccionado != null && RuedasSeleccionadas != null && MotorSeleccionado != null)
					BotonComenzar.setEnabled(true);
			}
			
			if (e.getActionCommand().equals("Motor")){
				ventanaMotor.setVisible(true);
				if (NivelSeleccionado != null && RuedasSeleccionadas != null && PistaSeleccionada != null)
					BotonComenzar.setEnabled(true);
			}
			
			if (e.getActionCommand().equals("Ruedas")){
				ventanaRuedas.setVisible(true);
				if (PistaSeleccionada != null && NivelSeleccionado != null && MotorSeleccionado != null)
					BotonComenzar.setEnabled(true);
			}
			
			if (e.getActionCommand().equals("Comenzar")) {
				System.out.println(PistaSeleccionada);
				System.out.println(NivelSeleccionado);
				System.out.println(MotorSeleccionado);
				System.out.println(RuedasSeleccionadas);
				setVisible(false);
			}
		} 
	}

	/** Clase que maneja el evento correspondiente los botones de la ventana seleccion de motor **/
	
	private class ManejadorDeEventosSeleccionMotor implements ActionListener{
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e){
					
			if (e.getActionCommand().equals("Salir")){
				int opcion = JOptionPane.showConfirmDialog(null, "¿Desea Salir?");
				if (opcion == 0) 
					System.exit(0);
			}
				
			if (e.getActionCommand().equals("Aceptar")){
				ventanaMotor.setVisible(false);
			}
					
			if (e.getActionCommand().equals("Win32")){
				MotorSeleccionado = "Win32";
				ventanaMotor.BotonAceptar.setEnabled(true);
				if (PistaSeleccionada !=null && RuedasSeleccionadas !=null && MotorSeleccionado != null)
					BotonComenzar.setEnabled(true);
			}
			
			if (e.getActionCommand().equals("MacX")){
				MotorSeleccionado = "MacX";
				ventanaMotor.BotonAceptar.setEnabled(true);
				if (PistaSeleccionada != null && RuedasSeleccionadas != null && MotorSeleccionado != null)
					BotonComenzar.setEnabled(true);
			}
			
			if (e.getActionCommand().equals("Lin64")){
				MotorSeleccionado = "Lin64";
				ventanaMotor.BotonAceptar.setEnabled(true);
				if (PistaSeleccionada != null && RuedasSeleccionadas != null && MotorSeleccionado != null)
					BotonComenzar.setEnabled(true);
			}
		}
	}
		
	/** Clase que maneja el evento correspondiente al botones de la ventana seleccion de ruedas **/
	private class ManejadorDeEventosSeleccionRuedas implements ActionListener{
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e){
					
			if (e.getActionCommand().equals("Salir")){
				int opcion = JOptionPane.showConfirmDialog(null, "¿Desea Salir?");
				if (opcion == 0) 
					System.exit(0);
			}
				
			if (e.getActionCommand().equals("Aceptar")){
				ventanaRuedas.setVisible(false);				
			}
					
			if (e.getActionCommand().equals("Paler9")){
				RuedasSeleccionadas = "Paler9";
				ventanaRuedas.BotonAceptar.setEnabled(true);
				if (PistaSeleccionada != null && RuedasSeleccionadas != null && MotorSeleccionado != null)
					BotonComenzar.setEnabled(true);
			}
					
			if (e.getActionCommand().equals("Mess10")){
				RuedasSeleccionadas = "Mess10";
				ventanaRuedas.BotonAceptar.setEnabled(true);
				if (PistaSeleccionada != null && RuedasSeleccionadas != null && MotorSeleccionado != null)
					BotonComenzar.setEnabled(true);
			}
		}			
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
}	
