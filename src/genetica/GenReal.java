package genetica;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GenReal extends Gen {


	public GenReal() {
		this.alelos = new ArrayList();
	}
	
	public GenReal(float prec){
		this.prec = prec;
	}
	
	public GenReal(GenReal nGen){
		this.prec = nGen.getPrec();
		this.neg = nGen.getNeg();
		this.alelos = new ArrayList<Object>();	
		for(Object o : nGen.getAlelos()){
			Object no = o;
			this.alelos.add(no);
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
	public List<Object> getAlelosNum() {
		return alelos;
	}

	@Override
	public void setGenotipo(double valor) {
		this.alelos = new ArrayList<>();

		this.alelos.add(valor);
	}

}
