package cruces;

import genetica.Gen;
import genetica.GenEntero;
import poblacion.Individuo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Ordinal extends AlgoritmoCruce {
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

        List<Integer> rec1 = new ArrayList<>();
        List<Integer> rec2 = new ArrayList<>();

        crearRecorrido(genes1, hijo1, rec1);
        crearRecorrido(genes2, hijo1, rec2);

        int random = ThreadLocalRandom.current().nextInt(min+1, max-1);

        List<Integer> rec3 = rec1.subList(0,random);
        rec3.addAll(rec2.subList(random,max-1));

        List<Integer> rec4 = rec2.subList(0,random);
        rec4.addAll(rec1.subList(random,max-1));


        setRecorridos(hijo1, rec3);

        setRecorridos(hijo2, rec4);
    }

    private void setRecorridos(List<Gen> hijo1, List<Integer> rec3) {
        List<Integer> pos = new ArrayList<>();

        for(int i = 0; i < hijo1.size();i++)
            pos.add(i);

        for(int i = 1; i < hijo1.size()-1; i++){
            hijo1.get(i).setGenotipo(pos.get(rec3.get(i)));
            pos.remove((int) rec3.get(i));
        }
    }

    private void crearRecorrido(List<Gen> genes1, List<Gen> hijo1, List<Integer> rec1) {
        List<Integer> pos = new ArrayList<>();

        for(int i = 0; i < hijo1.size();i++)
            pos.add(i + 1);

        for(int i = 1; i < genes1.size()-1; i++) {
            Gen g = genes1.get(i);
            rec1.add(pos.indexOf((int) g.getFenotipo()));
            pos.remove(new Integer((int) g.getFenotipo()));
        }
    }
}
