package com.example.proyecto_final;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import com.example.proyecto_final.modelo.*;
import com.example.proyecto_final.modelo.aEstrella.AEstrella;

public class MainController implements Initializable {

    private static ObservableList<Resultado> resultados = FXCollections.observableArrayList();

    @FXML
    private TableView<Resultado> DatosTabla;

    @FXML
    private Button aEstrellaButton;

    @FXML
    private Button bellmanFordButton;

    @FXML
    private Button dialsButton;

    @FXML
    private Button dijkstraButton;

    @FXML
    private Button ejecutarTodoButton;

    @FXML
    private Button findMinimumCycleButton;

    @FXML
    private Button floydWarshallButton;

    @FXML
    private TableColumn<Resultado, String> grafoCaso1Column;

    @FXML
    private TableColumn<Resultado, String> grafoCaso2Column;

    @FXML
    private TableColumn<Resultado, String> grafoCaso3Column;

    @FXML
    private TableColumn<Resultado, String> grafoCaso4Column;

    @FXML
    private TableColumn<Resultado, String> grafoCaso5Column;

    @FXML
    private TableColumn<Resultado, String> grafoCaso6Column;

    @FXML
    private TableColumn<Resultado, String> grafoCaso7Column;

    @FXML
    private TableColumn<Resultado, String> grafoCaso8Column;

    @FXML
    private Button grafoDirigidoAciclicoButton;

    @FXML
    private Button grafoNoPesadoButton;

    @FXML
    private Button johnsonButton;

    @FXML
    private Button karpsButton;

    @FXML
    private Button multiestadoButton;

    @FXML
    private TableColumn<Resultado, Double> tiempoCaso1Column;

    @FXML
    private TableColumn<Resultado, Double> tiempoCaso2Column;

    @FXML
    private TableColumn<Resultado, Double> tiempoCaso3Column;

    @FXML
    private TableColumn<Resultado, Double> tiempoCaso4Column;

    @FXML
    private TableColumn<Resultado, Double> tiempoCaso5Column;

    @FXML
    private TableColumn<Resultado, Double> tiempoCaso6Column;

    @FXML
    private TableColumn<Resultado, Double> tiempoCaso7Column;

    @FXML
    private TableColumn<Resultado, Double> tiempoCaso8Column;

    @FXML
    private Button zeroOneButton;

    @FXML
    void aEstrellaBtnAction(ActionEvent event) {

        generarGrafoAEstrella();
    }

    private List<Double> generarGrafoAEstrella() {

        int[] destino = new int[2];
        double tem1, tem2, tem3, tem4, tem5, tem6, tem7, tem8;

        System.out.println("Esterlla Caso 1");
        destino[0] = 500;
        destino[1] = 900;
        String AESTRLLACASO = "src/Recursos/aestrllacaso1.txt";
        tem1 = aestrella(AESTRLLACASO, 1000, destino);

        System.out.println("Esterlla Caso 2");
        destino[0] = 1500;
        destino[1] = 1900;
        AESTRLLACASO = "src/Recursos/aestrllacaso2.txt";
        tem2 = aestrella(AESTRLLACASO, 2000, destino);

        System.out.println("Esterlla Caso 3");
        destino[0] = 2500;
        destino[1] = 2900;
        AESTRLLACASO = "src/Recursos/aestrllacaso3.txt";
        tem3 = aestrella(AESTRLLACASO, 3000, destino);

        System.out.println("Esterlla Caso 4");
        destino[0] = 3500;
        destino[1] = 3900;
        AESTRLLACASO = "src/Recursos/aestrllacaso4.txt";
        tem4 = aestrella(AESTRLLACASO, 4000, destino);

        System.out.println("Esterlla Caso 5");
        destino[0] = 4500;
        destino[1] = 4900;
        AESTRLLACASO = "src/Recursos/aestrllacaso5.txt";
        tem5 = aestrella(AESTRLLACASO, 5000, destino);

        System.out.println("Esterlla Caso 6");
        destino[0] = 5500;
        destino[1] = 5900;
        AESTRLLACASO = "src/Recursos/aestrllacaso6.txt";
        tem6 = aestrella(AESTRLLACASO, 6000, destino);

        System.out.println("Esterlla Caso 7");
        destino[0] = 6500;
        destino[1] = 6900;
        AESTRLLACASO = "src/Recursos/aestrllacaso7.txt";
        tem7 = aestrella(AESTRLLACASO, 7000, destino);

        System.out.println("Esterlla Caso 8");
        destino[0] = 7500;
        destino[1] = 7900;
        AESTRLLACASO = "src/Recursos/aestrllacaso8.txt";
        tem8 = aestrella(AESTRLLACASO, 8000, destino);

        resultados.add(new Resultado("(599.686, 718.472)", tem1,
                "(2.401.158, 2.880.473)", tem2,
                "(5.399.360, 6.476.546)", tem3,
                "(9.601.277, 11.519.903)", tem4,
                "(14.997.216, 17.991.125)", tem5,
                "(21.595.753, 25.908.924)", tem6,
                "(29.399.578, 35.271.931)", tem7,
                "(38.403.457, 46.085.926)", tem8));

        DatosTabla.setItems((ObservableList<Resultado>) resultados);
        DatosTabla.refresh();

        // genrarArchivos();
        return Arrays.asList(tem1, tem2, tem3, tem4, tem5, tem6, tem7, tem8);
    }

