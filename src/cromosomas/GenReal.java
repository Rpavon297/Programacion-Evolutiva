package cromosomas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GenReal extends Gen {

	@Override
	public void randomize(double min, double max) {
		alelos.add(ThreadLocalRandom.current().nextDouble(min, max));
	}
	
	@Override
	public double getFenotipo() {
		// TODO Auto-generated method stub
		return (double) alelos.get(0);
	}

	@Override
	public List<Object> getAlelosNum() {
		// TODO Auto-generated method stub
		return alelos;
	}

	@Override
	public void setGenotipo(double valor) {
		// TODO Auto-generated method stub
		this.alelos = new ArrayList();
		this.alelos.add(valor);
	}

}
