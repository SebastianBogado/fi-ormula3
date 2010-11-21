package pruebas;

import junit.framework.TestCase;
import modelo.Mess10;
import modelo.Pozo;

import org.junit.Before;
import org.junit.Test;

public class PozoTest extends TestCase {

	private Pozo pozo;

	@Override
	@Before
	public void setUp() throws Exception {

		pozo = new Pozo(1, 1);
	}

	@Test
	public void testPozo() {
		double daño = 0;
		daño = pozo.chocarCon(new Mess10());
		assertTrue(daño > 0);
	}

}
