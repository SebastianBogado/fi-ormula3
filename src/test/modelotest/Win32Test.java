package test.modelotest;

import junit.framework.TestCase;
import modelo.Win32;

import org.junit.Before;
import org.junit.Test;

public class Win32Test extends TestCase {

	private Win32 motor;

	@Override
	@Before
	public void setUp() throws Exception {
		motor = new Win32();
	}

	@Test
	public void testVelocidad() {

		long velInst = (long) Math.ceil(motor.acelerar(5.2, 0));
		long velMax = (long) Math.ceil(motor.VelocidadMaxima());

		assertTrue(velInst == velMax);
	}

	@Test
	public void testMotor() {
		Win32 nuevoMotor = new Win32();
		String nombreMotor = "Win32";

		assertTrue(nombreMotor.equals(nuevoMotor.motor()));
	}

	@Test
	public void testWin32() {
		assertTrue(motor.VelocidadMaxima() == 100.0);
	}

}
