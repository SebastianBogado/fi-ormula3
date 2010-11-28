package modelo;

import org.jdom.Attribute;
import org.jdom.Element;

public class LomaDeBurro extends Obstaculo {
/*
 * @todo: sacarle el hardcodeo. Por si me olvido, me cuento:
 * - "anchoPista - 2" es para que el ancho sea definido por la pista, y que sea esquivable.
 * - "posicionX = 1" es para que se ponga centrado. Si tomamos como posición más extrema 1, este
 *   hardcodeo sería posicionX = 2
 */
	public LomaDeBurro(int posicionX, int posicionY, int anchoPista) {
		super(1, posicionY);
		this.ancho = anchoPista - 2;		
	}

	/*
	 * crea un nueva instancia de loma de burro a partir de un elemento xml
	 */
	public LomaDeBurro(Element elementLomaDeBurro,int AnchoDeLaPista) {
		super();
		this.ancho = AnchoDeLaPista;
		String posicionX = elementLomaDeBurro.getAttributeValue("posicionX");
		String posicionY = elementLomaDeBurro.getAttributeValue("posicionY");
		this.posicionEsquinaInferiorIzquierda().x(Double.parseDouble(posicionX));
		this.posicionEsquinaInferiorIzquierda().y(Double.parseDouble(posicionY));
	}

	@Override
	public double chocarCon(Neumaticos neumaticos) {
		return neumaticos.chocarConLomaDeBurro();
	}
	
	public Element serializarXML(){
		
		Element element= new Element("LomaDeBurro");
		
		Attribute posicionX= new Attribute ("posicionX",String.valueOf(this.posicionEsquinaInferiorIzquierda().x()));
		Attribute posicionY = new Attribute ("posicionY",String.valueOf(this.posicionEsquinaInferiorIzquierda().y()));	
		
		element.getAttributes().add(posicionX);
		element.getAttributes().add(posicionY);
		
		
		return element;
	}
	
}
