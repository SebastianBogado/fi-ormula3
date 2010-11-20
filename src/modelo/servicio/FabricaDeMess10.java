package modelo.servicio;

import modelo.Mess10;

public class FabricaDeMess10 implements Fabrica {

	@Override
	public Autoparte instanciar() {
		return new Mess10();
	}

}
