package Comun.Genetica;

import java.util.*;

public abstract class Gen {
	List<Object> alelos;
	float prec;
	boolean neg;
	int tam_cod;
	double min;
	double max;


	Gen() {
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
	boolean getNeg(){return this.neg;}
	public int getTam() {return this.alelos.size();}
	float getPrec() {return this.prec;}
	
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

	public boolean equals(Object o){
		if(!(o instanceof  Gen)) return false;

		Gen g = (Gen)o;
		return g.getFenotipo() == this.getFenotipo();
	}

	public String toString(){return Double.toString(this.getFenotipo());}
}
