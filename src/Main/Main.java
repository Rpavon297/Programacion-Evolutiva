package Main;

import poblacion.Mapa;
import vista.VistaDebugging;
import vista.VistaEvolutivo;
import vista.VistaGenetico;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = "";
		boolean seguir = true;

		while(seguir) {
			System.out.println("Introduzca una opcion ([g]enetica,[e]volutiva, [s]alir):");

			//input = scan.next();
			input = "e";
			System.out.println(Mapa.calcularDistancias(Mapa.Almeria, Mapa.Murcia));


			if(input.equals("g") || input.equals("genetica")){
				System.out.println("Cargando...");
				VistaGenetico frame = new VistaGenetico();
				frame.setVisible(true);
				seguir = false;
			}else if(input.equals("e") || input.equals("evolutiva")){
				System.out.println("Cargando...");
				//VistaEvolutivo frame = new VistaEvolutivo();
				//frame.setVisible(true);
				VistaDebugging frame = new VistaDebugging();
				frame.test();

				seguir = false;
			}else if(input.equals("s") || input.equals("salir"))
				seguir = false;
		}
	}
}