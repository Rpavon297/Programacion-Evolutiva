package mutaciones;

import genetica.Gen;
import poblacion.Individuo;

import java.util.Collections;
import java.util.List;

public class Inversion extends Mutacion {
    @Override
    public void mutar(List<Individuo> poblacion, List<Double> params) {

        double probabilidad = params.get(0);

        for(Individuo ind : poblacion){
            double random = Math.random();
            if(random < probabilidad){
                int pos1, pos2;
                int size = ind.getGenes().size();

                do {
                    pos1 = (int) (Math.random() * size);
                } while (pos1 == 0 || pos1 == size-1);

                do {
                    pos2 = (int) (Math.random() * size);
                } while (pos2 == 0 || pos2 == size-1 || pos2 == pos1);

                List<Gen> list = ind.getGenes().subList(Math.min(pos1, pos2), Math.max(pos1, pos2));
                Collections.reverse(list);
                ind.getGenes().removeAll(list);
                ind.getGenes().addAll(Math.min(pos1, pos2), list);
            }
        }
        this.nPoblacion = poblacion;
    }
}
