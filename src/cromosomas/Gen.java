package cromosomas;

import java.util.*;

public abstract class Gen {
	protected List<Object> alelos;
	protected float prec;
	protected boolean neg;
	
	public Gen(Gen nGen){
		this.prec = nGen.getPrec();
		
		this.alelos = new ArrayList<Object>(nGen.getAlelos());	
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
	public int getTam() {return this.alelos.size();}
	private float getPrec() {return this.prec;}
	
	public void setAlelos(List<Object> alelos) {this.alelos = alelos;}
	public abstract void setGenotipo(double valor);
	
	public abstract double getFenotipo();
	public abstract void randomize(double min, double max);
	public abstract List<Object> getAlelosNum();
}
