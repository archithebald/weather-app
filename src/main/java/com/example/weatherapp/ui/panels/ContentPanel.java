package com.example.weatherapp.ui.panels;

import com.example.weatherapp.ui.Panel;
import com.example.weatherapp.ui.PanelManager;
import com.example.weatherapp.ui.elements.MainLabel;
import com.example.weatherapp.ui.utils.Files;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.FontWeight;
import org.kordamp.ikonli.javafx.FontIcon;

public class ContentPanel extends Panel implements UIPosition, UIStyle {

    public static final double HEIGHT = PanelManager.SCENE_HEIGHT - TopBarPanel.HEIGHT;

    public ContentPanel(PanelManager panelManager, boolean showGridLines) {
        super(panelManager, showGridLines);
    }

    @Override
    public void init() {
        setupContainer();

        ColumnConstraints mainColumn = new ColumnConstraints();
        mainColumn.setPercentWidth(100);

        RowConstraints search = new RowConstraints();
        search.setPercentHeight(15);

        RowConstraints informations = new RowConstraints();
        informations.setPercentHeight(70);

        MainLabel cityName = new MainLabel("London", 0, 0, 0, FontWeight.BOLD, 25);
        cityName.setTranslateY(-50);
        setCenterH(cityName);

        MainLabel temperature = new MainLabel("25°C", 0, 0, 0, FontWeight.BOLD, 40);
        setCenterH(temperature);
        temperature.setTranslateY(-95.0d);

        TextField searchBox = new TextField();
        searchBox.setMaxWidth(230.0d);
        searchBox.setMinWidth(230.0d);
        searchBox.setMinHeight(40.0d);
        searchBox.setMaxHeight(40.0d);
        searchBox.setStyle("-fx-text-color: #ffffff; -fx-font-size: 12; -fx-border-style: solid; -fx-border-radius: 50; -fx-background-insets: 0; -fx-background-color: transparent;");
        setCenterH(searchBox);
        setBottom(searchBox);

        FontIcon searchIcon = new FontIcon();
        searchIcon.setIconLiteral("fa-search");
        setRight(searchIcon);
        setCenterV(searchIcon);
        searchIcon.setTranslateY(22.0d);
        searchIcon.setTranslateX(-55.0d);
        searchIcon.setIconSize(22);

        ImageView weatherImage = new ImageView(new Files().getImage("clear.png"));
        weatherImage.setPreserveRatio(true);
        weatherImage.setFitHeight(150.0d);
        weatherImage.setTranslateY(65.0d);
        setCenterH(weatherImage);

        this.container.getColumnConstraints().add(mainColumn);
        this.container.getRowConstraints().addAll(search, informations);

        this.container.add(searchIcon, 0, 0);
        this.container.add(searchBox, 0, 0);
        this.container.add(cityName, 0, 1);
        this.container.add(temperature, 0, 1);
        this.container.add(weatherImage, 0, 1);
    }

    private void setupContainer() {
        setBackgroundColor(this.container, 255, 255, 255);
        this.container.setMinWidth(PanelManager.SCENE_WIDTH);
        this.container.setMaxWidth(PanelManager.SCENE_WIDTH);
        this.container.setMaxHeight(HEIGHT);
        this.container.setMinHeight(HEIGHT);
        this.container.getRowConstraints().clear();
        this.container.getColumnConstraints().clear();
    }
}
