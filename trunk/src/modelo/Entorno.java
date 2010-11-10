package modelo;

import java.util.Observable;


public class Entorno extends Observable {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	
	  
	private double posicionAutoRealEnY;
	private double posicionAutoRealEnX;
	private long posicionAutoDiscretaEnX;
	private long posicionAutoDiscretaEnY;
	
	private double variacionPosicionDiscretaEnY;
	private double DiferencialDeTiempo;
	
	private Automovil unAutomovil;
	
	private boolean autoAvanzoUnMetro;
	
	private Obstaculo obstaculoYaChocado;
	private Obstaculo obstaculoSiguiente;
	
	private Pista pistaDeAutos;
	
	
	
	
	public Entorno(){
		
		this.pistaDeAutos= new Pista();
		obstaculoSiguiente=this.pistaDeAutos.getObstaculoSiguiente();
		
	}
	
	
	
	
	private void actualizarPosicion(){
		posicionAutoRealEnY=posicionAutoRealEnY+unAutomovil.getVelocidadInstantanea().rapidez()*DiferencialDeTiempo;
		variacionPosicionDiscretaEnY=(Math.round(posicionAutoRealEnY)-posicionAutoDiscretaEnY);
		posicionAutoDiscretaEnY=(Math.round(posicionAutoRealEnY));
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
			try{
			unAutomovil.desgastarPorObstaculo (obstaculoChocado);
			}
			catch (Exception e){
				
			};			
			obstaculoYaChocado = obstaculoChocado;
		}
	}
		
	
	private void informarTerreno(){
		if (autoAvanzoUnMetro){
			try{
			unAutomovil.desgastarPorTerreno(pistaDeAutos.getTerreno(posicionAutoDiscretaEnY));
			}
			catch(Exception e){
			}
		}
	}	
		
}

	




