package Comun.Algoritmo;

import Comun.Funcion.Funcion;
import Comun.Poblacion.Individuo;
import Comun.Poblacion.Poblacion;
import Comun.Vista.Vista;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AlgoritmoParalelos extends AlgoritmoGenetico {
    private int totalIslas;
    private int islasOperando;
    private int epocas;
    private int epocaActual;

    private volatile Poblacion[] poblaciones;
    private List<Isla> islas;
    private List<List<Generacion>> generaciones;

    public AlgoritmoParalelos(Vista vista, int nhebras, int nepoch) {
        super(vista);

        this.totalIslas = nhebras;
        this.islasOperando = nhebras;
        this.epocas = nepoch;

    }

    public void paralelizarAlgoritmo(int funcion, int paramsFuncion, int poblacionSize, int numGeneraciones,
                                     String seleccion, String cruce, String mutacion,
                                     double probabilidadCruce, double probabilidadMutacion, double precision,
                                     boolean elitismo, double percentElitismo, double parametroTruncProb,
                                     int parametroCruce, int ciudadInicio) {

        epocaActual = 0;
        poblaciones = new Poblacion[totalIslas];
        islas = new ArrayList<>();
        generaciones = new ArrayList<>();

        int nindividuos = poblacionSize / totalIslas;
        int nejecuciones = numGeneraciones / epocas;

        //Creamos la funcion correspondiente
        Funcion f = crearFuncion(funcion);

        //Inicializamos los parametros que necesitar� la funcion de cruce
        List<Double> paramsCruce = new ArrayList<>();
        paramsCruce.add(probabilidadCruce);
        paramsCruce.add((double) parametroCruce);

        //Inicializamos los parametros que necesitar� la funcion de mutacion
        List<Double> paramsMutacion = new ArrayList<>();
        paramsMutacion.add(probabilidadMutacion);
        paramsMutacion.addAll(f.getIntervalo());

        //Inicializamos las poblaciones
        for (int i = 0; i < totalIslas; i++) {
            poblaciones[i] = new Poblacion();
            inicalizarPoblacion(poblaciones[i], nindividuos, precision, funcion, paramsFuncion, ciudadInicio);
        }

        //Creamos las islas
        for (int i = 0; i < totalIslas; i++) {
            List<Generacion> generacions = new ArrayList<>();
            generaciones.add(generacions);
            islas.add(new Isla(this, paramsCruce, paramsMutacion, f, poblaciones[i], elitismo, nejecuciones, percentElitismo, parametroTruncProb, seleccion, cruce, mutacion, generacions, i, epocas));
        }

        //Lanzar x algoritmos por nejecucion generaciones, un numero nepoch veces
        for (Isla isla : islas)
            isla.start();
    }


    /**
     * SE LLAMA CADA VEZ QUE UNA ISLA HA TERMINADO SU ÉPOCA
     * Comprueba si aún hay procesos (islas) operando. Cuando no queda ninguno, migra las poblaciones entre sí.
     *
     * @param poblacion
     * @param islaID
     * @param generaciones
     */
    public void done(Poblacion poblacion, int islaID, List<Generacion> generaciones,
                     List<Double> paramsCruce, List<Double> paramsMutacion, Funcion f, boolean elitismo,
                     int nejecuciones, double percentElitismo, double parametroTruncProb,
                     String seleccion, String cruce, String mutacion) {
        //System.out.println("Funcion done de la isla " + islaID + " en la epoca " + epocaActual);
        this.islasOperando--;

        synchronized (this.islas.get(islaID)) {
            //¿Todas las islas han acabado su epoca de evolucion?
            if (this.islasOperando == 0) {
                epocaActual++;

                migrar(paramsCruce, paramsMutacion, f, elitismo, nejecuciones, percentElitismo, parametroTruncProb, seleccion, cruce, mutacion);

                //Si esta era la última época
                if (epocaActual == epocas)
                    mostrarSoluciones();
            } else {
                try {
                    this.islas.get(islaID).wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * SE LLAMA CUANDO TODAS LAS ISLAS TERMINAN UNA EPOCA
     * Coge algunos individuos al azar de las islas y los intercambia con otras islas para aumentar la diversidad.
     */
    private void migrar(List<Double> paramsCruce, List<Double> paramsMutacion, Funcion f, boolean elitismo,
                        int nejecuciones, double percentElitismo, double parametroTruncProb,
                        String seleccion, String cruce, String mutacion) {


        //System.out.println("Inicio funcion migrar en la epoca " + (epocaActual - 1));

        islasOperando = totalIslas;

        List<List<Individuo>> pobs = new ArrayList<>();

        /**
         * Se extraen un numero aleatorio de individuos de las islas
         * (un 10%)
         */

        for (Poblacion p : poblaciones) {
            List<Individuo> pob = new ArrayList<>();

            for (int i = 0; i < p.getPoblacion().size() / 10; i++) {
                int random = ThreadLocalRandom.current().nextInt(0, p.getPoblacion().size());
                //Si se da el caso en que no hay tantos individuos diferentes, deberemos resignarnos a repetir miembros
                //Tras 100 bucles buscando miembros, suponemos que ya no hay ninguno diferente
                int secure_count = 0;
                while (pob.contains(p.getPoblacion().get(random)) && secure_count < 100) {
                    random = ThreadLocalRandom.current().nextInt(0, p.getPoblacion().size());
                    secure_count++;
                }
                pob.add(new Individuo(p.getPoblacion().get(random)));
            }
            pobs.add(pob);
        }

        /**MIGRACION EN CIRCULO EXCLUSIVAMENTE
         * POSIBILIDAD DE AMPLIACION AQUI
         */

        for (int i = 0; i < totalIslas; i++) {
            int target = i + 1;
            if (target == totalIslas)
                target = 0;

            poblaciones[i].substitute(pobs.get(target));
        }


        //System.out.println("Fin funcion migrar en la epoca " + (epocaActual - 1));

        for (Isla isla : islas) {
            synchronized (isla) {
                isla.notify();
            }
        }
    }

    /**
     * Cuando todas las islas acaban todas las epicas, se llama a la grafica con los datos combinados de todas las islas.
     */

    private void mostrarSoluciones() {
        //System.out.println("Fin del algoritmo");
        int numGeneraciones = generaciones.get(0).size();
        double maxAbs = Double.NEGATIVE_INFINITY;
        List<Double> sols = new ArrayList();

        double[] mejorAbsoluto = new double[numGeneraciones];
        double[] mejor = new double[numGeneraciones];
        double[] media = new double[numGeneraciones];
        double[] peor = new double[numGeneraciones];


        for (int i = 0; i < numGeneraciones; i++) {
            double mejor_total = Double.NEGATIVE_INFINITY;
            double media_total = 0;
            double peor_total = Double.POSITIVE_INFINITY;

            for (int n = 0; n < totalIslas; n++) {
                List<Generacion> gen = generaciones.get(n);


                if (maxAbs < gen.get(i).getMejor()) {
                    maxAbs = gen.get(i).getMejor();
                    sols = gen.get(i).getSolucion();
                }

                if (gen.get(i).getMejor() > mejor_total)
                    mejor_total = gen.get(i).getMejor();

                if (gen.get(i).getPeor() < peor_total)
                    peor_total = gen.get(i).getPeor();

                media_total += gen.get(i).getMedia();
            }

            mejorAbsoluto[i] = maxAbs;
            mejor[i] = mejor_total;
            media[i] = media_total / totalIslas;
            peor[i] = peor_total;
        }
        this.vista.mostrarGrafica(mejorAbsoluto, mejor, media, peor, maxAbs, sols);
    }

}

