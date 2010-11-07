package modelo;

abstract public class Neumatico {
	
	private double daño=0;
	
	public void aumentarDaño(double difDaño){
		
		this.daño+=difDaño;
		
	}		
	
	/*
	 * Devuelve el daño en que se encuentra el neumatico porcentualmente (0-100)
	 */
	public double daño(){
		return daño;
	}
	
	/*
	 * Devuelve una instancia de alguna clase Derivada de Neumatico segun en el parametro recibido
	 */
	public static Neumatico NuevoNeumatico(int tipoNeumatico) {
		
		Neumatico cubiertas=null;
		
		switch (tipoNeumatico){
		case 1: cubiertas=new Mess10(); break;
		case 2: cubiertas=new Paler9(); break;
		default: cubiertas=new Mess10(); 
		
		}

		return cubiertas;
	}
}
