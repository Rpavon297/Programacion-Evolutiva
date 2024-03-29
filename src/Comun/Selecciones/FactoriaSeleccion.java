package Comun.Selecciones;

import java.util.List;

import Comun.Poblacion.Individuo;

@SuppressWarnings("ALL")
public class FactoriaSeleccion {
	private static int TAM_SELECCION = 20;
	
	public static AlgoritmoSeleccion getAlgoritmoSeleccion(String algoritmo, List<Individuo> poblacion, Object param) {
		TAM_SELECCION = poblacion.size()/2;

		AlgoritmoSeleccion sel;
		switch(algoritmo) {
		case "Estocastica":
			sel = new EstocasticoUniversal();
			sel.seleccion(poblacion, TAM_SELECCION);
			break;
		case "Ruleta":
			sel = new Ruleta();
			sel.seleccion(poblacion, TAM_SELECCION);
			break;
		case "Torneo":
			sel = new Torneo();
			sel.seleccion(poblacion, TAM_SELECCION);
			break;
		case "Torneo Probabilistico":
			sel = new TorneoProb();
			sel.seleccion(poblacion, new Pair(TAM_SELECCION, param));
			break;
		default:
			sel = new Truncamiento();
			sel.seleccion(poblacion, param);
			break;
		}
		return sel;
	}

}
