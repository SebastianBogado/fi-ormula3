package modelo.servicio;

public class Posicion extends Vector2D{
	
	public Posicion(){
		
	}
	
	public Posicion(double x, double y){
		super(x,y);
	}

	public void mover(Posicion variacionDePosicion) {
		this.vector.x += variacionDePosicion.x();
		this.vector.y += variacionDePosicion.y();		
	}
}
