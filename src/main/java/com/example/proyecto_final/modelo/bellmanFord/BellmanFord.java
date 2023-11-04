package com.example.proyecto_final.modelo.bellmanFord;

public class BellmanFord {
    // Código del programa principal
	public static void main(String[] args) {
		int V = 5; // Número de vértices en el grafo
		int E = 8; // Número de aristas en el grafo

		Grafo grafo = new Grafo(V, E);

		// Añadir arista 0-1 (o A-B en la figura de arriba)
		grafo.arista[0].origen = 0;
		grafo.arista[0].destino = 1;
		grafo.arista[0].peso = -1;

		// Añadir arista 0-2 (o A-C en la figura de arriba)
		grafo.arista[1].origen = 0;
		grafo.arista[1].destino = 2;
		grafo.arista[1].peso = 4;

		// Añadir arista 1-2 (o B-C en la figura de arriba)
		grafo.arista[2].origen = 1;
		grafo.arista[2].destino = 2;
		grafo.arista[2].peso = 3;

		// Añadir arista 1-3 (o B-D en la figura de arriba)
		grafo.arista[3].origen = 1;
		grafo.arista[3].destino = 3;
		grafo.arista[3].peso = 2;

		// Añadir arista 1-4 (o B-E en la figura de arriba)
		grafo.arista[4].origen = 1;
		grafo.arista[4].destino = 4;
		grafo.arista[4].peso = 2;

		// Añadir arista 3-2 (o D-C en la figura de arriba)
		grafo.arista[5].origen = 3;
		grafo.arista[5].destino = 2;
		grafo.arista[5].peso = 5;

		// Añadir arista 3-1 (o D-B en la figura de arriba)
		grafo.arista[6].origen = 3;
		grafo.arista[6].destino = 1;
		grafo.arista[6].peso = 1;

		// Añadir arista 4-3 (o E-D en la figura de arriba)
		grafo.arista[7].origen = 4;
		grafo.arista[7].destino = 3;
		grafo.arista[7].peso = -3;

		// Llamada a la función
		grafo.BellmanFord(grafo, 0);
	}
}