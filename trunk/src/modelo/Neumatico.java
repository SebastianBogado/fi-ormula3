package modelo;

import modelo.excepciones.ExcepcionObstaculoInvalido;
import modelo.excepciones.ExcepcionTerrenoInvalido;

abstract public class Neumatico {
	
	private double da�o=0;
	
	protected void aumentarDa�o(double difDa�o){
		if (this.da�o <= 100){
			this.da�o+=difDa�o;
		}
	}		
	
	/*
	 * Devuelve el da�o en que se encuentra el neumatico porcentualmente (0-100)
	 */
	public double da�o(){
		return da�o/100.0;
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

	abstract public void desgastarPorTerreno(Terreno terreno, Velocidad velocidadInstantanea) 
			throws ExcepcionTerrenoInvalido;
	abstract public void desgastarPorObstaculo(Obstaculo obstaculo) throws ExcepcionObstaculoInvalido;
	 
}