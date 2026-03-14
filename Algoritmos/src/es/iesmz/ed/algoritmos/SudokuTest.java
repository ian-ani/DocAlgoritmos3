package es.iesmz.ed.algoritmos;

/* LIBRERIAS */

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests unitarios de Sudoku
 * @author Iris Auñón Navarro
 */

public class SudokuTest {
    /**
     * Método sudokuValido. Comprueba que el sudoku sí es válido.
     * @see Sudoku#esCorrecto()
     */

    @Test
    public void sudokuValido() {
        int[][] tabla = {
                {4, 1, 3, 8, 2, 5, 6, 7, 9},
                {5, 6, 7, 1, 4, 9, 8, 3, 2},
                {2, 8, 9, 7, 3, 6, 1, 4, 5},

                {1, 9, 5, 4, 6, 2, 7, 8, 3},
                {7, 2, 6, 9, 8, 3, 5, 1, 4},
                {3, 4, 8, 5, 1, 7, 2, 9, 6},

                {8, 5, 1, 6, 9, 4, 3, 2, 7},
                {9, 7, 2, 3, 5, 8, 4, 6, 1},
                {6, 3, 4, 2, 7, 1, 9, 5, 8}
        };
        Sudoku sudoku = new Sudoku(tabla);

        assertTrue(sudoku.esCorrecto());
    }

    /**
     * Método sudokuInvalido. Comprueba que el sudoku no es válido (falla el 3x3).
     * @see Sudoku#esCorrecto()
     */

    @Test
    public void sudokuInvalido() {
        int[][] tabla = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},

                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {5, 6, 7, 8, 9, 1, 2, 3, 4},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},

                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}
        };
        Sudoku sudoku = new Sudoku(tabla);

        assertFalse(sudoku.esCorrecto());
    }
}
