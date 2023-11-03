package com.example.proyecto_final.modelo.karps;

// Programa en Java para encontrar el peso promedio mínimo
// de un ciclo en un grafo conectado y dirigido.
import java.io.*;
import java.util.*;

public class Main {
    static int V = 4;
    

    // vector para almacenar aristas
    static Vector<Arista>[] aristas = new Vector[V];
    static {
        for (int i = 0; i < V; i++)
            aristas[i] = new Vector<>();
    }

    static void agregarArista(int u, int v, int w) {
        aristas[v].add(new Arista(u, w));
    }

    // calcula el camino más corto
    static void caminoMasCorto(int[][] dp) {
        // inicializando todas las distancias como -1
        for (int i = 0; i <= V; i++)
            for (int j = 0; j < V; j++)
                dp[i][j] = -1;

        // distancia más corta desde el primer vértice
        // hasta sí mismo consistiendo en 0 aristas
        dp[0][0] = 0;

        // llenando la tabla dp
        for (int i = 1; i <= V; i++) {
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < aristas[j].size(); k++) {
                    if (dp[i - 1][aristas[j].elementAt(k).desde] != -1) {
                        int pesoActual = dp[i - 1][aristas[j].elementAt(k).desde] +
                                aristas[j].elementAt(k).peso;
                        if (dp[i][j] == -1)
                            dp[i][j] = pesoActual;
                        else
                            dp[i][j] = Math.min(dp[i][j], pesoActual);
                    }
                }
            }
        }
    }

    // Devuelve el valor mínimo del peso promedio
    // de un ciclo en el grafo.
    static double minPesoPromedio() {
        int[][] dp = new int[V + 1][V];
        caminoMasCorto(dp);

        // arreglo para almacenar los valores promedio
        double[] promedio = new double[V];
        for (int i = 0; i < V; i++)
            promedio[i] = -1;

        // Calcular valores promedio para todos los vértices usando
        // pesos de los caminos más cortos almacenados en dp.
        for (int i = 0; i < V; i++) {
            if (dp[V][i] != -1) {
                for (int j = 0; j < V; j++)
                    if (dp[j][i] != -1)
                        promedio[i] = Math.max(promedio[i],
                                ((double) dp[V][i] -
                                        dp[j][i]) / (V - j));
            }
        }

        // Encuentra el valor mínimo en promedio[]
        double resultado = promedio[0];
        for (int i = 0; i < V; i++)
            if (promedio[i] != -1 && promedio[i] < resultado)
                resultado = promedio[i];

        return resultado;
    }

    // Código del controlador
    public static void main(String[] args) {
        agregarArista(0, 1, 1);
        agregarArista(0, 2, 10);
        agregarArista(1, 2, 3);
        agregarArista(2, 3, 2);
        agregarArista(3, 1, 0);
        agregarArista(3, 0, 8);

        System.out.printf("%.5f", minPesoPromedio());
    }
}
