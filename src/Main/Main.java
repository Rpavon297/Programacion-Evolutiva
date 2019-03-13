package Main;

import vista.Vista;

public class Main {
	public static void main(String[] args) {
		System.out.println("Seleccione algoritmo a utilizar ([e]volutivo,[g]enetico): ");

		Vista frame = new Vista();
		frame.setVisible(true);
	}
}