package Practica3;

public class SingletonMapa {
    //Como el mapa es estatico, esto deberia mejorar bastante el rendimiento
    private static Mapa mapa;

    public static Mapa getInstance(){
        if(mapa == null){
            mapa = new Mapa();
        }
        return mapa;
    }

}
