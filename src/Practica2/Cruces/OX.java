package Practica2.Cruces;

import Comun.Cruces.AlgoritmoCruce;
import Comun.Genetica.Gen;
import Comun.Poblacion.Individuo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class OX extends AlgoritmoCruce {
    @Override
    public void cruzar(Individuo padre1, Individuo padre2, int param) {
        int min = (int)padre1.getGenes().get(0).getMin();
        int max = (int)padre1.getGenes().get(0).getMax();

        Individuo h1 = new Individuo(padre1);
        Individuo h2 = new Individuo(padre2);

        Individuo p1 = new Individuo(padre1);
        Individuo p2 = new Individuo(padre2);

        List<Gen> genes1 = p1.getGenes();
        List<Gen> genes2 = p2.getGenes();

        List<Gen> hijo1 = h1.getGenes();
        List<Gen> hijo2 = h2.getGenes();


        for(int i = 1; i < genes1.size()-1; i++){
            hijo1.get(i).setGenotipo(-1);
            hijo2.get(i).setGenotipo(-1);
        }

        int c1 = ThreadLocalRandom.current().nextInt(min+1, max-1);
        int c2 = c1;

        while(c1 == c2)
            c2 = ThreadLocalRandom.current().nextInt(min+1, max-1);

        for(int i = Math.min(c1,c2); i < Math.max(c1,c2); i++){
            hijo1.set(i,genes2.get(i));
            hijo2.set(i,genes1.get(i));
        }

        int i = Math.max(c1,c2);
        int acum = i;

        fill(genes1, hijo1, c1, c2, i, acum, genes1.size());

        i = Math.max(c1,c2);
        acum = i;

        fill(genes2, hijo2, c1, c2, i, acum, genes1.size());

        this.hijos = new ArrayList<>();

        this.hijos.add(new Individuo(hijo1));
        this.hijos.add(new Individuo(hijo2));
    }

    private void fill(List<Gen> genes, List<Gen> hijo, int c1, int c2, int i, int acum, int size) {
        while(i < hijo.size()-1){
            if(!hijo.contains(genes.get(acum))) {
                hijo.set(i, genes.get(acum));
                i++;
            }

            acum++;
            if(acum == size -1) acum = 1;
        }

        i = 1;

        while(i < Math.min(c1,c2)){
            if(!hijo.contains(genes.get(acum))) {
                hijo.set(i, genes.get(acum));
                i++;
            }
            acum++;
            if(acum == size -1) acum = 1;
        }
    }
}
