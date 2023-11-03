package com.example.proyecto_final.modelo.grafoNoPesado;

// Programa en Java para encontrar el camino más corto en un grafo no dirigido
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoNoPesado {

	// Programa principal
	public static void main(String args[])
	{
		// Número de vértices
		int v = 8;

		// Lista de adyacencia para almacenar qué vértices están conectados
		ArrayList<ArrayList<Integer>> adj = 
							new ArrayList<ArrayList<Integer>>(v);
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}

		// Creando el grafo dado en el diagrama anterior.
		// La función addEdge toma la lista de adyacencia, la fuente
		// y el vértice de destino como argumento y forma
		// una arista entre ellos.
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 3);
		addEdge(adj, 1, 2);
		addEdge(adj, 3, 4);
		addEdge(adj, 3, 7);
		addEdge(adj, 4, 5);
		addEdge(adj, 4, 6);
		addEdge(adj, 4, 7);
		addEdge(adj, 5, 6);
		addEdge(adj, 6, 7);
		int source = 0, dest = 7;
		printShortestDistance(adj, source, dest, v);
	}

	// Función para formar una arista entre dos vértices
	// fuente y destino
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j)
	{
		adj.get(i).add(j);
		adj.get(j).add(i);
	}

	// Función para imprimir la distancia más corta y el camino
	// entre el vértice fuente y el vértice destino
	private static void printShortestDistance(
					ArrayList<ArrayList<Integer>> adj,
							int s, int dest, int v)
	{
		// El array pred[i] almacena el predecesor de
		// i y el array dist almacena la distancia de i
		// desde s
		int pred[] = new int[v];
		int dist[] = new int[v];

		if (BFS(adj, s, dest, v, pred, dist) == false) {
			System.out.println("La fuente y el destino dados no están conectados");
			return;
		}

		// LinkedList para almacenar el camino
		LinkedList<Integer> path = new LinkedList<Integer>();
		int crawl = dest;
		path.add(crawl);
		while (pred[crawl] != -1) {
			path.add(pred[crawl]);
			crawl = pred[crawl];
		}

		// Imprimir distancia
		System.out.println("La longitud del camino más corto es: " + dist[dest]);

		// Imprimir camino
		System.out.println("El camino es ::");
		for (int i = path.size() - 1; i >= 0; i--) {
			System.out.print(path.get(i) + " ");
		}
	}

	// Una versión modificada de BFS que almacena el predecesor
	// de cada vértice en el array pred
	// y su distancia desde la fuente en el array dist
	private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int src,
								int dest, int v, int pred[], int dist[])
	{
		// Una cola para mantener los vértices cuya
		// lista de adyacencia debe ser escaneada según el
		// algoritmo BFS normal usando LinkedList de tipo Integer
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Array booleano visited[] que almacena la
		// información de si el i-ésimo vértice ha sido alcanzado
		// al menos una vez en la búsqueda en anchura
		boolean visited[] = new boolean[v];

		// Inicialmente, todos los vértices no están visitados
		// por lo que v[i] para todos i es falso
		// y como no se ha construido ningún camino aún
		// dist[i] para todos i se establece en infinito
		for (int i = 0; i < v; i++) {
			visited[i] = false;
			dist[i] = Integer.MAX_VALUE;
			pred[i] = -1;
		}

		// ahora la fuente es la primera en ser visitada y
		// la distancia desde la fuente hasta sí misma debe ser 0
		visited[src] = true;
		dist[src] = 0;
		queue.add(src);

		// Algoritmo BFS
		while (!queue.isEmpty()) {
			int u = queue.remove();
			for (int i = 0; i < adj.get(u).size(); i++) {
				if (visited[adj.get(u).get(i)] == false) {
					visited[adj.get(u).get(i)] = true;
					dist[adj.get(u).get(i)] = dist[u] + 1;
					pred[adj.get(u).get(i)] = u;
					queue.add(adj.get(u).get(i));

					// Condición de parada (cuando encontramos
					// nuestro destino)
					if (adj.get(u).get(i) == dest)
						return true;
				}
			}
		}
		return false;
	}
}
