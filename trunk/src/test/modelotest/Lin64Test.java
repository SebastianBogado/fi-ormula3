package test.modelotest;

import junit.framework.TestCase;
import modelo.Lin64;

import org.junit.Before;
import org.junit.Test;

public class Lin64Test extends TestCase {
	private Lin64 motor;

	@Override
	@Before
	public void setUp() throws Exception {
		motor = new Lin64();
	}

	@Test
	public void testVelocidad() {

		long velInst = (long) Math.ceil(motor.acelerar(10, 0));
		long velMax = (long) Math.ceil(motor.VelocidadMaxima());

		assertTrue(velInst == velMax);
	}

	@Test
	public void testMotor() {
		Lin64 nuevoMotor = new Lin64();
		String nombreMotor = "Lin64";

		assertTrue(nombreMotor.equals(nuevoMotor.motor()));

	}

	@Test
	public void testLin64() {
		assertTrue(motor.VelocidadMaxima() == 120.0);
	}

}
