package modelo;

public class Velocidad extends Vector2D{
	
	public Velocidad(double x, double y){
		super(x,y);
	}

	public Posicion variacionDePosicion(double difTiempo) {
		return new Posicion(vector.x * difTiempo, vector.y * difTiempo);
	}

}
