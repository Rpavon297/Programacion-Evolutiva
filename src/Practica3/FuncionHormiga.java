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
        Gramatica gramatica = new Gramatica();
        Hormiga hormiga = new Hormiga();

        //EN ESTA PRIMERA VERSION, SE EJECUTAN 100 PASOS Y NO SE COMPRUEBA SI SE HA COMIDO TODA LA COMIDA
        for(int i = 0; i < 100; i++) {
            gramatica.S(x, hormiga);
        }

        int comidas = Mapa.comidas;
        Mapa.reset();

        return comidas;
    }
}
