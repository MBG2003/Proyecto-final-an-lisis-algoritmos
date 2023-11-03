package com.example.proyecto_final.modelo.bellmanFord;

// Un programa en Java para el algoritmo de camino más corto de una única fuente de Bellman-Ford.

import java.io.*;
import java.lang.*;
import java.util.*;

// Una clase para representar un grafo conectado, dirigido y ponderado
class Grafo {
	int V, E;
	Arista arista[];

	// Crea un grafo con V vértices y E aristas
	Grafo(int v, int e) {
		V = v;
		E = e;
		arista = new Arista[e];
		for (int i = 0; i < e; ++i)
			arista[i] = new Arista();
	}

	// La función principal que encuentra las distancias más cortas desde
	// src a todos los demás vértices utilizando el algoritmo de Bellman-Ford.
	// La función también detecta ciclos de peso negativo.
	void BellmanFord(Grafo grafo, int src) {
		int V = grafo.V, E = grafo.E;
		int dist[] = new int[V];

		// Paso 1: Inicializar las distancias desde src a todos los
		// otros vértices como INFINITO
		for (int i = 0; i < V; ++i)
			dist[i] = Integer.MAX_VALUE;
		dist[src] = 0;

		// Paso 2: Relajar todas las aristas |V| - 1 veces. Un camino más corto
		// desde src a cualquier otro vértice puede tener como máximo |V| - 1 aristas.
		for (int i = 1; i < V; ++i) {
			for (int j = 0; j < E; ++j) {
				int u = grafo.arista[j].origen;
				int v = grafo.arista[j].destino;
				int peso = grafo.arista[j].peso;
				if (dist[u] != Integer.MAX_VALUE
						&& dist[u] + peso < dist[v])
					dist[v] = dist[u] + peso;
			}
		}

		// Paso 3: Comprobar ciclos de peso negativo. El paso anterior garantiza
		// distancias más cortas si el grafo no contiene ciclos de peso negativo.
		// Si obtenemos un camino más corto, entonces hay un ciclo.
		for (int j = 0; j < E; ++j) {
			int u = grafo.arista[j].origen;
			int v = grafo.arista[j].destino;
			int peso = grafo.arista[j].peso;
			if (dist[u] != Integer.MAX_VALUE
					&& dist[u] + peso < dist[v]) {
				System.out.println(
						"El grafo contiene un ciclo de peso negativo");
				return;
			}
		}
		imprimirArreglo(dist, V);
	}

	// Una función de utilidad utilizada para imprimir la solución
	void imprimirArreglo(int dist[], int V) {
		System.out.println("Vértice Distancia desde la Fuente");
		for (int i = 0; i < V; ++i)
			System.out.println(i + "\t\t" + dist[i]);
	}

	
}
// Contribuido por Aakash Hasija
