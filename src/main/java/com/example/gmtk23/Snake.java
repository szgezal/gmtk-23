package com.example.gmtk23;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Snake {
    private ArrayList<Coord> snake = new ArrayList<>();

    public Snake() {
        for (int i = 0; i < 10; i++) {
            snake.add(new Coord(20 + i, 20));
        }
    }

    public ArrayList<Coord> getSnake() {
        return snake;
    }

    public void updateSnake(Apple apple) {
        //elmentem a régi állapotát
        final ArrayList<Coord> oldSnake = new ArrayList<>(snake);

        //meghatározom, hogy merre lépjen tovább (azt az irányt választja amerre távolabb van az almától x vagy y)
        int diffX = snake.get(0).posX() - apple.getX();
        int diffY = snake.get(0).posY() - apple.getY();
        if (abs(diffX) > abs(diffY))
            if (diffX < 0)
                snake.set(0, new Coord(snake.get(0).posX() + 1, snake.get(0).posY()));
            else
                snake.set(0, new Coord(snake.get(0).posX() - 1, snake.get(0).posY()));
        else
            if (diffY < 0)
                snake.set(0, new Coord(snake.get(0).posX(), snake.get(0).posY() + 1));
            else
                snake.set(0, new Coord(snake.get(0).posX(), snake.get(0).posY() - 1));

        //frissítem a koordinátákat
        for (int i = 1; i < snake.size(); i++) {
            snake.set(i, new Coord(oldSnake.get(i - 1).posX(), oldSnake.get(i - 1).posY()));
        }
    }
}
