package test.modelotest;

import java.io.FileWriter;

import junit.framework.TestCase;
import modelo.LomaDeBurro;
import modelo.Mess10;
import modelo.excepciones.ExcepcionLimitesIncorrectosEnElTerreno;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.junit.Before;
import org.junit.Test;

public class LomaDeBurroTest extends TestCase {

	private LomaDeBurro loma;

	private static String Path = "LomaDeBurro.xml";

	@Override
	@Before
	public void setUp() throws Exception {

		loma = new LomaDeBurro(1, 1, 3);
	}

	@Test
	public void testLomaDeBurro() {
		double daño = 0;
		daño = loma.chocarCon(new Mess10());
		assertTrue(daño > 0);
	}

	@Test
	public void testSerializarXML()
			throws ExcepcionLimitesIncorrectosEnElTerreno {

		loma = new LomaDeBurro(1, 1, 3);

		try {

			Element root = loma.serializarXML();
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

		loma = new LomaDeBurro(1, 1, 3);

		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(Path);

			Element RootElement = document.getRootElement();
			LomaDeBurro otraLomaDeBurro = new LomaDeBurro(RootElement, 1);

			assertTrue(otraLomaDeBurro.getAncho() == loma.getAncho());
			assertTrue(otraLomaDeBurro.getLargo() == loma.getLargo());
			assertTrue(otraLomaDeBurro.posicionEsquinaInferiorIzquierda().x() == loma
					.posicionEsquinaInferiorIzquierda().x());
			assertTrue(otraLomaDeBurro.posicionEsquinaInferiorIzquierda().y() == loma
					.posicionEsquinaInferiorIzquierda().y());

		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

}
