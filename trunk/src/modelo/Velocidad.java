package modelo;

public class Velocidad extends Vector2D{
	
	public Velocidad(double x, double y){
		super(x,y);
	}

	public Posicion variacionDePosicion(double difTiempo) {
		return new Posicion(vector.x * difTiempo, vector.y * difTiempo);
	}
	
	/*
	 * devuelve el m�dulo de la velocidad
	 */
	public double rapidez(){
		return Math.hypot(this.vector.x, this.vector.y);
	}

}
