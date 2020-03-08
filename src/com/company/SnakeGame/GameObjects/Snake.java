package com.company.SnakeGame.GameObjects;

import java.awt.*;

public final class Snake {
    private final Image snakeDotImage;
    private int x;
    private int y;

    public Snake(Image snakeDotImage) {
        this.snakeDotImage = snakeDotImage;
        x = 0;
        y = 0;
    }

    public Snake(Image snakeDotImage, int x, int y) {
        this.snakeDotImage = snakeDotImage;
        this.x = x;
        this.y = y;
    }

    public Image getSnakeDotImage() {
        return snakeDotImage;
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
