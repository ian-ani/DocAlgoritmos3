package es.iesmz.ed.algoritmos.tests;

/* LIBRERIAS */

import es.iesmz.ed.algoritmos.SumaDescendente;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Tests unitarios de SumaDescendente
 * @author Iris Auñón Navarro
 */

public class SumaDescendenteTest {
    /**
     * Método sumasDescendentes. Comprueba si la suma de los números resultantes de quitar de manera reiterada
     * el dígito más significativo de un número dado es la esperada.
     * @see SumaDescendente#suma()
     */

    @Test
    public void sumasDescendentes() {
        long[] numeros = {4578, 656, 12, 9, 38693, 213853};
        long[] resultados = {5242, 718, 14, 9, 48175, 232468};

        for (int i = 0; i < numeros.length; i++) {
            assertEquals(resultados[i], new SumaDescendente(numeros[i]).suma());
        }
    }
}
