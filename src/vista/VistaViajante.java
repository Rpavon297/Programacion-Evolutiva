package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.math.plot.Plot2DPanel;
import poblacion.Mapa;
import algoritmos.AlgoritmoGenetico;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JSpinner.DefaultEditor;

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
    private JComboBox<String> comboMutacion;
    private JLabel labelKilometros;
    private JLabel textFieldCiudades;
    private JLabel labelTruncProb;
    private JSpinner spinnerTruncProb;
    private JButton btnEstudio;
    private JPanel params;

    /**
     * Create the frame.
     */
    public VistaViajante() {
        setTitle("Practica 2");
        setResizable(false);
        setBounds(100, 100, 1064, 710);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelParams = new JPanel();
        panelParams.setBounds(0, 0, 302, 527);
        contentPane.add(panelParams);
        this.params = panelParams;
        panelParams.setLayout(null);

        JLabel Titulo = new JLabel("Parametros");
        Titulo.setFont(new Font("Dialog", Font.PLAIN, 24));
        Titulo.setHorizontalAlignment(SwingConstants.CENTER);
        Titulo.setBounds(0, 11, 275, 41);
        panelParams.add(Titulo);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 64, 286, 14);
        panelParams.add(separator);

        JLabel lblCiudad = new JLabel("Ciudad Origen:");
        lblCiudad.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblCiudad.setBounds(10, 76, 115, 19);
        panelParams.add(lblCiudad);

        comboCiudad = new JComboBox<>(Mapa.Ciudades);
        comboCiudad.setSelectedItem("Madrid");
        comboCiudad.setBounds(128, 72, 168, 27);
        panelParams.add(comboCiudad);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(10, 107, 286, 14);
        panelParams.add(separator_1);

        JLabel labelPoblacion = new JLabel("Tamanio de la Poblacion:");
        labelPoblacion.setFont(new Font("Dialog", Font.PLAIN, 14));
        labelPoblacion.setBounds(10, 119, 207, 19);
        panelParams.add(labelPoblacion);

        spinnerPoblacion = new JSpinner();
        spinnerPoblacion.setFocusable(false);
        SpinnerModel modelPoblacion = new SpinnerNumberModel(100, 1, 2000, 1);
        spinnerPoblacion.setModel(modelPoblacion);
        ((DefaultEditor) spinnerPoblacion.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
        spinnerPoblacion.setBounds(209, 115, 87, 27);
        panelParams.add(spinnerPoblacion);

        JLabel labelGeners = new JLabel("Numero de Generaciones:");
        labelGeners.setFont(new Font("Dialog", Font.PLAIN, 14));
        labelGeners.setBounds(10, 152, 184, 19);
        panelParams.add(labelGeners);

        spinnerGeners = new JSpinner();
        SpinnerModel modelGeners = new SpinnerNumberModel(100, 1, 2000, 1);
        spinnerGeners.setModel(modelGeners);
        ((DefaultEditor) spinnerGeners.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
        spinnerGeners.setBounds(209, 148, 87, 27);
        panelParams.add(spinnerGeners);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(10, 182, 286, 14);
        panelParams.add(separator_2);

        JLabel labelSeleccion = new JLabel("Seleccion:");
        labelSeleccion.setFont(new Font("Dialog", Font.PLAIN, 14));
        labelSeleccion.setBounds(10, 193, 77, 19);
        panelParams.add(labelSeleccion);

        comboSeleccion = new JComboBox<>();
        comboSeleccion.addItem("Estocastica");
        comboSeleccion.addItem("Ruleta");
        comboSeleccion.addItem("Torneo");
        comboSeleccion.addItem("Torneo Probabilistico");
        comboSeleccion.addItem("Truncamiento");
        comboSeleccion.setBounds(128, 190, 168, 27);
        panelParams.add(comboSeleccion);

        JLabel labelCruce = new JLabel("Cruce:");
        labelCruce.setFont(new Font("Dialog", Font.PLAIN, 14));
        labelCruce.setBounds(10, 227, 115, 19);
        panelParams.add(labelCruce);

        comboCruce = new JComboBox<>();
        comboCruce.addItem("OX");
        comboCruce.addItem("PMX");
        comboCruce.addItem("OX Posiciones Prioritarias");
        comboCruce.addItem("OX Orden Prioritario");
        comboCruce.addItem("Ciclos");
        comboCruce.addItem("ERX");
        comboCruce.addItem("Codificacion ordinal");
        comboCruce.addItem("Intercambio de segmentos");
        comboCruce.setBounds(128, 223, 168, 27);
        panelParams.add(comboCruce);

        JLabel lblMutacion = new JLabel("Mutacion:");
        lblMutacion.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblMutacion.setBounds(10, 261, 115, 19);
        panelParams.add(lblMutacion);

        comboMutacion = new JComboBox<>();
        comboMutacion.addItem("Heuristica");
        comboMutacion.addItem("Insercion");
        comboMutacion.addItem("Intercambio");
        comboMutacion.addItem("Inversion");
        comboMutacion.setBounds(128, 257, 168, 27);
        panelParams.add(comboMutacion);

        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(10, 291, 286, 14);
        panelParams.add(separator_3);

        JLabel labelCruces = new JLabel("Probabilidad Cruces:");
        labelCruces.setFont(new Font("Dialog", Font.PLAIN, 14));
        labelCruces.setBounds(10, 304, 197, 19);
        panelParams.add(labelCruces);

        spinnerCruces = new JSpinner();
        spinnerCruces.setBounds(212, 300, 58, 27);
        SpinnerModel crucesModel = new SpinnerNumberModel(60, 0, 100, 1);
        spinnerCruces.setModel(crucesModel);
        ((DefaultEditor) spinnerCruces.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
        panelParams.add(spinnerCruces);

        JLabel percent1 = new JLabel("%");
        percent1.setFont(new Font("Dialog", Font.PLAIN, 16));
        percent1.setBounds(276, 304, 16, 19);
        panelParams.add(percent1);

        JLabel labelMutaciones = new JLabel("Probabilidad Mutaciones:");
        labelMutaciones.setFont(new Font("Dialog", Font.PLAIN, 14));
        labelMutaciones.setBounds(10, 338, 184, 19);
        panelParams.add(labelMutaciones);

        spinnerMutaciones = new JSpinner();
        spinnerMutaciones.setBounds(212, 334, 58, 27);
        SpinnerModel mutacionesModel = new SpinnerNumberModel(5, 0, 100, 1);
        spinnerMutaciones.setModel(mutacionesModel);
        ((DefaultEditor) spinnerMutaciones.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
        panelParams.add(spinnerMutaciones);

        JLabel percent2 = new JLabel("%");
        percent2.setFont(new Font("Dialog", Font.PLAIN, 16));
        percent2.setBounds(275, 338, 16, 19);
        panelParams.add(percent2);

        JSeparator separator_4 = new JSeparator();
        separator_4.setBounds(10, 367, 286, 14);
        panelParams.add(separator_4);

        chckbxElitismo = new JCheckBox("Elitismo:");
        chckbxElitismo.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxElitismo.setFont(new Font("Dialog", Font.PLAIN, 14));
        chckbxElitismo.setBounds(10, 378, 184, 23);
        panelParams.add(chckbxElitismo);

        spinnerElitismo = new JSpinner();
        spinnerElitismo.setBounds(212, 376, 58, 27);
        SpinnerModel elitismoModel = new SpinnerNumberModel(2, 0, 5, 1);
        spinnerElitismo.setModel(elitismoModel);
        ((DefaultEditor) spinnerElitismo.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
        panelParams.add(spinnerElitismo);

        JLabel percent3 = new JLabel("%");
        percent3.setFont(new Font("Dialog", Font.PLAIN, 16));
        percent3.setBounds(275, 380, 16, 19);
        panelParams.add(percent3);

        JSeparator separator_5 = new JSeparator();
        separator_5.setBounds(10, 408, 286, 14);
        panelParams.add(separator_5);

        labelTruncProb = new JLabel("Probabilidad Mutaciones:");
        labelTruncProb.setFont(new Font("Dialog", Font.PLAIN, 14));
        labelTruncProb.setBounds(10, 420, 197, 19);
        panelParams.add(labelTruncProb);
        labelTruncProb.setVisible(false);

        spinnerTruncProb = new JSpinner();
        spinnerTruncProb.setBounds(212, 416, 58, 27);
        panelParams.add(spinnerTruncProb);
        spinnerTruncProb.setVisible(false);

        JLabel percent4 = new JLabel("%");
        percent4.setFont(new Font("Dialog", Font.PLAIN, 16));
        percent4.setBounds(275, 420, 16, 19);
        panelParams.add(percent4);
        percent4.setVisible(false);

        Panel panelBotones = new Panel();
        panelBotones.setBounds(0, 527, 302, 151);
        contentPane.add(panelBotones);
        panelBotones.setLayout(null);

        JButton buttonEjecutar = new JButton("Comenzar");
        buttonEjecutar.setBounds(58, 6, 171, 45);
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
        btnDefecto.setBounds(43, 56, 203, 29);
        panelBotones.add(btnDefecto);

        btnEstudio = new JButton("Realizar Estudio");
        btnEstudio.setBounds(81, 108, 134, 29);
        panelBotones.add(btnEstudio);
        btnEstudio.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VistaEstudio v = new VistaEstudio(panelMathPlot);
                v.setVisible(true);
            }
        });

        JSeparator separator_6 = new JSeparator();
        separator_6.setBounds(6, 90, 286, 14);
        panelBotones.add(separator_6);
        btnDefecto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                valoresPorDefecto();

            }
        });

        panelMathPlot = new Plot2DPanel();
        panelMathPlot.setBounds(300, 0, 764, 527);
        contentPane.add(panelMathPlot);

        JPanel panelSolucion = new JPanel();
        panelSolucion.setBounds(300, 527, 764, 125);
        contentPane.add(panelSolucion);
        panelSolucion.setLayout(null);

        JLabel lblResultado = new JLabel("Resultado");
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
        lblResultado.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblResultado.setBounds(10, 22, 132, 19);
        panelSolucion.add(lblResultado);

        labelKilometros = new JLabel("");
        labelKilometros.setHorizontalAlignment(SwingConstants.CENTER);
        labelKilometros.setFont(new Font("Dialog", Font.PLAIN, 14));
        labelKilometros.setBounds(10, 52, 131, 19);
        panelSolucion.add(labelKilometros);

        textFieldCiudades = new JLabel();
        textFieldCiudades.setBounds(147, 10, 607, 105);
        panelSolucion.add(textFieldCiudades);

        JPanel panelNombres = new JPanel();
        panelNombres.setBounds(300, 651, 764, 27);
        contentPane.add(panelNombres);
        panelNombres.setLayout(null);

        JLabel labelNombres = new JLabel("Grupo 2 - Programacion Evolutiva - Jesus Granizo y Roberto Pavon");
        labelNombres.setHorizontalAlignment(SwingConstants.CENTER);
        labelNombres.setBounds(0, 0, 752, 27);
        panelNombres.add(labelNombres);

        comboSeleccion.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(comboSeleccion.getSelectedIndex() == 3) {
                    labelTruncProb.setText("Parametro Torneo: ");
                    labelTruncProb.setVisible(true);
                    SpinnerModel probModel = new SpinnerNumberModel(50, 50, 100, 1);
                    spinnerTruncProb.setModel(probModel);
                    ((DefaultEditor) spinnerTruncProb.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
                    spinnerTruncProb.setVisible(true);
                    percent4.setVisible(true);
                }
                else if(comboSeleccion.getSelectedIndex() == 4) {
                    labelTruncProb.setText("Umbral Truncamiento: ");
                    labelTruncProb.setVisible(true);
                    SpinnerModel truncModel = new SpinnerNumberModel(50, 10, 50, 10);
                    spinnerTruncProb.setModel(truncModel);
                    ((DefaultEditor) spinnerTruncProb.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
                    spinnerTruncProb.setVisible(true);
                    percent4.setVisible(true);
                }
                else{
                    labelTruncProb.setText("");
                    labelTruncProb.setVisible(false);
                    spinnerTruncProb.setVisible(false);
                    percent4.setVisible(false);
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
        comboMutacion.setSelectedIndex(0);
        spinnerCruces.setValue(60);
        spinnerMutaciones.setValue(5);
        chckbxElitismo.setSelected(false);
        spinnerElitismo.setValue(2);
    }

    private void capturaDatos() {

        int ciudadInicio = this.comboCiudad.getSelectedIndex();
        int poblacionSize = (int) this.spinnerPoblacion.getValue();
        int numGeneraciones = (int) this.spinnerGeners.getValue();

        String seleccion = (String) this.comboSeleccion.getSelectedItem();
        String cruce = (String) this.comboCruce.getSelectedItem();
        String mutacion = (String) this.comboMutacion.getSelectedItem();

        double probabilidadCruce =  (int) this.spinnerCruces.getValue();
        probabilidadCruce = probabilidadCruce / 100;
        double probabilidadMutacion =  (int) this.spinnerMutaciones.getValue();
        probabilidadMutacion = probabilidadMutacion / 100;
        boolean elitismo = this.chckbxElitismo.isSelected();
        double percentElitismo = (int) this.spinnerElitismo.getValue();
        percentElitismo = percentElitismo / 100;

        double parametroTruncProb = 0;

        if(seleccion == "TorneoProb" || seleccion == "Truncamiento") {
            parametroTruncProb = (int) this.spinnerTruncProb.getValue();
            parametroTruncProb = parametroTruncProb / 100;
        }

            AlgoritmoGenetico ag = new AlgoritmoGenetico(this);
            ag.ejecutarAlgoritmo(5, 0, poblacionSize, numGeneraciones, seleccion, cruce, mutacion, probabilidadCruce,
                    probabilidadMutacion, 0, elitismo, percentElitismo, parametroTruncProb, 0, ciudadInicio);

    }

    public void mostrarGrafica(double[] mejorAbs, double[] mejor, double[] media, double[] peor, double solucion, List<Double> sol) {

        panelMathPlot.removeAllPlots();
        double [] x = new double[mejorAbs.length];
        for(int i = 0; i < x.length; i++)
            x[i] = i+1;

        labelKilometros.setText(solucion + " km.");
        textFieldCiudades.setText("<html>");

        int i = 0;
        for(Double d : sol) {
            textFieldCiudades.setText(textFieldCiudades.getText() + "&nbsp;&nbsp;&nbsp;>&nbsp;&nbsp;&nbsp;" + Mapa.Ciudades[d.intValue()]);
            i++;
            if(i == 6){
                textFieldCiudades.setText(textFieldCiudades.getText() + "<br>");
                i=0;
            }
        }

        textFieldCiudades.setText(textFieldCiudades.getText() + "</html>");
        textFieldCiudades.setHorizontalAlignment(SwingConstants.CENTER);

        panelMathPlot.addLegend("SOUTH");
        panelMathPlot.addLinePlot("Mejor Absoluto", Color.MAGENTA, x, mejorAbs);
        panelMathPlot.addLinePlot("Mejor de la Generacion", Color.GREEN, x, mejor);
        panelMathPlot.addLinePlot("Media Generacion", Color.ORANGE, x, media);
        panelMathPlot.addLinePlot("Peor de la Generacion", Color.RED, x, peor);
    }
}
