package es.iesmz.ed.algoritmos;

/* LIBRERIAS */

import java.util.HashSet;
import java.util.Set;

/**
 * Clase Anno que comprueba si todos los dígitos de un número son diferentes o si hay alguno que coincide con otro,
 * en caso de que haya coincidencia devuelve cuantas hay.
 * @author Iris Auñón Navarro
 */

public class Anno {
    /* ATRIBUTOS */

    private long numero;

    /* CONSTRUCTOR */

    /**
     * Constructor para guardar el año a comprobar.
     * @param numero long; este parámetro recibe el año a comprobar.
     */

    public Anno(long numero) {
        this.numero = numero;
    }

    /* GETTERS */

    /**
     * Método que devuelve el año.
     * @return numero: long; devuelve el año a comprobar.
     */

    public long getNumero() {
        return numero;
    }

    /* SETTERS */

    /**
     * Método que cambia el valor del año.
     * @param numero long; cambia el año actual por otro año.
     */

    public void setNumero(long numero) {
        this.numero = numero;
    }

    /* METODO TOSTRING */

    /**
     * Método toString. Para poder mostrar el año guardado.
     * @return String; muestra el año.
     */

    @Override
    public String toString() {
        return String.format("Año: %d", numero);
    }

    /* OTROS METODOS */

    /**
     * Método digitosDiferentes. Permite calcular el número de dígitos diferentes dentro de un número, en este caso
     * en un año.
     * @return int; devuelve el número de dígitos diferentes.
     */

    public int digitosDiferentes() {
        // Crear un set (no acepta repetidos! :))
        Set<Long> digitos = new HashSet<>();

        // Copia del numero original para no sobreescribirlo
        long tmp = numero;

        // Guardar los digitos en el set
        while (tmp > 0) {
            // Obtener el ultimo digito del numero
            long ultimo = tmp % 10;

            // Guardar en el set
            digitos.add(ultimo);

            // El numero 'pierde' un digito
            tmp = tmp / 10;
        }

        // El tamano del set es el numero de digitos diferentes que hay
        return digitos.size();
    }
}
