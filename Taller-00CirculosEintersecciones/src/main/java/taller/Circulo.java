package taller;

public class Circulo {

	private Punto punto;
	private double radio;

	public Circulo() {
		this(new Punto(), 0);
	}

	public Circulo(Punto p, double r) {
		punto = p;
		radio = r;
	}

	@Override
	public String toString() {
		return "Circulo [punto=" + punto.toString() + ", radio=" + radio + "]";
	}

	public boolean intersectaCon(Circulo c) {
		boolean hayInterseccion = false;
		double d = punto.distanciaEntreDosPuntos(c.punto);

		if (d > (radio - c.radio) && d < (radio + c.radio)) {
			hayInterseccion = true;
		}

		return hayInterseccion;
	}
}
