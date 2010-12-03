package pruebas;

import junit.framework.TestCase;
import modelo.Lin64;
import modelo.Mess10;
import modelo.Pozo;
import modelo.Automovil;
import modelo.servicio.Colisionador;

import org.junit.Before;
import org.junit.Test;

public class ColisionadorTest extends TestCase {

	private Colisionador colisionador;
	private Automovil unAutomovil;

	@Override
	@Before
	public void setUp() throws Exception {
		colisionador = new Colisionador();
		unAutomovil = new Automovil(new Lin64(), new Mess10());
	}

	@Test
	public void testPasoElObstaculo() {
		Pozo pozo = new Pozo(1,1);
		unAutomovil.acelerar(0.1);
		unAutomovil.actualizarPosicion(0.001);
		assertTrue(colisionador.pasoElObstaculo(pozo, unAutomovil));
	}

	@Test
	public void testCoinciden() {
		Pozo pozo = new Pozo(3, 0);
		assertTrue(colisionador.coinciden(pozo, unAutomovil));
	}

}
