package poblacion;

import java.util.*;

import genetica.Gen;
import genetica.GenBinario;
import genetica.GenReal;

public class Individuo {
	protected List<Gen> genes;
	private int nGenes;
	private double acumulado;
	private double fitness;
	private double probSeleccion;
	private double fitnessAdaptado;
	
	public Individuo(Individuo nCrom){
		this.acumulado = nCrom.getAcumulado();
		this.fitness = nCrom.getFitness();
		this.fitnessAdaptado = nCrom.getFitnessAdaptado();
		this.probSeleccion = nCrom.getProbSeleccion();
		this.genes = new ArrayList<Gen>();
		
		for(Gen g : nCrom.getGenes()){
			if(g instanceof GenBinario)
				this.genes.add(new GenBinario((GenBinario)g));
			else if(g instanceof GenReal)
				this.genes.add(new GenReal((GenReal)g));
			
		}
	}
	
	public Individuo(List<Gen> genes){
		this.genes = genes;
	}
	
	
	public List<Double> getFenotipo(){
		List<Double> fenot = new ArrayList<>();
		
		for(Gen g : genes) 
			fenot.add(g.getFenotipo());
		return fenot;
	}
	
	public List<Object> getAlelos(){
		List<Object> alelos = new ArrayList<>();
				
		for(Gen g : this.genes) 
			alelos.addAll(g.getAlelos());
		
		return alelos;
	}
	
	public int getTam(){
		int ret = 0;
		if(!genes.isEmpty()){
			for(Gen g : this.genes){
				ret += g.getTam();
			}
		}
		
		return ret;
	}
	
	
	public List<Gen> getGenes() {return genes;}
	public int get() {return genes.size();}
	public double getFitness() {return fitness;}
	public int getNGenes(){return this.nGenes;}
	public double getAcumulado() {return acumulado;}
	
	
	public void setAcumulado(double acumulado) {this.acumulado = acumulado;}
	public void setFitness(double fitness) {this.fitness = fitness;}

	public double getProbSeleccion() {
		return probSeleccion;
	}

	public void setProbSeleccion(double probSeleccion) {
		this.probSeleccion = probSeleccion;
	}

	public double getFitnessAdaptado() {
		return fitnessAdaptado;
	}

	public void setFitnessAdaptado(double fitnessAdaptado) {
		this.fitnessAdaptado = fitnessAdaptado;
	}	
	
	
}
