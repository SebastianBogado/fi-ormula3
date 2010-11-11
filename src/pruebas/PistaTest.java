package pruebas;

import static org.junit.Assert.*;


import java.util.Iterator;

import modelo.Pista;
import modelo.Pozo;
import modelo.LomaDeBurro;
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
	public void testCargarListaEstaticaDePozos(){
		Iterator <Pozo> IteradorListaDePozos= unaPista.getListaDePozos().iterator(); 
		this.unaPista.cargarPistaEstatica();
		
		if (IteradorListaDePozos.hasNext())
			assertTrue("Pozo".equals(IteradorListaDePozos.next()));
				
	}
	
	@Test
	public void testCargarListaEstaticaDeLomasDeBurro(){
		Iterator <LomaDeBurro> IteradorListaDeLomasDeBurro= unaPista.getListaDeLomasDeBurro().iterator(); 
		this.unaPista.cargarPistaEstatica();
		
		if (IteradorListaDeLomasDeBurro.hasNext())
			assertTrue("LomaDeBurro".equals(IteradorListaDeLomasDeBurro.next()));
	}
	
	@Test
	
	public void testCargarListaEstaticaTerrenos(){
		Iterator<Terreno> IteradorListaDeTerrenos=unaPista.getListaDeTerrenos().iterator();
		this.unaPista.cargarPistaEstatica();
		
		while(IteradorListaDeTerrenos.hasNext()){
			assertTrue("Asfalto".equals(IteradorListaDeTerrenos.next()));
			assertTrue("Ripio".equals(IteradorListaDeTerrenos.next()));
			assertTrue("Tierra".equals(IteradorListaDeTerrenos.next()));
		}
		
		
	}
	
	

	
	@Test
	public void testCargarPista() {
		fail("Not yet implemented");
	}

	@Test
	public void testAleatoria() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTerreno() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetObstaculos() {
		fail("Not yet implemented");
	}

}
