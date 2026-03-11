package es.iesmz.ed.algoritmos;

/* LIBRERIAS */

import java.util.ArrayList;

public class CalculoMental {
    /* ATRIBUTOS */

    // Constantes
    private static final String kREGEX_VALORES = "(?=[+-])";

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

    public ArrayList<String> calcula() {
        // ArrayList a devolver
        ArrayList<String> calculos = new ArrayList<>();

        // Eliminar espacios
        secuencia = secuencia.replaceAll(" ", "");

        // Separar por valores (los valores tienen el simbolo incluido)
        String[] separarSecuencia = secuencia.split(kREGEX_VALORES);

        // Acumulacion de operaciones (empezando el total con el primer numero)
        // Si no se hiciera asi y se inicializara a 0, aunque no cambia el resultado
        // Si se mostraria como operacion parcial
        int total = Integer.parseInt(separarSecuencia[0]);

        // Iterar por cada elemento (empezando despues del primer numero)
        for (int i = 1; i < separarSecuencia.length; i++) {
            // El metodo parseInt interpreta el simbolo del numero
            // Asi que al sumar, si es negativo aplica la regla que toca
            total += Integer.parseInt(separarSecuencia[i]);

            // Anadir al ArrayList
            calculos.add(String.valueOf(total));
        }

        return calculos;
    }

    public String formatearCalcula() {
        String calculos;

        // Anadir comas entre los numeros
        calculos = String.join(", ", calcula());

        // Anadir punto final
        calculos += ".";

        return calculos;
    }
}
