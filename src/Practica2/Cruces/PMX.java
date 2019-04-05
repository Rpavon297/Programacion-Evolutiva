package Practica2.Cruces;

import Comun.Cruces.AlgoritmoCruce;
import Comun.Genetica.Gen;
import Comun.Poblacion.Individuo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PMX extends AlgoritmoCruce {
    @Override
    public void cruzar(Individuo padre1, Individuo padre2, int param) {
        int min = (int) padre1.getGenes().get(0).getMin();
        int max = (int) padre1.getGenes().get(0).getMax();

        Individuo h1 = new Individuo(padre1);
        Individuo h2 = new Individuo(padre2);

        Individuo p1 = new Individuo(padre1);
        Individuo p2 = new Individuo(padre2);

        List<Gen> genes1 = p1.getGenes();
        List<Gen> genes2 = p2.getGenes();

        List<Gen> hijo1 = h1.getGenes();
        List<Gen> hijo2 = h2.getGenes();

        for (int i = 1; i < genes1.size() - 1; i++) {
            hijo1.get(i).setGenotipo(-1);
            hijo2.get(i).setGenotipo(-1);
        }

        int c1 = ThreadLocalRandom.current().nextInt(min + 1, max - 1);
        int c2 = c1;

        while (c1 == c2)
            c2 = ThreadLocalRandom.current().nextInt(min + 1, max - 1);

        for (int i = Math.min(c1, c2); i <= Math.max(c1, c2); i++) {
            hijo1.set(i, genes2.get(i));
            hijo2.set(i, genes1.get(i));

        }

        for (int i = 1; i < hijo1.size() - 1; i++) {
            if (hijo1.get(i).getFenotipo() == -1 && !hijo1.contains(genes1.get(i)))
                hijo1.set(i, genes1.get(i));
            if (hijo2.get(i).getFenotipo() == -1 && !hijo2.contains(genes2.get(i)))
                hijo2.set(i, genes2.get(i));
        }
        while (tieneDuplicados(hijo1) || tieneDuplicados(hijo2)) {
            for (int i = 1; i < hijo1.size() - 1; i++) {
                if (hijo1.get(i).getFenotipo() == -1){
                    hijo1.set(i, genes1.get(genes2.indexOf(genes1.get(i))));
                }
                else if (duplicado(hijo1, i)) {
                    hijo1.set(i, genes1.get(genes2.indexOf(hijo1.get(i))));
                }
                if (hijo2.get(i).getFenotipo() == -1) {
                    hijo2.set(i, genes2.get(genes1.indexOf(genes2.get(i))));
                }
                else if (duplicado(hijo2, i)) {
                    hijo2.set(i, genes2.get(genes1.indexOf(hijo2.get(i))));
                }
            }
        }

        this.hijos = new ArrayList<>();
        this.hijos.add(new Individuo(hijo1));
        this.hijos.add(new Individuo(hijo2));
    }

    private boolean tieneDuplicados(List<Gen> hijo1) {
        List<Gen> check = new ArrayList<>();
        for (int i = 1; i < hijo1.size() - 1; i++) {
            if(hijo1.get(i).getFenotipo() != -1 && !check.contains(hijo1.get(i)))
                check.add(hijo1.get(i));
            else return true;
        }
        return false;
    }

    private boolean duplicado(List<Gen> hijo1, int index) {
        for (int i = 1; i < hijo1.size() - 1; i++) {
            if ((hijo1.get(i).equals(hijo1.get(index))) &&
                    (i != index)) {
                return true;
            }
        }
        return false;
    }
}
