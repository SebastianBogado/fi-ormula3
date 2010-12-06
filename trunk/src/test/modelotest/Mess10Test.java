package test.modelotest;

import junit.framework.TestCase;
import modelo.Mess10;

import org.junit.Before;
import org.junit.Test;

public class Mess10Test extends TestCase {
	private Mess10 neumaticos;

	@Override
	@Before
	public void setUp() throws Exception {

		neumaticos = new Mess10();
	}

	@Test
	public void testDesgastarPorTerreno() {

		assertTrue(neumaticos.desgastePorAsfalto() == 0.0);
		assertTrue(neumaticos.desgastePorRipio() == 1.0 / 100.0);
		assertTrue(neumaticos.desgastePorTierra() == 1.0 / 70.0);
	}

	@Test
	public void testDesgastarPorObstaculo() {
		assertTrue(neumaticos.chocarConPozo() == 5.0);
		assertTrue(neumaticos.chocarConLomaDeBurro() == 10);
	}

	public void testTipo() {
		assertTrue(neumaticos.neumaticos().equals("Mess10"));
	}

}
