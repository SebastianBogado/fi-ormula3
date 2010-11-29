package modelo.servicio;

import modelo.Motor;

public class FabricaAbstractaDeMotores extends FabricaAbstracta {
	public static final String LIN64 = "Lin64";
	public static final String MACX = "MacX";
	public static final String WIN32 = "Win32";

	public FabricaAbstractaDeMotores() {
		super();
		this.mapa.put(LIN64, new FabricaDeLin64());
		this.mapa.put(MACX, new FabricaDeMacX());
		this.mapa.put(WIN32, new FabricaDeWin32());
	}

	public Motor instanciarMotor(String motor) {
		return (Motor) this.mapa.get(motor).instanciar();

	}
}