package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.math.plot.Plot2DPanel;
import poblacion.Mapa;
//import algoritmos.AlgoritmoGenetico;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Panel;

public class VistaViajante extends Vista {

    private static final long serialVersionUID = 1L;
    private JSpinner spinnerPoblacion;
    private JSpinner spinnerGeners;
    private JComboBox<String> comboSeleccion;
    private JComboBox<String> comboCruce;
    private JSpinner spinnerCruces;
    private JSpinner spinnerMutaciones;
    private Plot2DPanel panelMathPlot;
    private JComboBox<String> comboCiudad;
    private JSpinner spinnerElitismo;
    private JCheckBox chckbxElitismo;

    /**
     * Create the frame.
     */
    public VistaViajante() {
        setTitle("Practica 2");
        setResizable(false);
        setBounds(100, 100, 1064, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelParams = new JPanel();
        panelParams.setBounds(0, 0, 302, 586);
        contentPane.add(panelParams);
        panelParams.setLayout(null);

        JLabel Titulo = new JLabel("Parametros");
        Titulo.setFont(new Font("Dialog", Font.PLAIN, 24));
        Titulo.setHorizontalAlignment(SwingConstants.CENTER);
        Titulo.setBounds(0, 11, 275, 41);
        panelParams.add(Titulo);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 64, 286, 14);
        panelParams.add(separator);

        JLabel labelPoblacion = new JLabel("Tamanio de la Poblacion:");
        labelPoblacion.setFont(new Font("Dialog", Font.PLAIN, 14));
        labelPoblacion.setBounds(10, 127, 207, 19);
        panelParams.add(labelPoblacion);

        spinnerPoblacion = new JSpinner();
        spinnerPoblacion.setFocusable(false);
        SpinnerModel modelPoblacion = new SpinnerNumberModel(100, 1, 200, 1);
        spinnerPoblacion.setModel(modelPoblacion);
        ((DefaultEditor) spinnerPoblacion.getEditor()).getTextField().setEditable(false);
        ((DefaultEditor) spinnerPoblacion.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
        spinnerPoblacion.setBounds(209, 124, 87, 27);
        panelParams.add(spinnerPoblacion);

        JLabel labelGeners = new JLabel("Numero de Generaciones:");
        labelGeners.setFont(new Font("Dialog", Font.PLAIN, 14));
        labelGeners.setBounds(10, 165, 184, 19);
        panelParams.add(labelGeners);

        spinnerGeners = new JSpinner();
        SpinnerModel modelGeners = new SpinnerNumberModel(100, 1, 200, 1);
        spinnerGeners.setModel(modelGeners);
        ((DefaultEditor) spinnerGeners.getEditor()).getTextField().setEditable(false);
        ((DefaultEditor) spinnerGeners.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
        spinnerGeners.setBounds(209, 162, 87, 27);
        panelParams.add(spinnerGeners);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(10, 196, 286, 14);
        panelParams.add(separator_1);

        JLabel labelSeleccion = new JLabel("Seleccion:");
        labelSeleccion.setFont(new Font("Dialog", Font.PLAIN, 14));
        labelSeleccion.setBounds(10, 217, 77, 19);
        panelParams.add(labelSeleccion);

        comboSeleccion = new JComboBox<>();
        comboSeleccion.addItem("Estocastica Univ.");
        comboSeleccion.addItem("Ruleta");
        comboSeleccion.addItem("Torneo");
        comboSeleccion.addItem("Torneo Prob.");
        comboSeleccion.addItem("Truncamiento");
        comboSeleccion.setBounds(128, 215, 168, 27);
        panelParams.add(comboSeleccion);

        JLabel labelCruce = new JLabel("Cruce:");
        labelCruce.setFont(new Font("Dialog", Font.PLAIN, 14));
        labelCruce.setBounds(10, 251, 61, 19);
        panelParams.add(labelCruce);

        comboCruce = new JComboBox<>();
        comboCruce.addItem("Aritmetico");
        comboCruce.addItem("BLX");
        comboCruce.addItem("Monopunto");
        comboCruce.addItem("Multipunto");
        comboCruce.addItem("Uniforme");
        comboCruce.setBounds(128, 249, 168, 27);
        panelParams.add(comboCruce);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(10, 282, 286, 14);
        panelParams.add(separator_2);

        JLabel labelCruces = new JLabel("Probabilidad Cruces:");
        labelCruces.setFont(new Font("Dialog", Font.PLAIN, 14));
        labelCruces.setBounds(10, 303, 158, 19);
        panelParams.add(labelCruces);

        spinnerCruces = new JSpinner();
        spinnerCruces.setBounds(212, 299, 58, 27);
        SpinnerModel crucesModel = new SpinnerNumberModel(60, 0, 100, 1);
        spinnerCruces.setModel(crucesModel);
        ((DefaultEditor) spinnerCruces.getEditor()).getTextField().setEditable(false);
        ((DefaultEditor) spinnerCruces.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
        panelParams.add(spinnerCruces);

        JLabel percent1 = new JLabel("%");
        percent1.setFont(new Font("Dialog", Font.PLAIN, 16));
        percent1.setBounds(276, 303, 16, 19);
        panelParams.add(percent1);

        JLabel labelMutaciones = new JLabel("Probabilidad Mutaciones:");
        labelMutaciones.setFont(new Font("Dialog", Font.PLAIN, 14));
        labelMutaciones.setBounds(10, 339, 184, 19);
        panelParams.add(labelMutaciones);

        spinnerMutaciones = new JSpinner();
        spinnerMutaciones.setBounds(212, 336, 58, 27);
        SpinnerModel mutacionesModel = new SpinnerNumberModel(5, 0, 100, 1);
        spinnerMutaciones.setModel(mutacionesModel);
        ((DefaultEditor) spinnerMutaciones.getEditor()).getTextField().setEditable(false);
        ((DefaultEditor) spinnerMutaciones.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
        panelParams.add(spinnerMutaciones);

        JLabel percent2 = new JLabel("%");
        percent2.setFont(new Font("Dialog", Font.PLAIN, 16));
        percent2.setBounds(275, 339, 16, 19);
        panelParams.add(percent2);

        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(10, 370, 286, 14);
        panelParams.add(separator_3);

        chckbxElitismo = new JCheckBox("Elitismo:");
        chckbxElitismo.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxElitismo.setFont(new Font("Dialog", Font.PLAIN, 14));
        chckbxElitismo.setBounds(10, 385, 184, 23);
        panelParams.add(chckbxElitismo);

        spinnerElitismo = new JSpinner();
        spinnerElitismo.setBounds(209, 383, 58, 27);
        SpinnerModel elitismoModel = new SpinnerNumberModel(2, 0, 5, 1);
        spinnerElitismo.setModel(elitismoModel);
        panelParams.add(spinnerElitismo);

        JLabel percent3 = new JLabel("%");
        percent3.setFont(new Font("Dialog", Font.PLAIN, 16));
        percent3.setBounds(273, 387, 16, 19);
        panelParams.add(percent3);

        JSeparator separator_4 = new JSeparator();
        separator_4.setBounds(10, 412, 286, 14);
        panelParams.add(separator_4);

        JLabel lblCiudad = new JLabel("Ciudad Origen:");
        lblCiudad.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblCiudad.setBounds(10, 79, 115, 19);
        panelParams.add(lblCiudad);

        comboCiudad = new JComboBox<String>(Mapa.Ciudades);
        comboCiudad.setSelectedItem("Madrid");
        comboCiudad.setBounds(128, 77, 168, 27);
        panelParams.add(comboCiudad);

        JSeparator separator_5 = new JSeparator();
        separator_5.setBounds(10, 110, 286, 14);
        panelParams.add(separator_5);

        panelMathPlot = new Plot2DPanel();
        panelMathPlot.setBounds(300, 0, 764, 527);
        contentPane.add(panelMathPlot);

        JPanel panelNombres = new JPanel();
        panelNombres.setBounds(300, 651, 764, 27);
        contentPane.add(panelNombres);
        panelNombres.setLayout(null);

        JLabel labelNombres = new JLabel("Grupo 2 - Programacion Evolutiva - Jesus Granizo y Roberto Pavon");
        labelNombres.setHorizontalAlignment(SwingConstants.CENTER);
        labelNombres.setBounds(0, 0, 752, 27);
        panelNombres.add(labelNombres);

        JPanel panelSolucion = new JPanel();
        panelSolucion.setBounds(300, 527, 764, 125);
        contentPane.add(panelSolucion);
        panelSolucion.setLayout(null);

        Panel panelBotones = new Panel();
        panelBotones.setBounds(0, 587, 302, 91);
        contentPane.add(panelBotones);
        panelBotones.setLayout(null);

        JButton buttonEjecutar = new JButton("Comenzar");
        buttonEjecutar.setBounds(57, 6, 171, 45);
        panelBotones.add(buttonEjecutar);
        buttonEjecutar.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
        buttonEjecutar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                capturaDatos();
            }
        });

        JButton btnDefecto = new JButton("Valores por defecto");
        btnDefecto.setFont(new Font("Dialog", Font.PLAIN, 14));
        btnDefecto.setBounds(42, 56, 203, 29);
        panelBotones.add(btnDefecto);
        btnDefecto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                valoresPorDefecto();

            }
        });

        comboSeleccion.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(comboSeleccion.getSelectedIndex() == 3) {
//                    labelTruncProb.setText("Parametro Torneo: ");
//                    labelTruncProb.setVisible(true);
//                    SpinnerModel probModel = new SpinnerNumberModel(50, 50, 100, 1);
//                    spinnerTruncProb.setModel(probModel);
//                    ((DefaultEditor) spinnerTruncProb.getEditor()).getTextField().setEditable(false);
//                    ((DefaultEditor) spinnerTruncProb.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
//                    spinnerTruncProb.setVisible(true);
//                    percent4.setVisible(true);
                }
                else if(comboSeleccion.getSelectedIndex() == 4) {
//                    labelTruncProb.setText("Umbral Truncamiento: ");
//                    labelTruncProb.setVisible(true);
                    SpinnerModel truncModel = new SpinnerNumberModel(50, 10, 50, 10);
//                    spinnerTruncProb.setModel(truncModel);
//                    ((DefaultEditor) spinnerTruncProb.getEditor()).getTextField().setEditable(false);
//                    ((DefaultEditor) spinnerTruncProb.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
//                    spinnerTruncProb.setVisible(true);
//                    percent4.setVisible(true);
                }
                else{
//                    labelTruncProb.setText("");
//                    labelTruncProb.setVisible(false);
//                    spinnerTruncProb.setVisible(false);
//                    percent4.setVisible(false);
                }

            }
        });

        comboCruce.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(comboCruce.getSelectedIndex() == 3) {
//                    labelParamCruce.setText("Numero de Cruces: ");
//                    labelParamCruce.setVisible(true);
                    SpinnerModel probModel = new SpinnerNumberModel(3, 1, 5, 1);
//                    spinnerParamCruce.setModel(probModel);
//                    ((DefaultEditor) spinnerParamCruce.getEditor()).getTextField().setEditable(false);
//                    ((DefaultEditor) spinnerParamCruce.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
//                    spinnerParamCruce.setVisible(true);
                }
                else{
//                    labelParamCruce.setVisible(false);
//                    spinnerParamCruce.setVisible(false);
                }

            }
        });
    }

    protected void valoresPorDefecto() {
        comboCiudad.setSelectedItem("Madrid");
        spinnerPoblacion.setValue(100);
        spinnerGeners.setValue(100);
        comboSeleccion.setSelectedIndex(0);
        comboCruce.setSelectedIndex(0);
        spinnerCruces.setValue(60);
        spinnerMutaciones.setValue(5);
        chckbxElitismo.setSelected(false);
        spinnerElitismo.setValue(2);
    }

    private void capturaDatos() {

//        int funcion = this.combofuncion.getSelectedIndex() + 1;
//        int paramsFuncion = (int) this.spinnerFunc.getValue();
        int poblacionSize = (int) this.spinnerPoblacion.getValue();
        int numGeneraciones = (int) this.spinnerGeners.getValue();

        int numSeleccion = this.comboSeleccion.getSelectedIndex();
        String seleccion;
        switch (numSeleccion) {
            case 0:
                seleccion = "Estocastico";
                break;
            case 1:
                seleccion = "Ruleta";
                break;
            case 2:
                seleccion = "Torneo";
                break;
            case 3:
                seleccion = "TorneoProb";
                break;
            default:
                seleccion = "Truncamiento";
                break;
        }

        int numCruce = this.comboCruce.getSelectedIndex();
        String cruce;
        switch (numCruce) {
            case 0:
                cruce = "Aritmetico";
                break;
            case 1:
                cruce = "BLX";
                break;
            case 2:
                cruce = "Monopunto";
                break;
            case 3:
                cruce = "Multipunto";
                break;
            default:
                cruce = "Uniforme";
                break;
        }

        double probabilidadCruce =  (int) this.spinnerCruces.getValue();
        probabilidadCruce = probabilidadCruce / 100;
        double probabilidadMutacion =  (int) this.spinnerMutaciones.getValue();
        probabilidadMutacion = probabilidadMutacion / 100;
//        double precision = 1 / (Math.pow(10, (int) this.spinnerPrecision.getValue()));
//        boolean elitismo = this.chckbxElitismo.isSelected();
//        double percentElitismo = (int) this.spinnerElitismo.getValue();
//        percentElitismo = percentElitismo / 100;

        double parametroTruncProb = 0;
        int parametroCruce = 0;

        if(seleccion == "TorneoProb" || seleccion == "Truncamiento") {
//            parametroTruncProb = (int) this.spinnerTruncProb.getValue();
            parametroTruncProb = parametroTruncProb / 100;
        }

//        if(cruce == "Multipunto")
//            parametroCruce = (int) this.spinnerParamCruce.getValue();

//        String mutacion ="MutacionBasica";
//        AlgoritmoGenetico ag = new AlgoritmoGenetico(this);
//        ag.ejecutarAlgoritmo(funcion, paramsFuncion, poblacionSize, numGeneraciones, seleccion, cruce, mutacion, probabilidadCruce,
//                probabilidadMutacion, precision, elitismo, percentElitismo, parametroTruncProb, parametroCruce);
    }

    public void mostrarGrafica(double[] mejorAbs, double[] mejor, double[] media, double[] peor, double solucion, List<Double> sol) {

        panelMathPlot.removeAllPlots();
        double [] x = new double[mejorAbs.length];
        for(int i = 0; i < x.length; i++)
            x[i] = i+1;

//        textField.setText(String.valueOf(solucion));
//        textField_1.removeAllItems();

        int i = 0;

        for(Double d : sol) {
            i++;
            d = Math.floor(d / 0.0001) * 0.0001;

            String text = "X" + String.valueOf(i) + ": " + String.valueOf(d);
//            textField_1.addItem(text);

        };

        panelMathPlot.addLegend("SOUTH");
        panelMathPlot.addLinePlot("Mejor Absoluto", Color.MAGENTA, x, mejorAbs);
        panelMathPlot.addLinePlot("Mejor de la Generacion", Color.GREEN, x, mejor);
        panelMathPlot.addLinePlot("Media Generacion", Color.ORANGE, x, media);
        panelMathPlot.addLinePlot("Peor de la Generacion", Color.RED, x, peor);

    }
}
