package Comun.Selecciones;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import Comun.Poblacion.Individuo;

@SuppressWarnings("ALL")
public class Torneo extends AlgoritmoSeleccion {
	

	@Override
	public void seleccion(List<Individuo> poblacion, Object param) {
		
		pobSeleccionada = new ArrayList<Individuo>();
		int k = (int) param;
		int tamTorneo = 2;
		
		if(poblacion.size() > 10) tamTorneo = 3;
		
		for(int i = 0; i < k; i++){
			List<Individuo> seleccionados = new ArrayList();
			for(int j = 1; j < tamTorneo; j++)
				seleccionados.add(poblacion.get(ThreadLocalRandom.current().nextInt(0,poblacion.size())));
			
			Individuo mejor = seleccionados.get(0);
			for(Individuo ind : seleccionados)
				if(ind.getFitnessAdaptado() > mejor.getFitnessAdaptado())
					mejor = ind;
			
			pobSeleccionada.add(mejor);
			
			/*int select = ThreadLocalRandom.current().nextInt(0,Comun.Poblacion.size());
			int selectMax = select;
			
			for(int j = 1; j < tamTorneo; j++){
				select = (int) (Math.random() * (Comun.Poblacion.size()));
				if(Comun.Poblacion.get(select).getFitness() > Comun.Poblacion.get(selectMax).getFitness())
					selectMax = select;
			}
			pobSeleccionada.add(Comun.Poblacion.get(selectMax));*/
			
		}
	}

}