    private void mostrarGrafico(List<String> nombres, List<Double> listaTiempos) {
        // Crear ejes
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        // Crear el gráfico de barras
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Gráfico de Barras");

        // Crear series de datos
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Datos 2023");

        for (int i = 0; i < listaTiempos.size(); i++) {
            series.getData().add(new XYChart.Data<>(nombres.get(i), listaTiempos.get(i)));

        }

        // Agregar la serie al gráfico de barras
        barChart.getData().add(series);

        Stage stage = new Stage();
        // Crear la escena
        Scene scene = new Scene(barChart, 800, 600);

        // Configurar el escenario
        stage.setTitle("Gráfico de Barras en JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    private void genrarArchivos() {
        boolean banera = true;
        do {
            int[] inicio = { 0, 0 };
            int[] destino = { 0, 0 };
            int n = 10;
            int m = 9;
            int[][] matriz = generateMatrix(inicio, destino, n, m);

            // for(int[] fila : matriz) {
            // System.out.println(Arrays.toString(fila));
            // }

            double timeInicial = System.nanoTime();
            if (AEstrella.aStarSearch(matriz, inicio, destino) == true) {
                banera = false;

            }
            double timeFinal = System.nanoTime();

            if (!banera) {
                Documento doc = new Documento();
                doc.crearTxtMatriz(matriz);
            }

            System.out.println((timeFinal - timeInicial) / 1000000000 + "Segundos");

        } while (banera == true);

    }

    private static double aestrella(String AESTRLLACASO, int i, int[] destino) {
        Documento documento = new Documento();

        int[] inicio = { 0, 0 };
        int n = i;
        int m = i;
        AEstrella.ROW = n;
        AEstrella.COL = m;

        int[][] matriz = documento.leerFormatoArchivoMatriz(AESTRLLACASO, i);

        // calcularVerticesAristas(matriz);

        double timeInicial = System.nanoTime();
        AEstrella.aStarSearch(matriz, inicio, destino);
        double timeFinal = System.nanoTime();

        System.out.println("tiempo: " + (timeFinal - timeInicial) / 1000000000 + "Segundos");
        return (timeFinal - timeInicial) / 1000000000;
    }

    private static void calcularVerticesAristas(int[][] graph) {
        int numVertices = 0;
        int numEdges = 0;

        int numRows = graph.length;
        int numCols = graph[0].length;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (graph[i][j] == 1) {
                    numVertices++;
                    // Comprueba las celdas adyacentes para contar las aristas
                    if (i > 0 && graph[i - 1][j] == 1) {
                        numEdges++;
                    }
                    if (i < numRows - 1 && graph[i + 1][j] == 1) {
                        numEdges++;
                    }
                    if (j > 0 && graph[i][j - 1] == 1) {
                        numEdges++;
                    }
                    if (j < numCols - 1 && graph[i][j + 1] == 1) {
                        numEdges++;
                    }
                }
            }
        }

        // Como el grafo se representa con una matriz, es posible que cuentes
        // algunas aristas dos veces. Puedes dividir el número de aristas por 2
        // para obtener el recuento real de aristas si eso es un problema.
        numEdges /= 2;

