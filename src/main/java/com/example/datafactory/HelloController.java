package com.example.datafactory;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HelloController {

    @FXML
    private TableView<WeatherData> tableView;
    @FXML
    private TableColumn<WeatherData, String> precipitationColumn;
    @FXML
    private TableColumn<WeatherData, String> stationCityColumn;
    @FXML
    private TableColumn<WeatherData, String> stationCodeColumn;
    @FXML
    private TableColumn<WeatherData, String> stationLocationColumn;
    @FXML
    private TableColumn<WeatherData, String> stationStateColumn;
    @FXML
    private TableColumn<WeatherData, String> avgTemperatureColumn;
    @FXML
    private TableColumn<WeatherData, String> windSpeedColumn;
    @FXML
    private TableColumn<WeatherData, Integer> idColumn;

    @FXML
    private void initialize() {
        precipitationColumn.setCellValueFactory(new PropertyValueFactory<>("precipitation"));
        stationCityColumn.setCellValueFactory(new PropertyValueFactory<>("stationCity"));
        stationCodeColumn.setCellValueFactory(new PropertyValueFactory<>("stationCode"));
        stationLocationColumn.setCellValueFactory(new PropertyValueFactory<>("stationLocation"));
        stationStateColumn.setCellValueFactory(new PropertyValueFactory<>("stationState"));
        avgTemperatureColumn.setCellValueFactory(new PropertyValueFactory<>("avgTemperature"));
        windSpeedColumn.setCellValueFactory(new PropertyValueFactory<>("windSpeed"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));


        // Set column resize policy
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    private void handleBrowseButtonAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open CSV File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                boolean firstRow = true; // Flag to skip the first row
                while ((line = reader.readLine()) != null) {
                    if (firstRow) {
                        firstRow = false;
                        continue; // Skip the first row
                    }
                    String[] parts = line.split(",");
                    if (parts.length >= 7) {
                        WeatherData weatherData = new WeatherData(parts[0], parts[1], parts[2],
                                parts[3], parts[4], parts[5], parts[6]);
                        tableView.getItems().add(weatherData);
                    } else {
                        System.err.println("Invalid number of columns in line: " + line);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
