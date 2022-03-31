/*
 * Escribir un método en Java que de una matriz numérica dada,
 *  devuelva una matriz con la misma cantidad de elementos, pero donde cada
 *   valor es la suma de sus adyacentes originales (arriba, abajo, izquierda, y derecha; si existen)

Ejemplo:
Para la matriz

 8  2 -3  4
 5 -6 -6 20
21  1 -5  0


La salida debe ser

15  1  -3 21
28 -4   0 18
27 11 -10 15
 * */
package matrices;

public class Ejercicio02 {

	public static int[][] suma_de_adyacentes(int[][] mat) {
		int filas = mat.length,
			filasIndice = filas - 1,
			columnasIndice;
		boolean sumado = false;

		int[][] suma = new int[filas][];
		for (int i = 0; i < filas; i++)
			suma[i] = mat[i].clone();

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < mat[i].length; j++) {

				columnasIndice = mat[i].length - 1;

				if (esquina_arriba_iz(i, j)) {
					suma[i][j] += mat[i + 1][j];
					suma[i][j] += mat[i][j + 1];

					sumado = true;
				}

				if (esquina_arriba_der(i, j, columnasIndice) && !sumado) {
					suma[i][j] += mat[i][j - 1];
					suma[i][j] += mat[i + 1][j];

					sumado = true;
				}

				if (esquina_abajo_iz(i, j, filasIndice) && !sumado) {
					suma[i][j] += mat[i - 1][j];
					suma[i][j] += mat[i][j + 1];

					sumado = true;
				}

				if (esquina_abajo_der(i, j, filasIndice, columnasIndice) && !sumado) {
					suma[i][j] += mat[i - 1][j];
					suma[i][j] += mat[i][j - 1];

					sumado = true;
				}

				if (lateral_arriba(i) && !sumado) {
					suma[i][j] += mat[i + 1][j];
					suma[i][j] += mat[i][j + 1];
					suma[i][j] += mat[i][j - 1];

					sumado = true;
				}

				if (lateral_abajo(i, filasIndice) && !sumado) {
					suma[i][j] += mat[i - 1][j];
					suma[i][j] += mat[i][j + 1];
					suma[i][j] += mat[i][j - 1];

					sumado = true;
				}

				if (lateral_iz(j) && !sumado) {
					suma[i][j] += mat[i - 1][j];
					suma[i][j] += mat[i][j + 1];
					suma[i][j] += mat[i + 1][j];

					sumado = true;
				}

				if (lateral_der(j, columnasIndice) && !sumado) {
					suma[i][j] += mat[i - 1][j];
					suma[i][j] += mat[i][j - 1];
					suma[i][j] += mat[i + 1][j];

					sumado = true;
				}

				// Pregunto si no sume es porque estoy en el medio de la matriz
				if (!sumado) {
					suma[i][j] += mat[i - 1][j];
					suma[i][j] += mat[i][j - 1];
					suma[i][j] += mat[i + 1][j];
					suma[i][j] += mat[i][j + 1];
				}

				sumado = false;
			}
		}

		return suma;
	}

	public static boolean esquina_arriba_iz(int fila, int columna) {
		return (fila == 0 && columna == 0);
	}

	public static boolean esquina_arriba_der(int fila, int columna, int totalColumnas) {
		return (fila == 0 && columna == totalColumnas);
	}

	public static boolean esquina_abajo_iz(int fila, int columna, int totalFilas) {
		return (fila == totalFilas && columna == 0);
	}

	public static boolean esquina_abajo_der(int fila, int columna, int totalFilas, int totalColumnas) {
		return (fila == totalFilas && columna == totalColumnas);
	}

	public static boolean lateral_arriba(int fila) {
		return (fila == 0);
	}

	public static boolean lateral_abajo(int fila, int totalFilas) {
		return (fila == totalFilas);
	}

	public static boolean lateral_der(int columna, int totalColumnas) {
		return (columna == totalColumnas);
	}

	public static boolean lateral_iz(int columna) {
		return (columna == 0);
	}

	public static void main(String[] args) {
		int[][] mat = { { 8, 2, -3, 4 }, { 5, -6, -6, 20 }, { 21, 1, -5, 0 } };

		int[][] resultado = suma_de_adyacentes(mat);

		for (int i = 0; i < resultado.length; i++) {
			System.out.println();
			for (int j = 0; j < resultado[i].length; j++) {
				System.out.print(resultado[i][j] + " ");
			}
		}

	}

}
