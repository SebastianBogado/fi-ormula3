package test.modelotest;

import static org.junit.Assert.assertTrue;
import modelo.Automovil;
import modelo.servicio.FabricaDeAutos;
import modelo.servicio.MetadataAuto;
import modelo.servicio.NombresDeFabricables;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AutomovilTest {
	MetadataAuto metaAuto;
	Automovil auto;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAutomovilConMotor_Lin64_YRuedas_Paler9() {
		metaAuto = new MetadataAuto(NombresDeFabricables.PALER9,
				NombresDeFabricables.LIN64);
		auto = FabricaDeAutos.instanciarAuto(metaAuto);
		assertTrue(auto.neumaticos() == NombresDeFabricables.PALER9);
		assertTrue(auto.motor() == NombresDeFabricables.LIN64);
	}

	@Test
	public void testAutomovilConMotor_Lin64_YRuedas_Mess10() {
		metaAuto = new MetadataAuto(NombresDeFabricables.MESS10,
				NombresDeFabricables.LIN64);
		auto = FabricaDeAutos.instanciarAuto(metaAuto);
		assertTrue(auto.neumaticos() == NombresDeFabricables.MESS10);
		assertTrue(auto.motor() == NombresDeFabricables.LIN64);
	}

	@Test
	public void testAutomovilConMotor_MacX_YRuedas_Paler9() {
		metaAuto = new MetadataAuto(NombresDeFabricables.PALER9,
				NombresDeFabricables.MACX);
		auto = FabricaDeAutos.instanciarAuto(metaAuto);
		assertTrue(auto.neumaticos() == NombresDeFabricables.PALER9);
		assertTrue(auto.motor() == NombresDeFabricables.MACX);
	}

	@Test
	public void testAutomovilConMotor_MacX_YRuedas_Mess10() {
		metaAuto = new MetadataAuto(NombresDeFabricables.MESS10,
				NombresDeFabricables.MACX);
		auto = FabricaDeAutos.instanciarAuto(metaAuto);
		assertTrue(auto.neumaticos() == NombresDeFabricables.MESS10);
		assertTrue(auto.motor() == NombresDeFabricables.MACX);
	}

	@Test
	public void testAutomovilConMotor_Win32_YRuedas_Paler9() {
		metaAuto = new MetadataAuto(NombresDeFabricables.PALER9,
				NombresDeFabricables.WIN32);
		auto = FabricaDeAutos.instanciarAuto(metaAuto);
		assertTrue(auto.neumaticos() == NombresDeFabricables.PALER9);
		assertTrue(auto.motor() == NombresDeFabricables.WIN32);
	}

	@Test
	public void testAutomovilConMotor_Win32_YRuedas_Mess10() {
		metaAuto = new MetadataAuto(NombresDeFabricables.MESS10,
				NombresDeFabricables.WIN32);
		auto = FabricaDeAutos.instanciarAuto(metaAuto);
		assertTrue(auto.neumaticos() == NombresDeFabricables.MESS10);
		assertTrue(auto.motor() == NombresDeFabricables.WIN32);
	}
}
