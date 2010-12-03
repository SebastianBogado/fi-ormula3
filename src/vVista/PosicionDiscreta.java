package vVista;

import tTitiritero.Posicionable;

public class PosicionDiscreta implements Posicionable {
	private int x = 0;
	private int y = 0;

	public PosicionDiscreta(int X, int Y) {
		this.setX(X);
		this.setY(Y);

	}

	public PosicionDiscreta() {

	}
	
	/** Devuelve la poscion en X **/
	public int getX() {
		return x;
	}
	
	/** Devuelve la poscion en Y **/
	public int getY() {
		return y;
	}

	/** Establece la poscion en X **/
	public void setX(int X) {
		this.x = X;
	}

	/** Establece la poscion en Y **/
	public void setY(int Y) {
		this.y = Y;
	}

}
