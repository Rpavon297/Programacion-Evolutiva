package algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cruces.FactoriaOperadores;
import funciones.Funcion;
import funciones.Funcion1;
import funciones.Funcion2;
import funciones.Funcion3;
import funciones.Funcion4;
import genetica.Gen;
import genetica.GenBinario;
import genetica.GenReal;
import poblacion.Individuo;
import poblacion.Poblacion;
import selecciones.FactoriaSeleccion;
import selecciones.Pair;
import vista.Vista;

public class AlgoritmoGenetico {

	public Poblacion ejecutarAlgoritmo(int funcion, int paramsFuncion, int poblacionSize, int numGeneraciones,
			String seleccion, String cruce, double probabilidadCruce, double probabilidadMutacion, double precision,
			boolean elitismo, double percentElitismo, double parametroTruncProb, int parametroCruce) {
		
		Poblacion poblacion = new Poblacion();
		Funcion f;
		
		//Creamos la funcion correspondiente
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
		default:
			f = new Funcion4();
			break;
		}
		
		//Inicializamos los parametros que necesitará la funcion de mutacion

		List<Double> paramsMutacion = new ArrayList<>();
		paramsMutacion.add(probabilidadMutacion);
		paramsMutacion.addAll(f.getIntervalo());
		
		//Inicializamos la poblacion
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
			default:
				for(int j = 0; j < paramsFuncion; j++) {
					genes.add(new GenReal((float) precision));
					genes.get(j).randomize(0, Math.PI);
				}
				break;
			}
			poblacion.getPoblacion().add(new Individuo(genes));
		}
		
		double maxAbs = 0;
		List<Double> sols = new ArrayList();
		double[] mejorAbsoluto = new double[numGeneraciones];
		double[] mejor = new double[numGeneraciones];
		double[] media = new double[numGeneraciones];
		double[] peor = new double[numGeneraciones];
		
		double fitnessTotal = actualizarPoblacion(poblacion, f, funcion);
		
		int salvados = (int) Math.ceil(poblacion.getPoblacion().size() * percentElitismo);
		Poblacion elite = new Poblacion();
		
		//INICIO DEL ALGORITMO
		for(int i = 0; i < numGeneraciones; i++) {
			
			//Calculamos maximo, minimo, media y maximo absoluto. La solucion será el maximo absoluto en la ultima generacion
			double max = poblacion.getPoblacion().get(0).getFitness();
			double min = poblacion.getPoblacion().get(poblacion.getPoblacion().size() -1).getFitness();
			double med = fitnessTotal / poblacion.getPoblacion().size();
			
			if(funcion == 1) {
				if(maxAbs < max) {
					maxAbs = max;
					sols = new ArrayList();
					sols.addAll(poblacion.getPoblacion().get(0).getFenotipo());
					
				}
			}
			else {
				if(maxAbs > max) {
					maxAbs = max;
					sols = new ArrayList();
					sols.addAll(poblacion.getPoblacion().get(0).getFenotipo());
				}
			}
			
			mejorAbsoluto[i] = maxAbs;
			mejor[i] = max;
			media[i] = med;
			peor[i] = min;
		
			//Si hay elitismo, guardamos el porcentaje designado en una poblacion auxiliar
			if(elitismo) 
				elite = new Poblacion(poblacion.getPoblacion().subList(0, salvados+1));
			
			//Seleccionamos parte de la poblacion
			Poblacion pobsel = new Poblacion(FactoriaSeleccion.getAlgoritmoSeleccion(seleccion, poblacion.copy(), parametroTruncProb).getPobSeleccionada());
			//Cruzamos la poblacion seleccionada y reemplazamos los peores con los hijos obtenidos
			poblacion.substitute(FactoriaOperadores.cruzarPoblacion(pobsel, cruce, parametroCruce));
			//Aplicamos mutaciones
			poblacion = new Poblacion(FactoriaOperadores.mutarPoblacion(poblacion, paramsMutacion).getPobMutada());
			
			//Actualizamos fitness y orden de nuestra poblacion
			fitnessTotal = actualizarPoblacion(poblacion, f, funcion);
			//Introducimos la elite y volvemos a calcular fitness
			poblacion.substitute(elite);
			fitnessTotal = actualizarPoblacion(poblacion, f, funcion);
		}
		
		maxAbs = Math.floor(maxAbs / precision) * precision;
		Vista.mostrarGrafica(mejorAbsoluto, mejor, media, peor,maxAbs,sols);
		System.out.println("Solucion de la funcion: ");
		System.out.println(maxAbs);
		
		return poblacion;
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
}
