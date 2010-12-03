package pruebas;

import junit.framework.TestCase;
import modelo.Asfalto;
import modelo.excepciones.ExcepcionLimitesIncorrectosEnElTerreno;

import org.junit.Test;

public class AsfaltoTest extends TestCase {

	private Asfalto terreno;

	@Test
	public void testAsfalto() throws ExcepcionLimitesIncorrectosEnElTerreno {
		terreno = new Asfalto(100, 200);

		assertTrue(terreno.principio() == 100);

		assertTrue(terreno.fin() == 200);

	}

}