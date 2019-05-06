package Practica3.Vista;

import Comun.Algoritmo.AlgoritmoGenetico;
import Practica2.Mapa;

import Practica3.Gramatica;
import Practica3.Hormiga;
import Practica3.SingletonMapa;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.math.plot.Plot2DPanel;
import Comun.Vista.Vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

@SuppressWarnings("ALL")
public class VistaEstudioHormiga extends Vista {

    private static final long serialVersionUID = 1L;
    private final List<Double> resultados;
    private final List<List<Double>> soluciones;
    private final Plot2DPanel panelMathPlot;
    private List<Integer> comidas;
    private int full;
    //MIN GENER
    private final JSpinner spinner;
    //MAX GENER
    private final JSpinner spinner_1;
    //MIN INDIVIDUOS
    private final JSpinner spinner_2;
    //MAX INDIVIDUOS
    private final JSpinner spinner_3;
    //MIN CRUCE
    private final JSpinner spinner_4;
    //MAX CRUCCE
    private final JSpinner spinner_5;
    //MIN MUTACION
    private final JSpinner spinner_6;
    //MAX MUTACION
    private final JSpinner spinner_7;
    //MIN ELITISMO
    private final JSpinner spinner_8;
    //MAX ELITISMO
    private final JSpinner spinner_9;
    private final JComboBox<String> comboBox_2;
    private final JComboBox<String> comboBox_1;
    private final JComboBox<String> comboBox;
    private final JCheckBox chckbxNewCheckBox;

