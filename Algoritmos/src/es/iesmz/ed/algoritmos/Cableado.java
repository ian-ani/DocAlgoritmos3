package es.iesmz.ed.algoritmos;

/* LIBRERIAS */

import java.util.Arrays;

/**
 * Clase Cableado que comprueba si hay el mismo número de conectores macho y conectores hembra.
 * @author Iris Auñón Navarro
 */

public class Cableado {
    /* ATRIBUTOS */

    private String[] conectores;

    /* CONSTRUCTOR */

    /**
     * Constructor para guardar los conectores a comprobar.
     * @param conectores String[]; este parámetro recibe un array de conectores a comprobar.
     */

    public Cableado(String[] conectores) {
        setConectores(conectores);
    }

    /* GETTERS */

    /**
     * Método que devuelve el array de conectores.
     * @return conectores: String[]; devuelve el array de conectores.
     */

    public String[] getConectores() {
        return conectores;
    }

    /* SETTERS */

    /**
     * Método que cambia el valor de los conectores.
     * @param conectores String[]; cambia el array de conectores por otro.
     */

    public void setConectores(String[] conectores) {
        if (conectores == null) {
            throw new IllegalArgumentException("El vector de conectores no puede ser nulo.");
        }

        this.conectores = conectores;
    }

    /* METODO TOSTRING */

    /**
     * Método toString. Para poder mostrar los conectores guardados.
     * @return String; muestra los conectores.
     */

    @Override
    public String toString() {
        return String.format("""
                Cables: %s
                """, Arrays.toString(conectores));
    }

    /* OTROS METODOS */

    /**
     * Método sePuedeConectar. Permite comprobar si hay un mismo número de conectores macho (M) y hembra (H).
     * @return boolean; devuelve si hay el mismo número de conectores macho y hembra.
     */

    public boolean sePuedeConectar() {
        // Inicio de valores
        int conectoresHembra = 0;
        int conectoresMacho = 0;

        // Bucle del array
        for (int i = 0; i < conectores.length; i++) {
            // Bucle de los strings (valores) del array
            for (int j = 0; j < conectores[i].length(); j++) {
                if (conectores[i].charAt(j) == 'H') {
                    conectoresHembra++;
                } else if (conectores[i].charAt(j) == 'M') {
                    conectoresMacho++;
                }
            }
        }

        // Comprobar si hay el mismo numero de conectores macho y conectores hembra
        return conectoresHembra == conectoresMacho;
    }
}
