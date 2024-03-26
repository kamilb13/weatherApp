package com.example.pierwszaaplikacja;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WeatherApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //String cssFile = getClass().getResource("/styles.css").toExternalForm();

        FXMLLoader fxmlLoader = new FXMLLoader(WeatherApplication.class.getResource("weather.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820, 440);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setTitle("Weather App");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}