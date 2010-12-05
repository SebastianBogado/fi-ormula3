package modelo.servicio;

import org.jdom.Attribute;
import org.jdom.Element;

public class Tiempo {

	private final String nombre;
	private final double tiempo;

	public Tiempo(String nombre, double tiempo) {
		this.nombre = nombre;
		this.tiempo = tiempo;
	}

	public Tiempo(Element element) {

		this.nombre = element.getAttributeValue("Nombre");
		this.tiempo = Double.parseDouble(element.getAttributeValue("Tiempo"));

	}

	public boolean EsMejorQue(Tiempo unTiempo) {
		if (unTiempo.tiempo != 0)
			return (unTiempo.tiempo <= this.tiempo);
		else
			return true;
	}

	public double getTiempo() {
		return this.tiempo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Element serializarXML() {

		Element element = new Element("Tiempo");

		Attribute nombre = new Attribute("Nombre", this.nombre);
		Attribute tiempo = new Attribute("Tiempo", String.valueOf(this.tiempo));
		element.getAttributes().add(nombre);
		element.getAttributes().add(tiempo);

		return element;
	}

}
