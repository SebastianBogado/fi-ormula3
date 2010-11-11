package pruebas;

import junit.framework.TestCase;
import modelo.Colisionador;
import modelo.Pozo;

import org.junit.Before;
import org.junit.Test;

public class ColisionadorTest extends TestCase {

	private Colisionador colisionador;

	@Override
	@Before
	public void setUp() throws Exception {
		colisionador = new Colisionador();
	}

	@Test
	public void testPasoElObstaculo() {
		Pozo pozo = new Pozo(1, 1);
		assertTrue(colisionador.pasoElObstaculo(pozo, 3.0));
	}

	@Test
	public void testCoinciden() {
		Pozo pozo = new Pozo(1, 1);
		assertTrue(colisionador.coinciden(pozo, 1, 1));
	}

}
