package modelo.servicio;

import modelo.Win32;

public class FabricaDeWin32 implements Fabrica {

	@Override
	public Autoparte instanciar() {
		return new Win32();
	}

}
