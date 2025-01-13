package com.example.weatherapp.ui.utils;

import javafx.scene.image.Image;

public class Files {
    private static final String IMAGES_PATH = "C:\\JavaProjects\\WeatherApp\\src\\main\\resources\\images";

    public Image getImage(String item) {
        return new Image(IMAGES_PATH + "\\" + item);
    }
}
