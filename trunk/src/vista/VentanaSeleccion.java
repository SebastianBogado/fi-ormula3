package vista;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.EscuchadorBotonAceptar;
import control.EscuchadorBotonSalir;
import control.EscuchadorMouseBoton;

abstract public class VentanaSeleccion extends JFrame {
	protected JButton BotonAceptar;
	protected JButton BotonSalir;
	protected JPanel panelSur;
	protected JPanel panelNorte;
	protected MenuPrincipal menu;
	protected JButton BotonVolver;

	public VentanaSeleccion(String titulo, Dimension tamaño, MenuPrincipal menu) {
		this.setTitle(titulo);
		this.setSize(tamaño);
		this.menu = menu;

		this.BotonSalir = new JButton("Salir");
		this.BotonVolver = new JButton("Volver");
		this.BotonAceptar = new JButton("Aceptar");
		this.BotonAceptar.setEnabled(false);

		panelSur = new JPanel();
		panelSur.add(BotonAceptar);
		panelSur.add(BotonVolver);
		panelSur.add(BotonSalir);
		this.add("South", panelSur);
		this.agregarControladores();
		this.setVisible(true);
	}

	private void agregarControladores() {
		this.BotonSalir.addActionListener(new EscuchadorBotonSalir());
		this.BotonVolver.addActionListener(new EscuchadorBotonAceptar(this));
		this.BotonAceptar.addActionListener(new EscuchadorBotonAceptar(this));
	}

	protected String obtenerDescripcion(String nombre) {
		Class clase = null;
		try {
			clase = Class.forName("modelo." + nombre);
		} catch (ClassNotFoundException e) {
		}
		
		Field atributo = null;
		try {
			atributo = clase.getField("descripcion");
		} catch (SecurityException e) {
		} catch (NoSuchFieldException e) {
		}

		try {
			return (String) atributo.get(new Object());
		} catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		}

		return "Algo salió mal";
	}

	protected JButton inicializarBotonDeSeleccion(String dato) {
		JButton boton = new JButton(dato);
		boton.setActionCommand(dato);
		boton.setToolTipText(this.obtenerDescripcion(dato));
		boton.addMouseListener(new EscuchadorMouseBoton());
		return boton;
	}

	public void habilitarAceptar() {
		this.BotonAceptar.setEnabled(true);
	}

}
