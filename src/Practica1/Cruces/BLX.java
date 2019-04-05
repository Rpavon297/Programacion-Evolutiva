package Practica1.Cruces;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import Comun.Cruces.AlgoritmoCruce;
import Comun.Genetica.Gen;
import Comun.Poblacion.Individuo;

@SuppressWarnings("ALL")
public class BLX extends AlgoritmoCruce {

	@Override
	public void cruzar(Individuo padre1, Individuo padre2, int param) {
		// TODO Auto-generated method stub
		
		List<Double> fenotipo1 = padre1.getFenotipo();
		List<Double> fenotipo2 = padre2.getFenotipo();

		Individuo h1 = new Individuo(padre1);
		Individuo h2 = new Individuo(padre2);

		List<Gen> hijo1 = h1.getGenes();
		List<Gen> hijo2 = h2.getGenes();
		
		
		for(int i = 0; i < hijo1.size(); i++){
			double cmax = Math.max(fenotipo1.get(i), fenotipo2.get(i));
			double cmin = Math.min(fenotipo1.get(i), fenotipo2.get(i));

			if(cmax == cmin){
				hijo1.get(i).setGenotipo(cmin);
				hijo2.get(i).setGenotipo(cmin);
			}else{
				double alfa,Ialfa,minI,maxI;

				do {
					alfa = ThreadLocalRandom.current().nextDouble(0, 1);
					Ialfa = (cmax - cmin) * alfa;

					minI = cmin - Ialfa;
					maxI = cmax + Ialfa;

					if(minI < hijo1.get(i).getMin()) minI = hijo1.get(i).getMin();
					if(maxI > hijo1.get(i).getMax() || maxI < minI) maxI = hijo1.get(i).getMax();
				}while(minI == maxI);

				hijo1.get(i).randomize(minI, maxI);
				hijo2.get(i).randomize(minI, maxI);
			}
		}
		
		this.hijos = new ArrayList<>();
		this.hijos.add(new Individuo(hijo1));
		this.hijos.add(new Individuo(hijo2));
	}

}
