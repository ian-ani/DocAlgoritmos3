package es.iesmz.ed.algoritmos;

/* LIBRERIAS */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests unitarios de AnnoTest
 * @author Iris Auñón Navarro
 */

public class AnnoTest {
    /**
     * Método comprobarDigitos. Comprueba si los años proporcionados tienen el número de dígitos diferentes esperado.
     * @see Anno#digitosDiferentes()
     */

    @Test
    public void comprobarDigitos() {
        long[] annos = {1999, 1998, 2000, 1994, 1982, 345, 668};
        long[] digitos = {2, 3, 2, 3, 4, 3, 2};

        for (int i = 0; i < annos.length; i++) {
            assertEquals(digitos[i], new Anno(annos[i]).digitosDiferentes());
        }
    }
}
