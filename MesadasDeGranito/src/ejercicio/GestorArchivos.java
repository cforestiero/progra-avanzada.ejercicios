package ejercicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class GestorArchivos {
	final static String rutaArchivosIn = "archivosIn/";
	final static String rutaArchivosOUT = "archivosOut/";

	public static ArrayList<Mesada> leerArchivo(String nombreArchivo) throws IOException {
		Scanner scanner = null;
		ArrayList<Mesada> datos = null;

		try {
			File file = new File(rutaArchivosIn + nombreArchivo);
			scanner = new Scanner(file);
			// Especifica la configuración regional que se va a utilizar
			scanner.useLocale(Locale.ENGLISH);
			// Para la configuración regional de Argentina, utilizar:
			// arch.useLocale(new Locale("es_AR"));

			int cant = scanner.nextInt();
			datos = new ArrayList<Mesada>(cant);

			for (int i = 0; i < cant; i++) {
				int l = scanner.nextInt();
				int a = scanner.nextInt();

				System.out.println(l);
				System.out.println(a);

				datos.add(new Mesada(l, a));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

		return datos;
	}

	public static void escribirArchivo(String nombreArchivo, int pilas) throws IOException {
		FileWriter archivo = new FileWriter(rutaArchivosOUT + nombreArchivo);
		PrintWriter pw = new PrintWriter(archivo);

		pw.println(pilas);

		archivo.close();
	}

}
