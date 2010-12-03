package cControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vVista.MenuPrincipal;


import modelo.Automovil;
import modelo.Pista;
import modelo.servicio.FabricaDeAutos;
import modelo.servicio.MetadataAuto;

public class EscuchadorComenzar extends EscuchadorMenu implements ActionListener {

	public EscuchadorComenzar(MenuPrincipal menu){
		super(menu);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MetadataAuto metaAuto = new MetadataAuto(this.menu.getRuedasSeleccionadas(),
				this.menu.getMotorSeleccionado());
		Automovil auto = FabricaDeAutos.instanciarAuto(metaAuto);
		Pista pista = new Pista(this.menu.getPistaSeleccionada());
		this.menu.setVisible(false);

		new ControladorDeCarrera(auto, pista);
	}

}
