package vista;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import control.EscuchadorBotonSeleccionRuedas;



import modelo.servicio.NombresDeFabricables;

public class VentanaSeleccionRuedas extends VentanaSeleccion {
	private JButton BotonPaler9;
	private JButton BotonMess10;

	public VentanaSeleccionRuedas(String titulo, Dimension tamaño, MenuPrincipal menu) {
		super(titulo, tamaño, menu);
		this.BotonPaler9 = inicializarBotonDeSeleccion(NombresDeFabricables.PALER9);
		this.BotonMess10 = inicializarBotonDeSeleccion(NombresDeFabricables.MESS10);

		panelNorte = new JPanel();
		panelNorte.add(BotonPaler9);
		panelNorte.add(BotonMess10);

		this.add("Center", panelNorte);	
		this.setVisible(true);
	}
	
	protected JButton inicializarBotonDeSeleccion(String nombre){
		JButton boton = super.inicializarBotonDeSeleccion(nombre);
		boton.addActionListener(new EscuchadorBotonSeleccionRuedas(menu));
		return boton;
	}
}
