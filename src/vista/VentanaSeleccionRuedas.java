package vista;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import modelo.servicio.NombresDeFabricables;
import control.EscuchadorBotonSeleccionRuedas;

public class VentanaSeleccionRuedas extends VentanaSeleccion {
	private final JButton BotonPaler9;
	private final JButton BotonMess10;

	public VentanaSeleccionRuedas(String titulo, Dimension tama�o,
			MenuPrincipal menu) {
		super(titulo, tama�o, menu);
		this.BotonPaler9 = inicializarBotonDeSeleccion(NombresDeFabricables.PALER9);
		this.BotonMess10 = inicializarBotonDeSeleccion(NombresDeFabricables.MESS10);

		panelNorte = new JPanel();
		panelNorte.add(BotonPaler9);
		panelNorte.add(BotonMess10);

		this.add("Center", panelNorte);
		this.setResizable(false);
		this.setLocation(480, 250);

		this.setVisible(true);
	}

	@Override
	protected JButton inicializarBotonDeSeleccion(String nombre) {
		JButton boton = super.inicializarBotonDeSeleccion(nombre);
		boton.addActionListener(new EscuchadorBotonSeleccionRuedas(menu));
		return boton;
	}
}
