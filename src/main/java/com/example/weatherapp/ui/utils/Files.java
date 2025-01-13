package com.example.weatherapp.ui.utils;

import javafx.scene.image.Image;

public class Files {
    private static final String IMAGES_PATH = "C:\\Users\\Salmen\\Desktop\\Java Projects\\weather-app\\src\\main\\resources\\images";

    public Image getImage(String item) {
        return new Image(IMAGES_PATH + "\\" + item);
    }
}
