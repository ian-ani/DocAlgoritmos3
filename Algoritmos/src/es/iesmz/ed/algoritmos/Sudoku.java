package es.iesmz.ed.algoritmos;

/* LIBRERIAS */

import java.util.HashSet;
import java.util.Set;

public class Sudoku {
    /* ATRIBUTOS */

    int[][] tabla;

    /* CONSTRUCTOR */

    public Sudoku(int[][] tabla) {
        this.tabla = tabla;
    }

    /* GETTERS */

    public int[][] getTabla() {
        return tabla;
    }

    /* SETTERS */

    public void setTabla(int[][] tabla) {
        this.tabla = tabla;
    }

    /* METODO TOSTRING */

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

    public boolean esCorrecto() {
        // Los Set no admiten duplicados :)
        Set<Integer> numerosFila = new HashSet<>();
        Set<Integer> numerosColumna = new HashSet<>();

        // Recorrer filas, luego columnas -> fila fija, columna varia
        for (int fila = 0; fila < tabla.length; fila++) {
            for (int columna = 0; columna < tabla[fila].length; columna++) {
                // Siempre es tabla[fila][columna], aunque...
                numerosColumna.add(tabla[fila][columna]);
            }

            // Si el tamano del Set no es 9 al final de la iteracion de columnas (bucle interno),
            // es porque el Set ha tenido algun numero repetido
            if (numerosColumna.size() < 9) {
                return false;
            }

            // Reiniciar Set en cada iteracion exterior
            numerosColumna = new HashSet<>();
        }

        // Recorrer columnas, luego filas -> columna fija, fila varia
        for (int columna = 0; columna < tabla.length; columna++) {
            for (int fila = 0; fila < tabla[columna].length; fila++) {
                // ...el orden cambie
                numerosFila.add(tabla[fila][columna]);
            }

            // Si el tamano del Set no es 9 al final de la iteracion de filas (bucle interno),
            // es porque el Set ha tenido algun numero repetido
            if (numerosFila.size() < 9) {
                return false;
            }

            // Reiniciar Set en cada iteracion exterior
            numerosFila = new HashSet<>();
        }

        // Nota: no compruebo el 3x3 porque no hace falta, si hay un duplicado en un 3x3 es
        // que en una fila o en una columna tambien lo va a haber

        // Si llega hasta aqui, to-do ha debido ir bien
        return true;
    }
}
