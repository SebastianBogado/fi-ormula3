package test.serviciotest;

import static org.junit.Assert.assertTrue;
import modelo.Pozo;
import modelo.servicio.CuerpoExtenso;

import org.junit.Before;
import org.junit.Test;

public class CuerpoExtensoTest {

	private CuerpoExtenso cuerpo;

	@Before
	public void setUp() throws Exception {
		cuerpo = new Pozo(1, 1);
	}

	@Test
	public void testGetAncho() {
		assertTrue(cuerpo.getAncho() == 1);
	}

	@Test
	public void testGetLargo() {
		assertTrue(cuerpo.getLargo() == 1);
	}

	@Test
	public void testPosicionEsquinaInferiorIzquierda() {
		assertTrue(cuerpo.posicionEsquinaInferiorIzquierda().x() == 1.0);
		assertTrue(cuerpo.posicionEsquinaInferiorIzquierda().y() == 1.0);
	}

}
