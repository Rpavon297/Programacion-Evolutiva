package mutaciones;

import funciones.Funcion;
import funciones.FuncionViajante;
import genetica.Gen;
import poblacion.Individuo;

import java.util.ArrayList;
import java.util.List;

public class Heuristica extends Mutacion{
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

                List<Integer> posiciones = new ArrayList<>();
                posiciones.add(pos1);
                posiciones.add(pos2);
                posiciones.add(pos3);


                List<Gen> conjunto = new ArrayList<>();
                conjunto.add(ind.getGenes().get(pos1));
                conjunto.add(ind.getGenes().get(pos2));
                conjunto.add(ind.getGenes().get(pos3));

                List<Gen> resultado = new ArrayList<>();

                List<Gen> indCopy = new ArrayList<>(ind.getGenes());
                Funcion f = new FuncionViajante();
                System.out.println(ind.getGenes());
                System.out.println(f.ejecutar(ind.getFenotipo()));
                Individuo maximo = new Individuo(new ArrayList<>(ind.getGenes()));
                permutaciones(indCopy, conjunto, resultado, posiciones, maximo);
                System.out.println(ind.getGenes());
                System.out.println(f.ejecutar(ind.getFenotipo()));
            }
        }
        this.nPoblacion = poblacion;

    }

    public static List<Gen> permutaciones(List<Gen> individuo, List<Gen> conjunto, List<Gen> resultado, List<Integer> posiciones, Individuo maximo) {

        Funcion f = new FuncionViajante();

        if (conjunto.size()==0) {
            individuo.set(posiciones.get(0), resultado.get(0));
            individuo.set(posiciones.get(1), resultado.get(1));
            individuo.set(posiciones.get(2), resultado.get(2));
            Individuo i = new Individuo(individuo);
            return i.getGenes();
            //double f1 = f.ejecutar(maximo.getFenotipo());
            //double f2 = f.ejecutar(i.getFenotipo());
            //System.out.println(posiciones);
            //if(f1 > f2) {
                //maximo = new Individuo(new ArrayList<>(i.getGenes()));
            //}
        }
        for (int i=0; i<conjunto.size(); i++) {
            Gen b = conjunto.remove(i);
            resultado.add(b);
            List<Gen> result = permutaciones(individuo, conjunto, resultado, posiciones, maximo);
            double f1 = f.ejecutar(maximo.getFenotipo());
            double f2 = f.ejecutar(new Individuo(new ArrayList<>(result)).getFenotipo());
            System.out.println(posiciones);
            if(f1 > f2)
                maximo = new Individuo(new ArrayList<>(result));
            resultado.remove(b);
            conjunto.add(i, b);
        }
        return maximo.getGenes();
    }
}
