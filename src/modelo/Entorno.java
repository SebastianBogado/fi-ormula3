package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.Timer;

import modelo.excepciones.ExcepcionPistaFinalizada;


public class Entorno extends Observable implements ActionListener{

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
	
	private Timer cicloConstante;
	
	
	/*
	 * Para crearse, necesita el auto, en esta primer entrega
	 * M�s tarde, habr� para elegir entre pista aleatoria y una ubicaci�n,
	 * donde estar� una pista interpretable en XML
	 */
	
	public Entorno(Automovil auto, Pista pista){
		this.unAutomovil = auto;
		this.pistaDeAutos= new Pista();
		obstaculoSiguiente=this.pistaDeAutos.getObstaculoSiguiente();
		this.darTresSegundosPrevios();
		
		this.iniciarSecuencia();
		
	}
	
	
	private void iniciarSecuencia(){
		cicloConstante = new Timer(diferencialDeTiempo, this);
		cicloConstante.setInitialDelay(0);
		cicloConstante.start();
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.actualizarPosicion();
		this.chequearColisiones();
		this.informarTerreno();
		try {
			this.chequearFinDePista();
		} catch (ExcepcionPistaFinalizada e) {
			this.cicloConstante.stop();
		}	
		
	}


	/*
	 * GENTLEMEN, START YOUR ENGINES!
	 * 3...2...1..GO! es la idea de esto. No es primordial
	 */
	private void darTresSegundosPrevios() {
		// TODO Auto-generated method stub
		
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
			  if (unColisionador.coinciden(obstaculoSiguiente, unAutomovil)){
				  this.informarColision(obstaculoSiguiente);
				  obstaculoYaChocado = obstaculoSiguiente;
				  obstaculoSiguiente = pistaDeAutos.getObstaculoSiguiente();
			  }
		  }
	}
	
	
	/*
	 * PRE: s�lo puede ser llamado por this.chequearColisiones()
	 */
	private void informarColision(Obstaculo obstaculoChocado){
		if (obstaculoYaChocado != obstaculoChocado){
			unAutomovil.desgastarPorObstaculo (obstaculoChocado);
		}
	}
		
	
	private void informarTerreno(){
		if (autoAvanzoUnMetro){
			unAutomovil.desgastarPorTerreno(pistaDeAutos.getTerreno(posicionAutoDiscretaEnY));
		}
	}	
		
	private void chequearFinDePista() throws ExcepcionPistaFinalizada{
		if (this.posicionAutoDiscretaEnY == this.pistaDeAutos.getLargo()){
			this.registrarTiempo();
			throw new ExcepcionPistaFinalizada();
		}
	}

	/*
	 * Con este m�todo se registra el tiempo que tard� en correr la pista
	 */
	private void registrarTiempo() {
		// TODO Auto-generated method stub
		
	}


}

	



