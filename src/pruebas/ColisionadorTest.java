package pruebas;

import junit.framework.TestCase;
import modelo.Colisionador;
import modelo.Pozo;
import modelo.Automovil;

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
		Pozo pozo = new Pozo(1,1);
		Automovil unAutomovil = new Automovil(1,1);
		unAutomovil.acelerar(0.1);
		unAutomovil.actualizarPosicion(0.001);
		assertTrue(colisionador.pasoElObstaculo(pozo, unAutomovil));
	}

	@Test
	public void testCoinciden() {
		Pozo pozo = new Pozo(0, 0);
		Automovil unAutomovil = new Automovil(1,1);
		assertTrue(colisionador.coinciden(pozo, unAutomovil));
	}

}
