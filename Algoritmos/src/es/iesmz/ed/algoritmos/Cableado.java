package es.iesmz.ed.algoritmos;

import java.util.Arrays;

public class Cableado {
    /* ATRIBUTOS */

    private String[] conectores;

    /* CONSTRUCTOR */

    public Cableado(String[] conectores) {
        setConectores(conectores);
    }

    /* GETTERS */

    public String[] getConectores() {
        return conectores;
    }

    /* SETTERS */

    public void setConectores(String[] conectores) {
        if (conectores == null) {
            throw new IllegalArgumentException("El vector de conectores no puede ser nulo.");
        }

        this.conectores = conectores;
    }

    /* METODO TOSTRING */

    @Override
    public String toString() {
        return String.format("""
                Cables: %s
                """, Arrays.toString(conectores));
    }

    /* OTROS METODOS */

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
