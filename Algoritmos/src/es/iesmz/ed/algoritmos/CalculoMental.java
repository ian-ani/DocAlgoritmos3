package es.iesmz.ed.algoritmos;

import java.util.ArrayList;

public class CalculoMental {
    /* ATRIBUTOS */

    // Constantes
    private static final int kMAX_VALOR = 200000;
    //private static final String kREGEX_VALORES = "(?:[+-]?\\s?\\d+)";
    private static final String kREGEX_VALORES = "(\\s?[^\\d+-])";

    // Variables
    private String secuencia;

    /* CONSTRUCTOR */

    public CalculoMental(String secuencia) {
        this.secuencia = secuencia;
    }

    /* GETTERS */

    public String getSecuencia() {
        return secuencia;
    }

    /* SETTERS */

    public void setSecuencia(String secuencia) {
        if (secuencia == null || secuencia.isBlank()) {
            throw new IllegalArgumentException("La secuencia de números a operar no puede ser nula ni estar vacía.");
        }

        this.secuencia = secuencia;
    }

    /* METODO TOSTRING */

    @Override
    public String toString() {
        return String.format("Secuencia a operar: %s\n", secuencia);
    }

    /* OTROS METODOS */

    // TODO: return ArrayList<String>
    public void calcula() {
        // Prueba: 15 + 8 − 7 + 10 − 3
        // Debe devolver: 23, 16, 26, 23.

        // Validar que la suma no sea mayor a 200000, ni ninguno de sus valores?

        // Separar por valores (incluido el simbolo)
        String[] separarSecuencia = secuencia.split(kREGEX_VALORES);

        // Iterar por cada elemento
        for (String s: separarSecuencia) {
            System.out.println(s);
        }
    }
}
