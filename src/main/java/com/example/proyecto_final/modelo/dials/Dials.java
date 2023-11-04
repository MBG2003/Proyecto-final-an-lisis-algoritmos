package com.example.proyecto_final.modelo.dials;

import java.util.*;

public class Dials {
        public static void main(String[] args)
    {
        // create the graph given in above figure
        int V = 9;
        Graph g = new Graph(V);
 
        // making above shown graph
        g.AddEdge(0, 1, 4);
        g.AddEdge(0, 7, 8);
        g.AddEdge(1, 2, 8);
        g.AddEdge(1, 7, 11);
        g.AddEdge(2, 3, 7);
        g.AddEdge(2, 8, 2);
        g.AddEdge(2, 5, 4);
        g.AddEdge(3, 4, 9);
        g.AddEdge(3, 5, 14);
        g.AddEdge(4, 5, 10);
        g.AddEdge(5, 6, 2);
        g.AddEdge(6, 7, 1);
        g.AddEdge(6, 8, 6);
        g.AddEdge(7, 8, 7);
 
        // maximum weighted edge - 14
        g.shortestPath(0, 14);
    }
}
