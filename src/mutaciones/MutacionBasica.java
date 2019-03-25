package mutaciones;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import genetica.Gen;
import poblacion.Individuo;

public class MutacionBasica extends Mutacion{

	@Override
	public void mutar(List<Individuo> poblacion, List<Double> params) {
		
		double probabilidad = params.get(0);
		double min = params.get(1);
		double max = params.get(2);
		
		if(params.size() == 5) {
			for(Individuo individuo : poblacion){
				double min1 = params.get(3);
				double max1 = params.get(4);
				double random = ThreadLocalRandom.current().nextDouble(0, 1);
				if(random <= probabilidad)
					individuo.getGenes().get(0).randomize(min, max);
				random = ThreadLocalRandom.current().nextDouble(0, 1);
				if(random <= probabilidad)
					individuo.getGenes().get(1).randomize(min1, max1);
			}
		}
		else {
			for(Individuo individuo : poblacion){
				for(Gen gen : individuo.getGenes()){
					double random = ThreadLocalRandom.current().nextDouble(0, 1);
					if(random <= probabilidad)
						gen.randomize(min, max);
				}
			}
		}
		
		this.nPoblacion = poblacion;
	}
}
