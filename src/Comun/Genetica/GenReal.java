package Comun.Genetica;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("ALL")
public class GenReal extends Gen {


	public GenReal(float prec){
		this.prec = prec;
	}
	
	public GenReal(GenReal nGen){
		this.min = nGen.getMax();
		this.max = nGen.getMax();
		this.prec = nGen.getPrec();
		this.neg = nGen.getNeg();
		this.alelos = new ArrayList<Object>();	
		for(Object o : nGen.getAlelos()){
			this.alelos.add(o);
		}
	}
	
	@Override
	public void randomize(double min, double max) {
		setGenotipo((ThreadLocalRandom.current().nextDouble(min, max+this.prec)));
	}
	
	@Override
	public double getFenotipo() {
		return (double) alelos.get(0);
	}

	@Override
	public void setGenotipo(double valor) {
		this.alelos = new ArrayList<>();

		this.alelos.add(valor);
	}

}
