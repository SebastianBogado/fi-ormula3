package modelo;

import java.util.ArrayList;

import modelo.excepciones.ExcepcionDificultadInvalida;
import java.util.LinkedList;
import java.util.Iterator;

public class Pista {
	
	private LinkedList<Pozo> ListaDePozos;
	private LinkedList<LomaDeBurro> ListaDeLomasDeBurro;
	private LinkedList<CambioDeTerreno> ListaDeCambiosDeTerreno;
	private Iterator <CambioDeTerreno> IteradorListaDeCambiosDeTerreno;
	private Iterator <Pozo> IteradorListaDePozos;
	private Iterator <LomaDeBurro> IteradorListaDeLomasDeBurro;
	private Pozo PoximoPozo;
	private LomaDeBurro ProximaLomaDeBurro;
	private Terreno TerrenoActual;
	private int PosicionDeCambioDeTerreno;
	
	
	public Pista(){
		ListaDePozos= new LinkedList<Pozo>();
		ListaDeLomasDeBurro= new LinkedList<LomaDeBurro>();
		ListaDeCambiosDeTerreno = new LinkedList<CambioDeTerreno>();
		
		IteradorListaDePozos=ListaDePozos.iterator();
		IteradorListaDeLomasDeBurro=ListaDeLomasDeBurro.iterator();
		IteradorListaDeCambiosDeTerreno=ListaDeCambiosDeTerreno.iterator();
		
		this.ActualizarTerreno();		
		
	}
	
	
	
	/*
	 * carga la pista desde el archivo XML pasado por parámetro
	 */
	public void cargarPista(String ubicacion){
		//@todo
	}
	
	private void cargarListaEstaticaDePozos(int AnchoPista,int LargoPista,int CantidadDePozos){
			
		int posicionPozoX=0;
		int posicionPozoY=0;
		Pozo unPozo;
		
		if (posicionPozoY>LargoPista){
			for (int i=1;i<=CantidadDePozos;i++){			
				if(posicionPozoX==AnchoPista)
					posicionPozoX=0;
				posicionPozoX++;
				posicionPozoY+=1000;
				unPozo=new Pozo(posicionPozoX,posicionPozoY);				
				ListaDePozos.add(i,unPozo);
			}
		}
		
	}
	
	
	private void cargarListaEstaticaDeLomasDeBurro(int AnchoPista,int LargoPista,int CantidadDeLomasDeBurro){
		
		int posicionLomaDeBurroEnX=1;
		int posicionLomaDeBurroEnY=200;
		LomaDeBurro unaLomaDeBurro;
		
		if (posicionLomaDeBurroEnY<LargoPista)
			for(int i=1;i<=CantidadDeLomasDeBurro;i++){
				posicionLomaDeBurroEnX=+1000;
				unaLomaDeBurro= new LomaDeBurro (posicionLomaDeBurroEnX,posicionLomaDeBurroEnY,AnchoPista);
				ListaDeLomasDeBurro.add(i,unaLomaDeBurro);
			}		
		
	}
	
	public void cargarPistaEstatica (){
		int AnchoPista=6;
	
		
	}
	
	/*
	 * devulve la lista que contiene los pozos a lo largo de la pista
	 */
	LinkedList<Pozo> getListaDePozos(){
		return this.ListaDePozos;
	}
	
	/*
	 * devulve la lista que contiene las lomas de burro a lo largo de la pista
	 */
	LinkedList<LomaDeBurro> getListaDeLomasDeBurro(){
		return this.ListaDeLomasDeBurro;
	}
	
	public LinkedList<CambioDeTerreno> getListaDeCambiosDeTerreno(){
		return this.ListaDeCambiosDeTerreno;
	}
	
	private void ActualizarProximoPozo(){
		if (IteradorListaDePozos.hasNext())
			this.PoximoPozo= IteradorListaDePozos.next();		
	}
	
	
	private void ActualiarProximaLomaDeBurro(){
		if(IteradorListaDeLomasDeBurro.hasNext())
				this.ProximaLomaDeBurro=IteradorListaDeLomasDeBurro.next();			
	}
	
	
	public Obstaculo getObstaculoSiguiente(){
		
		double posicionProximoPozo=this.PoximoPozo.posicionEsquinaInferiorIzquierda().y();
		double posicionProximaLomaDeBurro=this.ProximaLomaDeBurro.posicionEsquinaInferiorIzquierda().y();
		Obstaculo obstaculoSiguiente;
		
		if(posicionProximoPozo<posicionProximaLomaDeBurro){
			obstaculoSiguiente=PoximoPozo;
			this.ActualizarProximoPozo();
		}
		else
		{
			obstaculoSiguiente=ProximaLomaDeBurro;
			this.ActualiarProximaLomaDeBurro();
		}
		return obstaculoSiguiente;	
	}
	
	private void ActualizarTerreno(){
		if(IteradorListaDeCambiosDeTerreno.hasNext())
			TerrenoActual=IteradorListaDeCambiosDeTerreno.next().getTipoDeTerreno();		
	}
	

	
	
	public  Terreno getTerreno (long posicionAutoDiscretaEnY){
		if(posicionAutoDiscretaEnY<this.PosicionDeCambioDeTerreno)
			return this.TerrenoActual;
		else{
			this.ActualizarTerreno();
			return this.TerrenoActual;
		}		
	}
	
	
	/*
	 * devuelve el tipo de terreno en la posición pasada como parámetro
	 */
	/*public Terreno getTerreno(Posicion posicion){
		//@todo
		return null;
	}*/
	
	/*
	 * devuelve la lista de obstaculos, ordenada por posicion.y
	 * o devuelve una lista de listas de obstaculos (una por carril), ordenada
	 */
	public ArrayList<Obstaculo> getObstaculos(){
		//@todo
		return null;
	}
	
	/*
	 * crea una pista aleatoria en base a la dificultad, hardcodeada en ints :D
	 * fuera de joda: pensar cómo dejarlo más lindo
	 */
	public void aleatoria(int dificultad) throws ExcepcionDificultadInvalida{
		switch (dificultad){
		case 1 : this.aleatoriaFacil(); break;
		case 2 : this.aleatoriaMedia(); break;
		case 3 : this.aleatoriaDificil();
		default: throw new ExcepcionDificultadInvalida();
		}
	}
	
	private void aleatoriaDificil() {
		// TODO Auto-generated method stub
		
	}

	private void aleatoriaMedia() {
		// TODO Auto-generated method stub
		
	}

	private void aleatoriaFacil() {
		// TODO Auto-generated method stub
		
	}
	
	
}
