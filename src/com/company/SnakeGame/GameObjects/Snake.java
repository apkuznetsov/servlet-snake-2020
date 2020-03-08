package com.company.SnakeGame.GameObjects;

import org.jetbrains.annotations.NotNull;

import java.awt.*;

public final class Snake {
    private static int SIZE = 3;

    private final Image snakeDotImage;
    private int x;
    private int y;

    private int size;

    public Snake(@NotNull final Image snakeDotImage) {
        this.snakeDotImage = snakeDotImage;
        x = 0;
        y = 0;

        size = SIZE;
    }

    public Snake(Image snakeDotImage, int x, int y) {
        this.snakeDotImage = snakeDotImage;
        this.x = x;
        this.y = y;

        size = SIZE;
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

    public int getSize() {
        return size;
    }

    public void incSize() {
        size++;
    }
}
