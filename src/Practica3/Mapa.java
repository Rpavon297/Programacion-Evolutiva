package Practica3;


import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Mapa extends SingletonMapa{

    public static final int TotalPasos = 400;
    private Integer filas = 32;
    private Integer columnas = 32;
    private int comidas = 0;
    private int totalComida;
    private int pasos;
    private tipo[][] inicial;
    private tipo[][] tablero;

    public enum tipo {VACIO, COMIDA, PASO, HORMIGA}

    public void cargarMapa(String nombre) {
        totalComida = 0;
        pasos = 0;
        String cadena;
        tablero = new tipo[filas][columnas];
        inicial = new tipo[filas][columnas];

        try {
            FileReader f = new FileReader(nombre);
            BufferedReader b = new BufferedReader(f);
            int i = 0;
            while ((cadena = b.readLine()) != null) {
                cadena = cadena.replaceAll(" ", "");
                for (int j = 0; j < cadena.length(); j++) {
                    switch (cadena.charAt(j)) {
                        case '0':
                            tablero[i][j] = tipo.VACIO;
                            inicial[i][j] = tipo.VACIO;
                            break;
                        case '#':
                            this.totalComida++;
                            tablero[i][j] = tipo.COMIDA;
                            inicial[i][j] = tipo.COMIDA;
                            break;
                        case '@':
                            tablero[i][j] = tipo.HORMIGA;
                            inicial[i][j] = tipo.HORMIGA;
                            break;
                        case '$':
                            tablero[i][j] = tipo.PASO;
                            inicial[i][j] = tipo.PASO;
                            break;
                        default:
                            break;
                    }
                }
                i++;
            }
            b.close();
        } catch (Exception e) {
            System.out.println("Error al cargar el mapa");
        }
    }

    public void setCasilla(Integer fila, Integer columna, tipo paso) {
        tablero[fila][columna] = paso;
    }

    public tipo getCasilla(Integer fila, Integer columna){
        return tablero[fila][columna];
    }

    public void upComidas() {this.comidas++;}

    public void upPaso(){this.pasos++;}

    public int getTotalComidas() { return totalComida; }

    public Color getColor(int i, int j) {
        Color color;
        switch (tablero[i][j]) {
            case COMIDA:
                color = Color.gray;
                break;
            case HORMIGA:
                color = Color.RED;
                break;
            case PASO:
                color = Color.MAGENTA;
                break;
            default:
                color = Color.lightGray;
                break;
        }
        return color;
    }

    public void reset() {
        //tablero = inicial.clone();
        for(int i = 0; i < this.filas; i++){
            for(int j = 0; j < this.columnas; j++){
                this.tablero[i][j] = this.inicial[i][j];
            }
        }
        comidas = 0;
        pasos = 0;
    }

    public Integer getFilas() {
        return filas;
    }

    public void setFilas(Integer filas) {
        this.filas = filas;
    }

    public Integer getColumnas() {
        return columnas;
    }

    public void setColumnas(Integer columnas) {
        this.columnas = columnas;
    }

    public int getComidas() {
        return comidas;
    }

    public void setComidas(int comidas) {
        this.comidas = comidas;
    }

    public int getPasos(){
        return pasos;
    }

    public tipo[][] getTablero() {
        return tablero;
    }

    public void setTablero(tipo[][] tablero) {
        this.tablero = tablero;
    }

    public String toString(){
        StringBuilder cad = new StringBuilder();

        for(int i = 0; i < this.filas; i++){
            for(int j = 0; j < this.columnas; j++){
                cad.append(tablero[i][j].toString()).append(" ");
            }
            cad.append("\n");
        }

        return cad.toString();
    }
}
