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
		double daño = 0;
		daño = loma.chocarCon(Neumatico.NuevoNeumatico(1));
		assertTrue(daño > 0);
	}

}
