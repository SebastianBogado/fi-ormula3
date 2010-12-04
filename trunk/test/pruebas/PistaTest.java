package pruebas;

import static org.junit.Assert.*;

import modelo.Asfalto;
import modelo.LomaDeBurro;
import modelo.Pista;
import modelo.Obstaculo;
import modelo.Pozo;
import modelo.Terreno;
import modelo.excepciones.ExcepcionLimitesIncorrectosEnElTerreno;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PistaTest {

	Pista unaPista;
	
	
	@Before
	public void setUp() throws Exception {
		unaPista=new Pista();
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	
	@Test
	public void testGetObstaculoSiguiente(){
		
		Obstaculo unObstaculo; ;
		unObstaculo= unaPista.getObstaculoSiguiente();
		assertTrue(unObstaculo.posicionEsquinaInferiorIzquierda().x()==1);
		assertTrue(unObstaculo.posicionEsquinaInferiorIzquierda().y()==120);
		unObstaculo= unaPista.getObstaculoSiguiente();
		assertTrue(unObstaculo.posicionEsquinaInferiorIzquierda().x()==2);
		assertTrue(unObstaculo.posicionEsquinaInferiorIzquierda().y()==240);
	}
	
	@Test
	public void TestGetTerreno(){
		
		Terreno unTerreno;
		unTerreno=this.unaPista.getTerreno(0);
		assertTrue(unTerreno.principio()==0);
		assertTrue(unTerreno.fin()==500);
		unTerreno=this.unaPista.getTerreno(501);
		assertTrue(unTerreno.principio()==501);
		assertTrue(unTerreno.fin()==800);
		unTerreno=this.unaPista.getTerreno(801);
		assertTrue(unTerreno.principio()==801);
		assertTrue(unTerreno.fin()== unaPista.getLargo());
		
	}
	
	
	
	@Test
	public void testGuardarEnXML(){
			
		this.unaPista.guardarEnXML();
	}
	
	@Test
	public void testCargarDesdeXML(){
	
		String unaString ="\\pistas\\Default.xml";
		
		Pista unaPista =new Pista(unaString);
		
		assertTrue(unaPista!=null);
	}
	
	@Test
	public void testGetLargo(){
		
		assertTrue(unaPista.getLargo()==2000);
	}
	
	@Test
	public void testGetListaDePozos(){
		unaPista.getListaDePozos().getFirst().equals(new Pozo(1,1000));
		
	}
	@Test
	public void testGetListaDeLomasDeBurro(){
		unaPista.getListaDeLomasDeBurro().getFirst().equals(new LomaDeBurro(1,1200,6));
		
	}
	
	@Test
	public void testGetListaDeTerrenos(){
		try {
			unaPista.getListaDeTerrenos().getFirst().equals(new Asfalto(0,4000));
		} catch (ExcepcionLimitesIncorrectosEnElTerreno e) {
			e.printStackTrace();
		}
		
	}

}
