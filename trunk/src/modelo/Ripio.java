package modelo;

import modelo.excepciones.ExcepcionLimitesIncorrectosEnElTerreno;

import org.jdom.Attribute;
import org.jdom.Element;

public class Ripio extends Terreno {

	public Ripio(int principio, int fin)
			throws ExcepcionLimitesIncorrectosEnElTerreno {
		super(principio, fin);
	}

	/** Crea un nueva instancia de ripio a partir de un elemento xml **/
	public Ripio(Element element) throws ExcepcionLimitesIncorrectosEnElTerreno {
		String principio = element.getAttributeValue("principio");
		String fin = element.getAttributeValue("fin");

		this.principio = Integer.parseInt(principio);
		this.fin = Integer.parseInt(fin);
		if (this.fin < this.principio) {
			throw new ExcepcionLimitesIncorrectosEnElTerreno();
		}
	}

	@Override
	public String tipoTerreno() {
		return Ripio;
	}

	@Override
	public double desgastar(Neumaticos neumaticos) {
		return neumaticos.desgastePorRipio();
	}

	@Override
	public Element serializarXML() {

		Element element = new Element("Ripio");

		Attribute principio = new Attribute("principio", String.valueOf(this
				.principio()));
		Attribute fin = new Attribute("fin", String.valueOf(this.fin()));

		element.getAttributes().add(principio);
		element.getAttributes().add(fin);

		return element;
	}
}
