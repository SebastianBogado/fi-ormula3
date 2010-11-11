package modelo;

import java.util.Observable;


public class Entorno extends Observable {

	private long posicionAutoDiscretaEnX;
	private long posicionAutoDiscretaEnY;
	
	private double variacionPosicionDiscretaEnY;
	static private int diferencialDeTiempo = 36;
	static private double diferencialDeTiempoEnHoras = 0.00001;
	
	private Automovil unAutomovil;
	
	private boolean autoAvanzoUnMetro;
	
	private Obstaculo obstaculoYaChocado;
	private Obstaculo obstaculoSiguiente;
	
	private Pista pistaDeAutos;
	
	
	
	
	public Entorno(Automovil auto, Pista pista){
		this.unAutomovil = auto;
		this.pistaDeAutos= new Pista();
		obstaculoSiguiente=this.pistaDeAutos.getObstaculoSiguiente();
		
		
	}
	
	
	
	
	private void actualizarPosicion(){
		unAutomovil.actualizarPosicion(diferencialDeTiempoEnHoras);
		double auxPosicionX = unAutomovil.getPosicionReal().x();
		this.posicionAutoDiscretaEnX = Math.round(auxPosicionX);
		
		double auxPosicionY = unAutomovil.getPosicionReal().y();
		this.variacionPosicionDiscretaEnY=(Math.round(auxPosicionY) - posicionAutoDiscretaEnY);
		this.posicionAutoDiscretaEnY=(Math.round(auxPosicionY));

		
		if (variacionPosicionDiscretaEnY == 1 ){ autoAvanzoUnMetro = true;}
		else{ autoAvanzoUnMetro = false;}
		
	}
	
	private void chequearColisiones(){
		
		
		Colisionador unColisionador=new Colisionador() ;
		
		
		  if (unColisionador.pasoElObstaculo(obstaculoSiguiente, posicionAutoDiscretaEnY)){
			  obstaculoYaChocado = null;
			  obstaculoSiguiente = pistaDeAutos.getObstaculoSiguiente();
		  }
		  else{
			  if (unColisionador.coinciden(obstaculoSiguiente,posicionAutoDiscretaEnY, posicionAutoDiscretaEnY)){
				  obstaculoYaChocado = obstaculoSiguiente;
				  obstaculoSiguiente = pistaDeAutos.getObstaculoSiguiente();
			  }
		  }
	}
	
	
	private void informarColision(Obstaculo obstaculoChocado){
		if ((obstaculoChocado != null) && (obstaculoYaChocado != obstaculoChocado)){
			unAutomovil.desgastarPorObstaculo (obstaculoChocado);
			obstaculoYaChocado = obstaculoChocado;
		}
	}
		
	
	private void informarTerreno(){
		if (autoAvanzoUnMetro){
			unAutomovil.desgastarPorTerreno(pistaDeAutos.getTerreno(posicionAutoDiscretaEnY));
		}
	}	
		
	/*
	private boolean chequearFinDePista(){
	 
		return (this.posicionAutoDiscretaEnY == this.pistaDeAutos.getLargo());
	}
	 */
}

	




