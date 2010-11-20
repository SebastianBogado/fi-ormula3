package modelo.servicio;

import java.util.HashMap;

public class FabricaAbstracta {
	protected HashMap<String, Fabrica> mapa;
	protected FabricaAbstracta(){
		this.mapa = new HashMap<String, Fabrica>(3);
	}

}
