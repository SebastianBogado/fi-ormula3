package pruebas;

import java.io.FileWriter;

import junit.framework.TestCase;
import modelo.Tierra;
import modelo.excepciones.ExcepcionLimitesIncorrectosEnElTerreno;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.junit.Test;

public class TierraTest extends TestCase {

	private Tierra terreno;
	
	private static String Path= "Tierra.xml";

	@Test
	public void testTierra() throws ExcepcionLimitesIncorrectosEnElTerreno {
		terreno = new Tierra(100, 200);

		assertTrue(terreno.principio() == 100);

		assertTrue(terreno.fin() == 200);
	}
	
	@Test
	public void testSerializarXML() throws ExcepcionLimitesIncorrectosEnElTerreno {

		terreno = new Tierra(100, 200);
		
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
	public void testDeserializarXML() throws ExcepcionLimitesIncorrectosEnElTerreno{
		
		terreno = new Tierra(100, 200);
		
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(Path);

			Element RootElement = document.getRootElement();
			Tierra otroTerreno = new Tierra (RootElement);

			assertTrue(otroTerreno.tipoTerreno()==terreno.tipoTerreno());
			assertTrue(otroTerreno.principio()==terreno.principio());
			assertTrue(otroTerreno.fin()==terreno.fin());
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		}
	}

}
