package Practica2.Vista;

import Comun.Algoritmo.AlgoritmoGenetico;
import Practica2.Mapa;

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

public class VistaEstudio extends Vista {

    private static final long serialVersionUID = 1L;
    private List<Double> resultados;
    private List<List<Double>> soluciones;
    private Plot2DPanel panelMathPlot;
    private JButton btnRealizarEstudio;
    //MIN GENER
    private JSpinner spinner;
    //MAX GENER
    private JSpinner spinner_1;
    //MIN INDIVIDUOS
    private JSpinner spinner_2;
    //MAX INDIVIDUOS
    private JSpinner spinner_3;
    private JLabel lblProbabilidadCruce;
    //MIN CRUCE
    private JSpinner spinner_4;
    //MAX CRUCCE
    private JSpinner spinner_5;
    private JLabel lblProbabilidadMutacin;
    //MIN MUTACION
    private JSpinner spinner_6;
    //MAX MUTACION
    private JSpinner spinner_7;
    //MIN ELITISMO
    private JSpinner spinner_8;
    //MAX ELITISMO
    private JSpinner spinner_9;
    private JSeparator separator;
    private JSeparator separator_1;
    private JSeparator separator_2;
    private JLabel lblSeleccion;
    private JLabel lblCruce;
    private JComboBox<String> comboBox_2;
    private JComboBox<String> comboBox_1;
    private JComboBox<String> comboBox;
    private JCheckBox chckbxNewCheckBox;

    public VistaEstudio(Plot2DPanel panelMathPlot) {
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

        lblProbabilidadCruce = new JLabel("Probabilidad Cruce:");
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
        lblProbabilidadMutacin = new JLabel("Probabilidad AlgoritmoMutacion:");
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

        separator = new JSeparator();
        separator.setBounds(16, 88, 325, 12);
        add(separator);

        separator_1 = new JSeparator();
        separator_1.setBounds(16, 276, 325, 12);
        add(separator_1);

        separator_2 = new JSeparator();
        separator_2.setBounds(16, 188, 325, 12);
        add(separator_2);

        lblSeleccion = new JLabel("Seleccion:");
        lblSeleccion.setBounds(12, 108, 165, 16);
        add(lblSeleccion);

        lblCruce = new JLabel("Cruce:");
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
        comboBox_1.addItem("OX");
        comboBox_1.addItem("PMX");
        comboBox_1.addItem("OX Posiciones Prioritarias");
        comboBox_1.addItem("OX Orden Prioritario");
        comboBox_1.addItem("Ciclos");
        comboBox_1.addItem("ERX");
        comboBox_1.addItem("Codificacion ordinal");
        comboBox_1.addItem("Intercambio de segmentos");

        comboBox_2 = new JComboBox<>();
        comboBox_2.addItem("Heuristica");
        comboBox_2.addItem("Insercion");
        comboBox_2.addItem("Intercambio");
        comboBox_2.addItem("Inversion");
        comboBox_2.setBounds(171, 164, 158, 27);
        add(comboBox_2);

        chckbxNewCheckBox = new JCheckBox("Elitismo:");
        chckbxNewCheckBox.setBounds(18, 296, 128, 23);
        add(chckbxNewCheckBox);

        btnRealizarEstudio = new JButton("Realizar Estudio");
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
                    realizarEstudio(10, (int) spinner_2.getValue(), (int) spinner_3.getValue(), (int) spinner.getValue(), (int) spinner_1.getValue(), (String) comboBox.getSelectedItem(),
                            (String) comboBox_1.getSelectedItem(), (String) comboBox_2.getSelectedItem(), ((Integer) spinner_4.getValue()).doubleValue() / 100, ((Integer) spinner_5.getValue()).doubleValue() / 100, ((Integer) spinner_6.getValue()).doubleValue() / 100,
                            ((Integer) spinner_7.getValue()).doubleValue() / 100, chckbxNewCheckBox.isSelected(), ((Integer) spinner_8.getValue()).doubleValue() / 100, ((Integer) spinner_9.getValue()).doubleValue() / 100, 0.5, Mapa.Madrid);
                }

            }
        });
    }

    private void capturaDatos() {

        int ciudadInicio = 25;
        int minTamPob = (int) this.spinner_2.getValue();
        int maxTamPob = (int) this.spinner_3.getValue();
        int minTamGen = (int) this.spinner.getValue();
        int maxTamGen = (int) this.spinner_1.getValue();

        String seleccion = (String) this.comboBox.getSelectedItem();
        String cruce = (String) this.comboBox_1.getSelectedItem();
        String mutacion = (String) this.comboBox_2.getSelectedItem();

        double minProbCruce = (int) this.spinner_4.getValue();
        minProbCruce = minProbCruce / 100;
        double maxProbCruce = (int) this.spinner_5.getValue();
        maxProbCruce = maxProbCruce / 100;
        double minProbMuta = (int) this.spinner_6.getValue();
        minProbMuta = minProbMuta / 100;
        double maxProbMuta = (int) this.spinner_7.getValue();
        maxProbMuta = maxProbMuta / 100;
        boolean elitismo = this.chckbxNewCheckBox.isSelected();
        double minElit = (int) this.spinner_8.getValue();
        minElit = minElit / 100;
        double maxElit = (int) this.spinner_9.getValue();
        maxElit = maxElit / 100;

        double parametroTruncProb = 0;

        if (seleccion == "TorneoProb" || seleccion == "Truncamiento") {
            /*parametroTruncProb = (int) this.spinnerTruncProb.getValue();
            parametroTruncProb = parametroTruncProb / 100;*/
            parametroTruncProb = 0.5;
        }

        realizarEstudio(10,
                minTamPob, maxTamPob,
                minTamGen, maxTamGen,
                seleccion, cruce, mutacion,
                minProbCruce, maxProbCruce,
                minProbMuta, maxProbMuta,
                elitismo,
                minElit, maxElit,
                parametroTruncProb, ciudadInicio);
    }

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


        for (int i = 0; i < num_ejecuciones; i++) {
            int poblacionSize = pobSizeMin + (difPobSize * i);
            int numGeneraciones = numGenMin + (difNumGen * i);
            double probabilidadCruce = probCruceMin + (difProbCruce * i);
            double probabilidadMutacion = probMutaMin + (difProbMuta * i);
            double percentElitismo = porcenElitMin + (difPorcenElit * i);

            AlgoritmoGenetico ag = new AlgoritmoGenetico(this);
            ag.ejecutarAlgoritmo(5, 0, poblacionSize, numGeneraciones, seleccion, cruce, mutacion, probabilidadCruce,
                    probabilidadMutacion, 0, elitismo, percentElitismo, parametroTruncProb, 0, ciudadInicio);
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

        panelMathPlot.addLegend("SOUTH");
        panelMathPlot.addLinePlot("Resultados", Color.MAGENTA, x, y);
    }

    @Override
    public void mostrarGrafica(double[] mejorAbs, double[] mejor, double[] media, double[] peor, double solucion, List<Double> sol) {

        this.soluciones.add(sol);
        this.resultados.add(solucion);

    }
}
