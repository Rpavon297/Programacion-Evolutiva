package vista;

import algoritmos.AlgoritmoGenetico;

import java.util.List;

public class VistaDebugging extends Vista{

    public void test(){
        AlgoritmoGenetico algoritmo = new AlgoritmoGenetico(this);

        int funcion = 5;
        int paramsFuncion = 2;
        int poblacionSize = 100;
        int numGeneraciones = 100;
        String seleccion = "Estocastico";
        String cruce = "PMX";
        double probabilidadCruce = 0.6;
        double probabilidadMutacion = 0.05;
        double precision = 0.01;
        boolean elitismo = false;
        double percentElitismo = 0.1;
        double parametroTruncProb = 0.1;
        int parametroCruce = 0;
        algoritmo.ejecutarAlgoritmo(funcion,paramsFuncion,poblacionSize,numGeneraciones,seleccion,cruce,probabilidadCruce,probabilidadMutacion,precision,elitismo,percentElitismo,parametroTruncProb,parametroCruce);
    }

    @Override
    public void mostrarGrafica(double[] mejorAbs, double[] mejor, double[] media, double[] peor, double solucion, List<Double> sol) {
        System.out.println(solucion);
        System.out.println(sol);
    }
}
