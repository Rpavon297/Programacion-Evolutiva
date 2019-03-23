package cruces;

import genetica.Gen;
import poblacion.Individuo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PMX extends AlgoritmoCruce {
    @Override
    public void cruzar(Individuo padre1, Individuo padre2, int param) {
        int min = (int)padre1.getGenes().get(0).getMin();
        int max = (int)padre1.getGenes().get(0).getMax();

        Individuo h1 = new Individuo(padre1);
        Individuo h2 = new Individuo(padre2);

        List<Gen> genes1 = padre1.getGenes();
        List<Gen> genes2 = padre2.getGenes();

        List<Gen> hijo1 = h1.getGenes();
        List<Gen> hijo2 = h2.getGenes();

        for(int i = 1; i < genes1.size()-1; i++){
            hijo1.get(i).setGenotipo(-1);
            hijo2.get(i).setGenotipo(-1);
        }

        int c1 = ThreadLocalRandom.current().nextInt(min+1, max-1);
        int c2 = c1;

        while(c1 == c2)
            c2 = ThreadLocalRandom.current().nextInt(min, max);

        for(int i = Math.min(c1,c2); i < Math.max(c1,c2); i++){
            hijo1.set(i,genes2.get(i));
            hijo2.set(i,genes1.get(i));
        }

        int ind1 = -1;
        int ind2 = -1;

        for(int i = 1; i < Math.min(c1,c2); i++){
            ind1 = hijo1.indexOf(genes1.get(i));
            ind2 = hijo2.indexOf(genes2.get(i));

            if(ind1 == -1)
                hijo1.set(i,genes1.get(i));
            else
                hijo1.set(i,genes1.get(ind1));

            if(ind2 == -1)
                hijo2.set(i, genes2.get(i));
            else
                hijo2.set(i, genes2.get(ind2));

        }

        for(int i = Math.max(c1,c2); i < hijo1.size()-1; i++){
            ind1 = hijo1.indexOf(genes1.get(i));
            ind2 = hijo2.indexOf(genes2.get(i));

            if(ind1 == -1)
                hijo1.set(i,genes1.get(i));
            else
                hijo1.set(i,genes1.get(ind1));

            if(ind2 == -1)
                hijo2.set(i,genes2.get(i));
            else
                hijo2.set(i, genes2.get(ind2));
        }

        this.hijos = new ArrayList<>();
        this.hijos.add(new Individuo(hijo1));
        this.hijos.add(new Individuo(hijo2));
    }
}
