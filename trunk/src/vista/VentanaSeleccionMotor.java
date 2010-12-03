package vista;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import control.EscuchadorBotonSeleccionMotor;




import modelo.servicio.NombresDeFabricables;

public class VentanaSeleccionMotor extends VentanaSeleccion {
	private JButton BotonWin32;
	private JButton BotonMacX;
	private JButton BotonLin64;
	
	public VentanaSeleccionMotor(String titulo, Dimension tamaño, MenuPrincipal menu) {
		super(titulo, tamaño, menu);
		this.BotonWin32 = inicializarBotonDeSeleccion(NombresDeFabricables.WIN32);
		this.BotonMacX = inicializarBotonDeSeleccion(NombresDeFabricables.MACX);
		this.BotonLin64 = inicializarBotonDeSeleccion(NombresDeFabricables.LIN64);

		panelNorte = new JPanel();
		panelNorte.add(BotonWin32);
		panelNorte.add(BotonMacX);
		panelNorte.add(BotonLin64);
		this.add("Center", panelNorte);	
		this.setVisible(true);
		
	}
	
	protected JButton inicializarBotonDeSeleccion(String nombre){
		JButton boton = super.inicializarBotonDeSeleccion(nombre);
		boton.addActionListener(new EscuchadorBotonSeleccionMotor(menu));
		return boton;
	}
}
