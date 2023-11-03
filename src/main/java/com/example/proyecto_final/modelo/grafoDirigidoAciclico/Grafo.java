package com.example.proyecto_final.modelo.grafoDirigidoAciclico;

import java.util.*;

// Clase para representar el grafo como una lista de adyacencia
public class Grafo {
    static final int INF = Integer.MAX_VALUE;
    private int V;
    private LinkedList<NodoAdyacente> adj[];

    Grafo(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<NodoAdyacente>();
    }

    void agregarArista(int u, int v, int peso) {
        NodoAdyacente nodo = new NodoAdyacente(v, peso);
        adj[u].add(nodo);// Agrega v a la lista de u
    }

    // Una función recursiva utilizada por shortestPath.
    // Ver enlace a continuación para detalles
    void topologicalSortUtil(int v, Boolean visitado[], Stack pila) {
        // Marca el nodo actual como visitado.
        visitado[v] = true;
        Integer i;

        // Recorre todos los vértices adyacentes a este vértice
        Iterator<NodoAdyacente> it = adj[v].iterator();
        while (it.hasNext()) {
            NodoAdyacente nodo = it.next();
            if (!visitado[nodo.getV()])
                topologicalSortUtil(nodo.getV(), visitado, pila);
        }
        // Agrega el vértice actual a la pila que almacena el resultado
        pila.push(new Integer(v));
    }

    // La función para encontrar caminos más cortos desde el vértice dado. Utiliza
    // topologicalSortUtil() recursivo para obtener el orden topológico del grafo
    // dado.
    void shortestPath(int s) {
        Stack pila = new Stack();
        int dist[] = new int[V];

        // Marca todos los vértices como no visitados
        Boolean visitado[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visitado[i] = false;

        // Llama a la función auxiliar recursiva para almacenar el orden topológico
        // empezando desde todos los vértices uno por uno
        for (int i = 0; i < V; i++)
            if (visitado[i] == false)
                topologicalSortUtil(i, visitado, pila);

        // Inicializa las distancias a todos los vértices como infinitas y
        // la distancia a la fuente como 0
        for (int i = 0; i < V; i++)
            dist[i] = INF;
        dist[s] = 0;

        // Procesa los vértices en orden topológico
        while (pila.empty() == false) {
            // Obtiene el próximo vértice en el orden topológico
            int u = (int) pila.pop();

            // Actualiza las distancias de todos los vértices adyacentes
            Iterator<NodoAdyacente> it;
            if (dist[u] != INF) {
                it = adj[u].iterator();
                while (it.hasNext()) {
                    NodoAdyacente i = it.next();
                    if (dist[i.getV()] > dist[u] + i.getPeso())
                        dist[i.getV()] = dist[u] + i.getPeso();
                }
            }
        }

        // Imprime las distancias más cortas calculadas
        for (int i = 0; i < V; i++) {
            if (dist[i] == INF)
                System.out.print("INF ");
            else
                System.out.print(dist[i] + " ");
        }
    }
}
