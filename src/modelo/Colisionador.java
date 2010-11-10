package modelo;

	public class Colisionador{
		
		
		public Colisionador(){
			
		}
		
		public boolean pasoElObstaculo(Obstaculo obstaculoSiguiente, double posicionAutoDiscreta){
			
			
			
			if (posicionAutoDiscreta>obstaculoSiguiente.posicionEsquinaInferiorIzquierda().x()+obstaculoSiguiente.getLargo())
			return true;
			else
			return false;
		}
		
		public boolean coinciden (Obstaculo obstaculoSiguiente,long  posicionAutoDiscretaEnX,long posicionAutoDiscretaEnY){
			
			Posicion EsquinaInferiorIzquierdaDelObstaculo;
			double anchoObstaculo;
			double largoObstaculo;
			boolean coincide=false;
			
			
			EsquinaInferiorIzquierdaDelObstaculo= obstaculoSiguiente.posicionEsquinaInferiorIzquierda();
			anchoObstaculo= obstaculoSiguiente.getAncho();
			largoObstaculo= obstaculoSiguiente.getLargo();
			
			for (double i= EsquinaInferiorIzquierdaDelObstaculo.x();i<=anchoObstaculo;i++){
				for(double j= EsquinaInferiorIzquierdaDelObstaculo.y(); j<=largoObstaculo;j++){
					if(i==posicionAutoDiscretaEnX)
						if(j==posicionAutoDiscretaEnY)
							coincide=true;;			
				}
			}
			return coincide;
		}
		
	}
	
