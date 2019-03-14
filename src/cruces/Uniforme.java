package cruces;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import genetica.Gen;
import poblacion.Individuo;

public class Uniforme extends AlgoritmoCruce{

	@Override
	public void cruzar(Individuo padre1, Individuo padre2, int param) {
		List<Object> alelos1 = padre1.getAlelos();
		List<Object> alelos2 = padre2.getAlelos();
		
		List<Object> hijo1 = new ArrayList<>();
		List<Object> hijo2 = new ArrayList<>();
		
		for(int i = 0; i < alelos1.size(); i++){
			int random = ThreadLocalRandom.current().nextInt(0, 10);
			
			if(random >= 5){
				hijo1.add(alelos2.get(i));
				hijo2.add(alelos1.get(i));
			}else{
				hijo1.add(alelos1.get(i));
				hijo2.add(alelos2.get(i));
			}	
		}
		
		int acum = 0;
		Individuo h1 = new Individuo(padre1);
		Individuo h2 = new Individuo(padre2);

		List<Gen> genes1 = h1.getGenes();
		List<Gen> genes2 = h2.getGenes();
		
		for(Gen g : genes1) {
			g.setAlelos(hijo1.subList(acum, acum+g.getTam()));
			acum++;
		}
		
		acum = 0;
		
		for(Gen g : genes2) {
			g.setAlelos(hijo2.subList(acum, acum+g.getTam()));
			acum++;
		}
		
		this.hijos = new ArrayList<>();
		
		this.hijos.add(new Individuo(genes1));
		this.hijos.add(new Individuo(genes2));
	}

}
