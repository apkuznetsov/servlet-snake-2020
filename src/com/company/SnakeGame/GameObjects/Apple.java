package com.company.SnakeGame.GameObjects;

import org.jetbrains.annotations.NotNull;

import java.awt.*;

public final class Apple {
    private final Image image;
    private int x;
    private int y;

    public Apple(@NotNull final Image image) {
        this.image = image;
        x = 0;
        y = 0;
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
