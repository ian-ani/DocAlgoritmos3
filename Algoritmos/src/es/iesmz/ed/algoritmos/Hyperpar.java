package es.iesmz.ed.algoritmos;

/**
 * Clase Hyperpar que comprueba si un número es Hyperpar o no.
 * Para que un número sea Hyperpar, todos sus dígitos deben ser pares.
 * @author Iris Auñón Navarro
 */

public class Hyperpar {
    /* ATRIBUTOS */

    private long numero;

    /* CONSTRUCTOR */

    /**
     * Constructor para guardar el número a comprobar.
     * @param numero long; este parámetro recibe el número a comprobar.
     */
    public Hyperpar(long numero) {
        this.numero = numero;
    }

    /* GETTERS */

    /**
     * Método que devuelve el número del objeto.
     * @return numero: long; devuelve el número a comprobar.
     */

    public long getNumero() {
        return numero;
    }

    /* SETTERS */

    /**
     * Método que cambia el valor del número.
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
     * Método que comprueba si un número es Hyperpar o no. Dicho número es Hyperpar si todos sus dígitos son pares.
     * @return boolean; devuelve true si todos los números son true, devuelve false en el primer número
     * que no lo sea.
     */

    public boolean esHyperPar() {
        // Declarar array de 'digitos' de tipo booleano teniendo como tamano el largo del numero (pasado a String)
        boolean[] digitos = new boolean[String.valueOf(numero).length()];
        // Variable usada como indice para el bucle while
        int i = 0;

        // Copia de 'numero' para no reemplazar el numero real
        long tmp = numero;

        // Mientras 'tmp' sea mayor a 0 (tmp es la copia del numero real)
        while (tmp > 0) {
            // Guardar el ultimo digito
            long digito = tmp % 10;

            // Comprobar si es divisible entre 2 (par) o no, si lo es guardar el booleano en el array
            if (digito % 2 == 0) {
                digitos[i] = true;
            } else {
                digitos[i] = false;
            }

            // Incrementar variable de cuenta (para guardar en el array)
            i++;

            // Se divide el numero entre 10 para discriminar la parte decimal
            tmp = tmp / 10;
        }

        // Recorrer array de numeros con valores booleanos
        for (int j = 0; j < digitos.length; j++) {
            // En el primer momento que encuentra un numero impar, retorna 'false' porque ya no es hyperpar
            if (!digitos[j]) {
                return false;
            }
        }

        // Si llega hasta aqui, es hyperpar
        return true;
    }
}
