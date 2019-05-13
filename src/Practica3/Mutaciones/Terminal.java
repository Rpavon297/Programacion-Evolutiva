package Practica3.Mutaciones;

import Comun.Genetica.Gen;
import Comun.Mutaciones.AlgoritmoMutacion;
import Comun.Poblacion.Individuo;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Terminal extends AlgoritmoMutacion {
    @Override
    public void mutar(List<Individuo> poblacion, List<Double> params) {

        double probabilidad = params.get(0);
        double min = params.get(1);
        double max = params.get(2);

        for(Individuo individuo : poblacion) {
            for (Gen gen : individuo.getGenes()) {
                if (gen.getFenotipo() % 6 > 2) {
                    double random = ThreadLocalRandom.current().nextDouble(0, 1);
                    if (random <= probabilidad)
                        do {
                            gen.randomize(min, max);
                        } while (gen.getFenotipo() % 6 < 3);
                }
            }
        }
        this.nPoblacion = poblacion;
    }
}
