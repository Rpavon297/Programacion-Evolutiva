package Comun.Genetica;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GenEntero extends Gen {

	public GenEntero(){}

	public GenEntero(GenEntero nGen){
		this.min = nGen.getMin();
		this.max = nGen.getMax();
		this.prec = nGen.getPrec();
		this.neg = nGen.getNeg();
		this.alelos = new ArrayList<>();
		this.alelos.addAll(nGen.getAlelos());
	}

	@Override
	public void randomize(double min, double max) {
		this.min = min;
		this.max = max;

		setGenotipo((ThreadLocalRandom.current().nextInt((int)min, (int)max)));
	}

	@Override
	public double getFenotipo() {
		return (double) (int)alelos.get(0);
	}

	@Override
	public void setGenotipo(double valor) {
		this.alelos = new ArrayList<>();

		this.alelos.add((int)valor);
	}

}
