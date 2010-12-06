package test.modelotest;

import java.io.FileWriter;

import junit.framework.TestCase;
import modelo.Mess10;
import modelo.Pozo;
import modelo.excepciones.ExcepcionLimitesIncorrectosEnElTerreno;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.junit.Before;
import org.junit.Test;

public class PozoTest extends TestCase {

	private Pozo pozo;

	private static String Path = "Pozo.xml";

	@Override
	@Before
	public void setUp() throws Exception {

		pozo = new Pozo(1, 1);
	}

	@Test
	public void testPozo() {
		double daño = 0;
		daño = pozo.chocarCon(new Mess10());
		assertTrue(daño > 0);
	}

	@Test
	public void testSerializarXML()
			throws ExcepcionLimitesIncorrectosEnElTerreno {

		pozo = new Pozo(1, 1);

		try {

			Element root = pozo.serializarXML();
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

		pozo = new Pozo(1, 1);

		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(Path);

			Element RootElement = document.getRootElement();
			Pozo otroPozo = new Pozo(RootElement);

			assertTrue(otroPozo.getAncho() == pozo.getAncho());
			assertTrue(otroPozo.getLargo() == pozo.getLargo());
			assertTrue(otroPozo.posicionEsquinaInferiorIzquierda().x() == pozo
					.posicionEsquinaInferiorIzquierda().x());
			assertTrue(otroPozo.posicionEsquinaInferiorIzquierda().y() == pozo
					.posicionEsquinaInferiorIzquierda().y());

		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

}
