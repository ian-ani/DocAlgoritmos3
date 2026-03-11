package es.iesmz.ed.algoritmos;

/* LIBRERIAS */

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Tests unitarios de Hyperpar
 * @author Iris Auñón Navarro
 */

public class HyperparTest {
    /**
     * Método esHyperpar. Comprueba si el número proporcionado es hyperpar.
     * @see Hyperpar#esHyperPar()
     */

    @Test
    public void esHyperpar() {
        Hyperpar hyper = new Hyperpar(2068);
        assertTrue(hyper.esHyperPar());
    }

    /**
     * Método noEsHyperpar. Comprueba si el número proporcionado no es hyperpar.
     * @see Hyperpar#esHyperPar()
     */

    @Test
    public void noEsHyperpar() {
        Hyperpar hyper = new Hyperpar(2568);
        assertFalse(hyper.esHyperPar());
    }
}
