package vista;

import algoritmos.AlgoritmoGenetico;
import org.math.plot.Plot2DPanel;

import java.awt.*;
import java.util.List;

public class VistaEstudio extends Vista {

    private List<Double> resultados;
    private List<List<Double>> soluciones;
    private Plot2DPanel panelMathPlot;

    public void realizarEstudio(int num_ejecuciones,
                                int pobSizeMin, int pobSizeMax,
                                int numGenMin, int numGenMax,
                                String seleccion, String cruce, String mutacion,
                                double probCruceMin, double probCruceMax,
                                double probMutaMin, double probMutaMax,
                                boolean elitismo,
                                double porcenElitMin, double porcenElitMax,
                                double parametroTruncProb, int ciudadInicio) {

        int difPobSize = (int) ((pobSizeMax - pobSizeMin) / num_ejecuciones);
        int difNumGen = (int) ((numGenMax - numGenMin) / num_ejecuciones);
        double difProbCruce = (probCruceMax - probCruceMin) / num_ejecuciones;
        double difProbMuta = (probMutaMax - probMutaMin) / num_ejecuciones;
        double difPorcenElit = (porcenElitMax - porcenElitMin) / num_ejecuciones;


        for (int i = 1; i <= num_ejecuciones; i++) {
            int poblacionSize = difPobSize * i;
            int numGeneraciones = difNumGen * i;
            double probabilidadCruce = difProbCruce * i;
            double probabilidadMutacion = difProbMuta * i;
            double percentElitismo = difPorcenElit * i;

            AlgoritmoGenetico ag = new AlgoritmoGenetico(this);
            ag.ejecutarAlgoritmo(5, 0, poblacionSize, numGeneraciones, seleccion, cruce, mutacion, probabilidadCruce,
                    probabilidadMutacion, 0, elitismo, percentElitismo, parametroTruncProb, 0, ciudadInicio);
        }

        mostrarEstudio();
    }

    private void mostrarEstudio() {
        double [] x = new double[resultados.size()];
        for(int i = 0; i < x.length; i++)
            x[i] = i+1;

        double[] y = new double[resultados.size()];
        for(int i = 0;i < y.length; i++)
            y[i] = resultados.get(i);

        panelMathPlot.addLegend("SOUTH");
        panelMathPlot.addLinePlot("Resultados", Color.MAGENTA, x, y);
    }

    @Override
    public void mostrarGrafica(double[] mejorAbs, double[] mejor, double[] media, double[] peor, double solucion, List<Double> sol) {
        this.soluciones.add(sol);
        this.resultados.add(solucion);

    }
}
