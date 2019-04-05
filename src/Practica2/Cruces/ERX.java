package Practica2.Cruces;

import Comun.Genetica.Gen;
import Comun.Genetica.GenEntero;
import Comun.Poblacion.Individuo;

import java.util.ArrayList;
import java.util.List;

public class ERX extends Comun.Cruces.AlgoritmoCruce {
    @Override
    public void cruzar(Individuo padre1, Individuo padre2, int param) {
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

        List<List<Gen>> tabla = new ArrayList<>();

        llenaTabla(genes1, genes2, tabla);

        llenaHijo(genes1, hijo1, tabla);
        llenaHijo(genes2, hijo2, tabla);

        this.hijos = new ArrayList<>();

        this.hijos.add(new Individuo(hijo1));
        this.hijos.add(new Individuo(hijo2));
    }

    private void llenaHijo(List<Gen> genes1, List<Gen> hijo1, List<List<Gen>> tabla) {
        boolean trig = true;
        int control = 0;
        while(trig) {
            control++;
            trig = false;
            int index = 1;

            for(int i = 1; i < genes1.size()-1; i++){
                hijo1.get(i).setGenotipo(-1);
            }

            Gen nextstep = new GenEntero((GenEntero) genes1.get(1));
            hijo1.set(1, nextstep);

            int colum = (int)nextstep.getFenotipo();
            nextstep = menosConectado(tabla,colum, hijo1);

            while(nextstep != null && index < genes1.size()-1){
                index++;
                hijo1.set(index,nextstep);
                colum = (int)nextstep.getFenotipo();
                nextstep = menosConectado(tabla,colum, hijo1);

                if(nextstep == null && index < genes1.size()-2)
                    trig = true;
            }
            if(control > 100){
                for(int i = 1; i < genes1.size()-1; i++){
                    hijo1.set(i, genes1.get(i));
                }
                trig = false;
            }

        }
    }

    private void llenaTabla(List<Gen> hijo1, List<Gen> hijo2, List<List<Gen>> tabla) {
        for(int i = 0; i < hijo1.size()-1; i++) {
            tabla.add(new ArrayList<>());
        }
        for(int i = 0; i < hijo1.size()-1; i++){
            List<Gen> columna = new ArrayList<>();
            columna.add(new GenEntero((GenEntero)hijo1.get(i)));

            if(i > 1)
                columna.add(new GenEntero((GenEntero) hijo1.get(i - 1)));
            else
                columna.add(new GenEntero((GenEntero) hijo1.get(hijo1.size()-2)));
            if(i < hijo1.size()-2)
                columna.add(new GenEntero((GenEntero) hijo1.get(i+1)));
            else
                columna.add(new GenEntero((GenEntero) hijo1.get(1)));

            int j = hijo2.indexOf(hijo1.get(i));

            if(j > 1){
                if(!columna.contains(hijo2.get(j-1)))
                    columna.add(new GenEntero((GenEntero) hijo2.get(j-1)));
            }
            else{
                if(!columna.contains(hijo2.get(hijo2.size()-2)))
                    columna.add(new GenEntero((GenEntero) hijo2.get(hijo2.size()-2)));
            }
            if(j < hijo2.size()-2){
                if(!columna.contains(hijo2.get(j+1)))
                    columna.add(new GenEntero((GenEntero)hijo2.get(j+1)));
            }
            else{
                if(!columna.contains(hijo2.get(1)))
                    columna.add(new GenEntero((GenEntero)hijo2.get(1)));
            }

            tabla.set((int) hijo1.get(i).getFenotipo(), columna);
        }
    }

    private Gen menosConectado(List<List<Gen>> tabla, int columna, List<Gen> hijo1){
        List<Gen> genes = tabla.get(columna);
        Gen ret = null;
        int conexiones = 6;
        try {
            for (int i = 1; i < genes.size(); i++) {
                if (tabla.get((int) genes.get(i).getFenotipo()).size() < conexiones && !hijo1.contains(genes.get(i))) {
                    conexiones = tabla.get((int) genes.get(i).getFenotipo()).size();
                    ret = new GenEntero((GenEntero)genes.get(i));
                }
                if (tabla.get((int) genes.get(i).getFenotipo()).size() == conexiones && !hijo1.contains(genes.get(i))) {
                    double random = Math.random();
                    if (random < 0.5) {
                        conexiones = tabla.get((int) genes.get(i).getFenotipo()).size();
                        ret = new GenEntero((GenEntero) genes.get(i));
                    }
                }
            }
        }catch(Exception  e){
            System.out.println(e);
        }

        return ret;
    }
}
