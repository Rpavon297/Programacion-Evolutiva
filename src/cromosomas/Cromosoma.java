package cromosomas;

import genetica.Gen;

import java.util.*;

public class Cromosoma {
	protected List<Gen> genes;
	private int nGenes;
	private double acumulado;
	private double fitness;
	
	public Cromosoma(Cromosoma nCrom){
		this.acumulado = nCrom.getAcumulado();
		this.fitness = nCrom.getFitness();
		this.genes = new ArrayList<Gen>(nCrom.getGenes());
		
	}
	
	public Cromosoma(List<Gen> genes){
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
		int acum = 0;
		
		for(Gen g : this.genes) 
			alelos.addAll(g.getAlelos());
		
		return alelos;
	}
	
	public int getTam(){
		int ret = 0;
		if(!genes.isEmpty())
			ret = nGenes * genes.get(0).getTam();
		return ret;
	}
	
	
	public List<Gen> getGenes() {return genes;}
	public int get() {return genes.size();}
	public double getFitness() {return fitness;}
	public int getNGenes(){return this.nGenes;}
	public double getAcumulado() {return acumulado;}
	
	
	public void setAcumulado(double acumulado) {this.acumulado = acumulado;}
	public void setFitness(double fitness) {this.fitness = fitness;}	
	
	
}
