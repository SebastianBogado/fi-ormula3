package Vista;

import javax.swing.*;

import javax.swing.*;

import MenuPrincipal.VentanaOpciones;
import MenuPrincipal.VentanaOpciones.ManejadorDeEvento;
import MenuPrincipal.VentanaOpciones.ManejadorDeOpciones;

import java.awt.*;
import java.awt.event.*;

// el menu principal, que carece de botones de maximizacion y minimizacion
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
		
		// crea los botones Nivel, Motor y Ruedas, Salir y Seguir
		
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
		
		ManejadorDeEventosMenuPpal manejador = new ManejadorDeEventosMenuPpal();
		
		// establece para cada boton cual va a ser su detector de eventos
		this.BotonPista.addActionListener(manejador);
		this.BotonMotor.addActionListener(manejador);
		this.BotonRuedas.addActionListener(manejador);
		this.BotonSalir.addActionListener(manejador);
		this.BotonSeguir.addActionListener(manejador);
		
		// agrego los botones recientemente creados
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
					nivelValido = (nivelelegido.equals("1")) || (nivelelegido.equals("2")) || (nivelelegido.equals("3")));
				}
				NivelSeleccionado = nivelelegido;
				if (PistaSeleccionada!=null && RuedasSeleccionadas!=null && MotorSeleccionado!= null){
					BotonSeguir.setEnabled(true);
				}
			}
			
			if (e.getActionCommand().equals("Pista")){
				
				new VentanaSeleccionPista();
				if (NivelSeleccionado!=null && RuedasSeleccionadas!=null && MotorSeleccionado!= null){
					BotonSeguir.setEnabled(true);
			}
			
			if (e.getActionCommand().equals("Motor")){
				new VentanaSeleccionMotor();
				if (NivelSeleccionado!=null && RuedasSeleccionadas!=null && PistaSeccionada!= null){
					BotonSeguir.setEnabled(true);
			}
			if (e.getActionCommand().equals("Ruedas")){
				
				new VentanaSeleccionRuedas();
				if (PistaSeleccionada!=null && NivelSeleccionado!=null && MotorSeleccionado!= null){
					BotonSeguir.setEnabled(true);
			}
			
			if (e.getActionCommand().equals("Comenzar")) {
				
				Seguir = true;
				setVisible(false);
				
			}
		} 
	}
	
	/**
	 * Clase privada que representa la ventana de opciones para elegir la pista 
	 	 */
	private class VentanaSeleccionPista extends JFrame{
			
		private static final long serialVersionUID = 1L;
			
		private JComboBox ConjuntoPistas;	
		private JButton BotonAceptar;
		public VentanaSeleccionPista(){
			
			this.setTitle("Pista");
			this.setSize(300,150);
			this.setVisible(true);
			this.setLayout(new FlowLayout());
				
			this.ConjuntoPistas = new JComboBox(pistas);
			
			this.BotonAceptar = new JButton("Aceptar");
			this.BotonAceptar.setActionCommand("Aceptar");
			this.BotonAceptar.setEnabled(false);
				
			ManejadorDeEvento manejadoreventos = new ManejadorDeEvento();
			ManejadorDeOpciones manejadoropciones = new ManejadorDeOpciones();
		
			this.ConjuntoPistas.addItemListener(manejadoropciones);
			this.BotonAceptar.addActionListener(manejadoreventos);
			
			this.add(this.ConjuntoPistas);
			this.add(this.BotonAceptar);	
		}
			
		/**
		 * Clase privada que representa la ventana de opciones para elegir el motor
		 	 */
		private class VentanaSeleccionMotor extends JFrame{
				
			private static final long serialVersionUID = 1L;

			private JButton BotonWin32;
			private JButton BotonMacX;
			private JButton BotonLin64;
			private JButton BotonAceptar;

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
				
				this.BotonAceptar = new JButton("Aceptar");
				this.BotonAceptar.setActionCommand("Aceptar");
				this.BotonAceptar.setEnabled(false);
					
				ManejadorDeEvento manejadoreventos = new ManejadorDeEvento();
					
				this.BotonPaler9.addActionListener(manejadorDeEvento);
				this.BotonMess10.addActionListener(manejadorDeEvento);
				this.BotonAceptar.addActionListener(manejadorDeEvento);
	
				this.add(this.Paler9);
				this.add(this.Mess10);
				this.add(this.BotonAceptar);
				
			}
		
			/**
			 * Clase privada que representa la ventana de opciones para elegir el motor
			 	 */
			private class VentanaSeleccionRuedas extends JFrame{
					
				private static final long serialVersionUID = 1L;

				private JButton BotonMac;
				private JButton BotonMess10;
				private JButton BotonAceptar;

				public VentanaSeleccionMotor(){
					
					this.setTitle("Motor");
					this.setSize(300,150);
					this.setVisible(true);
					this.setLayout(new FlowLayout());
		
					this.BotonPaler9 = new JButton("Paler9");
					this.BotonPaler9.setActionCommand("Paler9");
		
					this.BotonMess10 = new JButton("Mess10");
					this.BotonMess10.setActionCommand("Mess10");
					
					this.BotonAceptar = new JButton("Aceptar");
					this.BotonAceptar.setActionCommand("Aceptar");
					this.BotonAceptar.setEnabled(false);
						
					ManejadorDeEvento manejadoreventos = new ManejadorDeEvento();
						
					this.BotonPaler9.addActionListener(manejadorDeEvento);
					this.BotonMess10.addActionListener(manejadorDeEvento);
					this.BotonAceptar.addActionListener(manejadorDeEvento);
		
					this.add(this.Paler9);
					this.add(this.Mess10);
					this.add(this.BotonAceptar);
					
				}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}	
}

	
	
	
}