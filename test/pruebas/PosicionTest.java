package pruebas;

import junit.framework.TestCase;
import modelo.servicio.Posicion;

import org.junit.Before;
import org.junit.Test;

public class PosicionTest extends TestCase {

	private Posicion posicion;

	@Override
	@Before
	public void setUp() throws Exception {
		posicion = new Posicion(0, 0);
	}

	@Test
	public void testPosicion() {
		Posicion nuevaPosicion = new Posicion(3, 5);
		assertTrue(nuevaPosicion.x() == 3);
		assertTrue(nuevaPosicion.y() == 5);
	}

	@Test
	public void testMover() {
		posicion.x(5);
		posicion.y(12);

		posicion.mover(new Posicion(3, 2));

		assertTrue(posicion.x() == 8);
		assertTrue(posicion.y() == 14);

	}

}
