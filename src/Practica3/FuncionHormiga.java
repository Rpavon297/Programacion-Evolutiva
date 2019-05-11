package Practica3;

import Comun.Funcion.Funcion;

import java.util.ArrayList;
import java.util.List;

public class FuncionHormiga extends Funcion {

    public FuncionHormiga(){
        this.intervalo = new ArrayList<>();
        this.intervalo.add(0.0);
        this.intervalo.add(256.0);
    }
    @Override
    public double ejecutar(List<Double> x) {
        Gramatica gramatica = new Gramatica(2);
        Hormiga hormiga = new Hormiga();

        //EN ESTA PRIMERA VERSION, SE EJECUTAN 100 PASOS Y NO SE COMPRUEBA SI SE HA COMIDO TODA LA COMIDA
        for(int i = 0; i < 400; i++) {
            gramatica.S(x, hormiga);
        }

        double comidas = SingletonMapa.getInstance().getComidas();
        double pasos = SingletonMapa.getInstance().getPasos();
        double demo = SingletonMapa.getInstance().getTotalComidas();
        double ratiop = pasos/SingletonMapa.getInstance().TotalPasos;

        SingletonMapa.getInstance().reset();

        //IMPLEMENTAR CONTROL DEL BLOATING
        if(ratiop == 0) return 0;
        // Opcion muy conservadora:
        return comidas - ratiop;
        // return (comidas * (SingletonMapa.getInstance().TotalPasos + 1)) - pasos;
    }
}
