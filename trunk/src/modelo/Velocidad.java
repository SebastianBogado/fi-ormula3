package modelo;

public class Velocidad extends Vector2D{
	
	public Velocidad(double x, double y){
		super(x,y);
	}

	public Posicion variacionDePosicion(double difTiempo) {
		return new Posicion(vector.x * difTiempo, vector.y * difTiempo);
	}
	
	public Posicion variacionDePosicionEnMetros(double difTiempo){
		return this.variacionDePosicion(difTiempo * 1000);
	}
	
	/*
	 * devuelve el módulo de la velocidad
	 */
	public double rapidez(){
		return Math.hypot(this.vector.x, this.vector.y);
	}

}
