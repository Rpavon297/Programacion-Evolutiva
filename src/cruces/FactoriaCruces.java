package cruces;

import poblacion.Individuo;
import poblacion.Poblacion;

public class FactoriaCruces {
	
	private static AlgoritmoCruce getAlgoritmoCruce(String algoritmo, Individuo padre1, Individuo padre2, int param) {
		
		AlgoritmoCruce cruce;
		switch(algoritmo) {
			case "Monopunto":
				cruce = new Monopunto();
				cruce.cruzar(padre1, padre2, param);
				break;
			case "Uniforme":
				cruce = new Uniforme();
				cruce.cruzar(padre1, padre2, param);
				break;
			case "Multipunto":
				cruce = new Multipunto();
				cruce.cruzar(padre1, padre2, param);
				break;
			case "BLX":
				cruce = new BLX();
				cruce.cruzar(padre1, padre2, param);
				break;
			case "PMX":
				cruce = new PMX();
				cruce.cruzar(padre1,padre2, param);
				break;
			case "OX":
				cruce = new OX();
				cruce.cruzar(padre1,padre2,param);
				break;
			case "OX posiciones prioritarias":
				cruce = new OXPP();
				cruce.cruzar(padre1,padre2,param);
			default:
				cruce = new Aritmetico();
				cruce.cruzar(padre1, padre2, param);
			}
		return cruce;
	}

	public static Poblacion cruzarPoblacion(Poblacion poblacion, String Algoritmo, int param) {

		Poblacion pob = new Poblacion();
		int aCruzar = 1;
		Individuo j = null;

		for(Individuo i : poblacion.getPoblacion()) {
			if(aCruzar == 1)
				j = i;
			if(aCruzar == 2) {
				aCruzar = 0;
				pob.getPoblacion().addAll(getAlgoritmoCruce(Algoritmo, i, j, param).getHijos());
			}

			aCruzar++;
		}
		return pob;
	}

}