package com.example.proyecto_final.modelo.zeroOneBFS;

// Programa en Java para implementar BFS 0-1
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ZeroOneBFS {
	private static class Nodo {
		int destino; // el vértice de destino
		int peso; // el peso de la arista

		public Nodo(int destino, int peso) {
			this.destino = destino;
			this.peso = peso;
		}
	}

	private static final int numVertices = 9;
	private ArrayList<Nodo>[] aristas = new ArrayList[numVertices];

	public ZeroOneBFS() {
		for (int i = 0; i < aristas.length; i++) {
			aristas[i] = new ArrayList<Nodo>();
		}
	}

	public void agregarArista(int u, int v, int peso) {
		aristas[u].add(aristas[u].size(), new Nodo(v, peso));
		aristas[v].add(aristas[v].size(), new Nodo(u, peso));
	}

	public void ZeroOneBFS(int origen) {

		// inicializar distancias desde la fuente dada
		int[] distancias = new int[numVertices];
		for (int i = 0; i < numVertices; i++) {
			distancias[i] = Integer.MAX_VALUE;
		}

		// cola de doble extremo para realizar BFS
		Deque<Integer> cola = new ArrayDeque<Integer>();
		distancias[origen] = 0;
		cola.addLast(origen);

		while (!cola.isEmpty()) {
			int v = cola.removeFirst();
			for (int i = 0; i < aristas[v].size(); i++) {

				// comprobando la distancia óptima
				if (distancias[aristas[v].get(i).destino] > distancias[v] + aristas[v].get(i).peso) {

					// actualizar la distancia
					distancias[aristas[v].get(i).destino] = distancias[v] + aristas[v].get(i).peso;

					// poner aristas de peso 0 al principio y aristas de peso 1 al final
					// para que los vértices se procesen en orden creciente de peso
					if (aristas[v].get(i).peso == 0) {
						cola.addFirst(aristas[v].get(i).destino);
					} else {
						cola.addLast(aristas[v].get(i).destino);
					}
				}
			}
		}

		for (int i = 0; i < distancias.length; i++) {
			System.out.print(distancias[i] + " ");
		}
	}

	public static void main(String[] args) {
		ZeroOneBFS grafo = new ZeroOneBFS();
		grafo.agregarArista(0, 1, 0);
		grafo.agregarArista(0, 7, 1);
		grafo.agregarArista(1, 7, 1);
		grafo.agregarArista(1, 2, 1);
		grafo.agregarArista(2, 3, 0);
		grafo.agregarArista(2, 5, 0);
		grafo.agregarArista(2, 8, 1);
		grafo.agregarArista(3, 4, 1);
		grafo.agregarArista(3, 5, 1);
		grafo.agregarArista(4, 5, 1);
		grafo.agregarArista(5, 6, 1);
		grafo.agregarArista(6, 7, 1);
		grafo.agregarArista(7, 8, 1);
		int origen = 0; // nodo fuente
		grafo.ZeroOneBFS(origen);
		return;
	}
}
