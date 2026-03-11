package es.iesmz.ed.algoritmos;

/* LIBRERIAS */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests unitarios de Cableado
 * @author Iris Auñón Navarro
 */

public class CableadoTest {
    /**
     * Método seConectan. Comprueba que haya la misma suma de conectores macho que de conectores hembra.
     * @see Cableado#sePuedeConectar()
     */

    @Test
    public void seConectan() {
        String[] conectores = {"HM", "HH", "MM", "HH", "MM", "HM"};
        Cableado cables = new Cableado(conectores);

        assertTrue(cables.sePuedeConectar());
    }

    /**
     * Método noSeConectan. Comprueba que no haya la misma suma de conectores macho que de conectores hembra.
     * @see Cableado#sePuedeConectar()
     */

    @Test
    public void noSeConectan() {
        String[] conectores = {"MM", "HH", "MM", "HM"};
        Cableado cables = new Cableado(conectores);

        assertFalse(cables.sePuedeConectar());
    }
}
