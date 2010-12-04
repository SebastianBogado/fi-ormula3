package modelo;

import org.jdom.Attribute;
import org.jdom.Element;

public class Pozo extends Obstaculo {

	public Pozo(int posicionX, int posicionY) {
		super(posicionX, posicionY);
		this.ancho = 1;
	}

	/** Crea un nueva instancia de pozo a partir de un elemento xml **/
	public Pozo(Element element) {
		super();
		this.ancho = 1;
		String posicionX = element.getAttributeValue("posicionX");
		String posicionY = element.getAttributeValue("posicionY");
		this.posicionEsquinaInferiorIzquierda()
				.x(Double.parseDouble(posicionX));
		this.posicionEsquinaInferiorIzquierda()
				.y(Double.parseDouble(posicionY));
	}

	@Override
	public double chocarCon(Neumaticos neumaticos) {
		return neumaticos.chocarConPozo();
	}

	public Element serializarXML() {

		Element element = new Element("Pozo");

		Attribute posicionX = new Attribute("posicionX", String.valueOf(Math
				.round(this.posicionEsquinaInferiorIzquierda().x())));
		Attribute posicionY = new Attribute("posicionY", String.valueOf(Math
				.round(this.posicionEsquinaInferiorIzquierda().y())));

		element.getAttributes().add(posicionX);
		element.getAttributes().add(posicionY);

		return element;
	}

}
