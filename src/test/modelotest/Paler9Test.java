package test.modelotest;

import junit.framework.TestCase;
import modelo.Paler9;

import org.junit.Before;
import org.junit.Test;

public class Paler9Test extends TestCase {

	private Paler9 neumaticos;

	@Override
	@Before
	public void setUp() throws Exception {
		neumaticos = new Paler9();
	}

	@Test
	public void testDesgastarPorTerreno() {

		assertTrue(neumaticos.desgastePorAsfalto() == 2.0 / 3000.0);
		assertTrue(neumaticos.desgastePorRipio() == 2.0 / 3000.0);
		assertTrue(neumaticos.desgastePorTierra() == 2.0 / 3000.0);
	}

	@Test
	public void testDesgastarPorObstaculo() {

		assertTrue(neumaticos.chocarConLomaDeBurro() == 6.0);
		assertTrue(neumaticos.chocarConPozo() == 6.0);
	}

	public void testTipo() {
		assertTrue(neumaticos.neumaticos().equals("Paler9"));
	}

}
