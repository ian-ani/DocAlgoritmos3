package es.iesmz.ed.algoritmos;

/* LIBRERIAS */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Tests unitarios de CalculoMental
 * @author Iris Auñón Navarro
 */

public class CalculoMentalTest {
    /**
     * Método comprobarCalculo. Comprueba si las operaciones proporcionadas dan el resultado esperado.
     * @see CalculoMental#calcula()
     * @see CalculoMental#formatearCalcula()
     */

    @Test
    public void comprobarCalculo() {
        String[] operaciones = {"15 + 8 - 7 + 10 - 3",
                                "200 + 9 - 65 + 22 - 50 + 800",
                                "45 - 96 + 78 + 100"};
        String[] resultados = {"23, 16, 26, 23.",
                                "209, 144, 166, 116, 916.",
                                "-51, 27, 127."};

        for (int i = 0; i < operaciones.length; i++) {
            assertEquals(resultados[i], new CalculoMental(operaciones[i]).formatearCalcula());
        }
    }
}
