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
