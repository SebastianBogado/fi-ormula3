package test.serviciotest;

import static org.junit.Assert.assertTrue;

import java.io.FileWriter;

import modelo.servicio.Tiempo;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TiempoTest {

	Tiempo unTiempo;
	private static String Path = "Tiempo.xml";

	@Before
	public void setUp() throws Exception {
		unTiempo = new Tiempo("Jugador", 60);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEsMejorQue() {
		Tiempo otroTiempo = new Tiempo("OtroJugador", 120);
		assertTrue(this.unTiempo.EsMejorQue(otroTiempo));
	}

	@Test
	public void testSerializarXML() {

		try {

			Element root = unTiempo.serializarXML();
			Document document = new Document(root);

			XMLOutputter outputter = new XMLOutputter();
			outputter.setFormat(Format.getPrettyFormat());

			FileWriter writer = new FileWriter(Path);
			outputter.output(document, writer);
			writer.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void testDeserializarXML() {

		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(Path);

			Element RootElement = document.getRootElement();
			Tiempo otroTiempo = new Tiempo(RootElement);

			assertTrue(otroTiempo.getNombre().equals(this.unTiempo.getNombre()));
			assertTrue(otroTiempo.getTiempo() == this.unTiempo.getTiempo());
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

}
