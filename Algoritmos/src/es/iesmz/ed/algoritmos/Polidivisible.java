package es.iesmz.ed.algoritmos;

/* LIBRERIAS */

import java.util.Arrays;

/**
 * Clase Polidivisible que comprueba si un número es divisible por su longitud y además el último dígito que queda
 * es un número que a su vez polidivisible también.
 * @author Iris Auñón Navarro
 */

public class Polidivisible {
    /* ATRIBUTOS */

    private long numero;

    /* CONSTRUCTOR */

    /**
     * Constructor para guardar el número a comprobar.
     * @param numero long; este parámetro recibe número a comprobar.
     */

    public Polidivisible(long numero) {
        this.numero = numero;
    }

    /* GETTERS */

    /**
     * Método que devuelve el número.
     * @return numero: long; devuelve el número a comprobar.
     */

    public long getNumero() {
        return numero;
    }

    /* SETTERS */

    /**
     * Método que cambia el el valor del número.
     * @param numero long; cambia el número actual por otro número.
     */

    public void setNumero(long numero) {
        this.numero = numero;
    }

    /* METODO TOSTRING */

    /**
     * Método toString. Para poder mostrar el número guardado.
     * @return String; muestra el número.
     */

    @Override
    public String toString() {
        return String.format("Número: %d", numero);
    }

    /* OTROS METODOS */

    /**
     * Método tieneTodosDigitos. Comprueba si el numero dado tiene todos los digitos (1 a su longitud).
     * @return boolean; devuelve si tiene todos los digitos o no.
     */

    public boolean tieneTodosDigitos(long tmp, int largo) {
        // Instanciar array de digitos que guardara todos los valores posibles a comprobar
        int[] digitos = new int[largo];

        // Llenar digitos con los valores posibles
        for (int i = 0; i < largo; i++) {
            digitos[i] = i + 1;
        }

        // Pasar 'tmp' a un array para ordenar los valores del numero
        int[] numero = new int[largo];

        // Llenar 'numero' con los digitos de 'tmp'
        for (int i = 0; i < largo; i++) {
            numero[i] = Character.getNumericValue(String.valueOf(tmp).charAt(i));
        }

        // Ordear 'numero' (es 'tmp')
        Arrays.sort(numero);

        // Comprobar si ambos arrays son iguales (tienen los mismos valores)
        return Arrays.equals(numero, digitos);
    }

    /**
     * Método esPolidivisible. Comprueba si el número es polidivisible.
     * @return boolean; devuelve si es polidivisible o no.
     */

    public boolean esPolidivisible() {
        // Copia de 'numero' para no reemplazar el numero real
        long copia = numero;

        // Comprobar si el numero actual tiene todos los digitos (38165472, largo 8 debe tener todos menos 9)
        if (!tieneTodosDigitos(copia, String.valueOf(copia).length())) return false;

        // Mientras 'copia' sea mayor a 0 (es la copia del numero real)
        while (copia > 0) {
            // Comprobar si no es polidivisible con el largo del numero
            // (comprobar si es divisible con el operador modulo)
            if ((copia % (String.valueOf(copia).length()) != 0)) return false;

            // Discriminar el ultimo digito y actualizar bucle
            copia = copia / 10;
        }

        return true;
    }
}
