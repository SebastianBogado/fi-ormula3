package modelo;

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

	@Override
	public double chocarCon(Neumaticos neumaticos) {
		return neumaticos.chocarConLomaDeBurro();
	}

}
