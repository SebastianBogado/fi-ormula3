package modelo;

import java.util.Observable;


public class Entorno extends Observable {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	
	  
	private double posicionAutoRealEnX;
	private double posicionAutoRealEnY;
	
	private long posicionAutoDiscretaEnX;
	private long posicionAutoDiscretaEnY;
	
	private double variacionPosicionDiscretaEnY;
	private double DiferencialDeTiempo;
	
	private Automovil unAutomovil;
	
	private boolean autoAvanzoUnMetro;
	
	private Obstaculo obstaculoYaChocado;
	private Obstaculo obstaculoSiguiente;
	
	
	
	
	
	public Entorno(){
		
	}
	
	
	
	
	private void actualizarPosicion(){
		posicionAutoRealEnY=posicionAutoRealEnY+unAutomovil.getVelocidadInstantanea().rapidez()*DiferencialDeTiempo;
		variacionPosicionDiscretaEnY=(Math.round(posicionAutoRealEnY)-posicionAutoDiscretaEnY);
		posicionAutoDiscretaEnY=(Math.round(posicionAutoRealEnY));
		if (variacionPosicionDiscretaEnY == 1 ){ autoAvanzoUnMetro = true;}
		else{ autoAvanzoUnMetro = false;}
		
	}
	
	private void chequearColisiones(Pista unPista){
		
		
		Colisionador unColisionador=new Colisionador() ;
		
		
		  if (unColisionador.pasoElObstaculo(obstaculoSiguiente, posicionAutoDiscretaEnY)){
			  obstaculoYaChocado = null;
			  obstaculoSiguiente = unPista.getObstaculoSiguiente();
		  }
		  else{
			  if (unColisionador.coinciden(obstaculoSiguiente,posicionAutoDiscretaEnY, posicionAutoDiscretaEnY)){
				  obstaculoYaChocado = obstaculoSiguiente;
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
	}	
		
}


