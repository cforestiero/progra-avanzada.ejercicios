package ponyexpress;

public class PonyExpress {
	/**
	 * @param estaciones es la distancia en millas de una estación hasta la otra
	 * @returns la cantidad de jinetes necesarios para enviar el correo desde un
	 *          extremo hasta el otro del recorrido
	 */
	public int jinetes(int[] estaciones) {
		int jinetes = 1, millas = 0, cantEstaciones = estaciones.length;

		for (int i = 0; i < cantEstaciones; i++) {
			if (millas + estaciones[i] > 100) {
				jinetes++;
				millas = estaciones[i];
			} else {
				millas += estaciones[i];
			}
		}
		
		return jinetes;
	}
}
