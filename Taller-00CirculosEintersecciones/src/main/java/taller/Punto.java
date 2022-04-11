package taller;

public class Punto {

	private double x;
	private double y;

	public Punto() {
		this(0, 0);
	}

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}

	public double distanciaEntreDosPuntos(Punto b) {
		double x1 = b.x - x;
		double y1 = b.y - y;

		return Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
	}
}
