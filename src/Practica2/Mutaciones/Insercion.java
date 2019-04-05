package Practica2.Mutaciones;

import Comun.Genetica.Gen;
import Comun.Mutaciones.AlgoritmoMutacion;
import Comun.Poblacion.Individuo;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Insercion extends AlgoritmoMutacion {
    @Override
    public void mutar(List<Individuo> poblacion, List<Double> params) {
        double probabilidad = params.get(0);
        int min = (int) poblacion.get(0).getGenes().get(0).getMin();
        int max = (int) poblacion.get(0).getGenes().get(0).getMax();

        for (Individuo ind : poblacion){
            double random = ThreadLocalRandom.current().nextDouble(0, 1);
            if(random < probabilidad){
                int posOri = ThreadLocalRandom.current().nextInt(min+1, max-1);
                int posDest = ThreadLocalRandom.current().nextInt(min+1, max-2);

                Gen swap = ind.getGenes().remove(posOri);
                ind.getGenes().add(posDest,swap);
            }
        }

        this.nPoblacion = poblacion;

    }
}
