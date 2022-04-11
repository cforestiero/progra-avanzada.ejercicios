package test;

import static org.junit.Assert.*;

import org.junit.Test;
import taller.Circulo;
import taller.Punto;

public class TestInterseccion {

	@Test
	public void testCirculosSiIntersectan() {
		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(1, 1), 1.5);

		boolean resultado = c1.intersectaCon(c2);
		
		assertTrue(resultado);
	}
	
	@Test
	public void testCirculosNoIntersectan() {
		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(5, 1), 1.5);

		boolean resultado = c1.intersectaCon(c2);
		
		assertFalse(resultado);
	}

}
