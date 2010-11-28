package pruebas;

import static org.junit.Assert.*;

import modelo.Pista;
import modelo.Obstaculo;
import modelo.Terreno;

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
		assertTrue(unObstaculo.posicionEsquinaInferiorIzquierda().y()==1000);
		unObstaculo= unaPista.getObstaculoSiguiente();
		assertTrue(unObstaculo.posicionEsquinaInferiorIzquierda().x()==1);
		assertTrue(unObstaculo.posicionEsquinaInferiorIzquierda().y()==1200);
	}
	
	@Test
	public void TestGetTerreno(){
		
		Terreno unTerreno;
		unTerreno=this.unaPista.getTerreno(0);
		assertTrue(unTerreno.principio()==0);
		assertTrue(unTerreno.fin()==4000);
		unTerreno=this.unaPista.getTerreno(4001);
		assertTrue(unTerreno.principio()==4001);
		assertTrue(unTerreno.fin()==7000);
		unTerreno=this.unaPista.getTerreno(7001);
		assertTrue(unTerreno.principio()==7001);
		assertTrue(unTerreno.fin()==10000);
		
	}
	
	@Test
	public void testGuardarEnXML(){
			
		this.unaPista.guardarEnXML();
	}
	
	@Test
	public void testCargarDesdeXML(){
	
		String unaString ="Default.xml";
		
		Pista unaPista =new Pista(unaString);
	}
/*

	@Test
	public void testAleatoria() {
		fail("Not yet implemented");
	}
*/


}
