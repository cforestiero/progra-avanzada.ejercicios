/*
 * Escribir un método en Java que permita comprobar si la multiplicación de todos 
 * los valores de una matriz numérica, dará 0 o no
 * */
package matrices;

public class Ejercicio01 {

	public static boolean producto_de_elementos_da_cero(int[][] mat) {
		int i, j;
		int filas = mat.length;

		for (i = 0; i < filas; i++) {
			for (j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 0)
					return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] m1 = { { 1, 0, 3 }, { 4, 1, 6 }, { 7, 8, 2 }, { 7, 8, 2 } };
		int[][] m2 = { { 1, 2, 3 , 4 }, { 4, 2, 6 }, { 7, 8, 2 } };
		int[][] m3 = { { 1, 2, 3 }, { 4, 2, 6 }, { 7, 8, 0 } };
		int[][] m4 = { { 1, 1, 3 }, { 4, 1, 6 }, { 7, 8, 2 }, { 7, 8, 0 } };

		System.out.println(producto_de_elementos_da_cero(m1));
		System.out.println(producto_de_elementos_da_cero(m2));
		System.out.println(producto_de_elementos_da_cero(m3));
		System.out.println(producto_de_elementos_da_cero(m4));

	}

}
