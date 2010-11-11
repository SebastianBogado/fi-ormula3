package pruebas;

import junit.framework.TestCase;
import modelo.Motor;

import org.junit.Test;

public class MotorTest extends TestCase {

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

}
