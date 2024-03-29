package modelo.servicio;

import modelo.Automovil;
import modelo.Obstaculo;

public class Colisionador {

	public Colisionador() {

	}

	public boolean pasoElObstaculo(Obstaculo obstaculoSiguiente,
			Automovil unAutomovil) {

		int posicionDiscretaEnY = (int) unAutomovil.getPosicionReal().y();
		int posicionObstaculo = (int) obstaculoSiguiente
				.posicionEsquinaInferiorIzquierda().y()
				+ obstaculoSiguiente.getLargo();

		/*
		 * int posDiscretaEnX = (int)
		 * unAutomovil.posicionEsquinaInferiorIzquierda .x(); int posDiscretaEnY
		 * = (int) unAutomovil.posicionEsquinaInferiorIzquierda .y();
		 * 
		 * int posObstaculoX = (int)
		 * obstaculoSiguiente.posicionEsquinaInferiorIzquierda .x(); int
		 * posObstaculoY = (int)
		 * obstaculoSiguiente.posicionEsquinaInferiorIzquierda .y();
		 * 
		 * if ((posDiscretaEnX <= posObstaculoX && (posDiscretaEnX + unAutomovil
		 * .getAncho()) >= posObstaculoX) && ((posDiscretaEnY <= posObstaculoY
		 * && (posDiscretaEnX + unAutomovil .getLargo()) >= posObstaculoY)))
		 */

		if (posicionDiscretaEnY > posicionObstaculo)
			return true;
		else
			return false;
	}

	public boolean coinciden(Obstaculo obstaculoSiguiente, Automovil auto) {

		/*
		 * Posicion EsquinaInferiorIzquierdaDelObstaculo; int anchoObstaculo;
		 * int largoObstaculo; int largoAuto; boolean coincide = false;
		 * 
		 * EsquinaInferiorIzquierdaDelObstaculo = obstaculoSiguiente
		 * .posicionEsquinaInferiorIzquierda(); anchoObstaculo =
		 * obstaculoSiguiente.getAncho(); largoObstaculo =
		 * obstaculoSiguiente.getLargo(); largoAuto = auto.getLargo();
		 * 
		 * 
		 * 
		 * for (int i = (int) EsquinaInferiorIzquierdaDelObstaculo.x(); i <=
		 * anchoObstaculo; i++) { for (int j = (int)
		 * EsquinaInferiorIzquierdaDelObstaculo.y(); j <= largoObstaculo; j++) {
		 * for (int k = (int) auto.getPosicionReal().y(); k <= largoAuto; k++) {
		 * if (i == (int) auto.getPosicionReal().x()) if (j == k) { coincide =
		 * true; return coincide; } } } } return coincide;
		 */

		boolean coincide = false;

		double posAutoX =  auto.posicionEsquinaInferiorIzquierda.x();
		double posAutoY =  auto.posicionEsquinaInferiorIzquierda.y();

		double posObsX = obstaculoSiguiente.posicionEsquinaInferiorIzquierda
				.x();
		double posObsY = obstaculoSiguiente.posicionEsquinaInferiorIzquierda
				.y();

		posObsX *= 100;

		if (posObsX == posAutoX)
			if (posObsY -15.0  <= posAutoY
					&& (posObsY + obstaculoSiguiente.largo-obstaculoSiguiente.largo -5.0 >= posAutoY))
				coincide = true;

		return coincide;

	}

}
