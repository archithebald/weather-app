package com.example.weatherapp.ui;

import com.example.weatherapp.ui.panels.UIPosition;
import com.example.weatherapp.ui.panels.UIStyle;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public abstract class Panel implements UIPosition, UIStyle {
    protected PanelManager panelManager;
    protected GridPane container;

    public Panel(PanelManager panelManager, boolean showGridLines) {
        this.panelManager = panelManager;

        this.container = new GridPane();
        this.container.setGridLinesVisible(showGridLines);

        this.init();
    }

    public GridPane getContainer() {
        return container;
    }

    public abstract void init();

    @Override
    public void setLeft(Node node) {
        GridPane.setHalignment(node, HPos.LEFT);
    }

    @Override
    public void setRight(Node node) {
        GridPane.setHalignment(node, HPos.RIGHT);
    }

    @Override
    public void setBottom(Node node) {
        GridPane.setValignment(node, VPos.BOTTOM);
    }

    @Override
    public void setTop(Node node) {
        GridPane.setValignment(node, VPos.TOP);
    }

    @Override
    public void setCenterH(Node node) {
        GridPane.setHalignment(node, HPos.CENTER);
    }

    @Override
    public void setCenterV(Node node) {
        GridPane.setValignment(node, VPos.CENTER);
    }
}
