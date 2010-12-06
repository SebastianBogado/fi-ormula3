package test.modelotest;

import junit.framework.TestCase;
import modelo.Motor;
import modelo.servicio.FabricaAbstractaDeMotores;

import org.junit.Test;

public class MotorTest extends TestCase {
	Motor motor;
	FabricaAbstractaDeMotores fabrica;

	@Override
	public void setUp() {
		fabrica = new FabricaAbstractaDeMotores();
		motor = fabrica.instanciarMotor("Lin64");
	}

	@Test
	public void testFrenar() {
		double velocDisminuida = motor.frenar(5);
		assertTrue(velocDisminuida == -125.0);
	}

	@Test
	public void testNuevoMotorDeTipo() {
		Motor nuevoMotor1 = fabrica.instanciarMotor("Lin64");
		assertTrue("Lin64".equals(nuevoMotor1.motor()));
		Motor nuevoMotor2 = fabrica.instanciarMotor("Win32");
		assertTrue("Win32".equals(nuevoMotor2.motor()));
		Motor nuevoMotor3 = fabrica.instanciarMotor("MacX");
		assertTrue("MacX".equals(nuevoMotor3.motor()));
	}

	@Test
	public void testVelocidadMaxima() {
		motor = fabrica.instanciarMotor("Lin64");
		assertEquals(120.0, motor.VelocidadMaxima());
		motor = fabrica.instanciarMotor("Win32");
		assertEquals(100.0, motor.VelocidadMaxima());
		motor = fabrica.instanciarMotor("MacX");
		assertEquals(150.0, motor.VelocidadMaxima());
	}

}
