package Practica2.Cruces;

import Comun.Cruces.AlgoritmoCruce;
import Comun.Genetica.Gen;
import Comun.Poblacion.Individuo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("ALL")
public class OXPP extends AlgoritmoCruce {
    @Override
    public void cruzar(Individuo padre1, Individuo padre2, int param) {
        //número de genes que se van a intercambiar entre padre e hijo
        final int NINTERCAMBIOS = 6;
        List<Integer> pcorte = new ArrayList<>();
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


        for (int i = 0; i < NINTERCAMBIOS; i++) {
            int c = ThreadLocalRandom.current().nextInt(min + 1, max - 1);

            while (pcorte.contains(c))
                c = ThreadLocalRandom.current().nextInt(min + 1, max - 1);
            pcorte.add(c);
        }

        Collections.sort(pcorte);

        for (int c : pcorte) {
            hijo1.set(c, genes2.get(c));
            hijo2.set(c, genes1.get(c));
        }

        int i = pcorte.get(NINTERCAMBIOS - 1) + 1, acum = i;

        fill(genes1, hijo1, i, acum);

        i = pcorte.get(NINTERCAMBIOS - 1) + 1;
        acum = i;

        fill(genes2, hijo2, i, acum);

        this.hijos = new ArrayList<>();

        this.hijos.add(new Individuo(hijo1));
        this.hijos.add(new Individuo(hijo2));
    }

    private void fill(List<Gen> genes, List<Gen> hijo, int i, int acum) {
        while (i < hijo.size() - 1) {
            if (!hijo.contains(genes.get(acum))) {
                hijo.set(i, genes.get(acum));
                i++;
            }
            acum++;
            if (acum == genes.size() - 1) acum = 1;
        }

        i = 1;

        while (i < hijo.size() - 1) {
            if (hijo.get(i).getFenotipo() == -1) {
                if (!hijo.contains(genes.get(acum))) {
                    hijo.set(i, genes.get(acum));
                    i++;
                }
                acum++;
                if (acum == genes.size() - 1) acum = 1;
            }
            else i++;
        }
    }

}
