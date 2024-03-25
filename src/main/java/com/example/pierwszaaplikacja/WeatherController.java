package com.example.pierwszaaplikacja;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.json.JSONObject;

public class WeatherController {
    @FXML
    public TextField cityLabel;

    @FXML
    private Label weatherLabel;

    @FXML
    protected void checkWeatherButtonClicked() {
        String city = cityLabel.getText();

        ApiConnection apiConnection = new ApiConnection();
        apiConnection.apiInit(city);
        String response = apiConnection.getInfoAboutCity();
        System.out.println(city + " " + response);

        String jsonStr = response;
        JSONObject jsonObject = new JSONObject(jsonStr);
        JSONObject mainObject = jsonObject.getJSONObject("main");
        double temperatureKelvin = mainObject.getDouble("temp");

        double temperatureCelsius = temperatureKelvin - 273.15;

        weatherLabel.setText("Informacje o pogodzie w " + city + ": " + temperatureCelsius);
    }
}
