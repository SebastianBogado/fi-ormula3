package modelo;

import java.util.Observable;


public class Entorno extends Observable {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	
	/*
	 * 
	 * 
	 * 
	private Posicion posicionAutoReal;
	private Posicion posicionAutoDiscreta;
	
	private Double variacionPosicionDiscretaEnY;
	private Double DiferencialDeTiempo;
	
	private Automovil unAutomovil;
	
	private boolean autoAvanzoUnMetro;
	
	private Obstaculo obstaculoYaChocado;
	
	
	
	
	
	
	public Entorno(){
		
	}
	
	
	
	
	private void actualizarPosicion(){
		posicionAutoReal.y(posicionAutoReal.y()+unAutomovil.getVelocidadInstantanea()*DiferencialDeTiempo);
		variacionPosicionDiscretaEnY=(Math.round(posicionAutoReal.y())-posicionAutoDiscreta.y());
		posicionAutoDiscreta.y(Math.round(posicionAutoReal.y()));
		if (variacionPosicionDiscretaEnY == 1 ){ autoAvanzoUnMetro = true;}
		else{ autoAvanzoUnMetro = false;}
		
	}
	
	private void chequearColisiones(Pista unPista){
		
		Obstaculo obstaculoSiguiente;
		Obstaculo obstaculoChocado;
		Colisionador unColisionador;
		
		
		  if (unColisionador.pasoElObstaculo(obstaculoSiguiente, posicionAutoDiscreta)){
			  obstaculoChocado = null;
			  obstaculoSiguiente = unPista.getObstaculoSiguiente();
		  }
		  else{
			  if (unColisionador.coinciden(obstaculoSiguiente, posicionAutoDiscreta)){
				  obstaculoChocado = obstaculoSiguiente;
				  obstaculoSiguiente = unPista.getObstaculoSiguiente();
			  }
		  }
	}
	
	
	private void informarColision(Obstaculo obstaculoChocado){
		if ((obstaculoChocado != null) && (obstaculoYaChocado != obstaculoChocado)){
			try{
			unAutomovil.desgastarPorObstaculo (obstaculoChocado);
			}
			catch (Exception e){
				
			};			
			obstaculoYaChocado = obstaculoChocado;
		}
	}
		
	
	private void informarTerreno(Terreno terrenoActual){
		if (autoAvanzoUnMetro){
			try{
			unAutomovil.desgastarPorTerreno(terrenoActual);
			}
			catch(Exception e){
			}
		}
	}	*/
		
}


