package cruces;

import poblacion.Individuo;
import poblacion.Poblacion;

import java.util.List;

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
			case "OX Posiciones Prioritarias":
				cruce = new OXPP();
				cruce.cruzar(padre1,padre2,param);
				break;
			case "OX Orden Prioritario":
				cruce = new OXOP();
				cruce.cruzar(padre1,padre2,param);
				break;
			case "Ciclos":
				cruce = new Ciclos();
				cruce.cruzar(padre1,padre2,param);
				break;
			case "ERX":
				cruce = new ERX();
				cruce.cruzar(padre1,padre2,param);
				break;
			case "Codificacion ordinal":
				cruce = new Ordinal();
				cruce.cruzar(padre1,padre2,param);
				break;
			case "Intercambio de segmentos":
				cruce = new ICC();
				cruce.cruzar(padre1,padre2,param);
				break;
			default:
				cruce = new Aritmetico();
				cruce.cruzar(padre1, padre2, param);
			}
		return cruce;
	}

	public static Poblacion cruzarPoblacion(Poblacion poblacion, String Algoritmo, List<Double> param) {

		Poblacion pob = new Poblacion();
		int aCruzar = 1;
		Individuo j = null;
		double probabilidad = param.get(0);

		for(Individuo i : poblacion.getPoblacion()) {
			if(Math.random() < probabilidad) {
				if (aCruzar == 1)
					j = i;
				if (aCruzar == 2) {
					aCruzar = 0;
					pob.getPoblacion().addAll(getAlgoritmoCruce(Algoritmo, i, j, param.get(1).intValue()).getHijos());
				}

				aCruzar++;
			}
		}
		return pob;
	}

}