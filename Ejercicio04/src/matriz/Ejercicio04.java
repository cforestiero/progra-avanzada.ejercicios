/*
 * Escribir un método en Java que de una matriz cuadrada dada, devuelva una matriz con n filas, 
 * donde cada una tendrá los datos de una de las diagonales (de abajo a la izquierda hacia arriba a la derecha)

Ejemplo:
Para la matriz

 1  2  3  4
 5  6  7  8
 9 10 11 12
13 14 15 16

La salida debe ser

13
 9 14
 5 10 15
 1  6 11 16
 2  7 12
 3  8
 4

 */

package matriz;

public class Ejercicio04 {

	public static int[][] diagonales(int[][] mat) {
		int filas = mat.length, i, j, p = 0, q = 0;
		int filasSalida = filas * 2 - 1, columnasSalida = filas;
		int[][] salida = new int[filasSalida][columnasSalida];

		for (int k = filas - 1; k >= 0; k--) {
			i = k;
			j = 0;
			q = 0;

			while (i <= filas - 1) {
				salida[p][q] = mat[i][j];
				i++;
				j++;
				q++;
			}

			p++;
		}

		for (int k = 1; k <= filas - 1; k++) {
			i = 0;
			j = k;
			q = 0;

			while (j <= filas - 1) {
				salida[p][q] = mat[i][j];
				i++;
				j++;
				q++;
			}

			p++;
		}

		return salida;

	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int[][] resultado = new int[mat.length][];
		resultado = diagonales(mat);

		for (int i = 0; i < resultado.length; i++) {
			System.out.println();
			for (int j = 0; j < resultado[i].length; j++) {
				System.out.print(resultado[i][j] + " ");
			}
		}

	}

}
