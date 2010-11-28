package modelo.servicio;

import java.awt.geom.Point2D;

public class Vector2D {
	protected Point2D.Double vector;

	public Vector2D() {
		vector = new Point2D.Double();
	}
	
	public Vector2D(double x, double y) {
		vector = new Point2D.Double();
		vector.setLocation(x, y);
	}

	public double x() {
		return vector.getX();
	}

	public double y() {
		return vector.getY();
	}

	public void x(double x) {
		vector.setLocation(x, vector.getY());
	}

	public void y(double y) {
		vector.setLocation(vector.getX(), y);
	}

}
