package Practica1.Cruces;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import Comun.Cruces.AlgoritmoCruce;
import Comun.Genetica.Gen;
import Comun.Poblacion.Individuo;

public class Multipunto extends AlgoritmoCruce {

	@Override
	public void cruzar(Individuo padre1, Individuo padre2, int param) {
		int min = 0;
		int max = padre1.getTam();
		
		int nCruces = param;

		Individuo h1 = new Individuo(padre1);
		Individuo h2 = new Individuo(padre2);

		List<Gen> genes1 = h1.getGenes();
		List<Gen> genes2 = h2.getGenes();
		
		List<Object> alelos1 = padre1.getAlelos();
		List<Object> alelos2 = padre2.getAlelos();
		
		List<Object> hijo1 = new ArrayList<>(alelos1);
		List<Object> hijo2 = new ArrayList<>(alelos2);
		
		for(int i = 0; i < nCruces; i ++){
			int random = ThreadLocalRandom.current().nextInt(min, max);
			
			List<Object> aux1 = hijo1.subList(0,random);
			aux1.addAll(hijo2.subList(random,max));

			List<Object> aux2 = hijo2.subList(0,random);
			aux2.addAll(hijo1.subList(random,max));
			
			hijo1 = aux1;
			hijo2 = aux2;
		}
		
		int acum = 0;
		
		for(Gen g : genes1) {
			g.setAlelos(hijo1.subList(acum, acum+g.getTam()));
			acum++;
		}
		
		acum = 0;
		
		for(Gen g : genes2) {
			g.setAlelos(hijo2.subList(acum, acum+g.getTam()));
			acum++;
		}
		
		this.hijos = new ArrayList<Individuo>();
		
		this.hijos.add(new Individuo(genes1));
		this.hijos.add(new Individuo(genes2));
	}

}
