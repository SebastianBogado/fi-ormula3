package modelo.servicio;

public class MetadataAuto {
	private String ruedas;
	private String motor;
	
	MetadataAuto(String ruedas, String motor){
		this.ruedas = ruedas;
		this.motor = motor;
	}
	
	public String getRuedas(){
		return this.ruedas;
	}
	
	public String getMotor(){
		return this.motor;
	}	
}
