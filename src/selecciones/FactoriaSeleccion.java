package selecciones;

import java.util.List;

import poblacion.Individuo;

public class FactoriaSeleccion {
	private static final int TAM_SELECCION = 6;
	
	public static AlgoritmoSeleccion getAlgoritmoSeleccion(String algoritmo, List<Individuo> poblacion, Object param) {
		
		AlgoritmoSeleccion sel;
		switch(algoritmo) {
		case "Estocastico":
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
		case "TorneoProb":
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
