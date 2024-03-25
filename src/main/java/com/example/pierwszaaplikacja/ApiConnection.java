package com.example.pierwszaaplikacja;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class ApiConnection {
    private static final String API_KEY = "5214784a4a37acdcf69a932daa46a806";
    private static final String CITY = "Warszawa";
    private StringBuilder response = new StringBuilder();

    public void apiInit(String city) {
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed: HTTP error code: " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            while ((output = br.readLine()) != null) {
                response.append(output);
            }

            conn.disconnect();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getInfoAboutCity() {
        return response.toString();
    }
}
