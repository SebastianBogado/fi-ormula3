package modelo.servicio;

import modelo.Lin64;

public class FabricaDeLin64 implements Fabrica {

	@Override
	public Autoparte instanciar() {
		return new Lin64();
	}

}
