package Vista;

import Titiritero.Posicionable;

public class PosicionDiscreta implements Posicionable {
	private int x = 0;
	private int y = 0;

	public PosicionDiscreta(int X, int Y) {
		this.setX(X);
		this.setY(Y);

	}

	public PosicionDiscreta() {

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int X) {
		this.x = X;
	}

	public void setY(int Y) {
		this.y = Y;
	}

}
