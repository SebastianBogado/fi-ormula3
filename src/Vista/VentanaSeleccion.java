package Vista;

import java.awt.Dimension;
import java.lang.reflect.Field;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Control.EscuchadorBotonAceptar;
import Control.EscuchadorBotonSalir;
import Control.EscuchadorMouseBoton;

abstract public class VentanaSeleccion extends JFrame {
	private JButton BotonAceptar;
	private JButton BotonSalir;
	protected JPanel panelSur;
	protected JPanel panelNorte;
	protected MenuPrincipal menu;
		
	public VentanaSeleccion(String titulo, Dimension tamaño, MenuPrincipal menu) {
		this.setTitle(titulo);
		this.setSize(tamaño);
		this.menu = menu;
		
		this.BotonSalir = new JButton ("Salir");
		this.BotonAceptar = new JButton("Aceptar");
		this.BotonAceptar.setEnabled(false);
		
		panelSur = new JPanel();
		panelSur.add(BotonAceptar);
		panelSur.add(BotonSalir);		
		this.add("South", panelSur);	
		this.agregarControladores();
		this.setVisible(true);
	}
	
	private void agregarControladores(){
		this.BotonSalir.addActionListener(new EscuchadorBotonSalir());
		this.BotonAceptar.addActionListener(new EscuchadorBotonAceptar(this));
	}
	
	protected String obtenerDescripcion(String nombre) {
		Class clase = null;
		try {
			clase = Class.forName("modelo." + nombre);
		} catch (ClassNotFoundException e) {}
						
		Field atributo = null;
		try {
			atributo = clase.getField("descripcion");
		} catch (SecurityException e) {} catch (NoSuchFieldException e) {}
		
		try {
			return (String) atributo.get(new Object());
		} catch (IllegalArgumentException e) {} catch (IllegalAccessException e) {}
		
		return "Algo salió mal";
	}
	protected JButton inicializarBotonDeSeleccion(String dato){
		JButton boton = new JButton(dato);
		boton.setActionCommand(dato);
		boton.setToolTipText(this.obtenerDescripcion(dato));
		boton.addMouseListener(new EscuchadorMouseBoton()); 
		return boton;
	}
	
	public void habilitarAceptar(){
		this.BotonAceptar.setEnabled(true);
	}
	
}
