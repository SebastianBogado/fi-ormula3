package test.serviciotest;

import static org.junit.Assert.assertTrue;
import modelo.servicio.Posicion;
import modelo.servicio.Velocidad;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VelocidadTest {

	private Velocidad vel;

	@Before
	public void setUp() throws Exception {
		vel = new Velocidad(0, 0);
	}

	@After
	public void tearDown() throws Exception {
		vel.x(0);
		vel.y(0);
	}

	@Test
	public void testVariacionDePosicion() {
		vel.x(1);
		vel.y(60);
		Posicion nuevaPosicion = vel.variacionDePosicion(0.5);
		assertTrue(nuevaPosicion.x() == 0.5);
		assertTrue(nuevaPosicion.y() == 30.0);

	}

	@Test
	public void testRapidez() {
		vel.x(4.0);
		vel.y(3.0);
		assertTrue(vel.rapidez() == 5.0);
	}

}
