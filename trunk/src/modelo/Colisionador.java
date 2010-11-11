package modelo;

	public class Colisionador{
		
		
		public Colisionador(){
			
		}
		
		public boolean pasoElObstaculo(Obstaculo obstaculoSiguiente, Automovil unAutomovil){
			
			int posicionDiscretaEnX = (int) unAutomovil.getPosicionReal().x();
			
			if (posicionDiscretaEnX > (int)obstaculoSiguiente.posicionEsquinaInferiorIzquierda().x()
									+ (int) obstaculoSiguiente.getLargo())
			return true;
			else
			return false;
		}
		
		public boolean coinciden (Obstaculo obstaculoSiguiente, Automovil auto){
			
			Posicion EsquinaInferiorIzquierdaDelObstaculo;
			int anchoObstaculo;
			int largoObstaculo;
			int largoAuto;
			boolean coincide=false;
			
			
			
			EsquinaInferiorIzquierdaDelObstaculo= obstaculoSiguiente.posicionEsquinaInferiorIzquierda();
			anchoObstaculo= (int)obstaculoSiguiente.getAncho();
			largoObstaculo= (int)obstaculoSiguiente.getLargo();
			largoAuto = (int)auto.getLargo();
						
			for (int i= (int)EsquinaInferiorIzquierdaDelObstaculo.x();i<=anchoObstaculo;i++){
				for(int j= (int)EsquinaInferiorIzquierdaDelObstaculo.y(); j<=largoObstaculo;j++){
					for (int k = (int) auto.getPosicionReal().y(); k <= largoAuto; k++ ){
						if(i == (int) auto.getPosicionReal().x())
							if(j == k){
								coincide=true;
								return coincide;
							}
					}
				}
			}
			return coincide;
		}
		
	}
	
