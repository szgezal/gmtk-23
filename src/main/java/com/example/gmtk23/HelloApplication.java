package com.example.gmtk23;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
public class HelloApplication extends Application {
    protected static ArrayList<ArrayList<Rectangle>> gameArea = new ArrayList<>();

    public void updateGameArea(Apple apple) {
        for (ArrayList<Rectangle> row: gameArea) {
            for (Rectangle r: row) {
                if (r.getX() == apple.getX() && r.getY() == apple.getY())
                    r.setFill(Color.color(1, 0, 0));
                else
                    r.setFill(Color.color(0.29, 0.9, 0.2));
            }
        }
    }

    @Override
    public void start(Stage stage) {
        Apple apple = new Apple(10, 10);

        Group group = new Group();
        GridPane gp = new GridPane();
        gp.setLayoutX(100);
        gp.setLayoutY(100);
        for(int i = 0; i < 40; i++) {
            ColumnConstraints column = new ColumnConstraints(10);
            gp.getColumnConstraints().add(column);
            RowConstraints row = new RowConstraints(10);
            gp.getRowConstraints().add(row);
        }
        for (int i = 0; i < 40; i++) {
            gameArea.add(new ArrayList<>());
            for (int j = 0; j < 40; j++) {
                Rectangle r;
                if (i == apple.getX() && j == apple.getY())
                    r = new Rectangle(10, 10, Color.color(1, 0, 0));
                else
                    r = new Rectangle(10, 10, Color.color(0.29, 0.9, 0.2));
                gameArea.get(i).add(r);
                gp.add(r, i, j);
                r.setX(i);
                r.setY(j);

            }
        }
        gp.setGridLinesVisible(true);
        group.getChildren().add(gp);
        Scene scene = new Scene(group, 600, 600);
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                apple.setY(apple.getY() - 1);
            } else if (e.getCode() == KeyCode.DOWN) {
                apple.setY(apple.getY() + 1);
            } else if (e.getCode() == KeyCode.LEFT) {
                apple.setX(apple.getX() - 1);
            } if (e.getCode() == KeyCode.RIGHT) {
                apple.setX(apple.getX() + 1);
            }
            if (apple.getX() < 0) {
                apple.setX(40);
            }
            if (apple.getX() > 40) {
                apple.setX(0);
            }
            if (apple.getY() < 0) {
                apple.setY(40);
            }
            if (apple.getY() > 40) {
                apple.setY(0);
            }
            System.out.println(apple.getX() + " " + apple.getY());
            updateGameArea(apple);
        });
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}