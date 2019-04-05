package Practica2.Mutaciones;

import Comun.Genetica.Gen;
import Comun.Mutaciones.AlgoritmoMutacion;
import Comun.Poblacion.Individuo;

import java.util.List;

public class Intercambio extends AlgoritmoMutacion {
    @Override
    public void mutar(List<Individuo> poblacion, List<Double> params) {

        double probabilidad = params.get(0);

        for(Individuo i : poblacion){
            double random = Math.random();
            if(random < probabilidad){
                int pos1, pos2;
                int size = i.getGenes().size();

                do {
                    pos1 = (int) (Math.random() * size);
                } while (pos1 == 0 || pos1 == size-1);

                do {
                    pos2 = (int) (Math.random() * size);
                } while (pos2 == 0 || pos2 == size-1 || pos2 == pos1);

                Gen aux = i.getGenes().get(pos1);
                i.getGenes().set(pos1, i.getGenes().get(pos2));
                i.getGenes().set(pos2, aux);
            }
        }
        this.nPoblacion = poblacion;
    }
}