    public VistaEstudioHormiga(Plot2DPanel panelMathPlot) {
        this.full = 0;
        this.resultados = new ArrayList<>();
        this.soluciones = new ArrayList<>();
        this.panelMathPlot = panelMathPlot;
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setBounds(0, 0, 347, 434);
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Intervalo Generaciones:");
        lblNewLabel.setBounds(6, 21, 165, 16);
        add(lblNewLabel);

        SpinnerModel model = new SpinnerNumberModel(100, 10, 2000, 1);

        spinner = new JSpinner();
        spinner.setBounds(171, 16, 73, 26);
        add(spinner);
        spinner.setModel(model);

        spinner_1 = new JSpinner();
        spinner_1.setBounds(256, 16, 73, 26);
        add(spinner_1);
        spinner_1.setModel(new SpinnerNumberModel(100, 10, 2000, 1));

        JLabel lblIntervaloIndividuos = new JLabel("Intervalo Individuos:");
        lblIntervaloIndividuos.setBounds(6, 60, 165, 16);
        add(lblIntervaloIndividuos);

        spinner_2 = new JSpinner();
        spinner_2.setBounds(171, 55, 73, 26);
        add(spinner_2);

        spinner_3 = new JSpinner();
        spinner_3.setBounds(256, 55, 73, 26);
        add(spinner_3);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 334, 347, 63);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);

        spinner_2.setModel(new SpinnerNumberModel(100, 10, 2000, 1));
        spinner_3.setModel(new SpinnerNumberModel(100, 10, 2000, 1));

        SpinnerModel model1 = new SpinnerNumberModel(60, 0, 100, 1);

        JLabel lblProbabilidadCruce = new JLabel("Probabilidad Cruce:");
        lblProbabilidadCruce.setBounds(18, 213, 165, 16);
        add(lblProbabilidadCruce);

        spinner_4 = new JSpinner();
        spinner_4.setBounds(183, 208, 73, 26);
        add(spinner_4);
        spinner_4.setModel(new SpinnerNumberModel(60, 0, 100, 1));

        spinner_5 = new JSpinner();
        spinner_5.setBounds(268, 208, 73, 26);
        add(spinner_5);
        spinner_5.setModel(new SpinnerNumberModel(60, 0, 100, 1));

        SpinnerModel model2 = new SpinnerNumberModel(5, 0, 100, 1);
        JLabel lblProbabilidadMutacin = new JLabel("Probabilidad AlgoritmoMutacion:");
        lblProbabilidadMutacin.setBounds(18, 248, 165, 16);
        add(lblProbabilidadMutacin);

        spinner_6 = new JSpinner();
        spinner_6.setBounds(183, 243, 73, 26);
        add(spinner_6);
        spinner_6.setModel(new SpinnerNumberModel(60, 0, 100, 1));

        spinner_7 = new JSpinner();
        spinner_7.setBounds(268, 243, 73, 26);
        add(spinner_7);
        spinner_7.setModel(new SpinnerNumberModel(60, 0, 100, 1));

        SpinnerModel model3 = new SpinnerNumberModel(2, 0, 10, 1);

        spinner_8 = new JSpinner();
        spinner_8.setBounds(183, 295, 73, 26);
        add(spinner_8);
        spinner_8.setModel(new SpinnerNumberModel(2, 0, 10, 1));

        spinner_9 = new JSpinner();
        spinner_9.setBounds(268, 295, 73, 26);
        add(spinner_9);
        spinner_9.setModel(new SpinnerNumberModel(2, 0, 10, 1));

        JSeparator separator = new JSeparator();
        separator.setBounds(16, 88, 325, 12);
        add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(16, 276, 325, 12);
        add(separator_1);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(16, 188, 325, 12);
        add(separator_2);

        JLabel lblSeleccion = new JLabel("Seleccion:");
        lblSeleccion.setBounds(12, 108, 165, 16);
        add(lblSeleccion);

        JLabel lblCruce = new JLabel("Cruce:");
        lblCruce.setBounds(12, 136, 165, 16);
        add(lblCruce);

        JLabel lblMutacion = new JLabel("AlgoritmoMutacion:");
        lblMutacion.setBounds(12, 164, 165, 16);
        add(lblMutacion);

        comboBox = new JComboBox<>();
        comboBox.addItem("Estocastica");
        comboBox.addItem("Ruleta");
        comboBox.addItem("Torneo");
        comboBox.addItem("Torneo Probabilistico");
        comboBox.addItem("Truncamiento");
        comboBox.setBounds(171, 104, 158, 27);
        add(comboBox);

        comboBox_1 = new JComboBox<>();
        comboBox_1.setBounds(171, 132, 158, 27);
        add(comboBox_1);
        comboBox_1.addItem("Aritmetico");
        comboBox_1.addItem("BLX");
        comboBox_1.addItem("Monopunto");
        comboBox_1.addItem("Multipunto");
        comboBox_1.addItem("Uniforme");

        comboBox_2 = new JComboBox<>();
        comboBox_2.addItem("Basica");
        comboBox_2.setBounds(171, 164, 158, 27);
        add(comboBox_2);

        chckbxNewCheckBox = new JCheckBox("Elitismo:");
        chckbxNewCheckBox.setBounds(18, 296, 128, 23);
        add(chckbxNewCheckBox);

        JButton btnRealizarEstudio = new JButton("Realizar Estudio");
        btnRealizarEstudio.setBounds(96, 17, 153, 29);
        panel_1.add(btnRealizarEstudio);

        btnRealizarEstudio.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if ((Integer) spinner_1.getValue() < (Integer) spinner.getValue() || (Integer) spinner_3.getValue() < (Integer) spinner_2.getValue() ||
                        (Integer) spinner_5.getValue() < (Integer) spinner_4.getValue() || (Integer) spinner_7.getValue() < (Integer) spinner_6.getValue() ||
                        (Integer) spinner_9.getValue() < (Integer) spinner_8.getValue()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Intervalo de datos no valido",
                            "Error de los datos",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    setVisible(false);
                    realizarEstudio((int) spinner_2.getValue(), (int) spinner_3.getValue(), (int) spinner.getValue(), (int) spinner_1.getValue(), (String) comboBox.getSelectedItem(),
                            (String) comboBox_1.getSelectedItem(), (String) comboBox_2.getSelectedItem(), ((Integer) spinner_4.getValue()).doubleValue() / 100, ((Integer) spinner_5.getValue()).doubleValue() / 100, ((Integer) spinner_6.getValue()).doubleValue() / 100,
                            ((Integer) spinner_7.getValue()).doubleValue() / 100, chckbxNewCheckBox.isSelected(), ((Integer) spinner_8.getValue()).doubleValue() / 100, ((Integer) spinner_9.getValue()).doubleValue() / 100);
                }

            }
        });
    }

    private void realizarEstudio(int pobSizeMin, int pobSizeMax,
                                 int numGenMin, int numGenMax,
                                 String seleccion, String cruce, String mutacion,
                                 double probCruceMin, double probCruceMax,
                                 double probMutaMin, double probMutaMax,
                                 boolean elitismo,
                                 double porcenElitMin, double porcenElitMax) {

        int difPobSize = (int) ((pobSizeMax - pobSizeMin) / 10);
        int difNumGen = (int) ((numGenMax - numGenMin) / 10);
        double difProbCruce = (probCruceMax - probCruceMin) / 10;
        double difProbMuta = (probMutaMax - probMutaMin) / 10;
        double difPorcenElit = (porcenElitMax - porcenElitMin) / 10;


        for (int i = 0; i < 10; i++) {
            int poblacionSize = pobSizeMin + (difPobSize * i);
            int numGeneraciones = numGenMin + (difNumGen * i);
            double probabilidadCruce = probCruceMin + (difProbCruce * i);
            double probabilidadMutacion = probMutaMin + (difProbMuta * i);
            double percentElitismo = porcenElitMin + (difPorcenElit * i);

            AlgoritmoGenetico ag = new AlgoritmoGenetico(this);
            ag.ejecutarAlgoritmo(6, 0, poblacionSize, numGeneraciones, seleccion, cruce, mutacion, probabilidadCruce,
                    probabilidadMutacion, 0, elitismo, percentElitismo, 0.5, 0, 0);
        }

        mostrarEstudio();
    }

    private void mostrarEstudio() {
        panelMathPlot.removeAllPlots();

        double[] x = new double[resultados.size()];
        for (int i = 0; i < x.length; i++)
            x[i] = i + 1;

        double[] y = new double[resultados.size()];
        for (int i = 0; i < y.length; i++)
            y[i] = resultados.get(i);

/*        double[] z = new double[this.comidas.size()];
        for(int i = 0; i < z.length; i++)
            z[i] = this.comidas.get(i);
*/
        double percent = (this.full/this.resultados.size()) * 100;
        panelMathPlot.addLegend("SOUTH");
        panelMathPlot.addLinePlot("Solucion", Color.MAGENTA, x, y);
        //panelMathPlot.addLinePlot("Comidas, "+ this.full + " (" + percent + ") perfectas", Color.GREEN, x, z);
    }

    @Override
    public void mostrarGrafica(double[] mejorAbs, double[] mejor, double[] media, double[] peor, double solucion, List<Double> sol) {


        Gramatica gramatica = new Gramatica(2);
        Hormiga hormiga = new Hormiga();
        for(int i = 0; i < 400; i++) {
            gramatica.S(sol, hormiga);
        }

        //this.comidas.add(SingletonMapa.getInstance().getComidas());
        this.soluciones.add(sol);
        this.resultados.add(solucion);

        SingletonMapa.getInstance().reset();
    }
}
