package modelo;



import modelo.excepciones.ExcepcionDificultadInvalida;
import java.util.LinkedList;
import java.util.Iterator;

public class Pista {
	
	private LinkedList<Pozo> ListaDePozos;
	private LinkedList<LomaDeBurro> ListaDeLomasDeBurro;
	private LinkedList<Terreno> ListaDeTerrenos;
	
	private Iterator <Pozo> IteradorListaDePozos;
	private Iterator <LomaDeBurro> IteradorListaDeLomasDeBurro;
	private Iterator <Terreno> IteradorListaDeTerrenos;
	
	private Pozo PoximoPozo;
	private LomaDeBurro ProximaLomaDeBurro;
	private Terreno TerrenoActual;
	
	private int PosicionDeCambioDeTerreno;
	private int LagroDeLaPista;
	
	
	public Pista(){
		ListaDePozos= new LinkedList<Pozo>();
		ListaDeLomasDeBurro= new LinkedList<LomaDeBurro>();
		ListaDeTerrenos = new LinkedList<Terreno>();
		
		this.cargarPistaEstatica();
		
		IteradorListaDePozos=ListaDePozos.iterator();
		IteradorListaDeLomasDeBurro=ListaDeLomasDeBurro.iterator();
		IteradorListaDeTerrenos=ListaDeTerrenos.iterator();
		
		this.ActualizarTerreno();
		this.ActualizarProximoPozo();
		this.ActualiarProximaLomaDeBurro();
		
	}
	
	
	
	/*
	 * carga la pista desde el archivo XML pasado por parámetro
	 */
	public void cargarPista(String ubicacion){
		//@todo
	}
	
	public int getLargo(){
		return this.LagroDeLaPista;
	}
	
	/*
	 * carga la lista de poszos con valores predeterminados
	 */
	
	private void cargarListaEstaticaDePozos(int AnchoPista,int LargoPista,int CantidadDePozos){
			
		int posicionPozoX=0;
		int posicionPozoY=0;
		Pozo unPozo;
		
		if (posicionPozoY<LargoPista){
			for (int i=0;i<CantidadDePozos;i++){			
				if(posicionPozoX==AnchoPista)
					posicionPozoX=0;
				posicionPozoX++;
				posicionPozoY+=1000;
				unPozo=new Pozo(posicionPozoX,posicionPozoY);				
				ListaDePozos.add(i,unPozo);
			}
		}
		
	}
	
	/*
	 * carga la lista de LomasDeBurro con valores predeterminados
	 */
	
	private void cargarListaEstaticaDeLomasDeBurro(int AnchoPista,int LargoPista,int CantidadDeLomasDeBurro){
		
		int posicionLomaDeBurroEnX=1;
		int posicionLomaDeBurroEnY=200;
		LomaDeBurro unaLomaDeBurro;
		
		if (posicionLomaDeBurroEnY<LargoPista)
			for(int i=0;i<CantidadDeLomasDeBurro;i++){
				posicionLomaDeBurroEnY+=1000;
				unaLomaDeBurro= new LomaDeBurro (posicionLomaDeBurroEnX,posicionLomaDeBurroEnY,AnchoPista);
				ListaDeLomasDeBurro.add(i,unaLomaDeBurro);
			}		
		
	}
	
	/*
	 * caraga la lista de terrenos con un terreno de cada tipo de longitud predeterminada
	 */
	
	
	private void cargarListaEstaticaTerrenos(){
		
		Terreno unTerreno;
				
		try{
			unTerreno= new Asfalto(0,4000);	
			this.ListaDeTerrenos.add(0,unTerreno);
		}
		catch (Exception e){}
		
		
		try{
			unTerreno= new Ripio(4001,7000);
			this.ListaDeTerrenos.add(1,unTerreno);
		}
		catch (Exception e){}
		
		
		try{
			unTerreno= new Ripio(7001,10000);
			this.ListaDeTerrenos.add(2,unTerreno);
		}
		catch (Exception e){}
		
	}
	
	/*
	 * crea una pista estatica que es igual en todas las ejecucuiones
	 */
	
	public void cargarPistaEstatica (){
		int AnchoPista=6;
		int LargoPista=10000;		
		int CantidadDePozos=10;
		int CantidadDeLomasDeBurro=10;
		
		this.cargarListaEstaticaDePozos(AnchoPista, LargoPista, CantidadDePozos);
		
		this.cargarListaEstaticaDeLomasDeBurro(AnchoPista, LargoPista, CantidadDeLomasDeBurro);

		this.cargarListaEstaticaTerrenos();		
	}
	
	/*
	 * devulve la lista que contiene los pozos a lo largo de la pista
	 */
	public LinkedList<Pozo> getListaDePozos(){
		return this.ListaDePozos;
	}
	
	/*
	 * devulve la lista que contiene las lomas de burro a lo largo de la pista
	 */
	public LinkedList<LomaDeBurro> getListaDeLomasDeBurro(){
		return this.ListaDeLomasDeBurro;
	}
	
	public LinkedList<Terreno> getListaDeTerrenos(){
		return this.ListaDeTerrenos;
	}
	
	/*
	 * 
	 */
	private void ActualizarProximoPozo(){
		if (IteradorListaDePozos.hasNext())
			this.PoximoPozo= IteradorListaDePozos.next();		
	}
	
	/*
	 * 
	 */
	private void ActualiarProximaLomaDeBurro(){
		if(IteradorListaDeLomasDeBurro.hasNext())
				this.ProximaLomaDeBurro=IteradorListaDeLomasDeBurro.next();			
	}
	
	/*
	 * devuelve el obstaculo mas proximo a colisionar con el auot
	 */
	
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
		if(IteradorListaDeTerrenos.hasNext()){
			this.TerrenoActual=this.IteradorListaDeTerrenos.next();
			this.PosicionDeCambioDeTerreno=TerrenoActual.fin();
		}
	}
	
	/*
	 * devuelve el Terreno actaul
	 */
	
	
	public  Terreno getTerreno (long posicionAutoDiscretaEnY){
		if(posicionAutoDiscretaEnY<this.PosicionDeCambioDeTerreno)
			return this.TerrenoActual;
		else{
			this.ActualizarTerreno();
			return this.TerrenoActual;
		}		
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
