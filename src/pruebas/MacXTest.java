package pruebas;

import static org.junit.Assert.assertTrue;
import modelo.MacX;

import org.junit.Before;
import org.junit.Test;

public class MacXTest {

	private MacX motor;

	@Before
	public void setUp() throws Exception {
		motor = new MacX();
	}

	@Test
	public void testVelocidad() {

		long velInst = (long) Math.ceil(motor.acelerar(2, 0));
		long velMax = 80;// (long) Math.ceil(motor.VelocidadMaxima());

		assertTrue(velInst == velMax);

		velInst = (long) Math.ceil(motor.acelerar(15, 80));
		velMax = (long) Math.ceil(motor.VelocidadMaxima());
		assertTrue(velInst == velMax);

	}

	@Test
	public void testMotor() {
		MacX nuevoMotor = new MacX();
		assertTrue("MacX".equals(nuevoMotor.motor()));
	}

	@Test
	public void testMacX() {
		assertTrue(motor.VelocidadMaxima() == 150.0);
	}

}
