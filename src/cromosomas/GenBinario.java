package cromosomas;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GenBinario extends Gen {

	
	public GenBinario(float prec){
		this.alelos = new ArrayList<>();
		this.prec = prec;
	}
	
	@Override
	public void randomize(double min, double max) {
		Double aux = ThreadLocalRandom.current().nextDouble(min, max);
		this.setGenotipo(aux);
	}

	@Override
	public List<Object> getAlelosNum() {
		List<Object> ret = new ArrayList<>();
		
		for(Object b : this.alelos) 
			ret.add((boolean) (b) ? 1 : 0);
			
		return ret;
	}

	@Override
	public double getFenotipo() {
		
		 double result = 0;
		 int p = 0;
         
         for(int i = this.alelos.size() - 1; i >= 0; i--){
        	 result += (int)alelos.get(i) * Math.pow(2,p);
             p++;
         }
         if(this.neg)
        	 return -(result * this.prec);
         else
         return result * this.prec;
	}

	@Override
	public void setGenotipo(double valor) {
		// TODO Auto-generated method stub
		if(valor < 0) {
			this.neg = true;
			valor = -valor;
		}
		int l = (int) (valor/this.prec);

		String arr = Integer.toBinaryString(l);
		this.alelos = new ArrayList<>(arr.length());
		
		for(int i = 0; i < arr.length(); i++)
			alelos.add(Character.getNumericValue(arr.charAt(i)));
	}
}
