package modelo.servicio;

import modelo.Motor;

public class FabricaAbstractaDeMotores extends FabricaAbstracta {

	public FabricaAbstractaDeMotores() {
		super();
		this.mapa.put(NombresDeFabricables.LIN64, new FabricaDeLin64());
		this.mapa.put(NombresDeFabricables.MACX, new FabricaDeMacX());
		this.mapa.put(NombresDeFabricables.WIN32, new FabricaDeWin32());
	}

	public Motor instanciarMotor(String motor) {
		return (Motor) this.mapa.get(motor).instanciar();

	}
}
