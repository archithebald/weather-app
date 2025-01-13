package com.example.weatherapp;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class WeatherApi {
    private static JSONObject getWeatherData(String locationName) {
        JSONArray locationData = getLocationData(locationName);

        JSONObject location = (JSONObject) locationData.get(0);
        double lat = (double) location.get("latitude");
        double lon = (double) location.get("longitude");

        String urlString = "https://api.open-meteo.com/v1/forecast?latitude="+ lat +"&longitude="+ lon + "&hourly=temperature_2m,relative_humidity_2m,weather_code,wind_speed_10m";

        try {
            HttpURLConnection conn = fetchApiResponse(urlString);

            if (conn.getResponseCode() != 200) {
                System.out.println("Error: Could not connect to API");
                return null;
            }

            StringBuilder resultJson = new StringBuilder();
            Scanner scanner = new Scanner(conn.getInputStream());
            while(scanner.hasNext()) {
                resultJson.append(scanner.nextLine());
            }

            scanner.close();
            conn.disconnect();

            JSONParser parser = new JSONParser();
            JSONObject resultJsonObject = (JSONObject) parser.parse(String.valueOf(resultJson));

            JSONObject hourly = (JSONObject) resultJsonObject.get("hourly");

            JSONArray time = (JSONArray) hourly.get("time");
            int index = findIndexOfCurrentTime();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static JSONArray getLocationData(String locationName) {
        locationName = locationName.replaceAll(" ", "+");

        String urlString = "https://geocoding-api.open-meteo.com/v1/search?name=" + locationName + "&count=10&language=en&format=json";

        try {
            HttpURLConnection conn = fetchApiResponse(urlString);

            if (conn.getResponseCode() == 200) {
                StringBuilder resultJson = new StringBuilder();
                Scanner scanner = new Scanner(conn.getInputStream());

                while(scanner.hasNext()) {
                    resultJson.append(scanner.nextLine());
                }

                scanner.close();
                conn.disconnect();

                JSONParser parser = new JSONParser();
                JSONObject resultJsonObject = (JSONObject) parser.parse(String.valueOf(resultJson));

                JSONArray locationData = (JSONArray) resultJsonObject.get("results");
                return locationData;
            } else {
                System.out.println("Error: Could not connect to API");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static HttpURLConnection fetchApiResponse(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.connect();
            return conn;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static int findIndexOfCurrentTime(JSONArray timeList) {
        String currentTime = getCurrentTime();
    }

    private static String getCurrentTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH':00'");
        String formatted = currentDateTime.format(formatter);

        return formatted;
    }
}
