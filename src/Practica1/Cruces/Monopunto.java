package Practica1.Cruces;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import Comun.Cruces.AlgoritmoCruce;
import Comun.Genetica.Gen;
import Comun.Poblacion.Individuo;

public class Monopunto extends AlgoritmoCruce {
	
	public void cruzar(Individuo padre1, Individuo padre2, int params) {
		int min = 0;
		int max = padre1.getTam();

		int random = ThreadLocalRandom.current().nextInt(min, max);
		
		Individuo h1 = new Individuo(padre1);
		Individuo h2 = new Individuo(padre2);

		List<Gen> genes1 = h1.getGenes();
		List<Gen> genes2 = h2.getGenes();
		
		List<Object> alelos1 = padre1.getAlelos();
		List<Object> alelos2 = padre2.getAlelos();
		
		List<Object> hijo1 = alelos1.subList(0,random);
		hijo1.addAll(alelos2.subList(random,max));

		List<Object> hijo2 = alelos2.subList(0,random);
		hijo2.addAll(alelos1.subList(random,max));

		int acum = 0;
		
		for(Gen g : genes1) {
			g.setAlelos(hijo1.subList(acum, acum+g.getTam()));
			acum += g.getTam();
		}
		
		acum = 0;
		
		for(Gen g : genes2) {
			g.setAlelos(hijo2.subList(acum, acum+g.getTam()));
			acum += g.getTam();
		}
		
		this.hijos = new ArrayList<Individuo>();
		
		this.hijos.add(new Individuo(genes1));
		this.hijos.add(new Individuo(genes2));
	}

}
