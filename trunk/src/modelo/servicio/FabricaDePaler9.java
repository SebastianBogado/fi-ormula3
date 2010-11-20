package modelo.servicio;

import modelo.Paler9;

public class FabricaDePaler9 implements Fabrica {

	@Override
	public Autoparte instanciar() {
		return new Paler9();
	}

}
