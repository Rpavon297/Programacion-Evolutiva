package algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cruces.FactoriaCruces;
import funciones.*;
import genetica.Gen;
import genetica.GenBinario;
import genetica.GenEntero;
import genetica.GenReal;
import mutaciones.FactoriaMutacion;
import poblacion.Individuo;
import poblacion.Mapa;
import poblacion.Poblacion;
import selecciones.FactoriaSeleccion;
import vista.Vista;

@SuppressWarnings("ALL")
public class AlgoritmoGenetico {
	private Vista vista;


	public AlgoritmoGenetico(Vista vista){this.vista = vista;}

	public Poblacion ejecutarAlgoritmo(int funcion, int paramsFuncion, int poblacionSize, int numGeneraciones,
									   String seleccion, String cruce, String mutacion, double probabilidadCruce, double probabilidadMutacion, double precision,
									   boolean elitismo, double percentElitismo, double parametroTruncProb, int parametroCruce) {
		
		Poblacion poblacion = new Poblacion();
		
		//Creamos la funcion correspondiente
		Funcion f = crearFuncion(funcion);
		//Inicializamos los parametros que necesitar� la funcion de mutacion
		List<Double> paramsMutacion = new ArrayList<>();
		paramsMutacion.add(probabilidadMutacion);
		paramsMutacion.addAll(f.getIntervalo());
		
		//Inicializamos la poblacion
		inicalizarPoblacion(poblacion,poblacionSize,precision,funcion,paramsFuncion);

		//Inicializamos el resto de datos necesarios para la ejecución
		List<Generacion> generaciones = new ArrayList<>();
		int salvados = (int) Math.ceil(poblacion.getPoblacion().size() * percentElitismo);
		Poblacion elite = new Poblacion();
		
		//INICIO DEL ALGORITMO

		//EVALUAR LA POBLACION INICIAL
		double fitnessTotal = actualizarPoblacion(poblacion, f, funcion);

		for(int i = 0; i < numGeneraciones; i++) {
			generaciones.add(new Generacion(poblacion, fitnessTotal));
		
			//GUARDAR ELITE
			if(elitismo) 
				elite = new Poblacion(poblacion.getPoblacion().subList(0, salvados+1));
			
			//SELECCIONAR POBLACION
			Poblacion pobsel = new Poblacion(FactoriaSeleccion.getAlgoritmoSeleccion(seleccion, poblacion.getPoblacion(), parametroTruncProb).getPobSeleccionada());
			//CRUZAR POBLACION
			poblacion.substitute(FactoriaCruces.cruzarPoblacion(pobsel, cruce, parametroCruce));
			//MUTAR POBLACION
			System.out.println(poblacion);
			poblacion = new Poblacion(FactoriaMutacion.mutarPoblacion(mutacion,poblacion, paramsMutacion).getPobMutada());
			System.out.println(poblacion);
			//EVALUAR POBLACION
			fitnessTotal = actualizarPoblacion(poblacion, f, funcion);
			//REINTRODUCIR ELITE
			poblacion.substitute(elite);
			//REEVALUAR CON LA ELITE
			fitnessTotal = actualizarPoblacion(poblacion, f, funcion);
		}
		//Se muestra el resultado por pantalla
		mostrarSolucion(generaciones, funcion, precision);

		return poblacion;
	}

	private Funcion crearFuncion(int funcion) {
		Funcion f = new Funcion1();

		switch (funcion) {
			case 1:
				f = new Funcion1();
				break;
			case 2:
				f = new Funcion2();
				break;
			case 3:
				f = new Funcion3();
				break;
			case 4:
				f = new Funcion4();
				break;
			case 5:
				f = new FuncionViajante();
				break;
		}
		return f;
	}

