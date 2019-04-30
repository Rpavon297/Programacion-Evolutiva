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

    public Hormiga() {
        this.fila = 0;
        this.columna = 0;
        this.direccion = Direccion.DERECHA;
    }

    public void avanza() {
        if(SingletonMapa.getInstance().getComidas() < SingletonMapa.getInstance().getTotalComidas() && SingletonMapa.getInstance().getPasos() < SingletonMapa.getInstance().TotalPasos) {
            SingletonMapa.getInstance().setCasilla(this.fila, this.columna, Mapa.tipo.PASO);
            switch (this.direccion) {
                case ARRIBA:
                    this.fila--;
                    if (this.fila == -1)
                        this.fila = SingletonMapa.getInstance().getFilas() - 1;
                    break;
                case DERECHA:
                    this.columna++;
                    if (this.columna.equals(SingletonMapa.getInstance().getColumnas()))
                        this.columna = 0;
                    break;
                case ABAJO:
                    this.fila++;
                    if (this.fila.equals(SingletonMapa.getInstance().getFilas()))
                        this.fila = 0;
                    break;
                case IZQUIERDA:
                    this.columna--;
                    if (this.columna == -1)
                        this.columna = SingletonMapa.getInstance().getColumnas() - 1;
                    break;
            }
            if (SingletonMapa.getInstance().getCasilla(this.fila, this.columna) == Mapa.tipo.COMIDA) {
                SingletonMapa.getInstance().upComidas();
            }
            SingletonMapa.getInstance().upPaso();
            SingletonMapa.getInstance().setCasilla(this.fila, this.columna, Mapa.tipo.HORMIGA);
        }
    }

    public void girar(Giro giro) {
        switch (giro) {
            case DERECHA:
                switch (this.direccion) {
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
                        this.direccion = Direccion.ARRIBA;
                        break;
                }
                break;
            case IZQUIERDA:
                switch (this.direccion) {
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
                        this.direccion = Direccion.ABAJO;
                        break;
                }
                break;
        }
    }

    public boolean hayComidaDelante() {
        int aux;
        switch (this.direccion) {
            case ARRIBA:
                if (this.fila == 0)
                    aux = SingletonMapa.getInstance().getFilas() - 1;
                else
                    aux = this.fila - 1;
                if (SingletonMapa.getInstance().getCasilla(aux, this.columna) == Mapa.tipo.COMIDA)
                    return true;
                break;
            case DERECHA:
                if (this.columna.equals(SingletonMapa.getInstance().getColumnas() - 1))
                    aux = 0;
                else
                    aux = this.columna + 1;
                if (SingletonMapa.getInstance().getCasilla(this.fila, aux) == Mapa.tipo.COMIDA)
                    return true;
                break;
            case ABAJO:
                if (this.fila.equals(SingletonMapa.getInstance().getFilas() - 1))
                    aux = 0;
                else
                    aux = this.fila + 1;
                if (SingletonMapa.getInstance().getCasilla(aux, this.columna) == Mapa.tipo.COMIDA)
                    return true;
                break;
            case IZQUIERDA:
                if (this.columna == 0)
                    aux = SingletonMapa.getInstance().getColumnas() - 1;
                else
                    aux = this.columna - 1;
                if (SingletonMapa.getInstance().getCasilla(this.fila, aux) == Mapa.tipo.COMIDA)
                    return true;
                break;
        }
        return false;
    }
}
