package modelo;

public class CambioDeTerreno {
	
	private Terreno TipoDeTerreno;
	private double PosicionDeCambio;
	
	public CambioDeTerreno(Terreno TipoDeTerreno,double PosicionDeCambio){
		
		this.TipoDeTerreno=TipoDeTerreno;
		this.PosicionDeCambio=PosicionDeCambio;
	}
	
	public Terreno getTipoDeTerreno(){
		return this.TipoDeTerreno;
	}
	
	public double getPosicionDeCambio(){
		return this.PosicionDeCambio;
	}
	

}
