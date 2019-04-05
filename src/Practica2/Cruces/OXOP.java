package Practica2.Cruces;

import Comun.Cruces.AlgoritmoCruce;
import Comun.Genetica.Gen;
import Comun.Poblacion.Individuo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OXOP extends AlgoritmoCruce {
    @Override
    public void cruzar(Individuo padre1, Individuo padre2, int param) {

        this.hijos = new ArrayList<>();
        System.out.println(padre1);
        System.out.println(padre2);
        cruzaHijos(padre1, padre2);
        cruzaHijos(padre2, padre1);
        System.out.println(hijos.get(0));
        System.out.println(hijos.get(1));
    }


    private void cruzaHijos(Individuo padre1, Individuo padre2) {
        List<Gen> listaAcruzar = new ArrayList<>();
        for(int i = 0; i < 15; i++){
            int pos = (int) (Math.random()*padre1.getGenes().size());
            Gen g = padre1.getGenes().get(pos);

            while(pos == 0 || pos == 28 || listaAcruzar.contains(g)){
                pos = (int) (Math.random()*padre1.getGenes().size());
                g = padre1.getGenes().get(pos);
            }
            listaAcruzar.add(g);
        }

        List<Integer> posiciones = new ArrayList<>();
        for(Gen i : listaAcruzar){
            posiciones.add(padre2.getGenes().indexOf(i));
        }
        Collections.sort(posiciones, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        Individuo hijo1 = new Individuo(padre2.getGenes());

        int o = 0;

        for(int i : posiciones){
            hijo1.getGenes().set(i, listaAcruzar.get(o));
            o++;
        }
        this.hijos.add(hijo1);
    }
}
