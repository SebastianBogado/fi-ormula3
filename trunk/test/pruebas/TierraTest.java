package pruebas;

import junit.framework.TestCase;
import modelo.Tierra;
import modelo.excepciones.ExcepcionLimitesIncorrectosEnElTerreno;

import org.junit.Test;

public class TierraTest extends TestCase {

	private Tierra terreno;

	@Test
	public void testTierra() throws ExcepcionLimitesIncorrectosEnElTerreno {
		terreno = new Tierra(100, 200);

		assertTrue(terreno.principio() == 100);

		assertTrue(terreno.fin() == 200);
	}

}
