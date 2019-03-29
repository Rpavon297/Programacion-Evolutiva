package mutaciones;

import funciones.Funcion;
import funciones.FuncionViajante;
import genetica.Gen;
import poblacion.Individuo;

import java.util.ArrayList;
import java.util.List;

public class Heuristica extends Mutacion{

    private Individuo mejor;

    @Override
    public void mutar(List<Individuo> poblacion, List<Double> params) {

        double probabilidad = params.get(0);

        for(Individuo ind : poblacion){
            double random = Math.random();
            if(random < probabilidad) {
                int pos1, pos2, pos3;
                int size = ind.getGenes().size();

                do {
                    pos1 = (int) (Math.random() * size);
                } while (pos1 == 0 || pos1 == size - 1);

                do {
                    pos2 = (int) (Math.random() * size);
                } while (pos2 == 0 || pos2 == size - 1 || pos2 == pos1);

                do {
                    pos3 = (int) (Math.random() * size);
                } while (pos3 == 0 || pos3 == size - 1 || pos3 == pos1 || pos3 == pos2);

                this.mejor = new Individuo(new ArrayList<>(ind.getGenes()));
                List<Integer> posiciones = new ArrayList<>();
                posiciones.add(pos1);
                posiciones.add(pos2);
                posiciones.add(pos3);

                List<Gen> conjunto = new ArrayList<>();
                conjunto.add(ind.getGenes().get(pos1));
                conjunto.add(ind.getGenes().get(pos2));
                conjunto.add(ind.getGenes().get(pos3));

                List<Gen> resultado = new ArrayList<>();

                Individuo indCopy = new Individuo(new ArrayList<>(ind.getGenes()));

                permutaciones(indCopy, conjunto, resultado, posiciones);
                ind.setGenes(this.mejor.getGenes());
            }
        }
        this.nPoblacion = poblacion;

    }

    private void permutaciones(Individuo individuo, List<Gen> conjunto, List<Gen> resultado, List<Integer> posiciones) {

        Funcion f = new FuncionViajante();

        if (conjunto.size()==0)
        {
            individuo.getGenes().set(posiciones.get(0), resultado.get(0));
            individuo.getGenes().set(posiciones.get(1), resultado.get(1));
            individuo.getGenes().set(posiciones.get(2), resultado.get(2));
            if(f.ejecutar(individuo.getFenotipo()) < f.ejecutar(this.mejor.getFenotipo()))
                this.mejor = new Individuo(new ArrayList<>(individuo.getGenes()));
        }
        for (int i=0;i<conjunto.size();i++)
        {
            Gen b = conjunto.remove(i);
            resultado.add(b);
            permutaciones (individuo, conjunto, resultado, posiciones);
            resultado.remove(b);
            conjunto.add(i,b);
        }
    }
}
