package com.example.proyecto_final.modelo.findMinimumCycle;

 // Clase para representar una tupla
public class Tuple<T, U> implements Comparable<Tuple<T, U>> {
    public final T primero;
    public final U segundo;
    public int v;
    public int w;

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