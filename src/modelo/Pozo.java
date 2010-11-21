package modelo;

public class Pozo extends Obstaculo {

	public Pozo(int posicionX, int posicionY) {
		super(posicionX, posicionY);
		this.ancho = 1;
	}

	@Override
	public double chocarCon(Neumaticos neumaticos) {
		return neumaticos.chocarConPozo();
	}

}
