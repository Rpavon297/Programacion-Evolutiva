package Comun.Genetica;

import java.util.*;

public abstract class Gen {
	protected List<Object> alelos;
	protected float prec;
	protected boolean neg;
	protected int tam_cod;
	protected double min;
	protected double max;


	public Gen(Gen nGen){
		this.min = nGen.getMin();
		this.max = nGen.getMax();
		this.prec = nGen.getPrec();
		this.neg = nGen.getNeg();
		this.alelos = new ArrayList<Object>();	
		for(Object o : nGen.getAlelos()){
			Object no = o;
			this.alelos.add(no);
		}
	}
	
	public Gen(List<Object> alelos){
		this.alelos = alelos;
	}

	public Gen() {
		// TODO Auto-generated constructor stub
	}

	public List<Object> getAlelos(){return alelos;}
	/*public List<Integer> getAlelosNum(){
		List<Integer> ret = new ArrayList<>();
		
		for(Object b : this.alelos) 
			ret.add((boolean) (b) ? 1 : 0);
		
		return ret;
	}*/
	public double getMin(){return this.min;}
	public double getMax(){return this.max;}
	public boolean getNeg(){return this.neg;}
	public int getTam() {return this.alelos.size();}
	public float getPrec() {return this.prec;}
	
	public void setAlelos(List<Object> alelos) {
		this.alelos = alelos;
		if(this.getFenotipo() < this.min || this.getFenotipo() > this.max) this.neg = !this.neg;
	}
	public abstract void setGenotipo(double valor);
	public void setMin(double min) {
		this.min = min;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public abstract double getFenotipo();
	public abstract void randomize(double min, double max);
	public abstract List<Object> getAlelosNum();

	public boolean equals(Object o){
		if(!(o instanceof  Gen)) return false;

		Gen g = (Gen)o;
		return g.getFenotipo() == this.getFenotipo();
	}

	public String toString(){return Double.toString(this.getFenotipo());}
}
