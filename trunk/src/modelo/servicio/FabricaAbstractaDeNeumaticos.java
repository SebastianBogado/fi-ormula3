package modelo.servicio;

import modelo.Neumaticos;

public class FabricaAbstractaDeNeumaticos extends FabricaAbstracta {

	public FabricaAbstractaDeNeumaticos() {
		super();
		this.mapa.put(NombresDeFabricables.MESS10, new FabricaDeMess10());
		this.mapa.put(NombresDeFabricables.PALER9, new FabricaDePaler9());
	}

	public Neumaticos instanciarRuedas(String ruedas) {
		return (Neumaticos) this.mapa.get(ruedas).instanciar();
	}
}
