package Comun.Selecciones;

import java.util.ArrayList;
import java.util.List;

import Comun.Poblacion.Individuo;

@SuppressWarnings("unchecked")
public class TorneoProb extends AlgoritmoSeleccion {


	@Override
	public void seleccion(List<Individuo> poblacion, Object param) {
		
		pobSeleccionada = new ArrayList<Individuo>();
		int k = (int) ((Pair<Integer, Double>) param).getLeft();
		double p = (double) ((Pair<Object, Object>) param).getRight();
		int tamTorneo = 2;
		
		if(poblacion.size() > 10) tamTorneo = 3;
		
		for(int i = 0; i < k; i++){
			
			int select = (int) (Math.random() * (poblacion.size()));
			int selectMax = select;
			int selectMin = select;
			
			for(int j = 1; j < tamTorneo; j++){
				select = (int) (Math.random() * (poblacion.size()));
				if(poblacion.get(select).getFitnessAdaptado() > poblacion.get(selectMax).getFitnessAdaptado())
					selectMax = select;
				if(poblacion.get(select).getFitnessAdaptado() < poblacion.get(selectMax).getFitnessAdaptado())
					selectMin = select;
			}
			if(p < Math.random() * 1)
				pobSeleccionada.add(poblacion.get(selectMax));
			else
				pobSeleccionada.add(poblacion.get(selectMin));
		}
	}

}
