package modelo;



import modelo.excepciones.ExcepcionDificultadInvalida;
import modelo.excepciones.ExcepcionLimitesIncorrectosEnElTerreno;

import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Attribute;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;






public class Pista {
	
	
	private static final long serialVersionUID = 1L;
	
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
	
	private String NombreDeLaPista;
	private int AnchoDeLaPista;
	private int LargoDeLaPista;
	private int CantidadDePozos;
	private int CantidadDeLomasDeBurro;
	private int CantidadDeTerrenos;
	
	/*
	 * crea una pista por Default
	 */
	
	public Pista(){
		this.crearListas();
		this.cargarPistaEstatica();
		this.inicializar();
	}
	
	/*
	 * crea una pista aleatoria con la fificultad especificada (1-3)
	 */
	
	public Pista(int dificultad) throws ExcepcionDificultadInvalida{
		
		this.crearListas();
		this.aleatoria(dificultad);
		this.inicializar();	
	}
	
	/*
	 *crea una pista a partir de un archivo xml 
	 */
	public Pista (String pathArchivo){
		this.crearListas();
		this.cargarPistaDesdeXML(pathArchivo);
		this.inicializar();
	}
	
	private void crearListas(){
		ListaDePozos= new LinkedList<Pozo>();
		ListaDeLomasDeBurro= new LinkedList<LomaDeBurro>();
		ListaDeTerrenos = new LinkedList<Terreno>();
	}
		/*
		 * asigna iteradores a las listas
		 * actualiza los elementos de la pista por primera vez
		 */
	private void inicializar(){
		
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
		return this.LargoDeLaPista;
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
	
	
	private void cargarListaEstaticaTerrenos(int LargoPista){
		
		Terreno unTerreno;
		
				
		try{
			unTerreno= new Asfalto(0,4000);	
			this.ListaDeTerrenos.add(0,unTerreno);
		}
		catch (Exception e){}
		
		
		try{
			unTerreno= new Tierra(4001,7000);
			this.ListaDeTerrenos.add(1,unTerreno);
		}
		catch (Exception e){}
		
		
		try{
			unTerreno= new Ripio(7001,LargoPista);
			this.ListaDeTerrenos.add(2,unTerreno);
		}
		catch (Exception e){}
		
	}
	
	/*
	 * crea una pista estatica que es igual en todas las ejecucuiones
	 */
	
	public void cargarPistaEstatica (){
		
		this.NombreDeLaPista="Default";
		this.LargoDeLaPista=10000;
		this.AnchoDeLaPista=6;
		this.CantidadDePozos=10;
		this.CantidadDeLomasDeBurro=10;
		this.CantidadDeTerrenos=3;
		
		
		this.cargarListaEstaticaDePozos(this.AnchoDeLaPista, this.LargoDeLaPista, CantidadDePozos);
		
		this.cargarListaEstaticaDeLomasDeBurro(this.AnchoDeLaPista, this.LargoDeLaPista, CantidadDeLomasDeBurro);

		this.cargarListaEstaticaTerrenos(this.LargoDeLaPista);		
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
	
	/*
	 * retorna un elemento xml que conteiene la pista
	 */

	public Element serializarXML(){
		Element element = new Element ("Pista");
		
		Attribute NombreDeLaPista = new Attribute ("NombreDeLaPista",this.NombreDeLaPista);
		element.getAttributes().add(NombreDeLaPista);
		
		Attribute LagroDeLaPista = new Attribute ("LargoDeLaPista",String.valueOf(this.LargoDeLaPista));
		element.getAttributes().add(LagroDeLaPista);
		
		Attribute AnchoDeLaPista = new Attribute ("AnchoDeLaPista",String.valueOf(this.AnchoDeLaPista));
		element.getAttributes().add(AnchoDeLaPista);
		
		this.serializarListaDePozosXML(element);
		
		this.serializarListaDeLomasDeBurroXML(element);
		
		this.serializarListaDeTerrenosXML(element);	
		
		return element;		
	}
	
	/*
	 * retorna un elemento xml que contiene la lista de pozos
	 */

	private Element serializarListaDePozosXML(Element elementPista){
		
		Pozo unPozo;
		
		Element ListaDePozos=new Element ("ListaDePozos"); 
		Attribute CantidadDePozos =new Attribute ("CantidadDePozos",String.valueOf(this.CantidadDePozos));
		ListaDePozos.getAttributes().add(CantidadDePozos);
		elementPista.getChildren().add(ListaDePozos);	
		
		unPozo= this.ListaDePozos.getFirst();
		ListaDePozos.getChildren().add(unPozo.serializarXML());
		
		while(this.IteradorListaDePozos.hasNext()) {
			unPozo= this.IteradorListaDePozos.next();
			ListaDePozos.getChildren().add(unPozo.serializarXML());
		};
		
		return ListaDePozos;
	}
	
	/*
	 * retorna un elemento xml que contiene la lista de lomas de burro
	 */
	private Element serializarListaDeLomasDeBurroXML(Element elementPista){
		
		LomaDeBurro unaLomaDeBurro;
		
		Element ListaDeLomasDeBurro=new Element ("ListaDeLomasDeBurro"); 
		Attribute CantidadDeLomasDeBurro =new Attribute ("CantidadDeLomasDeBurro",String.valueOf(this.CantidadDeLomasDeBurro));
		ListaDeLomasDeBurro.getAttributes().add(CantidadDeLomasDeBurro);
		elementPista.getChildren().add(ListaDeLomasDeBurro);
		
		unaLomaDeBurro = this.ListaDeLomasDeBurro.getFirst();
		ListaDeLomasDeBurro.getChildren().add(unaLomaDeBurro.serializarXML());
		
		while (this.IteradorListaDeLomasDeBurro.hasNext()) {
			unaLomaDeBurro = this.IteradorListaDeLomasDeBurro.next();
			ListaDeLomasDeBurro.getChildren().add(unaLomaDeBurro.serializarXML());
		};
		
		return ListaDeLomasDeBurro;
		
	}
	
	/*
	 * retorna un elemento xml que contiene la lista de terrenos
	 */
	private Element serializarListaDeTerrenosXML(Element elementPista){
		
		Terreno unTerreno;
		
		Element ListaDeTerrenos=new Element ("ListaDeTerrenos"); 
		Attribute CantidadDeTerrenos =new Attribute ("CantidadDeTerrenos",String.valueOf(this.CantidadDeTerrenos));
		ListaDeTerrenos.getAttributes().add(CantidadDeTerrenos);
		elementPista.getChildren().add(ListaDeTerrenos);
		
		unTerreno=this.ListaDeTerrenos.getFirst();
		ListaDeTerrenos.getChildren().add(unTerreno.serializarXML());
		
		while(this.IteradorListaDeTerrenos.hasNext()){		
			unTerreno = this.IteradorListaDeTerrenos.next();
			ListaDeTerrenos.getChildren().add(unTerreno.serializarXML());
		};	
		
		return ListaDeTerrenos;
		
	}
	

	/*
	 * guarda la pista en un archivo xml con el mismo nombre de la pista
	 */
	
	public void guardarEnXML(){
		
		try{
			
			Element root = this.serializarXML();
			Document document = new Document(root);
		
			XMLOutputter outputter = new XMLOutputter();
			outputter.setFormat(Format.getPrettyFormat());
		
			FileWriter writer = new FileWriter(this.NombreDeLaPista+".xml");
			outputter.output(document,writer);
			writer.close();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
}

	/*
	 * guarda la pista en un archivo xml con el nombre recivido
	 */
	
	public void guardarComoEnXML(String pathArchivo){
	
		try{
		
			Element root = this.serializarXML();
			Document document = new Document(root);
	
			XMLOutputter outputter = new XMLOutputter();
			outputter.setFormat(Format.getPrettyFormat());
	
			FileWriter writer = new FileWriter(pathArchivo);
			outputter.output(document,writer);
			writer.close();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
}

	/*
	 * extrae el elemento raiz de un archivo xml
	 */
	private  void cargarPistaDesdeXML(String pathArchivo) {
		try {
	        SAXBuilder builder = new SAXBuilder();
	        Document document = builder.build(pathArchivo);
	       	        
	        Element RootElement=document.getRootElement();
	        this.deserializarXML( RootElement);
	        
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * crea la pista a partir de un elemento raiz xml
	 */

	private void deserializarXML (Element elementPista){
		
		this.NombreDeLaPista = elementPista.getAttributeValue("NombreDeLaPista");
		String LargoDeLaPista = elementPista.getAttributeValue("LargoDeLaPista");
		String AnchoDeLaPista = elementPista.getAttributeValue("AnchoDeLaPista");
			
		this.LargoDeLaPista= Integer.parseInt(LargoDeLaPista);
		this.AnchoDeLaPista= Integer.parseInt(AnchoDeLaPista);
		
		this.deserializarListaDePozosXML(elementPista);
		this.deserializarListaDeLomasDeBurroXML(elementPista);
		this.deserializarListaDeTerrenosXML(elementPista);
		
		
	}
	
	/*
	 * crea la lista de pozos a partir de un elemento xml
	 */
	private void deserializarListaDePozosXML(Element elementPista){
		
		Pozo unPozo;
		Element elementPozo;
		
		Element elementListaDePozos= elementPista.getChild("ListaDePozos");	
		String stringCantidadDePozos=elementListaDePozos.getAttributeValue("CantidadDePozos");
		this.CantidadDePozos= Integer.parseInt(stringCantidadDePozos);
		
		List<Element> ListaDePozos = elementListaDePozos.getChildren("Pozo");	
		Iterator<Element> IteradorPozos= ListaDePozos.iterator();
		
		while (IteradorPozos.hasNext()){		
		 elementPozo= IteradorPozos.next();
		 unPozo=new Pozo(elementPozo);
		 this.ListaDePozos.add(unPozo);
		}
	}
	
	/*
	 * crea la lista de lomas de burro a partir de un elemento xml
	 */
	private void deserializarListaDeLomasDeBurroXML(Element elementPista){
		
		LomaDeBurro unaLomaDeBurro;
		Element elementLomaDeBurro;
		
		Element elementListaDeLomasDeBurro= elementPista.getChild("ListaDeLomasDeBurro");
		String stringCantidadDeLomasDeBurro= elementListaDeLomasDeBurro.getAttributeValue("CantidadDeLomasDeBurro");
		this.CantidadDeLomasDeBurro= Integer.parseInt(stringCantidadDeLomasDeBurro);
		
		List<Element>  ListaDeLomasDeBurro= elementListaDeLomasDeBurro.getChildren("LomaDeBurro");
		Iterator<Element> IteradorListaDeLomasDeBurro=ListaDeLomasDeBurro.iterator();
		
		while(IteradorListaDeLomasDeBurro.hasNext()){
			elementLomaDeBurro= IteradorListaDeLomasDeBurro.next();
			unaLomaDeBurro= new LomaDeBurro (elementLomaDeBurro,this.AnchoDeLaPista);
			this.ListaDeLomasDeBurro.add(unaLomaDeBurro);
		}		
	}
	
	/*
	 * crea la lista de terrenos a partir de un elemento xml
	 */
	
	private void deserializarListaDeTerrenosXML(Element elementPista){
		Terreno unTerreno = null;
		Element elementTerreno;
		
		Element elementListaDeTerrenos = elementPista.getChild("ListaDeTerrenos");
		String stringCantidadDeTerrenos= elementListaDeTerrenos.getAttributeValue("CantidadDeTerrenos");
		this.CantidadDeTerrenos= Integer.parseInt(stringCantidadDeTerrenos);
		
		List<Element> ListaDeTerrenos= elementListaDeTerrenos.getChildren();
		Iterator<Element> IteradorListaDeTerrenos= ListaDeTerrenos.iterator();
		
		while(IteradorListaDeTerrenos.hasNext()){
			elementTerreno=	IteradorListaDeTerrenos.next();
			String TipoDeTerreno= elementTerreno.getName();
			try{
				if(TipoDeTerreno.equals("Asfalto"))
					unTerreno= new Asfalto(elementTerreno);
				if(TipoDeTerreno.equals("Tierra"))
					unTerreno= new Tierra(elementTerreno);
				if(TipoDeTerreno.equals("Ripio"))
					unTerreno= new Ripio(elementTerreno);
	
				this.ListaDeTerrenos.add(unTerreno);
			}
			catch(Exception e){}
		}	
	}	
}
