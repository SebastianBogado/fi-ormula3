package modelo;

import modelo.excepciones.ExcepcionObstaculoInvalido;
import modelo.excepciones.ExcepcionTerrenoInvalido;

abstract public class Neumatico {
	
	private double daño=0;
	
	protected void aumentarDaño(double difDaño){
		if (this.daño <= 100){
			this.daño+=difDaño;
		}
	}		
	
	/*
	 * Devuelve el daño en que se encuentra el neumatico porcentualmente (0-100)
	 */
	public double daño(){
		return daño/100.0;
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