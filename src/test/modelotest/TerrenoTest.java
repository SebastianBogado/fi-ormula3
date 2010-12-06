package test.modelotest;

import junit.framework.TestCase;
import modelo.Asfalto;
import modelo.Terreno;

import org.junit.Before;
import org.junit.Test;

public class TerrenoTest extends TestCase {

	private Terreno terreno;

	@Override
	@Before
	public void setUp() throws Exception {
		terreno = new Asfalto(10, 20);
	}

	@Test
	public void testFin() {
		assertTrue(terreno.fin() == 20);
	}

	@Test
	public void testPrincipio() {
		assertTrue(terreno.principio() == 10);
	}

}
