package com.example.proyecto_final.modelo.floydWarshall;

// Programa en Java para el algoritmo de Floyd Warshall para encontrar todos los caminos más cortos entre pares de vértices
import java.io.*;
import java.lang.*;
import java.util.*;

class TodosLosCaminosCortosEntrePares {
    final static int INF = 99999, V = 4;

    void floydWarshall(int dist[][]) {

        int i, j, k;

        /*
         * Agrega todos los vértices uno por uno
         * al conjunto de vértices intermedios.
         * ---> Antes de comenzar una iteración,
         * tenemos distancias más cortas
         * entre todos los pares de vértices de manera que
         * las distancias más cortas consideran
         * solo los vértices en el conjunto {0, 1, 2, .. k-1}
         * como vértices intermedios.
         * ----> Después del final de una iteración,
         * el vértice nro. k se agrega
         * al conjunto de vértices intermedios y
         * el conjunto se convierte en {0, 1, 2, .. k}
         */
        for (k = 0; k < V; k++) {
            // Elige todos los vértices como fuente uno por uno
            for (i = 0; i < V; i++) {
                // Elige todos los vértices como destino para
                // la fuente seleccionada anteriormente
                for (j = 0; j < V; j++) {
                    // Si el vértice k está en el camino más corto
                    // de i a j, actualiza el valor de
                    // dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        // Imprime la matriz de distancias más cortas
        imprimirSolucion(dist);
    }

    void imprimirSolucion(int dist[][]) {
        System.out.println(
                "La siguiente matriz muestra las distancias más cortas "
                        + "entre cada par de vértices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Código del programa principal
    public static void main(String[] args) {
        /*
         * Creemos el siguiente grafo ponderado
         * 10
         * (0)------->(3)
         * | /|\
         * 5 | |
         * | | 1
         * \|/ |
         * (1)------->(2)
         * 3
         */
        int grafo[][] = { { 0, 5, INF, 10 },
                { INF, 0, 3, INF },
                { INF, INF, 0, 1 },
                { INF, INF, INF, 0 } };
        TodosLosCaminosCortosEntrePares a = new TodosLosCaminosCortosEntrePares();

        // Llamada a la función
        a.floydWarshall(grafo);
    }
}

