package Practica3;

public class Hormiga {

    private Integer fila;
    private Integer columna;
    private Direccion direccion;

    public static enum Direccion {
        ARRIBA, DERECHA, ABAJO, IZQUIERDA
    }

    public static enum Giro {
        DERECHA, IZQUIERDA
    }

    public Hormiga(){
        this.fila = 0;
        this.columna = 0;
        this.direccion = Direccion.DERECHA;
    }

    public void avanza(){
        switch (direccion){
            case ARRIBA:
                this.fila--;
                if(this.fila == -1)
                    this.fila = Mapa.filas - 1;
                break;
            case DERECHA:
                this.columna++;
                if(this.columna == Mapa.columnas)
                    this.columna = 0;
                break;
            case ABAJO:
                this.fila++;
                if(this.fila == Mapa.filas)
                    this.fila = 0;
                break;
            case IZQUIERDA:
                this.columna--;
                if(this.columna == -1)
                    this.columna = Mapa.columnas - 1;
                break;
        }
    }

    public void girar(Giro giro){
        switch (giro){

        }
    }
}
