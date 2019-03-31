package cruces;

import genetica.Gen;
import poblacion.Individuo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ICC extends AlgoritmoCruce{
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

        List<Integer> puntos_cruzados = new ArrayList<>();

        for(int j = 0; j < 5; j++) {

            int ind1 = ThreadLocalRandom.current().nextInt(min + 2, max - 2);
            int ind2 = genes2.indexOf(genes1.get(ind1));

            while (ind2 > max - 2 || ind2 <= min + 2 || puntos_cruzados.contains(ind1)) {
                ind1 = ThreadLocalRandom.current().nextInt(min + 2, max - 2);
                ind2 = genes2.indexOf(genes1.get(ind1));
            }
            puntos_cruzados.add(ind1);

            List<Gen> conj1 = new ArrayList<>();
            List<Gen> conj2 = new ArrayList<>();

            for (int i = -1; i < 2; i++) {
                conj1.add(hijo1.get(ind1 + i));
                conj2.add(hijo2.get(ind2 + i));
            }

            hijo1.remove(conj2.get(0));
            hijo1.remove(conj2.get(2));

            hijo2.remove(conj1.get(0));
            hijo2.remove(conj1.get(2));

            hijo1.add(ind1 - 1, conj2.get(0));
            hijo1.add(ind1 + 1, conj2.get(2));

            hijo2.add(ind2 - 1, conj1.get(0));
            hijo2.add(ind2 + 1, conj1.get(2));
        }

        this.hijos = new ArrayList<>();

        this.hijos.add(new Individuo(hijo1));
        this.hijos.add(new Individuo(hijo2));

    }
}
