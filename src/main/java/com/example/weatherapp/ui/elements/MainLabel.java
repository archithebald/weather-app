package com.example.weatherapp.ui.elements;

import com.example.weatherapp.ui.panels.UIStyle;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MainLabel extends Label implements UIStyle {
    public MainLabel(String s, int r, int g, int b, FontWeight weight, int size) {
        super(s);
        setTextColor(this, r, g, b);
        this.setFont(Font.font("Arial", weight, size));
    }
}
