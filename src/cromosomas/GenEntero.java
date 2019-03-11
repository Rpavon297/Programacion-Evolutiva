package cromosomas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GenEntero extends Gen {

	@Override
	public void randomize(double min, double max) {
		int minint = (int) min;
		int maxint = (int) max;
		
		alelos.add(ThreadLocalRandom.current().nextInt(minint, maxint));
	}

	@Override
	public List<Object> getAlelosNum() {
		// TODO Auto-generated method stub
		return alelos;
	}

	@Override
	public double getFenotipo() {
		// TODO Auto-generated method stub
		return (double) alelos.get(0);
	}

	@Override
	public void setGenotipo(double valor) {
		// TODO Auto-generated method stub
		this.alelos = new ArrayList();
		this.alelos.add((int) valor);
	}

}
