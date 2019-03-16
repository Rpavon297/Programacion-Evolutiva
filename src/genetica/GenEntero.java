package genetica;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GenEntero extends Gen {

	public GenEntero(){}
	public GenEntero(GenEntero nGen){
		this.min = nGen.getMax();
		this.max = nGen.getMax();
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
		setGenotipo((ThreadLocalRandom.current().nextInt((int)min, (int)max)));
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
