package com.example.proyecto_final.modelo.multiestado;

// Programa en Java para encontrar la distancia más corta
// en un grafo de varias etapas.
import java.io.*;
import java.util.*;

public class Multiestado {

    static int N = 8;
    static int INF = Integer.MAX_VALUE;

    // Devuelve la distancia más corta desde 0 hasta
    // N-1.
    public static int distanciaMasCorta(int[][] grafo) {

        // dist[i] almacenará la distancia más corta desde el nodo i hasta el nodo N-1.
        int[] dist = new int[N];

        dist[N - 1] = 0;

        // Calculando el camino más corto para
        // el resto de los nodos
        for (int i = N - 2; i >= 0; i--) {

            // Inicializar la distancia desde i hasta
            // el destino (N-1)
            dist[i] = INF;

            // Verificar todos los nodos de las etapas siguientes
            // para encontrar la distancia más corta desde
            // i hasta N-1.
            for (int j = i; j < N; j++) {
                // Rechazar si no existe una arista
                if (grafo[i][j] == INF) {
                    continue;
                }

                // Aplicamos la ecuación recursiva a
                // la distancia al destino a través de j.
                // y comparamos con la distancia mínima
                // hasta ahora.
                dist[i] = Math.min(dist[i],
                        grafo[i][j] + dist[j]);
            }
        }

        return dist[0];
    }

    // Código del controlador
    public static void main(String[] args) {
        // Grafo almacenado en forma de
        // una matriz de adyacencia
        int[][] grafo = new int[][] {
                { INF, 1, 2, 5, INF, INF, INF, INF },
                { INF, INF, INF, INF, 4, 11, INF, INF },
                { INF, INF, INF, INF, 9, 5, 16, INF },
                { INF, INF, INF, INF, INF, INF, 2, INF },
                { INF, INF, INF, INF, INF, INF, INF, 18 },
                { INF, INF, INF, INF, INF, INF, INF, 13 },
                { INF, INF, INF, INF, INF, INF, INF, 2 }
        };

        System.out.println(distanciaMasCorta(grafo));
    }
}


