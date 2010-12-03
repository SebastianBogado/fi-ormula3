package pruebas;

import junit.framework.TestCase;
import modelo.servicio.Vector2D;

import org.junit.Before;
import org.junit.Test;

public class Vector2DTest extends TestCase {

	private Vector2D vector;

	@Override
	@Before
	public void setUp() throws Exception {
		vector = new Vector2D(0, 0);
	}

	@Test
	public void testX() {
		vector.x(50.0);
		assertTrue(vector.x() == 50.0);
	}

	@Test
	public void testY() {
		vector.y(25.2);
		assertTrue(vector.y() == 25.2);
	}

}
