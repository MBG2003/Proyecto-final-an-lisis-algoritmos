package com.example.proyecto_final.modelo.grafoDirigidoAciclico;

public class NodoAdyacente {
    private int v;
    private int peso;

    NodoAdyacente(int _v, int _w) {
        v = _v;
        peso = _w;
    }

    int getV() {
        return v;
    }

    int getPeso() {
        return peso;
    }
}
