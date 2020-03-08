package com.company.SnakeGame.GameObjects;

import org.jetbrains.annotations.NotNull;

import java.awt.*;

public final class Snake {
    private final Image snakeDotImage;
    private final int dotSize;

    private int size;

    private final int[] xCoords;
    private final int[] yCoords;

    public Snake(
            @NotNull Image snakeDotImage,
            final int dotSize,
            final int maxSize,
            final int startX
    ) {
        this.snakeDotImage = snakeDotImage;
        this.dotSize = dotSize;

        size = 3;

        xCoords = new int[maxSize];
        yCoords = new int[xCoords.length];
        initDots(startX);
    }

    private void initDots(final int startX) {
        for (int dotIndex = 0; dotIndex < getSize(); dotIndex++) {
            xCoords[dotIndex] = startX - dotIndex * dotSize;
            yCoords[dotIndex] = startX;
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
        return xCoords[index];
    }

    public int getY(int index) {
        return yCoords[index];
    }

    public void setX(int index, int value) {
        xCoords[index] = value;
    }

    public void setY(int index, int value) {
        yCoords[index] = value;
    }
}
