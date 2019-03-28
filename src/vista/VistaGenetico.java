package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.math.plot.Plot2DPanel;
import algoritmos.AlgoritmoGenetico;

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
import javax.swing.JTextField;

public class VistaGenetico extends Vista {

	/**
	 *
	 */
	AlgoritmoGenetico ag;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> combofuncion;
	private JSpinner spinnerPoblacion;
	private JSpinner spinnerGeners;
	private JComboBox<String> comboSeleccion;
	private JComboBox<String> comboCruce;
	private JSpinner spinnerCruces;
	private JSpinner spinnerMutaciones;
	private JSpinner spinnerPrecision;
	private JCheckBox chckbxElitismo;
	private JCheckBox chckbxReal;
	private JLabel labelTruncProb;
	private JSpinner spinnerTruncProb;
	private JSpinner spinnerFunc;
	private Plot2DPanel panelMathPlot;
	private JSpinner spinnerElitismo;
	private JSpinner spinnerParamCruce;
	private static JComboBox<String>textField_1;
	private static JTextField textField;

	/**
	 * Create the frame.
	 */
	public VistaGenetico() {
		setTitle("Practica 1");
		setResizable(false);
		setBounds(100, 100, 1064, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelParams = new JPanel();
		panelParams.setBounds(0, 0, 302, 660);
		contentPane.add(panelParams);
		panelParams.setLayout(null);

		JLabel Titulo = new JLabel("Parametros");
		Titulo.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setBounds(0, 11, 275, 41);
		panelParams.add(Titulo);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 63, 255, 2);
		panelParams.add(separator);

		JLabel labelFuncion = new JLabel("Funcion:");
		labelFuncion.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		labelFuncion.setBounds(10, 79, 61, 19);
		panelParams.add(labelFuncion);

		combofuncion = new JComboBox<String>();
		combofuncion.addItem("Funcion 1");
		combofuncion.addItem("Funcion 2");
		combofuncion.addItem("Funcion 3");
		combofuncion.addItem("Funcion 4");
		combofuncion.setBounds(112, 77, 184, 27);
		panelParams.add(combofuncion);

		JLabel labelParamsFunc = new JLabel("Parametros Funcion:");
		labelParamsFunc.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		labelParamsFunc.setBounds(10, 117, 158, 19);
		panelParams.add(labelParamsFunc);

		spinnerFunc = new JSpinner();
		spinnerFunc.setFocusable(false);
		spinnerFunc.setBounds(209, 114, 87, 27);
		spinnerFunc.setValue(2);
		spinnerFunc.setEnabled(false);
		((DefaultEditor) spinnerFunc.getEditor()).getTextField().setEditable(false);
		((DefaultEditor) spinnerFunc.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		panelParams.add(spinnerFunc);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 153, 255, 2);
		panelParams.add(separator_1);

		JLabel labelPoblacion = new JLabel("Tamanio de la Poblacion:");
		labelPoblacion.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		labelPoblacion.setBounds(10, 166, 176, 19);
		panelParams.add(labelPoblacion);

		spinnerPoblacion = new JSpinner();
		spinnerPoblacion.setFocusable(false);
		SpinnerModel modelPoblacion = new SpinnerNumberModel(100, 1, 200, 1);
		spinnerPoblacion.setModel(modelPoblacion);
		((DefaultEditor) spinnerPoblacion.getEditor()).getTextField().setEditable(false);
		((DefaultEditor) spinnerPoblacion.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		spinnerPoblacion.setBounds(209, 163, 87, 27);
		panelParams.add(spinnerPoblacion);

		JLabel labelGeners = new JLabel("Numero de Generaciones:");
		labelGeners.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		labelGeners.setBounds(10, 204, 184, 19);
		panelParams.add(labelGeners);

		spinnerGeners = new JSpinner();
		SpinnerModel modelGeners = new SpinnerNumberModel(100, 1, 200, 1);
		spinnerGeners.setModel(modelGeners);
		((DefaultEditor) spinnerGeners.getEditor()).getTextField().setEditable(false);
		((DefaultEditor) spinnerGeners.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		spinnerGeners.setBounds(209, 201, 87, 27);
		panelParams.add(spinnerGeners);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 240, 255, 2);
		panelParams.add(separator_2);

		JLabel labelSeleccion = new JLabel("Seleccion:");
		labelSeleccion.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		labelSeleccion.setBounds(10, 253, 77, 19);
		panelParams.add(labelSeleccion);

		comboSeleccion = new JComboBox<String>();
		comboSeleccion.addItem("Estocastica Univ.");
		comboSeleccion.addItem("Ruleta");
		comboSeleccion.addItem("Torneo");
		comboSeleccion.addItem("Torneo Prob.");
		comboSeleccion.addItem("Truncamiento");
		comboSeleccion.setBounds(128, 251, 168, 27);
		panelParams.add(comboSeleccion);

		JLabel labelCruce = new JLabel("Cruce:");
		labelCruce.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		labelCruce.setBounds(10, 287, 61, 19);
		panelParams.add(labelCruce);

		comboCruce = new JComboBox<String>();
		comboCruce.addItem("Aritmetico");
		comboCruce.addItem("BLX");
		comboCruce.addItem("Monopunto");
		comboCruce.addItem("Multipunto");
		comboCruce.addItem("Uniforme");
		comboCruce.setBounds(128, 285, 168, 27);
		panelParams.add(comboCruce);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 323, 255, 2);
		panelParams.add(separator_3);

		JLabel labelCruces = new JLabel("Probabilidad Cruces:");
		labelCruces.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		labelCruces.setBounds(10, 336, 158, 19);
		panelParams.add(labelCruces);

		spinnerCruces = new JSpinner();
		spinnerCruces.setBounds(212, 328, 58, 27);
		SpinnerModel crucesModel = new SpinnerNumberModel(60, 0, 100, 1);
		spinnerCruces.setModel(crucesModel);
		((DefaultEditor) spinnerCruces.getEditor()).getTextField().setEditable(false);
		((DefaultEditor) spinnerCruces.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		panelParams.add(spinnerCruces);

		JLabel percent1 = new JLabel("%");
		percent1.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		percent1.setBounds(280, 330, 16, 19);
		panelParams.add(percent1);

		JLabel labelMutaciones = new JLabel("Probabilidad Mutaciones:");
		labelMutaciones.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		labelMutaciones.setBounds(10, 374, 184, 19);
		panelParams.add(labelMutaciones);

		spinnerMutaciones = new JSpinner();
		spinnerMutaciones.setBounds(212, 371, 58, 27);
		SpinnerModel mutacionesModel = new SpinnerNumberModel(5, 0, 100, 1);
		spinnerMutaciones.setModel(mutacionesModel);
		((DefaultEditor) spinnerMutaciones.getEditor()).getTextField().setEditable(false);
		((DefaultEditor) spinnerMutaciones.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		panelParams.add(spinnerMutaciones);

		spinnerPrecision = new JSpinner();
		spinnerPrecision.setBounds(206, 409, 61, 27);
		SpinnerModel precisionModel = new SpinnerNumberModel(3, 0, 5, 1);

		JLabel percent2 = new JLabel("%");
		percent2.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		percent2.setBounds(280, 373, 16, 19);
		panelParams.add(percent2);

		JLabel labelPrecision = new JLabel("Precision:");
		labelPrecision.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		labelPrecision.setBounds(10, 412, 158, 19);
		panelParams.add(labelPrecision);
		spinnerPrecision.setModel(precisionModel);
		((DefaultEditor) spinnerPrecision.getEditor()).getTextField().setEditable(false);
		((DefaultEditor) spinnerPrecision.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		panelParams.add(spinnerPrecision);

		JLabel labelDec = new JLabel("dec");
		labelDec.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		labelDec.setBounds(270, 411, 33, 19);
		panelParams.add(labelDec);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 448, 255, 2);
		panelParams.add(separator_4);

		chckbxElitismo = new JCheckBox("Elitismo:");
		chckbxElitismo.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		chckbxElitismo.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxElitismo.setBounds(6, 461, 105, 23);
		panelParams.add(chckbxElitismo);

		spinnerElitismo = new JSpinner();
		spinnerElitismo.setBounds(209, 462, 61, 27);
		SpinnerModel elitismoModel = new SpinnerNumberModel(2, 0, 5, 1);
		spinnerElitismo.setModel(elitismoModel);
		((DefaultEditor) spinnerElitismo.getEditor()).getTextField().setEditable(false);
		((DefaultEditor) spinnerElitismo.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		spinnerElitismo.setEnabled(false);
		panelParams.add(spinnerElitismo);

		JLabel percent3 = new JLabel("%");
		percent3.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		percent3.setBounds(280, 468, 16, 14);
		panelParams.add(percent3);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 499, 255, 2);
		panelParams.add(separator_5);

		labelTruncProb = new JLabel();
		labelTruncProb.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		labelTruncProb.setBounds(10, 512, 158, 19);
		panelParams.add(labelTruncProb);

		spinnerTruncProb = new JSpinner();
		spinnerTruncProb.setBounds(209, 508, 61, 27);
		panelParams.add(spinnerTruncProb);

		JLabel percent4 = new JLabel("%");
		percent4.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		percent4.setBounds(280, 512, 16, 19);
		panelParams.add(percent4);

		JLabel labelParamCruce = new JLabel();
		labelParamCruce.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		labelParamCruce.setBounds(10, 563, 184, 14);
		panelParams.add(labelParamCruce);

		spinnerParamCruce = new JSpinner();
		spinnerParamCruce.setBounds(235, 556, 61, 27);
		panelParams.add(spinnerParamCruce);

		labelTruncProb.setVisible(false);
		spinnerTruncProb.setVisible(false);
		percent4.setVisible(false);
		labelParamCruce.setVisible(false);
		spinnerParamCruce.setVisible(false);

		JButton buttonEjecutar = new JButton("Comenzar");
		buttonEjecutar.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		buttonEjecutar.setBounds(49, 608, 168, 41);
		panelParams.add(buttonEjecutar);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 550, 255, 2);
		panelParams.add(separator_6);

		buttonEjecutar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturaDatos();
			}
		});

		panelMathPlot = new Plot2DPanel();
		panelMathPlot.setBounds(300, 0, 758, 601);
		contentPane.add(panelMathPlot);

		JPanel panelNombres = new JPanel();
		panelNombres.setBounds(300, 639, 758, 21);
		contentPane.add(panelNombres);
		panelNombres.setLayout(null);

		JLabel labelNombres = new JLabel("Grupo 2 - Programacion Evolutiva - Jesus Granizo y Roberto Pavon");
		labelNombres.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombres.setBounds(28, 0, 756, 21);
		panelNombres.add(labelNombres);

		JPanel panel = new JPanel();
		panel.setBounds(300, 603, 758, 35);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Solucion:  ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblNewLabel.setBounds(131, 0, 120, 34);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		textField.setBounds(248, 7, 132, 20);
		textField.setEditable(false);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblParaLosPuntos = new JLabel("para los puntos  ");
		lblParaLosPuntos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblParaLosPuntos.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblParaLosPuntos.setBounds(390, 0, 120, 34);
		panel.add(lblParaLosPuntos);

		textField_1 = new JComboBox<>();
		textField_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		textField_1.setEditable(false);
		textField_1.setBounds(506, 10, 132, 20);
		panel.add(textField_1);

		comboSeleccion.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(comboSeleccion.getSelectedIndex() == 3) {
					labelTruncProb.setText("Parametro Torneo: ");
					labelTruncProb.setVisible(true);
					SpinnerModel probModel = new SpinnerNumberModel(50, 50, 100, 1);
					spinnerTruncProb.setModel(probModel);
					((DefaultEditor) spinnerTruncProb.getEditor()).getTextField().setEditable(false);
					((DefaultEditor) spinnerTruncProb.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
					spinnerTruncProb.setVisible(true);
					percent4.setVisible(true);
				}
				else if(comboSeleccion.getSelectedIndex() == 4) {
					labelTruncProb.setText("Umbral Truncamiento: ");
					labelTruncProb.setVisible(true);
					SpinnerModel truncModel = new SpinnerNumberModel(50, 10, 50, 10);
					spinnerTruncProb.setModel(truncModel);
					((DefaultEditor) spinnerTruncProb.getEditor()).getTextField().setEditable(false);
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

		combofuncion.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(combofuncion.getSelectedIndex() == 3) {
					spinnerFunc.setValue(1);
					SpinnerModel probModel = new SpinnerNumberModel(1, 1, 20, 1);
					spinnerFunc.setModel(probModel);
					((DefaultEditor) spinnerFunc.getEditor()).getTextField().setEditable(false);
					((DefaultEditor) spinnerFunc.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
					spinnerFunc.setEnabled(true);
				}
				else{
					spinnerFunc.setValue(2);
					spinnerFunc.setEnabled(false);
				}

			}
		});

		chckbxElitismo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(chckbxElitismo.isSelected())
					spinnerElitismo.setEnabled(true);
				else
					spinnerElitismo.setEnabled(false);
			}
		});

		comboCruce.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(comboCruce.getSelectedIndex() == 3) {
					labelParamCruce.setText("Numero de Cruces: ");
					labelParamCruce.setVisible(true);
					SpinnerModel probModel = new SpinnerNumberModel(3, 1, 5, 1);
					spinnerParamCruce.setModel(probModel);
					((DefaultEditor) spinnerParamCruce.getEditor()).getTextField().setEditable(false);
					((DefaultEditor) spinnerParamCruce.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
					spinnerParamCruce.setVisible(true);
				}
				else{
					labelParamCruce.setVisible(false);
					spinnerParamCruce.setVisible(false);
				}

			}
		});
	}

	private void capturaDatos() {

		int funcion = this.combofuncion.getSelectedIndex() + 1;
		int paramsFuncion = (int) this.spinnerFunc.getValue();
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
		double precision = 1 / (Math.pow(10, (int) this.spinnerPrecision.getValue()));
		boolean elitismo = this.chckbxElitismo.isSelected();
		double percentElitismo = (int) this.spinnerElitismo.getValue();
		percentElitismo = percentElitismo / 100;

		double parametroTruncProb = 0;
		int parametroCruce = 0;

		if(seleccion == "TorneoProb" || seleccion == "Truncamiento") {
			parametroTruncProb = (int) this.spinnerTruncProb.getValue();
			parametroTruncProb = parametroTruncProb / 100;
		}

		if(cruce == "Multipunto")
			parametroCruce = (int) this.spinnerParamCruce.getValue();

		String mutacion = "Basica";
		ag = new AlgoritmoGenetico(this);
		ag.ejecutarAlgoritmo(funcion, paramsFuncion, poblacionSize, numGeneraciones, seleccion, cruce, mutacion, probabilidadCruce,
				probabilidadMutacion, precision, elitismo, percentElitismo, parametroTruncProb, parametroCruce, 0);
	}

	public void mostrarGrafica(double[] mejorAbs, double[] mejor, double[] media, double[] peor, double solucion, List<Double> sol) {

		panelMathPlot.removeAllPlots();
		double [] x = new double[mejorAbs.length];
		for(int i = 0; i < x.length; i++) {
			x[i] = i+1;
		}

		textField.setText(String.valueOf(solucion));
		textField_1.removeAllItems();

		int i = 0;

		for(Double d : sol) {
			i++;
			d = Math.floor(d / 0.0001) * 0.0001;

			String text = "X" + String.valueOf(i) + ": " + String.valueOf(d);
			textField_1.addItem(text);

		};

		panelMathPlot.addLegend("SOUTH");
		panelMathPlot.addLinePlot("Mejor Absoluto", Color.MAGENTA, x, mejorAbs);
		panelMathPlot.addLinePlot("Mejor de la Generacion", Color.GREEN, x, mejor);
		panelMathPlot.addLinePlot("Media Generacion", Color.ORANGE, x, media);
		panelMathPlot.addLinePlot("Peor de la Generacion", Color.RED, x, peor);

	}
}
