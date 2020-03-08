package com.company.SnakeGame.GameObjects;

import org.jetbrains.annotations.NotNull;

import java.awt.*;

public final class Snake {
    public enum Directions {
        LEFT, UP, RIGHT, DOWN
    }

    private final Image snakeDotImage;
    private final int dotSize;
    private int size;

    private final int[] xs;
    private final int[] ys;

    private Directions currentDirection;

    public Snake(
            @NotNull Image snakeDotImage,
            final int dotSize,
            final int maxSize,
            final int startX
    ) {
        this.snakeDotImage = snakeDotImage;
        this.dotSize = dotSize;
        size = 3;

        xs = new int[maxSize];
        ys = new int[xs.length];
        initCoords(startX);

        currentDirection = Directions.RIGHT;
    }

    private void initCoords(final int startX) {
        for (int dotIndex = 0; dotIndex < getSize(); dotIndex++) {
            xs[dotIndex] = startX - dotIndex * dotSize;
            ys[dotIndex] = startX;
        }
    }

    public Image getSnakeDotImage() {
        return snakeDotImage;
    }

    public int getSize() {
        return size;
    }

    public void incSize() {
        size++;
    }

    public int getX(int index) {
        return xs[index];
    }

    public int getY(int index) {
        return ys[index];
    }

    public void setX(int index, int value) {
        xs[index] = value;
    }

    public void setY(int index, int value) {
        ys[index] = value;
    }

    public void incX(int index) {
        xs[0] += dotSize;
    }

    public void decX(int index) {
        xs[0] -= dotSize;
    }

    public void incY(int index) {
        ys[0] += dotSize;
    }

    public void decY(int index) {
        ys[0] -= dotSize;
    }

    public Directions getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Directions direction) {
        currentDirection = direction;
    }

    public boolean isLeftDirection() {
        return currentDirection == Directions.LEFT;
    }

    public boolean isUpDirection() {
        return currentDirection == Directions.UP;
    }

    public boolean isRightDirection() {
        return currentDirection == Directions.RIGHT;
    }

    public boolean isDownDirection() {
        return currentDirection == Directions.DOWN;
    }
}
