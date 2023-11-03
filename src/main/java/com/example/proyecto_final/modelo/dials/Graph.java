package com.example.proyecto_final.modelo.dials;


import java.util.*;
 
public class Graph {
    static final int INF = Integer.MAX_VALUE;
    private int V; // No. of vertices
    // In a weighted graph, we need to store vertex
    // and weight pair for every edge
    private ArrayList<ArrayList<Tuple> > adj;
 
    public Graph(int v) // Constructor
    {
        this.V = v;
        this.adj = new ArrayList<ArrayList<Tuple> >();
        for (int i = 0; i < v; i++)
            this.adj.add(new ArrayList<Tuple>());
    }
 
    // function to Add an edge to graph
    // Adds edge between u and v of weight w
    public void AddEdge(int u, int v, int w)
    {
        adj.get(u).add(new Tuple(v, w));
        adj.get(v).add(new Tuple(u, w));
    }
 
    // Prints shortest paths from src to all other vertices.
    // W is the maximum weight of an edge
    public void shortestPath(int src, int W)
    {
        /* With each distance, iterator to that vertex in
            its bucket is stored so that vertex can be
           deleted in O(1) at time of updation. So
            dist[i].first = distance of ith vertex from src
            vertex dits[i].second = iterator to vertex i in
            bucket number */
        int[] dist = new int[V];
 
        // Initialize all distances as infinite (INF)
        Arrays.fill(dist, INF);
 
        // Create buckets B[].
        // B[i] keep vertex of distance label i
        ArrayList<Integer>[] B = new ArrayList[W * V + 1];
        for (int i = 0; i < W * V + 1; i++)
            B[i] = new ArrayList<Integer>();
 
        B[0].add(src);
        dist[src] = 0;
 
        int idx = 0;
        while (true) {
            // Go sequentially through buckets till one
            // non-empty bucket is found
            while (B[idx].size() == 0 && idx < W * V)
                idx++;
 
            // If all buckets are empty, we are done.
            if (idx == W * V)
                break;
 
            // Take top vertex from bucket and pop it
            int u = B[idx].get(0);
            B[idx].remove(0);
 
            // Process all adjacents of extracted vertex 'u'
            // and update their distances if required.
            for (Tuple i : adj.get(u)) {
                int v = i.v;
                int weight = i.w;
 
                int du = dist[u];
                int dv = dist[v];
 
                // If there is shorted path to v through u.
                if (dv > du + weight) {
                    // updating the distance
                    dist[v] = du + weight;
                    dv = dist[v];
 
                    // pushing vertex v into updated
                    // distance's bucket
                    B[dv].add(0, v);
                }
            }
        }
 
        // Print shortest distances stored in dist[]
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }
 

}