	public void inicalizarPoblacion(Poblacion poblacion, int poblacionSize, double precision, int funcion, int paramsFuncion){
		for(int i = 0; i < poblacionSize; i++) {
			List<Gen> genes = new ArrayList<>();

			switch (funcion) {
				case 1:
					genes.add(new GenBinario((float) precision));
					genes.add(new GenBinario((float) precision));
					genes.get(0).randomize(-3, 12.1);
					genes.get(1).randomize(4.1, 5.8);

					break;
				case 2:
					genes.add(new GenBinario((float) precision));
					genes.add(new GenBinario((float) precision));

					genes.get(0).randomize(-512, 512);
					genes.get(1).randomize(-512, 512);
					break;
				case 3:
					genes.add(new GenBinario((float) precision));
					genes.add(new GenBinario((float) precision));

					genes.get(0).randomize(-10, 10);
					genes.get(1).randomize(-10, 10);
					break;
				case 4:
					for(int j = 0; j < paramsFuncion; j++) {
						genes.add(new GenReal((float) precision));
						genes.get(j).randomize(0, Math.PI);
					}
					break;
				case 5:
					Gen gen = new GenEntero();
					gen.setGenotipo((double)Mapa.Madrid);
					gen.setMin(0);
					gen.setMax(27);
					genes.add(gen);

					for(int j = 0; j < 27; j++){
						while(genes.contains(gen)){
							gen = new GenEntero();
							gen.randomize(0,27);
						}
						genes.add(gen);
					}

					gen = new GenEntero();
					gen.setGenotipo((double)Mapa.Madrid);
					gen.setMin(0);
					gen.setMax(27);
					genes.add(gen);
			}
			poblacion.getPoblacion().add(new Individuo(genes));
		}
	}

	public void ordenarPoblacion(Poblacion poblacion){
		Collections.sort(poblacion.getPoblacion(), new Comparator<Individuo>() {

			@Override
			public int compare(Individuo i1, Individuo i2) {
				return new Double(i2.getFitnessAdaptado()).compareTo(new Double(i1.getFitnessAdaptado()));
			}
		});
	}
	
	public double actualizarPoblacion(Poblacion poblacion, Funcion f, int funcion) {
		for(Individuo ind : poblacion.getPoblacion()) {
			List<Double> lista = ind.getFenotipo();
			ind.setFitness(f.ejecutar(lista));
		}
		
		if(funcion == 1)
			poblacion.revisarAdaptacion(true);
		else
			poblacion.revisarAdaptacion(false);
		
		double fitnessTotal = 0;
		double fitnessTotalNA = 0;
		for(Individuo ind : poblacion.getPoblacion()){
			fitnessTotal += ind.getFitnessAdaptado();
			fitnessTotalNA += ind.getFitness();
		}
		
		ordenarPoblacion(poblacion);
		poblacion.setProbSeleccion(fitnessTotal);
		
		return fitnessTotalNA;
	}

	public void mostrarSolucion(List<Generacion> generaciones, int funcion, double precision){
		int numGeneraciones = generaciones.size();
		double maxAbs = Double.POSITIVE_INFINITY;
		if(funcion == 1)
			maxAbs = Double.NEGATIVE_INFINITY;

		List<Double> sols = new ArrayList();
		double[] mejorAbsoluto = new double[numGeneraciones];
		double[] mejor = new double[numGeneraciones];
		double[] media = new double[numGeneraciones];
		double[] peor = new double[numGeneraciones];

		for (int i = 0;i < numGeneraciones; i++){
			if(funcion == 1) {
				if(maxAbs < generaciones.get(i).getMejor()) {
					maxAbs = generaciones.get(i).getMejor();
					sols = (generaciones.get(i).getSolucion());

				}
			}
			else {
				if(maxAbs > generaciones.get(i).getMejor()) {
					maxAbs = generaciones.get(i).getMejor();
					sols = generaciones.get(i).getSolucion();
				}
			}
			Generacion gen = generaciones.get(i);
			mejorAbsoluto[i] = maxAbs;
			mejor[i] = gen.getMejor();
			media[i] = gen.getMedia();
			peor[i] = gen.getPeor();
		}

		maxAbs = Math.floor(maxAbs / precision) * precision;

		this.vista.mostrarGrafica(mejorAbsoluto, mejor, media, peor, maxAbs, sols);
	}
}
