package ejercicio;

import java.util.ArrayList;
import java.util.Stack;

public class Mesada {
	private int ancho;
	private int largo;

	public Mesada(int largo, int ancho) {
		this.largo = largo;
		this.ancho = ancho;
	}

	public int getAncho() {
		return ancho;
	}

	public int getLargo() {
		return largo;
	}

	public static int armarPilas(ArrayList<Mesada> mesadas) {
		ArrayList<Stack<Mesada>> pilasDeMesadas = new ArrayList<Stack<Mesada>>();
		boolean pilaAgregada = false;		

		for (Mesada mesa : mesadas) {

			if (pilasDeMesadas.isEmpty()) {
				Stack<Mesada> pilaNueva = new Stack<Mesada>();
				pilaNueva.add(mesa);
				pilasDeMesadas.add(pilaNueva);

			} else {

				pilaAgregada = false;
				for (Stack<Mesada> pila : pilasDeMesadas) {
					if ((mesa.largo <= pila.firstElement().largo && mesa.ancho <= pila.firstElement().ancho
							|| mesa.largo <= pila.firstElement().ancho && mesa.ancho <= pila.firstElement().largo)) {
						pila.add(mesa);
						pilaAgregada = true;
						break;
					}
				}

				if (!pilaAgregada) {
					Stack<Mesada> pilaNueva = new Stack<Mesada>();
					pilaNueva.add(mesa);
					pilasDeMesadas.add(pilaNueva);
				}
			}
		}

		return pilasDeMesadas.size();
	}

}
