package genetica;

import java.util.*;

public abstract class Gen {
	protected List<Object> alelos;
	protected float prec;
	protected boolean neg;
	protected int tam_cod;
	
	public Gen(Gen nGen){
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
	public boolean getNeg(){return this.neg;}
	public int getTam() {return this.alelos.size();}
	public float getPrec() {return this.prec;}
	
	public void setAlelos(List<Object> alelos) {this.alelos = alelos;}
	public abstract void setGenotipo(double valor);
	
	public abstract double getFenotipo();
	public abstract void randomize(double min, double max);
	public abstract List<Object> getAlelosNum();
}
