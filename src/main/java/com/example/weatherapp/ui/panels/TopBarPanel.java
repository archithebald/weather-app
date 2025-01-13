package com.example.weatherapp.ui.panels;

import com.example.weatherapp.ui.Panel;
import com.example.weatherapp.ui.PanelManager;
import com.example.weatherapp.ui.elements.MainLabel;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.FontWeight;
import org.kordamp.ikonli.javafx.FontIcon;

public class TopBarPanel extends Panel {
    public static final double HEIGHT = 35.0d;
    private static final String ICON_PATH = "C:\\JavaProjects\\WeatherApp\\src\\main\\resources\\images\\clear.png";

    public TopBarPanel(PanelManager panelManager, boolean showGridLines) {
        super(panelManager, showGridLines);
    }

    @Override
    public void init() {
        setupContainer();
        configureColumnsAndRows();

        //ImageView icon = createIcon();
        //MainLabel title = createTitle();
        ButtonBar buttonBar = createButtonBar();

        //this.container.add(icon, 0, 0);
        //this.container.add(title, 0, 0);
        this.container.add(buttonBar, 3, 0);
    }

    private void setupContainer() {
        setBackgroundColor(this.container, 155, 155, 155);
        this.container.setMinWidth(PanelManager.SCENE_WIDTH);
        this.container.setMaxWidth(PanelManager.SCENE_WIDTH);
        this.container.getRowConstraints().clear();
    }

    private void configureColumnsAndRows() {
        ColumnConstraints detailsColumn = createColumnConstraints();
        ColumnConstraints buttonColumn = createColumnConstraints();

        this.container.getColumnConstraints().addAll(detailsColumn, buttonColumn);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPrefHeight(HEIGHT);
        this.container.getRowConstraints().add(rowConstraints);
    }

    private ColumnConstraints createColumnConstraints() {
        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(50.0);
        return column;
    }

    private ImageView createIcon() {
        ImageView icon = new ImageView(new Image(ICON_PATH));
        icon.setTranslateX(5.0d);
        icon.setPreserveRatio(true);
        icon.setFitHeight(25);
        return icon;
    }

    private MainLabel createTitle() {
        MainLabel title = new MainLabel("Weather", 0, 0, 0, FontWeight.BOLD, 14);
        setLeft(title);
        title.setTranslateX(35.0d);
        return title;
    }

    private ButtonBar createButtonBar() {
        ButtonBar buttonBar = new ButtonBar();
        setCenterH(buttonBar);

        FontIcon closeBtn = createFontIcon("fa-close", 18, event -> panelManager.getStage().close());
        FontIcon minimizeBtn = createFontIcon("fa-window-minimize", 14, event -> panelManager.getStage().setIconified(true));

        buttonBar.getButtons().addAll(minimizeBtn, closeBtn);
        return buttonBar;
    }

    private FontIcon createFontIcon(String iconLiteral, int iconSize, EventHandler<MouseEvent> onClickHandler) {
        FontIcon icon = new FontIcon(iconLiteral);
        icon.setIconSize(iconSize);
        icon.setTranslateX(-8.0d);
        icon.setOnMouseClicked(onClickHandler);
        return icon;
    }
}
