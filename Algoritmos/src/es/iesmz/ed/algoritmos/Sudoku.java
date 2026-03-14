package es.iesmz.ed.algoritmos;

/* LIBRERIAS */

import java.util.HashSet;
import java.util.Set;

/**
 * Clase Sudoku que comprueba si el sudoku proporcinado es correcto (en base a filas, columnas y bloques 3x3) o no.
 * @author Iris Auñón Navarro
 */

public class Sudoku {
    /* ATRIBUTOS */

    int[][] tabla;

    /* CONSTRUCTOR */

    /**
     * Constructor para guardar la tabla del sudoku.
     * @param tabla int[][]; este parámetro recibe una matriz de filas y columnas a comprobar dentro de la tabla.
     */

    public Sudoku(int[][] tabla) {
        setTabla(tabla);
    }

    /* GETTERS */

    /**
     * Método que devuelve la tabla en forma de matriz.
     * @return tabla: int[][]; devuelve el sudoku guardado.
     */

    public int[][] getTabla() {
        return tabla;
    }

    /* SETTERS */

    /**
     * Método que cambia la tabla del sudoku.
     * @param tabla int[][]; cambia un sudoku por otro.
     */

    public void setTabla(int[][] tabla) {
        this.tabla = tabla;
    }

    /* METODO TOSTRING */

    /**
     * Método toString. Para poder mostrar el sudoku formateado.
     * @return String; muestra el sudoku guardado.
     */

    @Override
    public String toString() {
        StringBuilder formato = new StringBuilder();

        // Dibujar una linea antes de empezar
        formato.append("---------------------------------------\n");

        for (int fila = 0; fila < tabla.length; fila++) {
            // En la primera columna
            formato.append("| ");

            for (int columna = 0; columna < tabla[fila].length; columna++) {
                if ((columna + 1) % 3 == 0 && columna < tabla.length - 1) {
                    // Cada tres columnas
                    formato.append(tabla[fila][columna]).append(" || ");
                } else {
                    formato.append(tabla[fila][columna]).append(" | ");
                }
            }

            // Salto de linea
            formato.append("\n");

            if ((fila + 1) % 3 == 0 && fila < tabla.length - 1) {
                // Cada tres filas
                formato.append("=======================================\n");
            } else {
                formato.append("---------------------------------------\n");
            }
        }

        return formato.toString();
    }

    /* OTROS METODOS */

    /**
     * Método esCorrecto. Permite comprobar si un sudoku dado es correcto: para ser correcto debe tener números del
     * 1 al 9 tanto por cada fila como por cada columna, y también en bloques de 3x3. No admite repetidos en ninguna
     * de ellas.
     * @return boolean; devuelve si el sudoku dado es correcto.
     */

    public boolean esCorrecto() {
        // Los Set no admiten duplicados :)
        Set<Integer> numerosFila = new HashSet<>();
        Set<Integer> numerosColumna = new HashSet<>();
        Set<Integer> numerosBloque = new HashSet<>();

        // Recorrer filas, luego columnas -> fila fija, columna varia
        for (int fila = 0; fila < tabla.length; fila++) {
            for (int columna = 0; columna < tabla[fila].length; columna++) {
                // Inicializar celda
                int celda = tabla[fila][columna];

                // Comprobar que este dentro del rango de 1 a 9
                if (celda < 1 || celda > 9) return false;

                // Si no puede insertar el valor en el set, es porque ya existe
                // Siempre es tabla[fila][columna], aunque...
                if (!numerosColumna.add(celda)) return false;
            }

            // Reiniciar Set en cada iteracion exterior
            numerosColumna.clear();
        }

        // Recorrer columnas, luego filas -> columna fija, fila varia
        for (int columna = 0; columna < tabla.length; columna++) {
            for (int fila = 0; fila < tabla[columna].length; fila++) {
                // Inicializar celda
                int celda = tabla[fila][columna];

                // Comprobar que este dentro del rango de 1 a 9
                if (celda < 1 || celda > 9) return false;

                // ...el orden cambie
                if (!numerosFila.add(celda)) return false;
            }

            // Reiniciar Set en cada iteracion exterior
            numerosFila.clear();
        }

        // Comprobar tambien el 3x3
        // 'Saltos' de 3 en 3
        for (int fila = 0; fila < tabla.length; fila+=3) {
            for (int columna = 0; columna < tabla[fila].length; columna+=3) {
                // 'Rango' de 3
                for (int bloqueFila = 0; bloqueFila < tabla[fila].length / 3; bloqueFila++) {
                    for (int bloqueColumna = 0; bloqueColumna < tabla[fila].length / 3; bloqueColumna++) {
                        // Desplazamiento dentro del bloque (celda)
                        // Parecido al desplazamiento en filtros de imagen pero sin restar nada (la referencia
                        // del sudoku es la esquina superior izquierda y no el centro del kernel/bloque)
                        int celda = tabla[bloqueFila + fila][bloqueColumna + columna];

                        // Comprobar que este dentro del rango de 1 a 9
                        if (celda < 1 || celda > 9) return false;

                        // Comprobar si duplicado
                        if (!numerosBloque.add(celda)) return false;
                    }
                }

                // Reiniciar Set en cada iteracion exterior
                numerosBloque.clear();
            }
        }

        // Si llega hasta aqui, to-do ha debido ir bien
        return true;
    }
}
