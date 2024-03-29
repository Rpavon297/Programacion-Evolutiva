package Practica2.Mutaciones;

import Comun.Genetica.Gen;
import Comun.Mutaciones.AlgoritmoMutacion;
import Comun.Poblacion.Individuo;

import java.util.List;

@SuppressWarnings("ALL")
public class Inversion extends AlgoritmoMutacion {
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

                int min = Math.min(pos1, pos2);
                int max = Math.max(pos1, pos2);

                while(min < max) {
                    Gen aux = ind.getGenes().get(min);
                    ind.getGenes().set(min, ind.getGenes().get(max));
                    ind.getGenes().set(max, aux);
                    min++;
                    max--;
                }
            }
        }
        this.nPoblacion = poblacion;
    }
}
