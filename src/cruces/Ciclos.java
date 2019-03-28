package cruces;

import genetica.Gen;
import poblacion.Individuo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Ciclos extends AlgoritmoCruce {
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

        fill(genes1, genes2, hijo1);

        fill(genes2, genes1, hijo2);

        this.hijos = new ArrayList<>();

        this.hijos.add(new Individuo(hijo1));
        this.hijos.add(new Individuo(hijo2));
    }

    private void fill(List<Gen> genes1, List<Gen> genes2, List<Gen> hijo1) {
        Gen step = genes1.get(1);
        int j = 1;

        while(!hijo1.contains(step)){
            hijo1.set(j,step);
            step = genes2.get(j);
            j = genes1.indexOf(step);
        }

        for(int i = 1; i < hijo1.size()-1; i++){
            if(hijo1.get(i).getFenotipo() == -1){
                hijo1.set(i, genes2.get(i));
            }
        }
    }
}
