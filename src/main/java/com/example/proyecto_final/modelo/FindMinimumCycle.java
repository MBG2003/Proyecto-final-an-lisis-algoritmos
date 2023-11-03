package com.example.proyecto_final.modelo.findMinimumCycle;

// Programa en Java para encontrar el ciclo ponderado más corto en un grafo no dirigido
import java.util.*;

// Clase para representar una arista
class Arista {
    public int u;
    public int v;
    public int peso;
}

// Clase para representar un grafo no dirigido ponderado
class Grafo {
    int V;
    List<Tuple<Integer, Integer>>[] adj;
    List<Arista> aristas;

    public Grafo(int V) {
        this.V = V;
        adj = new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        aristas = new ArrayList<>();
    }

    // Función para agregar una arista al grafo
    public void agregarArista(int u, int v, int w) {
        adj[u].add(new Tuple<>(v, w));
        adj[v].add(new Tuple<>(u, w));
        Arista arista = new Arista();
        arista.u = u;
        arista.v = v;
        arista.peso = w;
        aristas.add(arista);
    }

    // Función para eliminar una arista de un grafo no dirigido
    public void eliminarArista(int u, int v, int w) {
        adj[u].remove(new Tuple<>(v, w));
        adj[v].remove(new Tuple<>(u, w));
    }

    // Encuentra el camino más corto desde la fuente hasta el destino utilizando
    // el algoritmo de camino más corto de Dijkstra [Complejidad temporal
    // O(E logV)]
    public int caminoMasCorto(int u, int v) {

        // Crea un conjunto para almacenar los vértices que se están
        // preprocesando
        SortedSet<Tuple<Integer, Integer>> setds = new TreeSet<>();
        // Crea un vector para distancias e inicializa todas
        // las distancias como infinito (INF)
        List<Integer> dist = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            dist.add(Integer.MAX_VALUE);
        }
        // Inserta la fuente en sí misma en el conjunto e inicializa su
        // distancia como 0.
        setds.add(new Tuple<>(0, u));
        dist.set(u, 0);
        /* Bucle hasta que todas las distancias más cortas estén finalizadas
      entonces setds se vaciará */
        while (!setds.isEmpty()) {
            // El primer vértice en el conjunto es el mínimo
            // vértice de distancia, extráelo del conjunto.
            Tuple<Integer, Integer> tmp = setds.first();
            setds.remove(tmp);
            int uu = tmp.segundo;
            for (Tuple<Integer, Integer> i : adj[uu]) {
                int vv = i.primero;
                int peso = i.segundo;
                /* Si la distancia de v no es INF, entonces debe estar en nuestro conjunto,
                 así que quítalo e insértalo nuevamente con una distancia actualizada menor.
                 Nota: Extraemos solo esos vértices del conjunto para los cuales la distancia ya está finalizada.
                 Así que para ellos, nunca llegaríamos aquí. */
                if (dist.get(vv) > dist.get(uu) + peso) {
                    if (dist.get(vv) != Integer.MAX_VALUE) {
                        setds.remove(
                            new Tuple<>(dist.get(vv), vv));
                    }
                    dist.set(vv, dist.get(uu) + peso);
                    setds.add(
                        new Tuple<>(dist.get(vv), vv));
                }
            }
        }

        // Devuelve el camino más corto desde la fuente hasta el destino
        return dist.get(v);
    }

    // Función para encontrar el ciclo ponderado mínimo
    public int encontrarCicloMinimo() {
        int cicloMinimo = Integer.MAX_VALUE;
        int E = aristas.size();
        for (int i = 0; i < E; i++) {
            Arista arista = aristas.get(i);
            // Obtiene los vértices de la arista que estamos quitando actualmente del grafo
            // y luego encuentra el camino más corto entre estos dos vértices usando el
            // algoritmo de camino más corto de Dijkstra.
            eliminarArista(arista.u, arista.v, arista.peso);
            // Distancia mínima entre estos dos vértices
            int distancia = caminoMasCorto(arista.u, arista.v);

            // Para formar un ciclo, tenemos que agregar el peso de
            // la arista actualmente eliminada, si este es el ciclo más corto, actualiza cicloMinimo
            cicloMinimo
                = Math.min(cicloMinimo, distancia + arista.peso)
                  + 4;
            // Agrega la arista nuevamente al grafo
            agregarArista(arista.u, arista.v, arista.peso);
        }
        // Devuelve el ciclo más corto
        return cicloMinimo;
    }
}

// Clase para representar una tupla
class Tuple<T, U> implements Comparable<Tuple<T, U>> {
    public final T primero;
    public final U segundo;

    public Tuple(T primero, U segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public int compareTo(Tuple<T, U> otro) {
        if (this.primero.equals(otro.primero)) {
            return this.segundo.toString().compareTo(
                otro.segundo.toString());
        } else {
            return this.primero.toString().compareTo(
                otro.primero.toString());
        }
    }

    public String toString() {
        return "(" + primero.toString() + ", "
            + segundo.toString() + ")";
    }
}

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

