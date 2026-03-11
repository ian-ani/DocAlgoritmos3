package es.iesmz.ed.algoritmos;

/* LIBRERIAS */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Tests unitarios de DividirFactoriales
 * @author Iris Auñón Navarro
 */

public class DividirFactorialTest {
    /**
     * Método dividirFactoriales. Comprueba si la división entre un numerador y un denominador
     * devuelve el resultado esperado.
     * @see DividirFactorial#division()
     */

    @Test
    public void dividirFactoriales() {
        long[] numeradores = {5, 6};
        long[] denominadores = {3, 3};
        long[] resultado = {20, 120};

        for (int i = 0; i < numeradores.length; i++) {
            assertEquals(resultado[i], new DividirFactorial(numeradores[i], denominadores[i]).division());
        }
    }
}
