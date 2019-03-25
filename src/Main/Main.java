package Main;

import vista.VistaDebugging;
import vista.VistaInicial;

public class Main {
	public static void main(String[] args) {
		VistaInicial v = new VistaInicial();
		v.setVisible(true);
		VistaDebugging test = new VistaDebugging();
		test.test();
	}
}