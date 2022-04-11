/*
 * 1. Escribir un archivo de entre 10 mil y 20 mil números enteros aleatorios, en el rango de 0 a 12000. (La cantidad de números debe ser aleatoria)
2. Leer dicho archivo, buscando (a) máximo, (b) mínimo, (c) promedio.
3. Escribr un segundo archivo con una tabla de resultados. Ejemplo:

+----------+-------+
| Máximo   | 11978 |
+----------+-------+
| Mínimo   |     3 |
+----------+-------+
| Promedio |  7201 |
+----------+-------+


¡El formato de la última salida es parte del desafío!
*/
package entradasalida;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class EntradaSalida {
	final static String rutaArchivosIn = "archivosIN/";
	final static String rutaArchivosOUT = "archivosOUT/";

	public static String generarArchivoDeNumerosAleatorios() throws IOException {
		String nombreArchivo = "aleatorios.in";

		FileWriter archivo = new FileWriter(rutaArchivosIn + nombreArchivo);
		PrintWriter pw = new PrintWriter(archivo);

		int cantMinima = 10000, cantMaxima = 20000, rangoMinimo = 0, rangoMaximo = 12000;

		// Generar numeros random entre 10mil y 20mil de 0 a 12000
		int cantNumeros = (int) Math.floor(Math.random() * (cantMaxima - cantMinima + 1) + cantMinima);
		for (; cantNumeros > 0; cantNumeros--) {

			int n = (int) Math.floor(Math.random() * (rangoMaximo - rangoMinimo + 1) + rangoMinimo);
			pw.println(n);

		}

		archivo.close();

		return nombreArchivo;
	}

	public static int[] buscarMaximoMinimoPromedio(String nombreArchivo) {
		int[] resultados = new int[3];

		Scanner entrada;
		try {
			entrada = new Scanner(new File(rutaArchivosIn + nombreArchivo));
		} catch (IOException e) {
			e.printStackTrace();
			return resultados;
		}

		int n = 0;
		List<Integer> nums = new ArrayList<>();

		while (entrada.hasNext()) {// Mientras existan datos en el archivo.
			n = entrada.nextInt();
			nums.add(n);
		}

		entrada.close();

		if (!nums.isEmpty()) {

			// maximo
			resultados[0] = Collections.max(nums, null);
			// minimo
			resultados[1] = Collections.min(nums, null);
			// promedio
			resultados[2] = (int) nums.stream().mapToInt(a -> a).average().orElse(Double.NaN);
		}

		return resultados;
	}

	public static void generarArchivoConResultados(int[] resultados) throws IOException {
		String nombreArchivo = "resultado.txt";

		FileWriter archivo = new FileWriter(rutaArchivosOUT + nombreArchivo);
		PrintWriter pw = new PrintWriter(archivo);

		String lineaHorizontal = "+----------+-------+", lineaVertical = "|", espacios, fila;
		int cantEspacios, maximo = resultados[0], minimo = resultados[1], promedio = resultados[2];
		final int POSICIONES_EN_TABLA = 7;

		pw.println(lineaHorizontal);

		cantEspacios = POSICIONES_EN_TABLA - String.valueOf(maximo).length();
		espacios = " ".repeat(cantEspacios);
		fila = lineaVertical + "Maximo    " + lineaVertical + espacios + maximo + lineaVertical;
		pw.println(fila);

		pw.println(lineaHorizontal);

		cantEspacios = POSICIONES_EN_TABLA - String.valueOf(minimo).length();
		espacios = " ".repeat(cantEspacios);
		fila = lineaVertical + "Minimo    " + lineaVertical + espacios + minimo + lineaVertical;
		pw.println(fila);

		pw.println(lineaHorizontal);

		cantEspacios = POSICIONES_EN_TABLA - String.valueOf(promedio).length();
		espacios = " ".repeat(cantEspacios);
		fila = lineaVertical + "Promedio  " + lineaVertical + espacios + promedio + lineaVertical;
		pw.println(fila);

		pw.println(lineaHorizontal);

		archivo.close();
	}

	public static void main(String[] args) {
		try {
			String nombreArchivo = generarArchivoDeNumerosAleatorios();
			int[] resultado = buscarMaximoMinimoPromedio(nombreArchivo);
			generarArchivoConResultados(resultado);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
