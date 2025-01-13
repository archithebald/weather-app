package com.example.weatherapp.ui.panels;

import javafx.scene.Node;

public interface UIStyle {
    default void setBackgroundColor(Node node, int r, int g, int b) {
        node.setStyle("-fx-background-color: rgb(" + r + "," + g + "," + b + ");");
    }

    default void setTextColor(Node node, int r, int g, int b) {
        node.setStyle("-fx-text-fill: rgb(" + r + "," + g + "," + b + ");");
    }
}
