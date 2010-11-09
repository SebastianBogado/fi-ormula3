package modelo;

	public class Colisionador{
		
		
		public Colisionador(){
			
		}
		
		public boolean pasoElObstaculo(Obstaculo obstaculoSiguiente,Posicion posicionAutoDiscreta){
			//TODO
			return false;
		}
		
		public boolean coinciden (Obstaculo obstaculoSiguiente,Posicion posicionAutoDiscreta){
			
			Posicion EsquinaInferiorIzquierdaDelObstaculo;
			double anchoObstaculo;
			double largoObstaculo;
			boolean coincide=false;
			
			
			EsquinaInferiorIzquierdaDelObstaculo= obstaculoSiguiente.posicionEsquinaInferiorIzquierda();
			anchoObstaculo= obstaculoSiguiente.getAncho();
			largoObstaculo= obstaculoSiguiente.getLargo();
			
			for (double i= EsquinaInferiorIzquierdaDelObstaculo.x();i<=anchoObstaculo;i++){
				for(double j= EsquinaInferiorIzquierdaDelObstaculo.y(); j<=largoObstaculo;j++){
					if(i==posicionAutoDiscreta.x())
						if(j==posicionAutoDiscreta.y())
							coincide=true;;			
				}
			}
			return coincide;
		}
		
	}
	
