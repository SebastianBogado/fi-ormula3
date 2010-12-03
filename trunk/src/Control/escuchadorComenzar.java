package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.MenuPrincipal;

import modelo.Automovil;
import modelo.Pista;
import modelo.servicio.FabricaDeAutos;
import modelo.servicio.MetadataAuto;

public class escuchadorComenzar implements ActionListener {
	MenuPrincipal menu;
	
	public escuchadorComenzar(MenuPrincipal menu){
		this.menu = menu;
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
