package com.example.weatherapp.ui;

import com.example.weatherapp.ui.panels.ContentPanel;
import com.example.weatherapp.ui.panels.TopBarPanel;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PanelManager {
    public static final int SCENE_WIDTH = 400;
    public static final int SCENE_HEIGHT = 600;
    private final Stage stage;
    private final TopBarPanel topBar = new TopBarPanel(this, false);
    private final ContentPanel content = new ContentPanel(this, false);
    private GridPane layout;

    public PanelManager(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    public void init() {
        this.stage.setTitle("Weather App");
        this.stage.setWidth(SCENE_WIDTH);
        this.stage.setHeight(SCENE_HEIGHT);
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.centerOnScreen();
        this.layout = new GridPane();

        Scene scene = new Scene(this.layout);

        this.layout.setGridLinesVisible(true);

        this.showPanel(this.topBar, 0, 0);
        this.showPanel(this.content, 0, 1);

        this.stage.setScene(scene);
        this.stage.show();
    }

    private void showPanel(Panel panel, int column, int row) {
        this.layout.add(panel.getContainer(), column, row);
        panel.init();
    }

    public GridPane getLayout() {
        return layout;
    }
}
