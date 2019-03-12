package cruces;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import genetica.Gen;
import poblacion.Individuo;

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

				double alfa = ThreadLocalRandom.current().nextDouble(0, 1);
				double Ialfa = (cmax - cmin) * alfa;

				hijo1.get(i).randomize(cmin - Ialfa, cmax + Ialfa);
				hijo2.get(i).randomize(cmin - Ialfa, cmax + Ialfa);
			}
		}
		
		this.hijos = new ArrayList<>();
		this.hijos.add(new Individuo(hijo1));
		this.hijos.add(new Individuo(hijo2));
	}

}
