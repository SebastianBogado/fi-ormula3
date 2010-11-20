package modelo.servicio;

import modelo.MacX;

public class FabricaDeMacX implements Fabrica {

	@Override
	public Autoparte instanciar() {
		return new MacX();
	}

}
