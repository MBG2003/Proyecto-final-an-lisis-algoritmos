package com.example.proyecto_final.modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Documento {

    private final String AESTRLLACASO1 = "src/Recursos/aestrllacaso1.txt";
    private final String AESTRLLACASO2 = "src/Recursos/aestrllacaso2.txt";
    private final String AESTRLLACASO3 = "src/Recursos/aestrllacaso3.txt";
    private final String AESTRLLACASO4 = "src/Recursos/aestrllacaso4.txt";
    private final String AESTRLLACASO5 = "src/Recursos/aestrllacaso5.txt";
    private final String AESTRLLACASO6 = "src/Recursos/aestrllacaso6.txt";
    private final String AESTRLLACASO7 = "src/Recursos/aestrllacaso7.txt";
    private final String AESTRLLACASO8 = "src/Recursos/aestrllacaso8.txt";

    private final String BELLMANFORD1 = "src/Recursos/bellmanFord1.txt";
    private final String BELLMANFORD2 = "src/Recursos/bellmanFord2.txt";
    private final String BELLMANFORD3 = "src/Recursos/bellmanFord3.txt";
    private final String BELLMANFORD4 = "src/Recursos/bellmanFord4.txt";
    private final String BELLMANFORD5 = "src/Recursos/bellmanFord5.txt";
    private final String BELLMANFORD6 = "src/Recursos/bellmanFord6.txt";
    private final String BELLMANFORD7 = "src/Recursos/bellmanFord7.txt";
    private final String BELLMANFORD8 = "src/Recursos/bellmanFord8.txt";

    private final String DIALS1 = "src/Recursos/dials1.txt";
    private final String DIALS2 = "src/Recursos/dials2.txt";
    private final String DIALS3 = "src/Recursos/dials3.txt";
    private final String DIALS4 = "src/Recursos/dials4.txt";
    private final String DIALS5 = "src/Recursos/dials5.txt";
    private final String DIALS6 = "src/Recursos/dials6.txt";
    private final String DIALS7 = "src/Recursos/dials7.txt";
    private final String DIALS8 = "src/Recursos/dials8.txt";

    private final String DIJKSTRA1 = "src/Recursos/dijkstra1.txt";
    private final String DIJKSTRA2 = "src/Recursos/dijkstra2.txt";
    private final String DIJKSTRA3 = "src/Recursos/dijkstra3.txt";
    private final String DIJKSTRA4 = "src/Recursos/dijkstra4.txt";
    private final String DIJKSTRA5 = "src/Recursos/dijkstra5.txt";
    private final String DIJKSTRA6 = "src/Recursos/dijkstra6.txt";
    private final String DIJKSTRA7 = "src/Recursos/dijkstra7.txt";
    private final String DIJKSTRA8 = "src/Recursos/dijkstra8.txt";

    private final String FINDMINIMUMCYCLE1 = "src/Recursos/findMinimumCycle1.txt";
    private final String FINDMINIMUMCYCLE2 = "src/Recursos/findMinimumCycle2.txt";
    private final String FINDMINIMUMCYCLE3 = "src/Recursos/findMinimumCycle3.txt";
    private final String FINDMINIMUMCYCLE4 = "src/Recursos/findMinimumCycle4.txt";
    private final String FINDMINIMUMCYCLE5 = "src/Recursos/findMinimumCycle5.txt";
    private final String FINDMINIMUMCYCLE6 = "src/Recursos/findMinimumCycle6.txt";
    private final String FINDMINIMUMCYCLE7 = "src/Recursos/findMinimumCycle7.txt";
    private final String FINDMINIMUMCYCLE8 = "src/Recursos/findMinimumCycle8.txt";

    private final String FLOYD1 = "src/Recursos/floyd1.txt";
    private final String FLOYD2 = "src/Recursos/floyd2.txt";
    private final String FLOYD3 = "src/Recursos/floyd3.txt";
    private final String FLOYD4 = "src/Recursos/floyd4.txt";
    private final String FLOYD5 = "src/Recursos/floyd5.txt";
    private final String FLOYD6 = "src/Recursos/floyd6.txt";
    private final String FLOYD7 = "src/Recursos/floyd7.txt";
    private final String FLOYD8 = "src/Recursos/floyd8.txt";

    private final String GRAFODIRIGIDO1 = "src/Recursos/grafoDirigidoAciclico1.txt";
    private final String GRAFODIRIGIDO2 = "src/Recursos/grafoDirigidoAciclico2.txt";
    private final String GRAFODIRIGIDO3 = "src/Recursos/grafoDirigidoAciclico3.txt";
    private final String GRAFODIRIGIDO4 = "src/Recursos/grafoDirigidoAciclico4.txt";
    private final String GRAFODIRIGIDO5 = "src/Recursos/grafoDirigidoAciclico5.txt";
    private final String GRAFODIRIGIDO6 = "src/Recursos/grafoDirigidoAciclico6.txt";
    private final String GRAFODIRIGIDO7 = "src/Recursos/grafoDirigidoAciclico7.txt";
    private final String GRAFODIRIGIDO8 = "src/Recursos/grafoDirigidoAciclico8.txt";

    private final String GRAFONOPESADO1 = "src/Recursos/grafoNoPesado1.txt";
    private final String GRAFONOPESADO2 = "src/Recursos/grafoNoPesado2.txt";
    private final String GRAFONOPESADO3 = "src/Recursos/grafoNoPesado3.txt";
    private final String GRAFONOPESADO4 = "src/Recursos/grafoNoPesado4.txt";
    private final String GRAFONOPESADO5 = "src/Recursos/grafoNoPesado5.txt";
    private final String GRAFONOPESADO6 = "src/Recursos/grafoNoPesado6.txt";
    private final String GRAFONOPESADO7 = "src/Recursos/grafoNoPesado7.txt";
    private final String GRAFONOPESADO8 = "src/Recursos/grafoNoPesado8.txt";

    private final String JOHNSON1 = "src/Recursos/johnson1.txt";
    private final String JOHNSON2 = "src/Recursos/johnson2.txt";
    private final String JOHNSON3 = "src/Recursos/johnson3.txt";
    private final String JOHNSON4 = "src/Recursos/johnson4.txt";
    private final String JOHNSON5 = "src/Recursos/johnson5.txt";
    private final String JOHNSON6 = "src/Recursos/johnson6.txt";
    private final String JOHNSON7 = "src/Recursos/johnson7.txt";
    private final String JOHNSON8 = "src/Recursos/johnson8.txt";

    private final String KARPS1 = "src/Recursos/karps1.txt";
    private final String KARPS2 = "src/Recursos/karps2.txt";
    private final String KARPS3 = "src/Recursos/karps3.txt";
    private final String KARPS4 = "src/Recursos/karps4.txt";
    private final String KARPS5 = "src/Recursos/karps5.txt";
    private final String KARPS6 = "src/Recursos/karps6.txt";
    private final String KARPS7 = "src/Recursos/karps7.txt";
    private final String KARPS8 = "src/Recursos/karps8.txt";

    private final String MULTIESTADO1 = "src/Recursos/multiestado1.txt";
    private final String MULTIESTADO2 = "src/Recursos/multiestado2.txt";
    private final String MULTIESTADO3 = "src/Recursos/multiestado3.txt";
    private final String MULTIESTADO4 = "src/Recursos/multiestado4.txt";
    private final String MULTIESTADO5 = "src/Recursos/multiestado5.txt";
    private final String MULTIESTADO6 = "src/Recursos/multiestado6.txt";
    private final String MULTIESTADO7 = "src/Recursos/multiestado7.txt";
    private final String MULTIESTADO8 = "src/Recursos/multiestado1.txt";

    private final String ZEROONEBFS1 = "src/Recursos/zeroonebfs1.txt";
    private final String ZEROONEBFS2 = "src/Recursos/zeroonebfs2.txt";
    private final String ZEROONEBFS3 = "src/Recursos/zeroonebfs3.txt";
    private final String ZEROONEBFS4 = "src/Recursos/zeroonebfs4.txt";
    private final String ZEROONEBFS5 = "src/Recursos/zeroonebfs5.txt";
    private final String ZEROONEBFS6 = "src/Recursos/zeroonebfs6.txt";
    private final String ZEROONEBFS7 = "src/Recursos/zeroonebfs7.txt";
    private final String ZEROONEBFS8 = "src/Recursos/zeroonebfs8.txt";

    public static void main(String[] args) {
        Documento documento = new Documento();
        documento.crearTxt();
    }

    public Documento() {

    }

    public void crearTxtMatriz(int[][] matriz) {
        try {
            File archivo = new File(AESTRLLACASO8);
            if (!archivo.exists()) {
                FileWriter out = new FileWriter(archivo);
                BufferedWriter writer = new BufferedWriter(out);

                Random random = new Random();

                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        writer.write(matriz[i][j] + ",");
                    }
                    writer.write("\n");
                }

                writer.close();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void crearTxtBellman(ArrayList<Integer> lista, int E) {
        int cont = 0;
        try {
            File archivo = new File(DIALS8);
            if (!archivo.exists()) {
                FileWriter out = new FileWriter(archivo);
                BufferedWriter writer = new BufferedWriter(out);

                Random random = new Random();

                for (int i = 0; i < E; i++) {

                    writer.write(lista.get(cont) + "," + lista.get(cont + 1) + "," + lista.get(cont + 2));
                    cont = cont + 3;
                    writer.write("\n");
                }

                writer.close();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void crearTxt() {
        try {
            File archivo = new File(AESTRLLACASO1);
            if (!archivo.exists()) {
                FileWriter out = new FileWriter(archivo);
                BufferedWriter writer = new BufferedWriter(out);

                Random random = new Random();

                for (int i = 1; i < 1048576; i++) {
                    writer.write(random.nextInt(100) + ",");
                }
                System.out.println(random.nextInt(100));
                writer.write(random.nextInt(100));

                writer.close();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public int[][] leerFormatoArchivoMatriz(String filename, int tam) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            int[][] arr = new int[tam][tam];
            int filaIndex = 0;

            while (scanner.hasNextLine()) {
                String[] linea = scanner.nextLine().split(",");
                for (int i = 0; i < linea.length; i++) {
                    arr[filaIndex][i] = Integer.parseInt(linea[i]);
                }
                filaIndex++;
            }
            scanner.close();
            return arr;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new int[0][0];
        }
    }

    public ArrayList<Integer> leerFormatoArchivoBellman(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            ArrayList<Integer> arr = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String[] linea = scanner.nextLine().split(",");
                arr.add(Integer.parseInt(linea[0]));
                arr.add(Integer.parseInt(linea[1]));
                arr.add(Integer.parseInt(linea[2]));
            }
            scanner.close();
            return arr;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


}