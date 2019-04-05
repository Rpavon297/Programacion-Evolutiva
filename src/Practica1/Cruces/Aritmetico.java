package Practica1.Cruces;

import java.util.ArrayList;
import java.util.List;

import Comun.Cruces.AlgoritmoCruce;
import Comun.Genetica.Gen;
import Comun.Poblacion.Individuo;

public class Aritmetico extends AlgoritmoCruce {

	@Override
	public void cruzar(Individuo padre1, Individuo padre2, int param) {
		List<Double> fenotipo1 = padre1.getFenotipo();
		List<Double> fenotipo2 = padre2.getFenotipo();

		Individuo copia_padre = new Individuo(padre1);
		List<Gen> hijo = copia_padre.getGenes();
		
		for(int i = 0; i < fenotipo1.size(); i++){
			double media = (fenotipo1.get(i) + fenotipo2.get(i)) / 2;
			hijo.get(i).setGenotipo(media);
			if(hijo.get(i).getFenotipo() < hijo.get(i).getMin())
				System.out.println("stop");
		}
		
		this.hijos = new ArrayList<>();
		this.hijos.add(new Individuo(hijo));
		
	}

}