        System.out.println("Número de vértices: " + numVertices);
        System.out.println("Número de aristas: " + numEdges);

    }

    public static int[][] generateMatrix(int[] inicio, int[] destino, int n, int m) {
        int ROWS = n; // Número de filas
        int COLS = m; // Número de columnas

        int[][] grid = new int[ROWS][COLS];

        // Generar la matriz con caminos (1) y bloqueos (0)
        // Por ejemplo, puedes usar un bucle para llenar la matriz de manera aleatoria.
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                // Probabilidad de 0.2 de ser un bloqueo (0), el resto serán caminos (1)
                grid[i][j] = (Math.random() < 0.4) ? 0 : 1;
            }
        }

        // Asegurarse de que el punto de inicio y destino sean caminos (1)
        grid[inicio[0]][inicio[1]] = 1;
        grid[destino[0]][destino[1]] = 1;

        // Imprimir la matriz (esto es opcional, solo para ver la matriz generada)
        // for (int i = 0; i < ROWS; i++) {
        // for (int j = 0; j < COLS; j++) {
        // System.out.print(grid[i][j] + " ");
        // }
        // System.out.println();
        // }

        return grid;

    }

    @FXML
    void bellmanFordBtnAction(ActionEvent event) {

    }

    @FXML
    void dialsBtnAction(ActionEvent event) {

    }

    @FXML
    void dijkstraBtnAction(ActionEvent event) {

    }

    @FXML
    void ejecutarTodoBtnAction(ActionEvent event) {

        List<String> nombres = Arrays.asList("A Estrella", "Bellman Ford", "Dial's", "Dijkstra", "Find Minimum Cycle",
                "Floyd Warshall", "Grafo Dirigido Aciclico", "Grafo No Pesado", "Johnson", "Karps", "Multiestado",
                "0 - 1 BFS");

        List<Double> tiemposAEstrella = generarGrafoAEstrella();

        List<Double> tiemposCaso1 = new ArrayList<>();
        tiemposCaso1.add(tiemposAEstrella.get(0));
        tiemposCaso1.add(tiemposAEstrella.get(1));

        mostrarGrafico(nombres, tiemposCaso1);

    }

    @FXML
    void findMinimumCycleBtnAction(ActionEvent event) {

    }

    @FXML
    void floydWarshallBtnAction(ActionEvent event) {

    }

    @FXML
    void grafoDirigidoAciclicoBtnAction(ActionEvent event) {

    }

    @FXML
    void grafoNoPesadoBtnAction(ActionEvent event) {

    }

    @FXML
    void johnsonBtnAction(ActionEvent event) {

    }

    @FXML
    void karpsBtnAction(ActionEvent event) {

    }

    @FXML
    void multiestadoBtnAction(ActionEvent event) {

    }

    @FXML
    void zeroOneBtnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        grafoCaso1Column.setCellValueFactory(new PropertyValueFactory<>("grafo"));
        grafoCaso2Column.setCellValueFactory(new PropertyValueFactory<>("grafo2"));
        grafoCaso3Column.setCellValueFactory(new PropertyValueFactory<>("grafo3"));
        grafoCaso4Column.setCellValueFactory(new PropertyValueFactory<>("grafo4"));
        grafoCaso5Column.setCellValueFactory(new PropertyValueFactory<>("grafo5"));
        grafoCaso6Column.setCellValueFactory(new PropertyValueFactory<>("grafo6"));
        grafoCaso7Column.setCellValueFactory(new PropertyValueFactory<>("grafo7"));
        grafoCaso8Column.setCellValueFactory(new PropertyValueFactory<>("grafo8"));

        tiempoCaso1Column.setCellValueFactory(new PropertyValueFactory<>("tiempo"));
        tiempoCaso2Column.setCellValueFactory(new PropertyValueFactory<>("tiempo2"));
        tiempoCaso3Column.setCellValueFactory(new PropertyValueFactory<>("tiempo3"));
        tiempoCaso4Column.setCellValueFactory(new PropertyValueFactory<>("tiempo4"));
        tiempoCaso5Column.setCellValueFactory(new PropertyValueFactory<>("tiempo5"));
        tiempoCaso6Column.setCellValueFactory(new PropertyValueFactory<>("tiempo6"));
        tiempoCaso7Column.setCellValueFactory(new PropertyValueFactory<>("tiempo7"));
        tiempoCaso8Column.setCellValueFactory(new PropertyValueFactory<>("tiempo8"));

        DatosTabla.getItems().clear();

        // resultados.add(new Resultado("Grafo 1", 10.5, "Grafo 2", 20.2, "Grafo 3",
        // 20.2, "Grafo 4", 20.2, "Grafo 5", 20.2, "Grafo 6", 20.2, "Grafo 7", 20.2,
        // "Grafo 8", 20.2));

        DatosTabla.setItems((ObservableList<Resultado>) resultados);

        DatosTabla.refresh();

    }

    public class Resultado {
        private String grafo;
        private double tiempo;

        private String grafo2;
        private double tiempo2;

        private String grafo3;
        private double tiempo3;

        private String grafo4;
        private double tiempo4;

        private String grafo5;
        private double tiempo5;

        private String grafo6;
        private double tiempo6;

        private String grafo7;
        private double tiempo7;

        private String grafo8;
        private double tiempo8;

        public Resultado(String grafo, double tiempo, String grafo2, double tiempo2, String grafo3, double tiempo3,
                String grafo4, double tiempo4, String grafo5, double tiempo5, String grafo6, double tiempo6,
                String grafo7, double tiempo7, String grafo8, double tiempo8) {
            this.grafo = grafo;
            this.tiempo = tiempo;
            this.grafo2 = grafo2;
            this.tiempo2 = tiempo2;
            this.grafo3 = grafo3;
            this.tiempo3 = tiempo3;
            this.grafo4 = grafo4;
            this.tiempo4 = tiempo4;
            this.grafo5 = grafo5;
            this.tiempo5 = tiempo5;
            this.grafo6 = grafo6;
            this.tiempo6 = tiempo6;
            this.grafo7 = grafo7;
            this.tiempo7 = tiempo7;
            this.grafo8 = grafo8;
            this.tiempo8 = tiempo8;
        }

        public String getGrafo() {
            return grafo;
        }

        public void setGrafo(String grafo) {
            this.grafo = grafo;
        }

        public String getGrafo2() {
            return grafo2;
        }

        public void setGrafo2(String grafo2) {
            this.grafo2 = grafo2;
        }

        public double getTiempo() {
            return tiempo;
        }

        public void setTiempo(double tiempo) {
            this.tiempo = tiempo;
        }

        public double getTiempo2() {
            return tiempo2;
        }

        public void setTiempo2(double tiempo2) {
            this.tiempo2 = tiempo2;
        }

        public String getGrafo3() {
            return grafo3;
        }

        public void setGrafo3(String grafo3) {
            this.grafo3 = grafo3;
        }

        public double getTiempo3() {
            return tiempo3;
        }

        public void setTiempo3(double tiempo3) {
            this.tiempo3 = tiempo3;
        }

        public String getGrafo4() {
            return grafo4;
        }

        public void setGrafo4(String grafo4) {
            this.grafo4 = grafo4;
        }

        public double getTiempo4() {
            return tiempo4;
        }

        public void setTiempo4(double tiempo4) {
            this.tiempo4 = tiempo4;
        }

        public String getGrafo5() {
            return grafo5;
        }

        public void setGrafo5(String grafo5) {
            this.grafo5 = grafo5;
        }

        public double getTiempo5() {
            return tiempo5;
        }

        public void setTiempo5(double tiempo5) {
            this.tiempo5 = tiempo5;
        }

        public String getGrafo6() {
            return grafo6;
        }

        public void setGrafo6(String grafo6) {
            this.grafo6 = grafo6;
        }

        public String getGrafo7() {
            return grafo7;
        }

        public void setGrafo7(String grafo7) {
            this.grafo7 = grafo7;
        }

        public double getTiempo7() {
            return tiempo7;
        }

        public void setTiempo7(double tiempo7) {
            this.tiempo7 = tiempo7;
        }

        public String getGrafo8() {
            return grafo8;
        }

        public void setGrafo8(String grafo8) {
            this.grafo8 = grafo8;
        }

        public double getTiempo8() {
            return tiempo8;
        }

        public void setTiempo8(double tiempo8) {
            this.tiempo8 = tiempo8;
        }

        public double getTiempo6() {
            return tiempo6;
        }

        public void setTiempo6(double tiempo6) {
            this.tiempo6 = tiempo6;
        }

    }

}
