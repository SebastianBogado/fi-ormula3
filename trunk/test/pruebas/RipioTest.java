package pruebas;

import junit.framework.TestCase;
import modelo.Ripio;
import modelo.excepciones.ExcepcionLimitesIncorrectosEnElTerreno;

import org.junit.Test;

public class RipioTest extends TestCase {

	private Ripio terreno;

	@Test
	public void testRipio() throws ExcepcionLimitesIncorrectosEnElTerreno {

		terreno = new Ripio(50, 100);

		assertTrue(terreno.principio() == 50);

		assertTrue(terreno.fin() == 100);

	}

}
