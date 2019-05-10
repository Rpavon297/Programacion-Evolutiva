package Comun.Algoritmo;

import Comun.Funcion.Funcion;
import Comun.Poblacion.Poblacion;
import Comun.Vista.Vista;

import java.util.ArrayList;
import java.util.List;

public class AlgoritmoParalelos extends AlgoritmoGenetico {
    public AlgoritmoParalelos(Vista vista) {
        super(vista);
    }

    public Poblacion paralelizarAlgoritmo(int nepoch, int nhebras, int funcion, int paramsFuncion, int poblacionSize, int numGeneraciones,
                                       String seleccion, String cruce, String mutacion, double probabilidadCruce, double probabilidadMutacion, double precision,
                                       boolean elitismo, double percentElitismo, double parametroTruncProb, int parametroCruce, int ciudadInicio) {
        Poblacion[] islas = new Poblacion[nhebras];
        int ejecuciones = numGeneraciones/nepoch;

        //Creamos la funcion correspondiente
        Funcion f = crearFuncion(funcion);

        //Inicializamos los parametros que necesitar� la funcion de mutacion
        List<Double> paramsCruce = new ArrayList<>();
        paramsCruce.add(probabilidadCruce);
        paramsCruce.add((double) parametroCruce);

        //Inicializamos los parametros que necesitar� la funcion de mutacion
        List<Double> paramsMutacion = new ArrayList<>();
        paramsMutacion.add(probabilidadMutacion);
        paramsMutacion.addAll(f.getIntervalo());

        //Inicializamos las poblaciones
        for(Poblacion pob : islas){
            pob = new Poblacion();
            inicalizarPoblacion(pob,poblacionSize,precision,funcion,paramsFuncion, ciudadInicio);
        }

        //Generar x hebras
        //Lanzar x algoritmos por nepoch generaciones, un numero numGeneraciones/nepoch veces
        for(int i = 0; i < ejecuciones; i++){

        }


        return null;
    }
}
