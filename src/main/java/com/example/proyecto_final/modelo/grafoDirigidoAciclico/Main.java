package com.example.proyecto_final.modelo.grafoDirigidoAciclico;

// Programa en Java para encontrar caminos más cortos desde una fuente en grafos dirigidos acíclicos
import java.io.*;
import java.util.*;

public class Main {

    // Método para crear una nueva instancia de grafo a través de un objeto
    // de la clase Grafo
    Grafo nuevoGrafo(int numero) {
        return new Grafo(numero);
    }

    public static void main(String args[]) {
        // Crea un grafo dado en el diagrama anterior. Aquí, los números de vértices son
        // 0, 1, 2, 3, 4, 5 con las siguientes asignaciones:
        // 0=r, 1=s, 2=t, 3=x, 4=y, 5=z
        Main t = new Main();
        Grafo g = t.nuevoGrafo(6);
        g.agregarArista(0, 1, 5);
        g.agregarArista(0, 2, 3);
        g.agregarArista(1, 3, 6);
        g.agregarArista(1, 2, 2);
        g.agregarArista(2, 4, 4);
        g.agregarArista(2, 5, 2);
        g.agregarArista(2, 3, 7);
        g.agregarArista(3, 4, -1);
        g.agregarArista(4, 5, -2);

        int s = 1;
        System.out.println("Las distancias más cortas desde la fuente " + s +
                " son las siguientes:");
        g.shortestPath(s);
    }
}
