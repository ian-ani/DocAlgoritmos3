package es.iesmz.ed.algoritmos;

/**
 * Clase SumaDescendente para obtener la suma de los números resultantes al quitar de forma reiterada el dígito más
 * significativo del número dado.
 * @author Iris Auñón Navarro
 */

public class SumaDescendente {
    /* ATRIBUTOS */

    private long numero;

    /* CONSTRUCTOR */

    /**
     * Constructor para guardar el número a calcular.
     * @param numero long; recibe el número entero.
     */

    public SumaDescendente(long numero) {
        setNumero(numero);
    }

    /* GETTERS */

    /**
     * Método que devuelve el número.
     * @return numero: long; devuelve el número.
     */

    public long getNumero() {
        return numero;
    }

    /* SETTERS */

    /**
     * Método que cambia el número actual por otro.
     * @param numero long; cambia el número actual por otro.
     */

    public void setNumero(long numero) {
        this.numero = numero;
    }

    /* METODO TOSTRING */

    /**
     * Método toString. Muestra el número.
     * @return String; número.
     */

    @Override
    public String toString() {
        return String.format("Número: %d", numero);
    }

    /* OTROS METODOS */

    /**
     * Método suma. Devuelve la suma de los dígitos en bloques.
     * @return long; resultado la suma del set de dígitos.
     */

    public long suma() {
        String numStr = String.valueOf(this.numero);
        long suma = 0;

        for (int i = 0; i < numStr.length(); i++) {
            suma += Long.parseLong(numStr.substring(i));
        }

        return suma;
    }
}
