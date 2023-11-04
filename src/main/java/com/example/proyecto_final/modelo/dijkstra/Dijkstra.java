package com.example.proyecto_final.modelo.dijkstra;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Dijkstra {
    // Una función de utilidad para encontrar el vértice con el valor de distancia
    // mínimo,
    // del conjunto de vértices que aún no están incluidos en el árbol de camino más
    // corto.
    static final int V = 9;

    int minDistance(int dist[], Boolean sptSet[]) {
        // Inicializa el valor mínimo
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // Una función de utilidad para imprimir el array de distancias construido
    void printSolution(int dist[]) {
        System.out.println(
                "Vértice \t\t Distancia desde la Fuente");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    // Función que implementa el algoritmo de camino más corto de una sola fuente de
    // Dijkstra
    // para un grafo representado usando una matriz de adyacencia
    void dijkstra(int graph[][], int src) {
        int dist[] = new int[V]; // El array de salida.
                                 // dist[i] contendrá
        // la distancia más corta desde src hasta i

        // sptSet[i] será verdadero si el vértice i está incluido en
        // el árbol de camino más corto o si la distancia más corta desde src
        // hasta i se ha finalizado
        Boolean sptSet[] = new Boolean[V];

        // Inicializa todas las distancias como INFINITO y sptSet[]
        // como falso
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // La distancia desde el vértice fuente hasta sí mismo siempre es 0
        dist[src] = 0;

        // Encuentra el camino más corto para todos los vértices
        for (int count = 0; count < V - 1; count++) {
            // Elije el vértice con la distancia mínima del conjunto
            // de vértices que aún no han sido procesados. u es siempre
            // igual a src en la primera iteración.
            int u = minDistance(dist, sptSet);

            // Marca el vértice seleccionado como procesado
            sptSet[u] = true;

            // Actualiza el valor de distancia de los vértices adyacentes al
            // vértice seleccionado.
            for (int v = 0; v < V; v++)

                // Actualiza dist[v] solo si no está en sptSet,
                // hay una arista de u a v, y el peso total
                // del camino desde src hasta v a través de u es
                // menor que el valor actual de dist[v]
                if (!sptSet[v] && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        // Imprime el array de distancias construido
        printSolution(dist);
    }

    // Código del programa principal
    public static void main(String[] args) {
        /*
         * Creemos el grafo de ejemplo discutido anteriormente
         */
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        Dijkstra t = new Dijkstra();

        // Llamada a la función
        t.dijkstra(graph, 0);
    }
}
// Este código fue contribuido por Aakash Hasija
