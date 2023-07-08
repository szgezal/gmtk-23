package com.example.gmtk23;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class HelloApplication extends Application {
    protected static ArrayList<ArrayList<Rectangle>> gameArea = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        GridPane gp = new GridPane();
        gp.setLayoutX(20);
        gp.setLayoutY(20);
        for(int i = 0; i < 40; i++) {
            ColumnConstraints column = new ColumnConstraints(10);
            gp.getColumnConstraints().add(column);
            RowConstraints row = new RowConstraints(10);
            gp.getRowConstraints().add(row);
        }
        for (int i = 0; i < 10; i++) {
            gameArea.add(new ArrayList<>());
            for (int j = 0; j < 10; j++) {
                Rectangle r = new Rectangle(10, 10, Color.color(0, 0, 1));
                gameArea.get(i).add(r);
                gp.add(r, i, j);
                r.setX(i);
                r.setY(j);
                //Ellenfél táblájára kattintás esetén küld az ellenfélnek (a szerveren keresztül)
                //egy üzenetet a célzott celláról.
                r.setOnMouseClicked(e -> {

                });
            }
        }
        gp.setGridLinesVisible(false);
        group.getChildren().add(gp);
        Scene scene = new Scene(group, 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}