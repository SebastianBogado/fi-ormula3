package Vista;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

// el menu principal, que carece de botones de maximizacion y minimizacion
public class MenuPrincipal extends JDialog{
	
	private static final long serialVersionUID = 1L;

	private JButton BotonMotor;
	private JButton BotonRuedas;
	private JButton BotonSalir;
	private JButton BotonSeguir;
	private String NivelSeleccionado=null;
	private String MotorSeleccionado=null;
	private String RuedasSeleccionado=null;
	private boolean Seguir;

}