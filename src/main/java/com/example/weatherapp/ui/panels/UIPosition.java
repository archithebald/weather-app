package com.example.weatherapp.ui.panels;

import javafx.scene.Node;

public interface UIPosition {
    void setLeft(Node node);
    void setRight(Node node);
    void setBottom(Node node);
    void setTop(Node node);
    void setCenterH(Node node);
    void setCenterV(Node node);
}
