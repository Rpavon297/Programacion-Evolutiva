package Practica3;

import Comun.Funcion.Funcion;

import java.util.List;

public class FuncionHormiga extends Funcion {
    @Override
    public double ejecutar(List<Double> x) {
        Gramatica gramatica = new Gramatica();
        Hormiga hormiga = new Hormiga();

        gramatica.S(x, hormiga);
        int comidas = Mapa.comidas;
        Mapa.reset();

        return comidas;
    }
}
