package punto;

public class Pruebas {

	public static void main(String[] args) {

		Punto puntoUno = new Punto(1, 1); // Var referencia
		Punto puntoDos = new Punto(1, 6);

		System.out.println(puntoUno.toString());
		System.out.println(puntoDos.toString());

		if (puntoUno.equals(puntoDos)) {
			System.out.println("son iguales");
		} else {
			System.out.println("falso");
		}

		puntoDos.desplazar(1, 2.5);
		System.out.println(puntoDos.toString());

		Punto p3 = puntoUno.suma(puntoDos);

		System.out.println(p3.toString());
	}

}

// Todos los obj de Java heredan de la clase Object