package pruebas;

import junit.framework.TestCase;
import modelo.Motor;

import org.junit.Test;

public class MotorTest extends TestCase {
	Motor motor;

	@Override
	public void setUp() {
		motor = Motor.NuevoMotorDeTipo(1);
	}

	@Test
	public void testFrenar() {
		Motor motor = Motor.NuevoMotorDeTipo(1);
		double velocDisminuida = motor.frenar(5);
		assertTrue(velocDisminuida == -125.0);
	}

	@Test
	public void testNuevoMotorDeTipo() {
		Motor nuevoMotor1 = Motor.NuevoMotorDeTipo(1);
		assertTrue("Lin64".equals(nuevoMotor1.motor()));
		Motor nuevoMotor2 = Motor.NuevoMotorDeTipo(2);
		assertTrue("Win32".equals(nuevoMotor2.motor()));
		Motor nuevoMotor3 = Motor.NuevoMotorDeTipo(3);
		assertTrue("MacX".equals(nuevoMotor3.motor()));
		Motor nuevoMotor4 = Motor.NuevoMotorDeTipo(5);
		assertTrue("Lin64".equals(nuevoMotor4.motor()));
	}

	@Test
	public void testVelocidadMaxima() {
		motor = Motor.NuevoMotorDeTipo(1);
		assertEquals(120.0, motor.VelocidadMaxima());
		motor = Motor.NuevoMotorDeTipo(2);
		assertEquals(100.0, motor.VelocidadMaxima());
		motor = Motor.NuevoMotorDeTipo(3);
		assertEquals(150.0, motor.VelocidadMaxima());
		motor = Motor.NuevoMotorDeTipo(5647);
		assertEquals(120.0, motor.VelocidadMaxima());
	}

}
