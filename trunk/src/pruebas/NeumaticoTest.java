package pruebas;

import static org.junit.Assert.assertTrue;
import modelo.Neumaticos;
import modelo.Pozo;
import modelo.Ripio;
import modelo.excepciones.ExcepcionLimitesIncorrectosEnElTerreno;
import modelo.servicio.FabricaAbstractaDeNeumaticos;
import modelo.servicio.Velocidad;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NeumaticoTest {

	private Neumaticos neumaticos;
	private FabricaAbstractaDeNeumaticos fabrica;

	@Before
	public void setUp() throws Exception {
		fabrica = new FabricaAbstractaDeNeumaticos();
		neumaticos = fabrica.instanciarRuedas("Mess10");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDaño() {
		assertTrue(neumaticos.daño() == 0);
	}

	@Test
	public void testNuevoNeumatico() {
		Neumaticos n1 = fabrica.instanciarRuedas("Mess10");
		Neumaticos n2 = fabrica.instanciarRuedas("Paler9");

		assertTrue(n1.tipo().equals("Mess10"));
		assertTrue(n2.tipo().equals("Paler9"));
	}

	@Test
	public void testDesgastarPorTerreno()
			throws ExcepcionLimitesIncorrectosEnElTerreno, NullPointerException {
		assertTrue(neumaticos.daño() == 0);
		Ripio terreno = new Ripio(10, 100);
		Velocidad vel = new Velocidad(1.0, 50.0);
		neumaticos.desgastarPorTerreno(terreno, vel);
		assertTrue(neumaticos.daño() > 0);

	}

	@Test
	public void testDesgastarPorObstaculo() {

		assertTrue(neumaticos.daño() == 0);
		Pozo pozo = new Pozo(1, 1);
		Velocidad vel = new Velocidad(1.0, 50.0);
		neumaticos.desgastarPorObstaculo(pozo, vel);
		assertTrue(neumaticos.daño() > 0);

	}

}
