package pruebas;

import junit.framework.TestCase;
import modelo.LomaDeBurro;
import modelo.Neumatico;

import org.junit.Before;
import org.junit.Test;

public class LomaDeBurroTest extends TestCase {

	private LomaDeBurro loma;

	@Override
	@Before
	public void setUp() throws Exception {

		loma = new LomaDeBurro(1, 1, 3);
	}

	@Test
	public void testLomaDeBurro() {
		double da�o = 0;
		da�o = loma.chocarCon(Neumatico.NuevoNeumatico(1));
		assertTrue(da�o > 0);
	}

}
