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

        List<Gen> genes1 = h1.getGenes();
        List<Gen> genes2 = h2.getGenes();

        List<Gen> hijo1 = new ArrayList<>(genes1);
        List<Gen> hijo2 = new ArrayList<>(genes2);

        int c1 = ThreadLocalRandom.current().nextInt(min+1, max-1);
        int c2 = c1;

        while(c1 == c2)
            c2 = ThreadLocalRandom.current().nextInt(min, max);

        for(int i = Math.min(c1,c2); i < Math.max(c1,c2); i++){
            hijo1.set(i,genes2.get(i));
            hijo2.set(i,genes1.get(i));
        }

        for(int i = 1; i < Math.min(c1,c2); i++){
            if(hijo1.contains(genes1.get(i)))
                hijo1.set(i,genes2.get(hijo1.indexOf(genes1.get(i))));

            if(hijo2.contains(genes2.get(i)))
                hijo2.set(i,genes1.get(hijo2.indexOf(genes2.get(i))));
        }

        for(int i = Math.max(c1,c2); i < hijo1.size()-1; i++){
            if(hijo1.contains(genes1.get(i)))
                hijo1.set(i,genes2.get(hijo1.indexOf(genes1.get(i))));

            if(hijo2.contains(genes2.get(i)))
                hijo2.set(i,genes1.get(hijo2.indexOf(genes2.get(i))));
        }
        this.hijos = new ArrayList<>();
        this.hijos.add(new Individuo(hijo1));
        this.hijos.add(new Individuo(hijo2));
    }
}
