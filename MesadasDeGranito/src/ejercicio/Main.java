package ejercicio;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		try {
			ArrayList<Mesada> mesadas = GestorArchivos.leerArchivo("mesadas.in");

			int pilas = Mesada.armarPilas(mesadas);

			GestorArchivos.escribirArchivo("mesadas.out", pilas);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
