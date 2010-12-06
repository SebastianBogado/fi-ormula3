package test.modelotest;

import java.io.FileWriter;

import junit.framework.TestCase;
import modelo.Ripio;
import modelo.excepciones.ExcepcionLimitesIncorrectosEnElTerreno;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.junit.Test;

public class RipioTest extends TestCase {

	private Ripio terreno;

	private static String Path = "Ripio.xml";

	@Test
	public void testRipio() throws ExcepcionLimitesIncorrectosEnElTerreno {

		terreno = new Ripio(50, 100);

		assertTrue(terreno.principio() == 50);

		assertTrue(terreno.fin() == 100);

	}

	@Test
	public void testSerializarXML()
			throws ExcepcionLimitesIncorrectosEnElTerreno {

		terreno = new Ripio(100, 200);

		try {

			Element root = terreno.serializarXML();
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
	public void testDeserializarXML()
			throws ExcepcionLimitesIncorrectosEnElTerreno {

		terreno = new Ripio(100, 200);

		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(Path);

			Element RootElement = document.getRootElement();
			Ripio otroTerreno = new Ripio(RootElement);

			assertTrue(otroTerreno.tipoTerreno() == terreno.tipoTerreno());
			assertTrue(otroTerreno.principio() == terreno.principio());
			assertTrue(otroTerreno.fin() == terreno.fin());
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

}
