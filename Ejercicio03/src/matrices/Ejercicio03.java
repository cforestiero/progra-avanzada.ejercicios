/*
 * Escribir un método en Java que de una matriz numérica dada, devuelva un vector con n elementos, 
 * donde cada elemento es la moda de una fila. Si hubiese más de una moda, se deberá utilizar la de mayor valor

Ejemplo:
Para la matriz

 1  2  3  4
 5 -6 -6 20
 1  1 10 10


La salida debe ser

4 -6 10


 * */

package matrices;

public class Ejercicio03 {

	public int[] CalcularModa(int[][] matriz) {
		int contadorModa;
		int valorModa;
		int valor_a_buscar;
		int contadorNuevo;

		int[] vectorModa = new int[matriz.length];

		int i, j, k = 0;

		for (i = 0; i < matriz.length; i++) {
			valorModa = matriz[i][0];
			contadorModa = 1;
			contadorNuevo = 0;

			for (j = 0; j < matriz[0].length; j++) {
				valor_a_buscar = matriz[i][j];
				contadorNuevo = 0;

				for (k = j; k < matriz[0].length; k++) {

					if (valor_a_buscar == matriz[i][k]) {
						contadorNuevo++;
					}

				}

				if (contadorNuevo == contadorModa) {
					if (valor_a_buscar > valorModa) {
						valorModa = valor_a_buscar;
						contadorModa = contadorNuevo;
						contadorNuevo = 0;
						vectorModa[i] = matriz[i][j];
					}
				}

				if (contadorNuevo > contadorModa) {
					valorModa = valor_a_buscar;
					contadorModa = contadorNuevo;
					contadorNuevo = 0;
					vectorModa[i] = matriz[i][j];
				}

			}

		}

		return vectorModa;

	}

	public static void main(String[] args) {
		int[][] matrizEjemplo = { { 1, 2, 3, 4 }, { 5, -6, -6, 20 }, { 1, 1, 10, 10 } };
		int[] vectorModa;
		int i;

		Ejercicio03 e = new Ejercicio03();
		vectorModa = e.CalcularModa(matrizEjemplo);

		for (i = 0; i < vectorModa.length; i++) {
			System.out.print(vectorModa[i] + " ");
		}

	}

}
