package Vista;

import Titiritero.Posicionable;

public class PosicionDiscreta implements Posicionable {
	private int x = 0;
	private int y = 0;

	public PosicionDiscreta(int X, int Y) {
		this.setX(X);
		this.setY(Y);

	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

}
