package modelo.servicio;

import modelo.Neumaticos;

public class FabricaAbstractaDeNeumaticos extends FabricaAbstracta{

	private static final String MESS10 = "Mess10";
	private static final String PALER9 = "Paler9";
	
	
	public FabricaAbstractaDeNeumaticos(){
		super();
		this.mapa.put(MESS10, new FabricaDeMess10());
		this.mapa.put(PALER9, new FabricaDePaler9());
	}

	public Neumaticos instanciarRuedas(String ruedas) {
		return (Neumaticos) this.mapa.get(ruedas).instanciar();
	}
}
