package com.example.proyecto_final;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class MainPrueba extends Application {

    @Override
    public void start(Stage stage) {
        // Crear ejes
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        // Crear el gráfico de barras
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Ejemplo de Gráfico de Barras");

        // Crear series de datos
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Datos 2023");
        series.getData().add(new XYChart.Data<>("Categoría 1", 10));
        series.getData().add(new XYChart.Data<>("Categoría 2", 20));
        series.getData().add(new XYChart.Data<>("Categoría 3", 15));
        series.getData().add(new XYChart.Data<>("Categoría 4", 30));

        // Agregar la serie al gráfico de barras
        barChart.getData().add(series);

        // Crear la escena
        Scene scene = new Scene(barChart, 800, 600);

        // Configurar el escenario
        stage.setTitle("Gráfico de Barras en JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}