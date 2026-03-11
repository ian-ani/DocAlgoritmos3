package es.iesmz.ed.algoritmos;

/**
 * Clase DividirFactorial para obtener la división entre un numerador y un denominador con combinatoria.
 * @author Iris Auñón Navarro
 */

public class DividirFactorial {
    /* ATRIBUTOS */

    private long numerador;
    private long denominador;

    /* CONSTRUCTOR */

    /**
     * Constructor para guardar número a calcular.
     * @param numerador long; recibe el numerador de la división.
     * @param denominador long; recibe el denominador de la división.
     */

    public DividirFactorial(long numerador, long denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    /* GETTERS */

    /**
     * Método que devuelve el numerador.
     * @return numerador: long; devuelve el numerador.
     */

    public long getNumerador() {
        return numerador;
    }

    /**
     * Método que devuelve el denominador.
     * @return denominador: long; devuelve el denominador.
     */

    public long getDenominador() {
        return denominador;
    }

    /* SETTERS */

    /**
     * Método que cambia el numerador de la operación.
     * @param numerador long; cambia el numerador por otro.
     */

    public void setNumerador(long numerador) {
        this.numerador = numerador;
    }

    /**
     * Método que cambia el denominador de la operación.
     * @param denominador long; cambia el denominador por otro.
     */

    public void setDenominador(long denominador) {
        this.denominador = denominador;
    }

    /* METODO TOSTRING */

    /**
     * Método toString. Muestra numerador y denominador.
     * @return String; Numerador y denominador con formato.
     */

    @Override
    public String toString() {
        return String.format("%d! / %d!", numerador, denominador);
    }

    /* OTROS METODOS */

    /**
    * Método division. Devuelve la división entre n! / k! (sin dividir).
    * @return long; resultado de n! / k! con combinatoria.
    */

    public long division() {
        // n! / (k! * (n - k)!)
        // Pero los factoriales se hacen muy grandes, computacionalmente es horrendo
        // Entonces se simplifica la expresion donde si 6! / 3! se elimina lo 'comun' que tienen ambos
        // 6,5,4,3,2,1 y 3,2,1 -> se elimina 3,2,1 y nos quedamos con 6,5,4 que pasa a 6 * 5 * 4 = 120

        // No hace falta calcular el 0, asi que se puede empezar desde 1
        long res = 1;

        // Empieza en el numerador y baja hasta el denominador, de 1 en 1
        // Si n = 6!, k = 3! pasa por 6,5,4 y llega hasta 3 (no incluido)
        for (long i = numerador; i > denominador; i--) {
            res *= i;
        }

        return res;
    }
}
