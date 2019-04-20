package Practica3;


import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Mapa {

    public static Integer filas = 32;
    public static Integer columnas = 32;
    public static int comidas = 0;
    public static tipo[][] inicial;
    public static tipo[][] tablero;

    public enum tipo{VACIO, COMIDA, PASO, HORMIGA};

    public static void cargarMapa(String nombre) {

        String cadena;
        tablero = new tipo[filas][columnas];

        try {
            FileReader f = new FileReader(nombre);
            BufferedReader b = new BufferedReader(f);
            int i = 0;
            while((cadena = b.readLine())!=null) {
                cadena = cadena.replaceAll(" ", "");
                for(int j = 0; j < cadena.length(); j++){
                    switch (cadena.charAt(j)){
                        case '0':
                            tablero[i][j] = tipo.VACIO;
                            break;
                        case '#':
                            tablero[i][j] = tipo.COMIDA;
                            break;
                        case '@':
                            tablero[i][j] = tipo.HORMIGA;
                            break;
                        case '$':
                            tablero[i][j] = tipo.PASO;
                            break;
                            default:
                                break;
                    }
                }
                i++;
            }
            b.close();
            inicial = tablero;
        } catch (Exception e){
            System.out.println("Error al cargar el mapa");
        }
    }

    public static Color getColor(int i, int j){
        Color color;
        switch(tablero[i][j]){
            case COMIDA:
                color = Color.gray;
                break;
            case HORMIGA:
                color = Color.RED;
                break;
            case PASO:
                color = Color.darkGray;
                break;
                default:
                    color = Color.lightGray;
                    break;
        }
        return color;
    }

    public static void reset(){
        tablero = inicial;
        comidas = 0;
    }
}
