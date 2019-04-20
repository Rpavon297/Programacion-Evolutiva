package Practica3;

import java.util.Map;

public class Hormiga {

    private Integer fila;
    private Integer columna;
    private Direccion direccion;

    public enum Direccion {
        ARRIBA, DERECHA, ABAJO, IZQUIERDA
    }

    public enum Giro {
        DERECHA, IZQUIERDA
    }

    public Hormiga(){
        this.fila = 0;
        this.columna = 0;
        this.direccion = Direccion.DERECHA;
    }

    public void avanza(){
        switch (this.direccion){
            case ARRIBA:
                this.fila--;
                if(this.fila == -1)
                    this.fila = Mapa.filas - 1;
                break;
            case DERECHA:
                this.columna++;
                if(this.columna.equals(Mapa.columnas))
                    this.columna = 0;
                break;
            case ABAJO:
                this.fila++;
                if(this.fila.equals(Mapa.filas))
                    this.fila = 0;
                break;
            case IZQUIERDA:
                this.columna--;
                if(this.columna == -1)
                    this.columna = Mapa.columnas - 1;
                break;
        }
        if(Mapa.tablero[this.fila][this.columna] == Mapa.tipo.COMIDA)
            Mapa.comidas++;
    }

    public void girar(Giro giro){
        switch (giro){
            case DERECHA:
                switch (this.direccion){
                    case ARRIBA:
                        this.direccion = Direccion.DERECHA;
                        break;
                    case DERECHA:
                        this.direccion = Direccion.ABAJO;
                        break;
                    case ABAJO:
                        this.direccion = Direccion.IZQUIERDA;
                        break;
                    case IZQUIERDA:
                        this.direccion =Direccion.ARRIBA;
                        break;
                }
                break;
            case IZQUIERDA:
                switch (this.direccion){
                    case ARRIBA:
                        this.direccion = Direccion.IZQUIERDA;
                        break;
                    case DERECHA:
                        this.direccion = Direccion.ARRIBA;
                        break;
                    case ABAJO:
                        this.direccion = Direccion.DERECHA;
                        break;
                    case IZQUIERDA:
                        this.direccion =Direccion.ABAJO;
                        break;
                }
                break;
        }
    }

    public boolean hayComidaDelante(){
        int aux;
        switch (this.direccion){
            case ARRIBA:
                if(this.fila == 0)
                    aux = Mapa.filas - 1;
                else
                    aux = this.fila - 1;
                if(Mapa.tablero[aux][this.columna] == Mapa.tipo.COMIDA)
                    return true;
                break;
            case DERECHA:
                if(this.columna.equals(Mapa.columnas))
                    aux = 0;
                else
                    aux = this.columna + 1;
                if(Mapa.tablero[this.fila][aux] == Mapa.tipo.COMIDA)
                    return true;
                break;
            case ABAJO:
                if(this.fila.equals(Mapa.filas))
                    aux = 0;
                else
                    aux = this.fila + 1;
                if(Mapa.tablero[aux][this.columna] == Mapa.tipo.COMIDA)
                    return true;
                break;
            case IZQUIERDA:
                if(this.columna == 0)
                    aux = Mapa.columnas - 1;
                else
                    aux = this.columna - 1;
                if(Mapa.tablero[this.fila][aux] == Mapa.tipo.COMIDA)
                    return true;
                break;
        }
        return false;
    }
}
