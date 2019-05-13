package Practica3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.*;

public abstract class SingletonMapa {
    //Como el mapa es estatico, esto deberia mejorar bastante el rendimiento
    //private static SingletonMapa mapa;

    private static List<Mapa> mapa;
    private static List<Integer> address;

    public static synchronized SingletonMapa getInstance() {
        /*if(mapa == null)
            mapa = new Mapa();
        return mapa;*/

        int id = (int) Thread.currentThread().getId();

        if (mapa == null)
            mapa = new ArrayList<>();
        if (address == null)
            address = new ArrayList<>();

        if (address.contains(id))
            return mapa.get(address.indexOf(id));
        else {
            System.out.println("Acceso a mapa para hilo " + id);

            Mapa nmapa = new Mapa();
            nmapa.cargarMapa("santaFe.txt");
            mapa.add(nmapa);
            address.add(id);

            return nmapa;
        }
    }
    public abstract void cargarMapa(String nombre);
    public abstract void setCasilla(Integer fila, Integer columna, Mapa.tipo paso);
    public abstract Mapa.tipo getCasilla(Integer fila, Integer columna);
    public abstract void upComidas();
    public abstract void upPaso();
    public abstract int getTotalComidas();
    public abstract Color getColor(int i, int j);
    public abstract void reset();
    public abstract Integer getFilas();
    public abstract void setFilas(Integer filas);
    public abstract Integer getColumnas();
    public abstract void setColumnas(Integer columnas);
    public abstract int getComidas();
    public abstract void setComidas(int comidas);
    public abstract int getPasos();
    public abstract Mapa.tipo[][] getTablero();
    public abstract void setTablero(Mapa.tipo[][] tablero);

}
