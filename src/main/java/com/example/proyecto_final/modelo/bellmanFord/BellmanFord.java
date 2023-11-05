package com.example.proyecto_final.modelo.bellmanFord;

import java.util.ArrayList;

public class BellmanFord {
	// Código del programa principal
	public static void main (String[] args) {
		int V = 5; // Número de vértices en el grafo
		int E = 2; // Número de aristas en el grafo
        ArrayList<Integer> miArrayList = new ArrayList<>();

		// Agregar elementos al ArrayList
        miArrayList.add(2);
        miArrayList.add(1);
        miArrayList.add(1);

		// Agregar elementos al ArrayList
        miArrayList.add(0);
        miArrayList.add(1);
        miArrayList.add(3);

		realizarGrafoBellmanFord(V, E,miArrayList);

	}

	public static boolean realizarGrafoBellmanFord(int V, int E, ArrayList<Integer> lista) {
		Grafo grafo = new Grafo(V, E);

		int cont= 0;
		for(int i = 0; i < E; i++){
			grafo.arista[i].origen = lista.get(cont);
			grafo.arista[i].destino = lista.get(cont+1);
			grafo.arista[i].peso = lista.get(cont+2);
			cont = cont +3;
		}
		
		return grafo.BellmanFord(grafo, 0);
	}

	public static double realizarGrafoBellmanFordTiempo(int V, int E, ArrayList<Integer> lista) {
		Grafo grafo = new Grafo(V, E);

		int cont= 0;
		for(int i = 0; i < E; i++){
			grafo.arista[i].origen = lista.get(cont);
			grafo.arista[i].destino = lista.get(cont+1);
			grafo.arista[i].peso = lista.get(cont+2);
			cont = cont +3;
		}

		double timeInicial = System.nanoTime();
		grafo.BellmanFord(grafo, 0);
		double timeFinal = System.nanoTime();

        return (timeFinal - timeInicial) / 1000000000;
	}
}