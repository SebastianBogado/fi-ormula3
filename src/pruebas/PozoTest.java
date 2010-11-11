package pruebas;

import junit.framework.TestCase;
import modelo.Neumatico;
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
		double da�o = 0;
		da�o = pozo.chocarCon(Neumatico.NuevoNeumatico(1));
		assertTrue(da�o > 0);
	}

}
