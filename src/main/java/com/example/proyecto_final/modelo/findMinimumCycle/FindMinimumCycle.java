package com.example.proyecto_final.modelo.findMinimumCycle;

// Programa en Java para encontrar el ciclo ponderado más corto en un grafo no dirigido
import java.util.*;

// Código del controlador
public class FindMinimumCycle {
    public static void main(String[] args) {
        int V = 9;
        Grafo g = new Grafo(V);
        g.agregarArista(0, 1, 4);
        g.agregarArista(0, 7, 8);
        g.agregarArista(1, 2, 8);
        g.agregarArista(1, 7, 11);
        g.agregarArista(2, 3, 7);
        g.agregarArista(2, 8, 2);
        g.agregarArista(2, 5, 4);
        g.agregarArista(3, 4, 9);
        g.agregarArista(3, 5, 14);
        g.agregarArista(4, 5, 10);
        g.agregarArista(5, 6, 2);
        g.agregarArista(6, 7, 1);
        g.agregarArista(6, 8, 6);
        g.agregarArista(7, 8, 7);
        System.out.println(g.encontrarCicloMinimo());
    }
}

