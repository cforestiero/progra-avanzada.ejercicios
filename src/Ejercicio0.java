/*
 * Escribir un método en Java que permita comprobar si la diagonal principal de una matriz cuadrada de enteros 
 * tiene en cada posición un valor igual a la suma de todos los valores de las posiciones anteriores de dicha diagonal. 
 * Por ejemplo, la siguiente matriz comprueba la regla:

				1 2 3
				4 1 6
				7 8 2
 * Pero esta otra, no la comprueba:

				1 2 3
				4 2 6
				7 8 2 
 */
public class Ejercicio0 {

	public static boolean comprobar(int[][] mat) {
		int suma = mat[0][0];

		for (int i = 1; i < mat.length; i++) {
			if (mat[i][i] != suma) {
				return false;
			}
			suma += mat[i][i];
		}

		return true;
	}

	public static void main(String[] args) {
		int[][] mCorrecta = { { 1, 2, 3 }, { 4, 1, 6 }, { 7, 8, 2 } };
		int[][] mIncorrecta = { { 1, 2, 3 }, { 4, 2, 6 }, { 7, 8, 2 } };

		System.out.println(comprobar(mCorrecta));
		System.out.println(comprobar(mIncorrecta));
	}
}
