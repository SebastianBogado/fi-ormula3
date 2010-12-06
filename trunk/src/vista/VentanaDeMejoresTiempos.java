package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import programa.Fiormula3;
import titiritero.Ventana;

import modelo.servicio.Tiempo;

public class VentanaDeMejoresTiempos extends JFrame {

	public VentanaDeMejoresTiempos(LinkedList<Tiempo> listaDeMejoresTiempos) {

		this.setLayout(new GridLayout(1, 1));

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		this.setLocation(500, 160);

		panel1.setLayout(new GridLayout(12, 1));
		panel2.setLayout(new GridLayout(12, 1));

		panel1.add(new JLabel("Nombre:"));
		panel2.add(new JLabel("Tiempo:"));

		java.util.Iterator<Tiempo> it = listaDeMejoresTiempos.iterator();

		for(int i=0;it.hasNext() && i<10;i++) {

			Tiempo unTiempo = it.next();

			panel1.add(new JLabel(unTiempo.getNombre()));
			panel2.add(new JLabel(unTiempo.getTiempo() + ""));

		}

		this.add(panel1);
		this.add(panel2);

		this.setSize(240, 400);

		
		
		JButton botonNuevoJuego=new JButton("Nuevo Juego");
		JButton botonSalir=new JButton("Salir");
		
		botonNuevoJuego.addActionListener(new OyenteBoton(this));
		botonSalir.addActionListener(new OyenteBoton(this));
		
		panel1.add(botonNuevoJuego);
		panel2.add(botonSalir);
		
		this.setVisible(true);

	}
	
	private class OyenteBoton implements ActionListener{
		
		
		private JFrame ventana;

		public OyenteBoton(JFrame ventana){
			this.ventana=ventana;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			 
			if(e.getActionCommand()=="Nuevo Juego"){
								
				Fiormula3.main(null);
				
				Ventana.instancia.setVisible(false);
				
				this.ventana.setVisible(false);
			}
			
			if(e.getActionCommand()=="Salir")
				System.exit(0);
			
		}
		
	}
	
	


}
