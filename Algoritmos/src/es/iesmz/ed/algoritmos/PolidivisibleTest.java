package es.iesmz.ed.algoritmos;

/* LIBRERIAS */

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests unitarios de Polidivisible
 * @author Iris Auñón Navarro
 */

public class PolidivisibleTest {
    /**
     * Método esPolidivisible. Comprueba si el número proporcionado es hyperpar.
     * @see Polidivisible#esPolidivisible()
     */

    @Test
    public void esPolidivisible() {
        Polidivisible poli = new Polidivisible(381654729);
        assertTrue(poli.esPolidivisible());
    }

    /**
     * Método noEsPolidivisible. Comprueba si el número proporcionado no es hyperpar.
     * @see Polidivisible#esPolidivisible()
     */

    @Test
    public void noEsPolidivisible() {
        Polidivisible poli = new Polidivisible(100);
        assertFalse(poli.esPolidivisible());
    }

}
