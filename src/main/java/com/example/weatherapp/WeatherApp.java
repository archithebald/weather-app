package com.example.weatherapp;

import com.example.weatherapp.ui.PanelManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class WeatherApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        PanelManager panelManager = new PanelManager(stage);
        panelManager.init();
    }
}
