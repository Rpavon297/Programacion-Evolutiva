package vista;

import javax.swing.*;
import java.util.List;

public abstract class Vista extends JFrame {
    public abstract void mostrarGrafica(double[] mejorAbs, double[] mejor, double[] media, double[] peor, double solucion, List<Double> sol);

}
