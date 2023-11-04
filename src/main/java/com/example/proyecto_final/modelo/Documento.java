package com.example.proyecto_final.modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
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

    private final String RUTA_ARCHIVO_8192_1 = "src/Recursos/archivo8192_1.txt";

    private final String RUTA_ARCHIVO_8192_2 = "src/Recursos/archivo8192_2.txt";

    private final String RUTA_ARCHIVO_32768_1 = "src/Recursos/archivo32768_1.txt";

    private final String RUTA_ARCHIVO_32768_2 = "src/Recursos/archivo32768_2.txt";

    public static void main(String[] args) {
        Documento documento = new Documento();
        documento.crearTxt();
    }

    public Documento() {
        
    }

    public void crearTxtMatriz(int[][] matriz) {
        try {
            File archivo = new File(AESTRLLACASO8);
            if(!archivo.exists()) {
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

    public void crearTxt() {
        try {
            File archivo = new File(AESTRLLACASO1);
            if(!archivo.exists()) {
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
                for(int i = 0; i < linea.length; i++) {
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
}