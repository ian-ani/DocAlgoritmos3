package es.iesmz.ed.algoritmos;

/* LIBRERIAS */

import java.util.ArrayList;

/**
 * Clase CalculoMental que calcula una secuencia de sumas y restas dadas, mostrando cada operación intermedia.
 * @author Iris Auñón Navarro
 */

public class CalculoMental {
    /* ATRIBUTOS */

    // Constantes
    private static final String kREGEX_VALORES = "(?=[+-])";

    // Variables
    private String secuencia;

    /* CONSTRUCTOR */

    /**
     * Constructor para guardar las operaciones a calcular.
     * @param secuencia String; este parámetro recibe una secuencia de números a calcular.
     */

    public CalculoMental(String secuencia) {
        this.secuencia = secuencia;
    }

    /* GETTERS */

    /**
     * Método que devuelve la secuencia de números.
     * @return secuencia: String; devuelve la secuencia de números.
     */

    public String getSecuencia() {
        return secuencia;
    }

    /* SETTERS */

    /**
     * Método que cambia el valor de la secuencia.
     * @param secuencia String[]; cambia una secuencia por otra.
     */

    public void setSecuencia(String secuencia) {
        if (secuencia == null || secuencia.isBlank()) {
            throw new IllegalArgumentException("La secuencia de números a operar no puede ser nula ni estar vacía.");
        }

        this.secuencia = secuencia;
    }

    /* METODO TOSTRING */

    /**
     * Método toString. Para poder mostrar la secuencia guardada.
     * @return String; muestra la secuencia.
     */

    @Override
    public String toString() {
        return String.format("Secuencia a operar: %s\n", secuencia);
    }

    /* OTROS METODOS */

    /**
     * Método calcula. Permite calcular una secuencia de operaciones y obtener sus resultados intermedios.
     * @return ArrayList de tipo String; devuelve los cálculos intermedios de la secuencia dada.
     */

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

    /**
     * Método formatearCalcula. Muestra las operaciones de la secuencia con formato.
     * @return String; devuelve las operaciones intermedias con formato.
     */

    public String formatearCalcula() {
        String calculos;

        // Anadir comas entre los numeros
        calculos = String.join(", ", calcula());

        // Anadir punto final
        calculos += ".";

        return calculos;
    }
}
