package modelo;

import modelo.excepciones.ExcepcionLimitesIncorrectosEnElTerreno;

import org.jdom.Attribute;
import org.jdom.Element;

public class Asfalto extends Terreno {

	public Asfalto(int principio, int fin)
			throws ExcepcionLimitesIncorrectosEnElTerreno {
		super(principio, fin);
	}

	/** crea un nueva instancia de asfalto a partir de un elemento xml **/
	public Asfalto(Element element)
			throws ExcepcionLimitesIncorrectosEnElTerreno {
		String principio = element.getAttributeValue("principio");
		String fin = element.getAttributeValue("fin");

		this.principio = Integer.parseInt(principio);
		this.fin = Integer.parseInt(fin);
		if (this.fin < this.principio) {
			throw new ExcepcionLimitesIncorrectosEnElTerreno();
		}
	}

	@Override
	public double desgastar(Neumaticos neumaticos) {
		return neumaticos.desgastePorAsfalto();
	}

	@Override
	public Element serializarXML() {

		Element element = new Element("Asfalto");

		Attribute principio = new Attribute("principio", String.valueOf(this
				.principio()));
		Attribute fin = new Attribute("fin", String.valueOf(this.fin()));

		element.getAttributes().add(principio);
		element.getAttributes().add(fin);

		return element;
	}

	@Override
	public String tipoTerreno() {

		return Asfalto;
	}

}
