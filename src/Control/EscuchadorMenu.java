package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.MenuPrincipal;

abstract public class EscuchadorMenu implements ActionListener {
	MenuPrincipal menu;
	
	public EscuchadorMenu(MenuPrincipal menu){
		this.menu = menu;
	}
	
	@Override
	public abstract void actionPerformed(ActionEvent arg0); 

}
